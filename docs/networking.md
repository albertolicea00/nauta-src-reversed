# Networking & Endpoints

Target: `cu.etecsa.enp_oficial` v1.2.0.1 (versionCode `1`).

> [!NOTE]
> **Status:** Structural template (pending decompilation). Known ETECSA Nauta domains are listed below as initial references; verify exact hardcoded URLs, ports, HTTP clients, and TLS trust managers from decompiled source.

## Ecosystem & Known Infrastructure Domains

| Domain / URL | Role |
| :--- | :--- |
| `https://www.nauta.cu/` | Unified Nauta User Portal (self-service account management, balance, recharges, transfers) |
| `https://portal.nauta.cu/` | Legacy Nauta User Portal endpoint often referenced by older Android clients |
| `https://secure.etecsa.net:8443/` | Captive portal authentication and session management gateway (`LoginServlet`, `LogoutServlet`, `EtecsaQueryServlet`) |
| `https://www.etecsa.cu/` | ETECSA official corporate portal and APK download source |
| `https://www.apklis.cu/application/cu.etecsa.enp_oficial` | Official Android distribution page on Apklis |

## Pending Analysis Sections (Post-Decompilation)

- **HTTP Client Stack:** `HttpURLConnection` / OkHttp / Apache HttpClient / Jsoup usage, cookie jar handling (`JSESSIONID`), timeouts, and User-Agent headers.
- **Network Routing & Mobile Data Toggle:** How the app switches or binds between `WIFI_ETECSA` and mobile data (`nauta` APN) when opening the User Portal.
- **TLS & Certificate Pinning:** Custom `X509TrustManager`, `HostnameVerifier`, or bundled ETECSA root/intermediate certificates for `secure.etecsa.net:8443` and `portal.nauta.cu`.
