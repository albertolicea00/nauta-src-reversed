#!/usr/bin/env python3
"""Synchronize the README progress bar with TODO checkboxes and mapping stats.

Combines task-list progress from TODO.md and exact source reconstruction links
from scripts/mapping-stats.sh. Tasks have equal weight; adding scope can lower
the percentage. Use --check in checks.
"""

import argparse
import re
import subprocess
from pathlib import Path

MARKER = "<!-- do not delete this progress-bar-->"


def parse_mapping_stats(root):
    script = root / "scripts" / "mapping-stats.sh"
    proc = subprocess.run(
        ["bash", str(script)],
        cwd=str(root),
        capture_output=True,
        text=True,
        check=True,
    )
    stats = {}
    for key, val in re.findall(r"^\s*([a-z_]+):\s*(\d+)\s*$", proc.stdout, re.MULTILINE):
        stats[key] = int(val)
    if "source_files" not in stats or "single_candidate" not in stats:
        raise ValueError("mapping-stats.sh output missing source_files or single_candidate")
    return stats


def update(readme, todo, stats):
    tasks = re.findall(r"^- \[([ xX])\] ", todo, re.MULTILINE)
    if not tasks:
        raise ValueError("TODO.md has no task checkboxes")
    completed = sum(value.lower() == "x" for value in tasks)
    todo_pct = completed * 100 // len(tasks)

    source_files = stats["source_files"]
    single_candidate = stats["single_candidate"]
    source_pct = single_candidate * 100 // source_files if source_files > 0 else 0

    overall_pct = (todo_pct + source_pct) // 2
    blocks = overall_pct * 50 // 100
    bar = "█" * blocks + "░" * (50 - blocks)
    replacement = (
        '<!-- 50 blocks; each full block = 2% overall progress --> ' + MARKER + "\n"
        f'<span style="white-space: nowrap;"><code>[{bar}] {overall_pct}%</code></span>\n\n'
        f'**Task-list progress: {completed}/{len(tasks)} completed ({todo_pct}%); '
        f'{len(tasks) - completed} pending | '
        f'Source reconstruction: {single_candidate}/{source_files} ({source_pct}%).** '
        'Tasks have equal weight. This is not verified code coverage or a working-app percentage. '
        'The value can fall when scope grows. '
        'Run `make progress` or `make inventory` to refresh it from [TODO.md](TODO.md) and `scripts/mapping-stats.sh`.'
    )
    pattern = (
        r"<!--[^\n]*" + re.escape(MARKER) + r"\n<span[^\n]*</span>"
        r"(?:\n\n\*\*Task-list progress:[^\n]*)?"
    )
    result, count = re.subn(pattern, lambda _: replacement, readme)
    if count != 1:
        raise ValueError("Expected exactly one README progress bar marker")
    return result


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--check", action="store_true", help="Fail if README progress is stale")
    args = parser.parse_args()
    path = args.root / "README.md"
    previous = path.read_text()
    stats = parse_mapping_stats(args.root)
    current = update(previous, (args.root / "TODO.md").read_text(), stats)
    if args.check:
        if previous != current:
            parser.exit(1, "README progress is stale; run make progress\n")
        print("README progress matches TODO.md and mapping-stats.sh")
    else:
        if previous != current:
            path.write_text(current)
        print(re.search(r"\*\*Task-list progress:.*?\*\*", current)[0].strip("*"))


if __name__ == "__main__":
    main()
