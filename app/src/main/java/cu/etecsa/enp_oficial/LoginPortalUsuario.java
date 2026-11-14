package cu.etecsa.enp_oficial;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 * WebView wrapper for https://www.portal.nauta.cu/user/login/es-es/.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.LoginPortalUsuario
 */
public class LoginPortalUsuario extends android.support.v7.app.c {
    private d q;
    private boolean r;
    private RelativeLayout s;
    private WebView t;
    private CardView u;
    private c v;
    private Timer z;
    private boolean w = false;
    private boolean x = false;
    private Integer y = 0;
    private boolean A = false;
    private boolean B = false;

    class a extends TimerTask {

        /* JADX INFO: renamed from: cu.etecsa.enp_oficial.LoginPortalUsuario$a$a, reason: collision with other inner class name */
        class RunnableC0053a implements Runnable {

            /* JADX INFO: renamed from: cu.etecsa.enp_oficial.LoginPortalUsuario$a$a$a, reason: collision with other inner class name */
            class RunnableC0054a implements Runnable {
                RunnableC0054a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoginPortalUsuario loginPortalUsuario = LoginPortalUsuario.this;
                    loginPortalUsuario.F(loginPortalUsuario.s, "No se pudo cargar el portal de usuario", R.color.cardviewerror);
                }
            }

            RunnableC0053a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoginPortalUsuario.this.q.b1();
                LoginPortalUsuario.this.r = true;
                LoginPortalUsuario.this.t.setVisibility(4);
                LoginPortalUsuario.this.u.setVisibility(0);
                LoginPortalUsuario.this.runOnUiThread(new RunnableC0054a());
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LoginPortalUsuario loginPortalUsuario = LoginPortalUsuario.this;
            Integer numValueOf = Integer.valueOf(loginPortalUsuario.y.intValue() + 1);
            loginPortalUsuario.y = numValueOf;
            if (numValueOf.intValue() == 30) {
                LoginPortalUsuario.this.z.cancel();
                LoginPortalUsuario.this.runOnUiThread(new RunnableC0053a());
            }
        }
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            LoginPortalUsuario.this.q.c1();
            if (LoginPortalUsuario.this.r) {
                LoginPortalUsuario loginPortalUsuario = LoginPortalUsuario.this;
                loginPortalUsuario.F(loginPortalUsuario.s, "No se pudo cargar el portal de usuario", R.color.cardviewerror);
                LoginPortalUsuario.this.t.setVisibility(4);
                LoginPortalUsuario.this.u.setVisibility(0);
                if (LoginPortalUsuario.this.z != null) {
                    LoginPortalUsuario.this.z.cancel();
                }
            } else {
                if (!LoginPortalUsuario.this.x) {
                    LoginPortalUsuario loginPortalUsuario2 = LoginPortalUsuario.this;
                    loginPortalUsuario2.F(loginPortalUsuario2.s, "Portal de usuario cargado con éxito", R.color.menucolor);
                    LoginPortalUsuario.this.x = true;
                    if (LoginPortalUsuario.this.z != null) {
                        LoginPortalUsuario.this.z.cancel();
                    }
                }
                LoginPortalUsuario.this.t.setVisibility(0);
                LoginPortalUsuario.this.u.setVisibility(4);
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            LoginPortalUsuario.this.r = true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return false;
        }
    }

    private class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(LoginPortalUsuario loginPortalUsuario, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intent intent2;
            String str;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (!LoginPortalUsuario.this.w || activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (!LoginPortalUsuario.this.w && !activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                        intent2 = new Intent(LoginPortalUsuario.this, (Class<?>) MainActivity.class);
                    } else if (LoginPortalUsuario.this.w || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                        return;
                    } else {
                        intent2 = new Intent(LoginPortalUsuario.this, (Class<?>) MainActivity.class);
                    }
                    intent2.putExtra("message", "Fueron deshabilitados los datos móviles");
                } else {
                    LoginPortalUsuario.this.D();
                    intent2 = new Intent(LoginPortalUsuario.this, (Class<?>) MainActivity.class);
                    str = "Se habilitaron los datos móviles";
                }
                LoginPortalUsuario.this.startActivity(intent2);
                LoginPortalUsuario.this.finish();
            }
            LoginPortalUsuario.this.D();
            intent2 = new Intent(LoginPortalUsuario.this, (Class<?>) MainActivity.class);
            str = "No existe conexión con ninguna red";
            intent2.putExtra("message", str);
            LoginPortalUsuario.this.startActivity(intent2);
            LoginPortalUsuario.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (UserAccountService.class.getName().equals(it.next().service.getClassName())) {
                stopService(new Intent(this, (Class<?>) UserAccountService.class));
            }
        }
    }

    private void E() {
        A((Toolbar) findViewById(R.id.toolbar));
        u().s(true);
        u().u("Portal de usuario");
        if (getIntent().getExtras() != null) {
            this.w = true;
            this.A = getIntent().getExtras().getBoolean("tendedera");
            this.B = getIntent().getExtras().getBoolean("allow");
        } else {
            this.w = false;
        }
        c cVar = new c(this, null);
        this.v = cVar;
        registerReceiver(cVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.r = false;
        this.s = (RelativeLayout) findViewById(R.id.rootrelative);
        d dVar = new d();
        this.q = dVar;
        dVar.f1(true);
        this.q.h1(l(), "custom");
        CardView cardView = (CardView) findViewById(R.id.errorcardview);
        this.u = cardView;
        cardView.setVisibility(4);
        TextView textView = (TextView) findViewById(R.id.errorcardviewicon);
        TextView textView2 = (TextView) findViewById(R.id.errorcardviewtext);
        cu.etecsa.enp_oficial.g.d.a(textView, "fontawesome-webfont", this);
        cu.etecsa.enp_oficial.g.d.a(textView2, "RobotoCondensed-Bold", this);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.t = webView;
        webView.loadUrl("https://www.portal.nauta.cu/user/login/es-es/");
        this.t.getSettings().setJavaScriptEnabled(true);
        this.t.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.t.setWebChromeClient(new WebChromeClient());
        U();
        this.t.setWebViewClient(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(View view, String str, int i) {
        Snackbar snackbarW = Snackbar.w(view, str, 0);
        View viewK = snackbarW.k();
        cu.etecsa.enp_oficial.g.d.a((TextView) viewK.findViewById(R.id.snackbar_text), "RobotoCondensed-Regular", this);
        viewK.setBackgroundColor(getResources().getColor(i));
        snackbarW.s();
    }

    private void U() {
        this.z = new Timer();
        this.y = 0;
        this.z.schedule(new a(), 1000L);
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login_portal_usuario);
        E();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_portalusuario, menu);
        return true;
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.app.Activity
    protected void onDestroy() {
        c cVar = this.v;
        if (cVar != null) {
            unregisterReceiver(cVar);
        }
        super.onDestroy();
    }

    @Override // android.support.v7.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        moveTaskToBack(true);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.action_refresh) {
                return false;
            }
            U();
            this.q.h1(l(), "custom");
            this.t.loadUrl("https://www.portal.nauta.cu/user/login/es-es/");
            this.r = false;
            this.x = false;
            return true;
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        if (this.w) {
            if (this.B) {
                intent.putExtra("this_time", true);
            }
            if (this.A) {
                intent.putExtra("tendedera", true);
            }
            intent.putExtra("allow_without_verified_internet", true);
        }
        this.q.c1();
        startActivity(intent);
        finish();
        return true;
    }
}
