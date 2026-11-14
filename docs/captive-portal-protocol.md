# Captive Portal & Session Protocol

Target: `cu.etecsa.enp_oficial` v1.2.0.1 (versionCode `1`).

> [!NOTE]
> **Status:** Structural template (pending decompilation). Document exact HTTP form parameters, HTML scraping selectors, and session state machines once `src/` and `smali/` are extracted.

## Scope

The official ETECSA Nauta app (`cu.etecsa.enp_oficial`) manages authentication against ETECSA public Wi-Fi (`WIFI_ETECSA`) and Nauta Hogar captive portals (`secure.etecsa.net:8443`), verifies legitimate access points, tracks remaining session time, and provides direct access to the Nauta User Portal (`portal.nauta.cu` / `www.nauta.cu`).

## Areas to Document

1. **Access Point & Captive Portal Detection (`WIFI_ETECSA`)**
   - Wi-Fi SSID/BSSID checks (`ACCESS_WIFI_STATE`, `CHANGE_WIFI_STATE`) and anti-spoofing / rogue AP validation logic.
   - Initial HTTP probe and captive portal redirect detection.

2. **Login & Authentication Flow (`secure.etecsa.net:8443`)**
   - Login page scraping (`CSRFHW`, `wlanuserip`, `loggerId`, `ssid`, `udar`, etc.).
   - Credential submission (`username` `@nauta.com.cu` / `@nauta.co.cu`, `password`) and session UUID extraction (`ATTRIBUTE_UUID`).
   - Error message parsing (insufficient balance, account already in use, invalid credentials).

3. **Active Session Management & Logout**
   - Remaining time query (`getLeftTime` / `op=getLeftTime`) and periodic keep-alive polling.
   - Logout request (`LogoutServlet` / `ATTRIBUTE_UUID`) and fallback session termination.

4. **User Portal Integration (`portal.nauta.cu` / `www.nauta.cu`)**
   - Embedded WebView or HTTP client flows for captcha, balance checks, top-ups (voucher recharge), transfers, and password changes.
