# Email Protocol Scope (`@nauta.cu`)

Static inspection of `cu.etecsa.enp_oficial` (`v1.2.0.1`, `versionCode` `1`) confirms that **no IMAP, POP3, or SMTP client is implemented** in this APK.

## Clarification

- *Entorno Nauta Portal* (`cu.etecsa.enp_oficial`) is specifically ETECSA's official **Wi-Fi captive portal and `portal.nauta.cu` utility client**.
- Email domain references in `EmailDomainAutoCompleteAdapter` (`f/a.java`) and `DomainSuggestionItem` (`f/b.java`) apply only to **Nauta Wi-Fi navigation accounts** (`@nauta.com.cu` and `@nauta.co.cu`), not `@nauta.cu` mail transport.
