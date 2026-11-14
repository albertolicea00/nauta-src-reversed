# Changelog

## 2026-11-14 — cu.etecsa.enp_oficial-v1.apk — SHA-256: `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`

- Initialized repository directory structure (`app/assets/`, `app/res/`, `app/src/main/java/`, `src/`, `smali/`, `mappings/evidence/`, `scripts/tests/`, `docs/`, `.workspace/bin/`, `.workspace/archives/`) matching `transfermovil-src-reversed` without starting APK decompilation yet.
- Verified target APK metadata (`cu.etecsa.enp_oficial` v1.2.0.1, versionCode `1`, minSdk `14`, targetSdk `28`, compileSdk `28`, SHA-256 `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`) and documented reproducible extraction commands in `docs/target-metadata.md`.
- Added `Makefile` and analysis toolchain scripts (`verify-apk.sh`, `decompile.sh`, `search-strings.sh`, `mapping-stats.sh`, `reconstruction-inventory.py`, `update-progress.py`, `compile-reconstruction.py`) configured for `cu.etecsa.enp_oficial`.
- Created initial documentation set in `docs/` (`target-metadata.md`, `versioning.md`, `architecture.md`, `captive-portal-protocol.md`, `networking.md`, `security.md`, `storage.md`, `domain-model.md`, `reconstruction-inventory.md`, `unmapped-source-review.md`, `java-compilation.md`, `runtime-validation.md`).
- Added `README.md` with target metadata, official ETECSA Nauta web and portal references (`www.nauta.cu`, `portal.nauta.cu`, `secure.etecsa.net:8443`, `etecsa.cu`, Apklis), project status, documentation index, versioning strategy, and repository structure.
- Added `AGENTS.md` repository working guide and `TODO.md` reverse-engineering checklist.
