# Security Analysis

Security assessment of **ETECSA Nauta** (`cu.etecsa.enp_oficial` `v1.2.0.1`, `versionCode` `1`).

## 1. Manifest & Component Security

- **Backup disabled**: `android:allowBackup="false"` prevents ADB backup extraction of `enp.db`.
- **Exported components**: Only `SplashScreenActivity` is exported (via `MAIN`/`LAUNCHER`). Both `UserAccountService` and `SendAccountService` set `android:exported="false"`.
- **Overlay permission**: Requests `SYSTEM_ALERT_WINDOW` to display the floating session timer (`UserAccountService`).

## 2. Credential & Session Storage

- The `user` table in `enp.db` stores `user VARCHAR(50)` and `password VARCHAR(30)` locally when "Remember" is enabled (`settings.remember`).
- `session` and `sessionfake` store `remaining_time_url`, `logout_url`, `time_elapsed`, `mac`, and `date`.

## 3. Rogue-AP Telemetry & Leftover Development URL

- **Certificate Pinning (`enpserver.nauta.cu`)**: `MainActivity` pins `res/raw/server.crt` via `SslContextHelper` (`g/a.java`) and restricts hostname verification to `enpserver.nauta.cu`.
- **Leftover LAN Endpoint in `SendAccountService`**: `SendAccountService.java` hardcodes `http://192.168.43.227:8000/` with a `HostnameVerifier` checking `"192.168.43.227:8000"`, indicating uncleaned development/testing code for `api-enp/userfakeap/` and `api-enp/useretecsaap/`.
- **`SendAccountService` Telemetry Payload**: Sends `ServicePostUserClient` (4 string fields) to the telemetry endpoints when reporting AP events.
