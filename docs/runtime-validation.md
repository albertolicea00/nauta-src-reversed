# Runtime Validation

Scope and status of dynamic/runtime validation for **ETECSA Nauta** (`cu.etecsa.enp_oficial` `v1.2.0.1`, `versionCode` `1`).

## Static Verification Completed

- `make verify` confirmed package `cu.etecsa.enp_oficial`, `versionName` `v1.2.0.1`, `versionCode` `1`, `minSdkVersion` `14`, `targetSdkVersion` `28`, `compileSdkVersion` `28`, and APK SHA-256 `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`.
- JADX 1.5.6 extracted all 35 files in `cu.etecsa.enp_oficial.*` cleanly (2 JADX errors occurred only in third-party obfuscated support/library classes outside `cu.*`).
- Apktool 3.0.3 decoded `AndroidManifest.xml`, 109 XML resources, `res/raw/server.crt`, and `assets/databases/enp.db`.

## Outstanding Runtime Checks

- Emulator verification of `UserAccountService` floating overlay (`SYSTEM_ALERT_WINDOW`) and `LoginNautaPortal` form submission against a mocked `secure.etecsa.net:8443` captive portal.
