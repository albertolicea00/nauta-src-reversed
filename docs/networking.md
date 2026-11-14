# Networking & TLS

Analysis of HTTP clients, endpoints, and TLS configuration in `cu.etecsa.enp_oficial`.

## Observed Endpoints

| Endpoint | Component | Purpose |
|---|---|---|
| `https://secure.etecsa.net:8443` | `LoginNautaPortal` | Fetch `CSRFHW` token and `JSESSIONID` cookie |
| `https://secure.etecsa.net:8443/EtecsaQueryServlet` | `LoginNautaPortal`, `NautaInfoActivity` | Captive portal authentication and remaining-time polling |
| `https://secure.etecsa.net:8443/LogoutServlet` | `NautaInfoActivity` | Captive portal session logout |
| `https://www.portal.nauta.cu/user/login/es-es/` | `LoginPortalUsuario` | User Portal `WebView` |
| `https://enpserver.nauta.cu/api-enp/checkmac/` | `MainActivity` → `WifiAPService` | Official vs. rogue Wi-Fi AP MAC verification |
| `http://connectivitycheck.android.com/generate_204` | `MainActivity` | Captive portal / internet reachability probe |
| `http://192.168.43.227:8000/api-enp/userfakeap/` | `SendAccountService` → `WifiAPService` | Leftover development URL for fake-AP telemetry |
| `http://192.168.43.227:8000/api-enp/useretecsaap/` | `SendAccountService` → `WifiAPService` | Leftover development URL for ETECSA-AP telemetry |

## HTTP Clients & TLS Pinning

- **Retrofit 2 + OkHttp 3 + Gson** (`WifiAPService`):
  - `MainActivity` configures `OkHttpClient.Builder` with a custom `SSLSocketFactory` from `SslContextHelper.a(Context)` (`g/a.java`), which loads the X.509 certificate `R.raw.server` (`res/raw/server.crt`) into a `KeyStore` and `TrustManagerFactory`.
  - `MainActivity` pairs this with a `HostnameVerifier` checking `hostname.equals("enpserver.nauta.cu")`.
- **Jsoup** (`LoginNautaPortal`, `NautaInfoActivity`):
  - Performs direct HTTPS form GET/POST requests to `secure.etecsa.net:8443` and parses HTML/JS responses via `NautaHtmlParser` (`g/c.java`).
