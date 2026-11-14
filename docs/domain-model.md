# Domain Model

Catalog of domain entities and DTOs in `cu.etecsa.enp_oficial.model` (plus `DomainSuggestionItem`).

| Clean Class | Obfuscated Source | Purpose |
|---|---|---|
| `LoginPortalNautaData` | `cu.etecsa.enp_oficial.model.LoginPortalNautaData` | Holds captive portal base URL and response status message |
| `MenuIconItem` | `cu.etecsa.enp_oficial.model.MenuIconItem` | Dashboard grid item (label and icon resource ID) |
| `NautaInfoData` | `cu.etecsa.enp_oficial.model.NautaInfoData` | Active session metadata displayed in `NautaInfoActivity` |
| `ServicePostAp` | `cu.etecsa.enp_oficial.model.ServicePostAp` | Retrofit payload for `api-enp/checkmac/` (AP MAC, message, BSSID, app version, device info) |
| `ServicePostUserClient` | `cu.etecsa.enp_oficial.model.ServicePostUserClient` | Retrofit payload for `api-enp/userfakeap/` and `api-enp/useretecsaap/` |
| `Session` | `cu.etecsa.enp_oficial.model.Session` | Active session URLs (`remaining_time_url`, `logout_url`, `time_elapsed`) |
| `SettingsItem` | `cu.etecsa.enp_oficial.model.SettingsItem` | User preference row backed by `enp.db` `settings` table |
| `UserInfo` | `cu.etecsa.enp_oficial.model.UserInfo` | Saved Nauta username/password entry |
| `DomainSuggestionItem` | `cu.etecsa.enp_oficial.f.b` | Autocomplete item for `@nauta.com.cu` / `@nauta.co.cu` |
