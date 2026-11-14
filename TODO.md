# TODO — ETECSA Nauta Reverse Engineering

## Extraction & Setup

- [x] Verify APK identity (SHA-256, package `cu.etecsa.enp_oficial`, version `1.2.0.1`, code `1`, SDK levels)
- [x] Initialize repository directory structure, documentation templates, and toolchain scripts
- [x] Inventory APK contents (DEX files, assets, raw resources, bundled certificates)
- [x] Run `make decompile` to extract JADX Java (`src/`), Apktool smali (`smali/`), manifest, resources (`app/res/`), and assets (`app/assets/`)
- [x] Archive local smali disassembly into `.workspace/archives/smali-1.2.0.1.1.zip` and record its SHA-256
- [x] Verify JADX decompilation quality and error count
- [x] Decode and analyze `app/AndroidManifest.xml` (activities, services, receivers, permissions, intent filters)
- [x] Extract resource strings, error messages, and portal URLs

## Clean Java Reconstruction

- [x] Generate initial reproducible [source-to-clean inventory](docs/reconstruction-inventory.md) after decompilation (`make inventory`)
- [x] Identify named (unobfuscated) classes and infer obfuscated sub-package roles in `cu.etecsa.enp_oficial`
- [x] Populate initial high-confidence class mappings in `mappings/classes.json`
- [x] Classify main-package sources in [unmapped-source-review.md](docs/unmapped-source-review.md) (application behavior, support, generated, library)
- [x] Reconstruct core activities, captive portal client, and floating timer service
- [x] Reconstruct account and session domain entities and persistence helpers
- [ ] Set up local `target-bytecode.jar` with dex2jar and run `make compile-audit`

## Architecture & Components

- [x] Map application startup flow and main navigation screens
- [x] Document the floating session window service (`SYSTEM_ALERT_WINDOW`)
- [x] Document Wi-Fi state receivers (`ACCESS_WIFI_STATE`, `CHANGE_WIFI_STATE`, `ACCESS_NETWORK_STATE`)
- [x] Inspect bundled assets or raw resources (certificates, HTML templates, configuration)

## Captive Portal & User Portal Protocol

- [x] Trace `WIFI_ETECSA` access point detection and genuineness verification logic
- [x] Reverse engineer captive portal login handshake against `secure.etecsa.net:8443` (`CSRFHW`, `wlanuserip`, `ATTRIBUTE_UUID`)
- [x] Reverse engineer active session time queries (`getLeftTime`) and keep-alive polling
- [x] Reverse engineer session logout flow (`LogoutServlet`) and error recovery
- [x] Trace User Portal (`portal.nauta.cu` / `www.nauta.cu`) authentication, captcha handling, voucher recharge, balance transfer, and password change flows

## Networking & TLS

- [x] Extract all hardcoded `*.etecsa.net`, `*.nauta.cu`, and `*.etecsa.cu` URLs from DEX and resources
- [x] Document HTTP client implementation, cookie management (`JSESSIONID`), and HTML parser (e.g., Jsoup)
- [x] Trace network interface selection / Wi-Fi vs. mobile data switching for User Portal access
- [x] Audit TLS configuration, custom `X509TrustManager` / `HostnameVerifier`, and certificate pinning

## Security & Cryptography

- [x] Audit manifest security flags (`debuggable`, `allowBackup`, `usesCleartextTraffic`, exported components)
- [x] Analyze how legitimate ETECSA hotspots are distinguished from rogue/evil-twin APs
- [x] Identify any encryption or obfuscation used for stored Nauta credentials (`@nauta.com.cu`, `@nauta.co.cu`)
- [x] Check for hardcoded keys, salts, or trust-all TLS bypasses

## Local Storage & Database

- [x] Identify database engine or persistence mechanism (`SQLiteOpenHelper`, ORMLite, `SharedPreferences`)
- [x] Extract schema for stored accounts, connection logs, and session state (`ATTRIBUTE_UUID`)
- [x] Map all `SharedPreferences` keys and session recovery behavior after app restart or network drop

## Dynamic & Runtime Checks (Isolated Emulator)

- [ ] Launch APK in an isolated, network-restricted Android emulator and capture initial startup behavior
- [ ] Inspect UI hierarchy and compare with static layout/navigation analysis
- [ ] Record runtime observations and safety boundaries in [runtime-validation.md](docs/runtime-validation.md)
