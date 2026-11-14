# Java Compilation Audit

Static compilation notes for `cu.etecsa.enp_oficial` (`v1.2.0.1`, `versionCode` `1`).

## Scope & Dependencies

- Reconstructed clean sources under `app/src/main/java/cu/etecsa/enp_oficial/` (34 classes) link directly to obfuscated third-party library packages in the APK (`android.support.v7.*`, `b.a.a.*` Gson, `c.*` OkHttp 3, `e.*` Retrofit 2, `b.b.a.a` `SQLiteAssetHelper`, `org.jsoup.*`).
- Full `javac` compilation requires building a local `target-bytecode.jar` from the APK's DEX via `dex2jar` alongside `android-28` `android.jar` (`make compile-audit ANDROID_JAR=... BYTECODE_JAR=...`).
