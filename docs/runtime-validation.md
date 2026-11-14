# Local Android runtime validation

Target: `cu.etecsa.enp_oficial-v1.apk`, SHA-256
`037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`.

## Scope and safety rules

When performing dynamic or hybrid-APK validation in an Android emulator:

1. Use an isolated Android Virtual Device (AVD) dedicated to research.
2. Disable external network connectivity or route traffic only to a local mock server when testing captive portal responses.
3. Do not submit live Nauta credentials or unauthorized requests to production ETECSA servers (`secure.etecsa.net`, `portal.nauta.cu`, `www.nauta.cu`).
4. Keep all modified/hybrid APKs, UI hierarchy dumps, screenshots, and logcat captures inside `.workspace/` (excluded from Git).

## Observed results

Pending decompilation and initial static analysis. Record emulator environment, API level, startup behavior, and screen hierarchy comparisons here once dynamic checks are performed.
