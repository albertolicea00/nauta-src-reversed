# Java Compilation Audit

Static compilation notes for `cu.etecsa.enp_oficial` (`v1.2.0.1`, `versionCode` `1`).

## Scope & Dependencies

- Reconstructed clean sources under `app/src/main/java/cu/etecsa/enp_oficial/` (34 classes) link directly to obfuscated third-party library packages in the APK (`android.support.v7.*`, `b.a.a.*` Gson, `c.*` OkHttp 3, `e.*` Retrofit 2, `b.b.a.a` `SQLiteAssetHelper`, `org.jsoup.*`).
- Full `javac` compilation requires building a local `target-bytecode.jar` from the APK's DEX via `dex2jar` alongside an Android SDK `android.jar` (`make compile-audit ANDROID_JAR=... BYTECODE_JAR=...`).

## Observed `make compile-audit` Results (2026-11-15)

- **Command**: `ANDROID_JAR=$HOME/Library/Android/sdk/platforms/android-37.0/android.jar make compile-audit`
- **Compiler**: `javac 17.0.15` (`34` clean sources + generated `cu.etecsa.enp_oficial.R`)
- **Classpath**: `android-37.0/android.jar` + `.workspace/tools/target-bytecode.jar`
- **Initial run**: failed with **7 parse errors in 7 files** (`invalid method declaration; return type required`) due to leftover obfuscated constructor names (`b`, `a`, `c`, `d`, `e`) after class renaming.
- **After fixing the 7 constructor names**: `javac` progressed to type/symbol resolution and failed with **95 errors in 12 files** (22 clean files had 0 errors):
  - `MainActivity.java` (36): inner class `MainActivity.e` shadows Retrofit package `e.*` (`e.d`, `e.b`, `e.l`).
  - `NautaInfoActivity.java` (17): inner class `NautaInfoActivity.c` shadows OkHttp package `c.*` (`c.f`, `c.e`), plus `c.f` package-private visibility.
  - `EmailDomainAutoCompleteAdapter.java` (16), `MenuIconAdapter.java` (6), `SettingsAdapter.java` (6), `MenuIconViewHolder.java` (4), `SettingsViewHolder.java` (2): leftover short class / enclosing-`this` names (`b`, `c`, `e`, `a`) after moving/renaming into `cu.etecsa.enp_oficial.ui.adapter` and `cu.etecsa.enp_oficial.model`.
  - `SendAccountService.java` (3): `WifiAPService.class` / `bVar.clone().u(this)` type/symbol mismatches against `target-bytecode.jar`.
  - `LoginNautaPortal.java` (2): `ByteOrder.nativeOrder().equals(...)` and `Collections.list(NetworkInterface.getNetworkInterfaces())` attribution errors.
  - `UserAccountService.java` (1): `a.b.f.a.c.b(this).d(intent)` shadowed by inner class `a`.
  - `Settings.java` (1), `NautaHtmlParser.java` (1): `cannot infer type arguments for ArrayList<>` / `TreeMap<>` during multi-file attribution.
