# Architecture Overview

Target: `cu.etecsa.enp_oficial` v1.2.0.1 (versionCode `1`), SHA-256 `037f7bf4ddb93ed828507b1a42b97bfdb132c8744525e3338d8e76ebfdfaf32a`.

> [!NOTE]
> **Status:** Pre-decompilation baseline. Only APK badging metadata (`aapt2 dump badging`) has been extracted so far. Run `make decompile` to populate `src/`, `smali/`, `app/res/`, `app/assets/`, and `app/AndroidManifest.xml`.

## Build & Package Properties

| Property | Value |
| :--- | :--- |
| **Package Name** | `cu.etecsa.enp_oficial` |
| **Application Label** | `Nauta` |
| **Version Name** | `1.2.0.1` |
| **Version Code** | `1` |
| **Compile SDK** | `28` (Android 9) |
| **Min SDK** | `14` (Android 4.0) |
| **Target SDK** | `28` (Android 9) |
| **APK Size** | 3,087,734 bytes (~2.9 MB) |

## Declared Permissions (from `aapt2 dump badging`)

- Wi-Fi & Network Management: `ACCESS_WIFI_STATE`, `CHANGE_WIFI_STATE`, `ACCESS_NETWORK_STATE`, `INTERNET`
- Overlay / Floating Timer UI: `SYSTEM_ALERT_WINDOW`

## Pending Analysis Sections (Post-Decompilation)

- **Manifest Components:** Activities, Services (floating timer / connection monitor), BroadcastReceivers (`WIFI_STATE_CHANGED`, connectivity changes), and exported flags.
- **Package Structure & Obfuscation:** ProGuard/R8 obfuscation patterns under `cu.etecsa.enp_oficial` and bundled third-party libraries (e.g., Jsoup, OkHttp, Android Support/AndroidX).
- **Floating Session Window (`SYSTEM_ALERT_WINDOW`):** Service implementation that displays active connection time and quick disconnect controls.
- **Bundled Assets & Certificates:** Any bundled X.509 certificates, HTML templates, or configuration files in `app/assets/` and `app/res/raw/`.
