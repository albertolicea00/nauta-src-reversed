# Architecture Overview

Static architectural analysis of **ETECSA Nauta** (*Entorno Nauta Portal*, package `cu.etecsa.enp_oficial`, version `v1.2.0.1`, `versionCode` `1`).

## Target Summary

| Attribute | Value |
|---|---|
| Package | `cu.etecsa.enp_oficial` |
| Version | `v1.2.0.1` (`versionCode` `1`) |
| Min / Target / Compile SDK | `14` / `28` / `28` |
| Total DEX Classes | 1,867 (35 under `cu.etecsa.enp_oficial.*`) |
| Launcher Activity | `cu.etecsa.enp_oficial.SplashScreenActivity` |
| Architecture Pattern | Classic Android Support v7 (`AppCompatActivity`) + Retrofit 2 + OkHttp 3 + Jsoup + `SQLiteAssetHelper` |

## Manifest Components

### Activities (8, portrait-locked, `AppTheme.NoActionBar`, none exported except launcher)
- `SplashScreenActivity` (`MAIN`/`LAUNCHER`): Initializes `EnpDatabaseHelper` (`enp.db`), displays version `v1.2.0.1`, and transitions to `MainActivity`.
- `MainActivity`: Primary dashboard showing menu tiles (`MenuIconAdapter`), checking `connectivitycheck.android.com/generate_204`, inspecting `wlan0` MAC/BSSID, and querying `https://enpserver.nauta.cu/api-enp/checkmac/`.
- `LoginNautaPortal`: Captive portal authentication form with `@nauta.com.cu` / `@nauta.co.cu` autocomplete (`EmailDomainAutoCompleteAdapter`) posting to `https://secure.etecsa.net:8443/EtecsaQueryServlet`.
- `NautaInfoActivity`: Active session screen polling remaining time from `EtecsaQueryServlet` and issuing session disconnect via `LogoutServlet`.
- `LoginPortalUsuario`: Embedded `WebView` loading `https://www.portal.nauta.cu/user/login/es-es/`.
- `InfoUser`: Account information screen.
- `Settings`: Preferences screen (`SettingsAdapter`) persisted in the `settings` table of `enp.db`.
- `About`: Version and ETECSA credit screen.

### Services (2, `exported="false"`)
- `UserAccountService`: Floating `WindowManager` overlay (`SYSTEM_ALERT_WINDOW`, `floatinguseraccountlayout.xml`) displaying live elapsed/remaining session time.
- `SendAccountService`: Background service posting telemetry to `api-enp/userfakeap/` and `api-enp/useretecsaap/`.

## Permissions & Bundled Resources

- **Permissions**: `ACCESS_WIFI_STATE`, `CHANGE_WIFI_STATE`, `ACCESS_NETWORK_STATE`, `INTERNET`, `SYSTEM_ALERT_WINDOW` (plus `<uses-permission-sdk-23>` duplicates).
- **Raw Certificate**: `res/raw/server.crt` (1,306 bytes X.509 certificate for `enpserver.nauta.cu`).
- **Prepopulated Database**: `assets/databases/enp.db` (schema dumped in `app/assets/databases/enp_schema.sql`).
- **Bundled Fonts**: Roboto, Roboto Condensed, and FontAwesome TTF files in `assets/fonts/`.
