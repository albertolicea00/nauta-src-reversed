# ETECSA Nauta Source (Reversed)

![Target Version](https://img.shields.io/badge/Target%20Version-1.2.0.1-blue?style=flat-square)
![Version Code](https://img.shields.io/badge/Version%20Code-1-informational?style=flat-square)
![Min SDK](https://img.shields.io/badge/Min%20SDK-14-orange?style=flat-square)
![Target SDK](https://img.shields.io/badge/Target%20SDK-28-green?style=flat-square)
![Last Update](https://img.shields.io/badge/Last%20Update-November%202026-lightgrey?style=flat-square)

<!-- 50 blocks; each full block = 2% of TODO tasks --> <!-- do not delete this progress-bar-->
<span style="white-space: nowrap;"><code>[██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░] 5%</code></span>

**Task-list progress: 2/38 completed; 36 pending.** Tasks have equal weight. This is not verified code coverage or a working-app percentage. The value can fall when scope grows. Run `make progress` or `make inventory` to refresh it from [TODO.md](TODO.md).

**Main-package exact source links: 0/0 (0% — pre-decompilation).** This counts original Java classes with one exact clean-source candidate; it does not verify implementation completeness. The [reconstruction inventory](docs/reconstruction-inventory.md) reports current counts, and the [unlinked-source review ledger](docs/unmapped-source-review.md) tracks per-source classifications once `make decompile` has been executed.

## Overview

This repository contains reverse-engineered source code, extracted resources, and structural analysis of the official **ETECSA Nauta** (`cu.etecsa.enp_oficial`) Android client binary. The application facilitates Wi-Fi hotspot verification (`WIFI_ETECSA`), captive portal login/logout (`secure.etecsa.net:8443`), active session time tracking, and access to the Nauta User Portal (`portal.nauta.cu` / `www.nauta.cu`). The primary objective is to inspect implementation details, verify captive portal and account management protocols, and document internal architecture and security posture.

> [!WARNING]
> **Disclaimer:** This repository is strictly intended for interoperability research, protocol analysis, and security auditing. All original application logic, trademarks, and associated intellectual property belong to ETECSA (Empresa de Telecomunicaciones de Cuba S.A.). No proprietary binaries are hosted for redistribution.

## Official References & Ecosystem Links

| Resource | URL / Identifier | Description |
| :--- | :--- | :--- |
| **Nauta User Portal** | [https://www.nauta.cu/](https://www.nauta.cu/) | Official ETECSA self-service portal for Nauta accounts, recharges, transfers, and Nauta Hogar |
| **Legacy User Portal** | `https://portal.nauta.cu/` | Legacy portal endpoint referenced by mobile clients for account operations |
| **Captive Portal Gateway** | `https://secure.etecsa.net:8443/` | Captive portal authentication, remaining-time queries, and session termination on `WIFI_ETECSA` |
| **ETECSA Official Website** | [https://www.etecsa.cu/](https://www.etecsa.cu/) | Empresa de Telecomunicaciones de Cuba S.A. corporate portal and official APK downloads |
| **Android Package (Apklis)** | [`cu.etecsa.enp_oficial`](https://www.apklis.cu/application/cu.etecsa.enp_oficial) | Official distribution on the Cuban app store Apklis |

## Current Target Metadata

| Property | Value |
| :--- | :--- |
| **Package Name** | `cu.etecsa.enp_oficial` |
| **Application Label** | `Nauta` |
| **Target Version** | `1.2.0.1` |
| **Version Code** | `1` |
| **Project tag** | `1.2.0.1.1-v1.0` *(planned)* |
| **Compile SDK** | `28` |
| **Min SDK** | `14` |
| **Target SDK** | `28` |
| **SHA-256 Hash** | `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a` |

See [metadata extraction](docs/target-metadata.md) to reproduce these values from the APK.

## Project status

| Area | Status | Current state |
| :--- | :--- | :--- |
| APK identification and setup | Complete for current APK | Target APK (`cu.etecsa.enp_oficial-v1.apk`) placed in `.workspace/bin/`; SHA-256, version, and SDK metadata verified; folder and doc structure initialized. |
| APK decompilation and extraction | Pending | Ready to run `make decompile` to populate `src/`, `smali/`, `app/res/`, `app/assets/`, and `app/AndroidManifest.xml`. |
| Clean Java reconstruction | Not started | `app/src/main/java/` and `mappings/classes.json` are initialized and awaiting decompilation. |
| Protocol and feature analysis | Not started | Topic templates created in `docs/` for captive portal protocol, networking, security, storage, and domain models. |
| Build and behavioral validation | Not started | Compiler audit (`scripts/compile-reconstruction.py`) and runtime validation docs prepared. |

See the [task list](TODO.md) for specific remaining work. Paused sessions record a temporary checkpoint in `.workspace/handoff.md`. The bar above tracks completed checklist items; full reconstruction and Android behavior remain unverified.

## Documentation

| Document | Contents |
| :--- | :--- |
| [Target metadata](docs/target-metadata.md) | APK identity, version, SDK levels, and SHA-256 extraction. |
| [Versioning](docs/versioning.md) | Repository versions, tags, local smali archives, and cross-version comparisons. |
| [Architecture](docs/architecture.md) | Build properties, permissions (`ACCESS_WIFI_STATE`, `CHANGE_WIFI_STATE`, `SYSTEM_ALERT_WINDOW`), manifest components, and dependencies. |
| [Captive portal protocol](docs/captive-portal-protocol.md) | `WIFI_ETECSA` hotspot verification, login/logout flows (`secure.etecsa.net:8443`), `ATTRIBUTE_UUID` tracking, and User Portal actions. |
| [Networking](docs/networking.md) | HTTP stack, cookies, Wi-Fi vs. mobile data routing, and TLS certificate handling. |
| [Security](docs/security.md) | Hotspot anti-spoofing checks, TLS certificate validation, credential encryption, and manifest security audit. |
| [Storage](docs/storage.md) | Local SQLite/ORM schema, stored accounts, session state persistence, and SharedPreferences. |
| [Domain model](docs/domain-model.md) | Entities (Nauta accounts, captive portal sessions, connection history) and enum mappings. |
| [Reconstruction inventory](docs/reconstruction-inventory.md) | Reproducible source links, duplicate candidates, mapping conflicts, and review limits. |
| [Unlinked-source review ledger](docs/unmapped-source-review.md) | Per-source classification and evidence for unlinked main-package Java files. |
| [Java compilation audit](docs/java-compilation.md) | Dependency-backed compiler audit (`scripts/compile-reconstruction.py`) and classpath limits. |
| [Android runtime validation](docs/runtime-validation.md) | Isolated emulator validation guidelines, safety rules, and runtime observations. |

For work in progress, use the [task list](TODO.md). Paused sessions also provide `.workspace/handoff.md`. [CHANGELOG.md](CHANGELOG.md) records completed changes; [AGENTS.md](AGENTS.md) is the repository guide for contributors and coding agents.

---

## Versioning Strategy

Release names and Git tags use `<APK versionName>.<APK versionCode>-v<internal version>`. The current target's first planned project release is `1.2.0.1.1-v1.0`. Later work on the same APK uses `-v1.1`, `-v1.2`, and so on; a new APK starts its own internal sequence at `-v1.0`.

The project follows a **single-branch workflow** (`main`). Raw JADX Java in `src/` stays in Git for mapping references and cross-version diffs. Smali stays in the local `smali/` directory, ignored by Git, with APK-specific ZIPs in `.workspace/archives/` for local comparison or possible future Release assets.

For complete details, branching guidelines, and the APK upgrade procedure, see [docs/versioning.md](docs/versioning.md).

## Tag History

| Tag | APK version | Version code | Internal release | GitHub Release |
| :--- | :--- | ---: | :--- | :--- |
| `1.2.0.1.1-v1.0` *(pending)* | `1.2.0.1` | `1` | `v1.0` | Not published |

---

## Project structure

```text
.
├── app/
│   ├── assets/                     Extracted APK assets (pending decompilation)
│   ├── res/                        Extracted Android resources (pending decompilation)
│   └── src/main/java/              Clean Java reconstruction target
├── src/                            Raw, obfuscated JADX Java output (pending decompilation)
├── smali/                          Local Dalvik disassembly (Git-ignored)
├── mappings/
│   ├── evidence/                   Bytecode/smali verification evidence
│   └── classes.json                Obfuscated-to-clean name mappings
├── docs/                           Topic-specific analysis and procedures
├── scripts/                        Extraction, verification, inventory, and search tools
│   └── tests/                      Reconstruction unit tests
├── .workspace/
│   ├── handoff.md                  Temporary pause/resume note, tracked by Git when present
│   ├── bin/                        Local APK inputs (cu.etecsa.enp_oficial-v1.apk)
│   └── archives/                   Local versioned smali ZIPs
├── Makefile                        Analysis commands
├── TODO.md                         Remaining project tasks
├── CHANGELOG.md                    Completed changes by analysis session
├── AGENTS.md                       Repository working guide
└── README.md
```

*Generated files under `.workspace/` and the local `smali/` directory are excluded from Git, except for `.gitkeep` files that keep empty directories in clones. `handoff.md` is tracked so a paused session can be resumed. A fresh clone needs the matching APK to regenerate smali, or a separately obtained versioned smali ZIP.*

Repository inventory for the current target (2026-11-14, pre-decompilation):

| Item | Count | Location |
| :--- | ---: | :--- |
| Decompiled Java files | 0 | `src/` (pending `make decompile`) |
| Clean Java reconstruction files | 0 | `app/src/main/java/` |
| Local smali files | 0 | `smali/` (ignored by Git; pending `make decompile`) |
| Extracted resource files | 0 | `app/res/` (pending `make decompile`) |
| Extracted asset files | 0 | `app/assets/` (pending `make decompile`) |
| Topic documents | 12 | `docs/` |
| Class mappings | 0 | `mappings/classes.json` |
| Analysis scripts | 7 | `scripts/` |

## Legal Notice

**This is not the official source code for ETECSA Nauta.** It is a close approximation reconstructed from the publicly distributed build of the application for research purposes.

The Copyright Laws of the United States recognize "fair use" of copyrighted content. Section 107 of the U.S. Copyright Act states:

> "Notwithstanding the provisions of sections 106 and 106A, the fair use of a copyrighted work, including such use by reproduction in copies or phonorecords or by any other means specified by that section, for purposes such as criticism, comment, news reporting, teaching (including multiple copies for classroom use), scholarship, or research, is not an infringement of copyright."

This repository and its contents are covered under fair use for the purposes of interoperability research, security auditing, and protocol analysis. Any DMCA takedown notice targeting this repository on these grounds would be invalid.
