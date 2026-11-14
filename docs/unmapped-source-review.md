# Unlinked main-package source review

Target: `cu.etecsa.enp_oficial-v1.apk`, SHA-256
`037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`.

## Purpose and limits

This ledger tracks Java source files in the main application package (`cu.etecsa.enp_oficial`) that lack exact clean-source links in `app/src/main/java/`. The ledger is an audit queue, not a decompilation-success metric. JADX decompilation success and source-to-clean class identity links are separate measures, and a link does not prove behavioral equivalence.

Classification categories:
- `application behavior`: UI, routing, domain rules, persistence, captive-portal protocol, Wi-Fi verification, network, or security logic.
- `application support`: shared helpers, base classes, adapters, or internal utilities supporting app behavior.
- `generated`: resource/build output, synthetic bridges, binding code, or compiler-generated machinery (`BuildConfig`, `R`, R8 synthetic classes).
- `third-party/library`: vendored or dependency implementation rather than Nauta-specific behavior.

## Current status

Pending initial decompilation (`make decompile`). Populate package-by-package review tables after generating the baseline inventory with `make inventory`.
