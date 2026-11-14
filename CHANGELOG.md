# Changelog

## 2026-11-14 — cu.etecsa.enp_oficial-v1.apk — SHA-256: `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`

- Initialized repository directory structure (`app/assets/`, `app/res/`, `app/src/main/java/`, `src/`, `smali/`, `mappings/evidence/`, `scripts/tests/`, `docs/`, `.workspace/bin/`, `.workspace/archives/`) matching `transfermovil-src-reversed` without starting APK decompilation yet.
- Verified target APK metadata (`cu.etecsa.enp_oficial` v1.2.0.1, versionCode `1`, minSdk `14`, targetSdk `28`, compileSdk `28`, SHA-256 `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`) and documented reproducible extraction commands in `docs/target-metadata.md`.
- Added `Makefile` and analysis toolchain scripts (`verify-apk.sh`, `decompile.sh`, `search-strings.sh`, `mapping-stats.sh`, `reconstruction-inventory.py`, `update-progress.py`, `compile-reconstruction.py`) configured for `cu.etecsa.enp_oficial`.
- Created initial documentation set in `docs/` (`target-metadata.md`, `versioning.md`, `architecture.md`, `captive-portal-protocol.md`, `networking.md`, `security.md`, `storage.md`, `domain-model.md`, `reconstruction-inventory.md`, `unmapped-source-review.md`, `java-compilation.md`, `runtime-validation.md`).
- Added `README.md` with target metadata, official ETECSA Nauta web and portal references (`www.nauta.cu`, `portal.nauta.cu`, `secure.etecsa.net:8443`, `etecsa.cu`, Apklis), project status, documentation index, versioning strategy, and repository structure.
- Added `AGENTS.md` repository working guide and `TODO.md` reverse-engineering checklist.
- Added a `Related Repositories` cross-reference table in `README.md` linking all six Cuban Android reverse-engineering repositories.
- Decompiled `cu.etecsa.enp_oficial-v1.apk` with JADX 1.5.6 and Apktool 3.0.3 (`src/`, `app/AndroidManifest.xml`, `app/res/`, `app/assets/databases/enp_schema.sql`) and archived local `smali/` to `.workspace/archives/smali-1.2.0.1.1.zip` (SHA-256: `85c41d79a8922cc2ce0a85424736ebf33d9d193448b9a20784c337aae78e2e96`).
- Reconstructed all 34 application Java classes under `app/src/main/java/cu/etecsa/enp_oficial/` (deobfuscating `a..d`, `e.a.*`, `f.*`, and `g.*`) and mapped them in `mappings/classes.json`.
- Completed static analysis across `docs/architecture.md`, `docs/captive-portal.md`, `docs/email-protocol.md`, `docs/networking.md`, `docs/security.md`, `docs/storage.md`, `docs/domain-model.md`, `docs/unmapped-source-review.md`, `docs/java-compilation.md`, `docs/runtime-validation.md`, and `docs/versioning.md`.
- Tagged baseline release `1.2.0.1.1-v1.0`.
- Updated `scripts/update-progress.py` to combine `TODO.md` task-list progress (`34/38`, `89%`) with `scripts/mapping-stats.sh` source reconstruction (`34/35`, `97%`) for an overall `93%` progress bar, and refreshed `README.md` exact source link counts (`34/35 (97%)`).
