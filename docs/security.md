# Security & Cryptography

Target: `cu.etecsa.enp_oficial` v1.2.0.1 (versionCode `1`).

> [!NOTE]
> **Status:** Structural template (pending decompilation). Populate with concrete evidence from `app/AndroidManifest.xml`, `src/`, and `smali/` after decompiling.

## Audit Checklist

1. **Manifest Security Posture**
   - `android:debuggable`, `android:allowBackup`, `android:usesCleartextTraffic` (especially relevant on `targetSdkVersion 28`).
   - Exported Activities, Services, BroadcastReceivers, and ContentProviders.
   - `SYSTEM_ALERT_WINDOW` overlay permission usage.

2. **Wi-Fi & Captive Portal Verification**
   - How `cu.etecsa.enp_oficial` verifies that a `WIFI_ETECSA` hotspot is genuine before transmitting Nauta credentials.
   - TLS certificate validation on `secure.etecsa.net:8443` (whether it pins ETECSA certificates, uses bundled CAs, or bypasses trust checks).

3. **Credential & Session Storage**
   - How stored `@nauta.com.cu` / `@nauta.co.cu` usernames, passwords, and active `ATTRIBUTE_UUID` tokens are persisted locally (plaintext vs. encrypted in SQLite / `SharedPreferences`).
   - Any hardcoded encryption keys, salts, or obfuscated secrets in DEX bytecode.
