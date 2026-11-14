# Local Storage & Database

Persistence analysis for `cu.etecsa.enp_oficial` (`v1.2.0.1`, `versionCode` `1`).

## SQLite Database (`assets/databases/enp.db`)

Opened via `EnpDatabaseHelper` (`cu.etecsa.enp_oficial.g.b`), extending `SQLiteAssetHelper` (`b.b.a.a`, database version `1`). The extracted schema is tracked in `app/assets/databases/enp_schema.sql`.

| Table | Purpose | Key Columns |
|---|---|---|
| `user` | Saved Nauta credentials | `id`, `user VARCHAR(50)`, `password VARCHAR(30)` |
| `session` | Active captive portal session URLs | `id`, `remaining_time_url`, `logout_url`, `time_elapsed DEFAULT "00:00"` |
| `sessionfake` | Recorded rogue/fake AP session info | `id`, `remaining_time_url`, `logout_url`, `mac`, `date` |
| `userterms` | Terms-of-use acceptance flag | `id`, `seen BOOLEAN` |
| `time` | Session time log | `id`, `time TEXT` |
| `settings` | Prepopulated app preferences (1 default row: `1\|true\|true\|true\|true\|true\|false`) | `showwidget`, `showdownload`, `showsignal`, `showupload`, `remember`, `disconnect` |
