# Captive Portal & User Portal Protocol

Analysis of ETECSA's Wi-Fi captive portal handshake and User Portal integration in `cu.etecsa.enp_oficial`.

## 1. Connectivity & Rogue-AP Check (`MainActivity`)

Before authenticating on `WIFI_ETECSA`:
1. `MainActivity` probes `http://connectivitycheck.android.com/generate_204` (`AsyncTask` subclasses `n` and `o`) to detect whether the device is behind a captive portal or already online.
2. Reads the `wlan0` network interface and Wi-Fi BSSID/MAC address.
3. Submits `ServicePostAp` to `https://enpserver.nauta.cu/api-enp/checkmac/` via `WifiAPService` (`Retrofit` + pinned `res/raw/server.crt`) to verify whether the connected access point MAC is an official ETECSA AP or a rogue/fake AP.

## 2. Captive Portal Login (`LoginNautaPortal` → `secure.etecsa.net:8443`)

`LoginNautaPortal` uses **Jsoup** rather than a WebView to perform the login handshake:

1. **GET** `https://secure.etecsa.net:8443`
   - Captures session cookies (`JSESSIONID`) and parses `input[name=CSRFHW]` from the HTML login form.
2. **POST** `https://secure.etecsa.net:8443/EtecsaQueryServlet` with cookies and form parameters:
   - `wlanuserip`: Device's local Wi-Fi IP (`LoginNautaPortal.C`)
   - `wlanacname`: `""`
   - `wlanmac`: `""`
   - `firsturl`: `"notFound.jsp"`
   - `ssid`: `""`
   - `usertype`: `""`
   - `gotopage`: `"/nauta_etecsa/LoginURL/mobile_login.jsp"`
   - `successpage`: `"/nauta_etecsa/OnlineURL/mobile_index.jsp"`
   - `loggerId`: generated timestamp/session string
   - `lang`: `"es_ES"`
   - `username`: Nauta account (`@nauta.com.cu` / `@nauta.co.cu`)
   - `password`: Account password
   - `CSRFHW`: Extracted CSRF token
3. `NautaHtmlParser.a(Document, String)` (`g/c.java`) checks whether the returned HTML has title `"Nauta"` and contains the expected success marker; otherwise it extracts the error message from `#banner_promos ~ script`.

## 3. Session Tracking & Logout (`NautaInfoActivity` & `NautaHtmlParser`)

- `NautaHtmlParser.d(String)` extracts `ATTRIBUTE_UUID` from the `pageOnunload`..`logoutToFirstPage` JS block.
- `NautaHtmlParser.e(String)` extracts the `op=...` query parameter from `updateAvailableTime`..`EtecsaQueryServlet`.
- **Remaining Time Query**: `NautaInfoActivity` queries `https://secure.etecsa.net:8443/EtecsaQueryServlet` periodically to refresh remaining balance/time.
- **Logout**: `NautaInfoActivity` posts to `https://secure.etecsa.net:8443/LogoutServlet` to terminate the active session.

## 4. User Portal (`LoginPortalUsuario`)

- Loads `https://www.portal.nauta.cu/user/login/es-es/` inside an Android `WebView` for account management (recharge, balance transfer, password changes).
