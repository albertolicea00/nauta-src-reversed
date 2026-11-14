package cu.etecsa.enp_oficial;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import c.a0;
import c.c0;
import c.x;
import cu.etecsa.enp_oficial.api.WifiAPService;
import cu.etecsa.enp_oficial.model.MenuIconItem;
import cu.etecsa.enp_oficial.model.ServicePostAp;
import cu.etecsa.enp_oficial.model.Session;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends android.support.v7.app.c implements cu.etecsa.enp_oficial.e.a.a {
    private static String E = "default_channel";
    private static String F = "Default";
    private r D;
    private RecyclerView q;
    private WifiManager t;
    private ArrayList<MenuIconItem> u;
    private Session v;
    private cu.etecsa.enp_oficial.a w;
    private String x;
    private String y;
    private RelativeLayout z;
    String[] r = {"android.permission.INTERNET", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"};
    private int s = 0;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.K(mainActivity.z, "El certificado no es válido.", R.color.cardviewerror);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.K(mainActivity.z, "Usted posee conexión a Internet.", R.color.cardviewerror);
        }
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.v.open();
            if (!MainActivity.this.v.seen()) {
                MainActivity.this.v.insertseen();
            }
            MainActivity.this.v.close();
        }
    }

    class d implements DialogInterface.OnClickListener {
        d(MainActivity mainActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity mainActivity = MainActivity.this;
            android.support.v4.app.a.g(mainActivity, mainActivity.r, 101);
        }
    }

    class f implements DialogInterface.OnClickListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "No fueron otorgados los permisos a la aplicación.", R.color.cardviewerror);
            }
        }

        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.runOnUiThread(new a());
        }
    }

    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity mainActivity = MainActivity.this;
            android.support.v4.app.a.g(mainActivity, mainActivity.r, 101);
        }
    }

    class h implements DialogInterface.OnClickListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "No fueron otorgados los permisos a la aplicación.", R.color.cardviewerror);
            }
        }

        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.runOnUiThread(new a());
        }
    }

    class i implements HostnameVerifier {
        i(MainActivity mainActivity) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return str.equals("enpserver.nauta.cu");
        }
    }

    class j implements e.d<ServicePostAp> {

        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e.l f2228b;

            a(e.l lVar) {
                this.f2228b = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.H(((ServicePostAp) this.f2228b.a()).getOk_response());
                Toast.makeText(MainActivity.this, ((ServicePostAp) this.f2228b.a()).getOk_response(), 1).show();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "Conectado a Wi-fi de ETECSA.", R.color.menucolor);
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "Su versión caducó, debe actualizarla.", R.color.cardviewerror);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f2232b;

            d(String str) {
                this.f2232b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.H(this.f2232b);
                Toast.makeText(MainActivity.this, this.f2232b, 1).show();
            }
        }

        class e implements DialogInterface.OnClickListener {
            e() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new o(MainActivity.this, null).execute("http://connectivitycheck.android.com/generate_204");
            }
        }

        class f implements DialogInterface.OnClickListener {
            f() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.w.c1();
            }
        }

        class g implements Runnable {
            g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "Error en el servidor.", R.color.cardviewerror);
            }
        }

        class h implements Runnable {
            h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "La conexion no es válida, intente de nuevo o cambie de ubicación.", R.color.cardviewerror);
            }
        }

        class i implements Runnable {
            i() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "La conexion falló, inténtelo de nuevo.", R.color.cardviewerror);
            }
        }

        j() {
        }

        @Override // e.d
        public void a(e.b<ServicePostAp> bVar, Throwable th) {
            MainActivity mainActivity;
            Runnable iVar;
            MainActivity.this.w.c1();
            if (th.toString().contains("javax.net.ssl.SSLHandshakeException")) {
                mainActivity = MainActivity.this;
                iVar = new h();
            } else {
                mainActivity = MainActivity.this;
                iVar = new i();
            }
            mainActivity.runOnUiThread(iVar);
        }

        @Override // e.d
        public void b(e.b<ServicePostAp> bVar, e.l<ServicePostAp> lVar) {
            MainActivity mainActivity;
            Runnable gVar;
            if (lVar.b() == 200) {
                if (!lVar.a().getOk_response().equals("")) {
                    MainActivity.this.runOnUiThread(new a(lVar));
                }
                MainActivity.this.runOnUiThread(new b());
                if (MainActivity.this.y != null) {
                    MainActivity.this.v.open();
                    MainActivity.this.v.delete_sessionfake(MainActivity.this.y);
                    MainActivity.this.v.close();
                }
                new n(MainActivity.this, null).execute("http://connectivitycheck.android.com/generate_204");
                return;
            }
            if (lVar.b() == 301) {
                if (MainActivity.this.y != null) {
                    MainActivity.this.v.open();
                    MainActivity.this.v.delete_sessionfake(MainActivity.this.y);
                    MainActivity.this.v.close();
                }
                if (MainActivity.this.x != null) {
                    MainActivity.this.v.open();
                    MainActivity.this.v.delete_session(MainActivity.this.x);
                    MainActivity.this.v.close();
                }
                mainActivity = MainActivity.this;
                gVar = new c();
            } else {
                if (lVar.b() == 403) {
                    if (MainActivity.this.x != null) {
                        MainActivity.this.v.open();
                        MainActivity.this.v.delete_session(MainActivity.this.x);
                        MainActivity.this.v.close();
                    }
                    if (lVar.d() != null) {
                        try {
                            String strI = lVar.d().I();
                            String strTrim = strI.substring(strI.indexOf(":") + 1, strI.indexOf("}")).replace('\"', ' ').trim();
                            if (!strTrim.equals("")) {
                                MainActivity.this.runOnUiThread(new d(strTrim));
                            }
                        } catch (Exception unused) {
                        }
                    }
                    android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(MainActivity.this);
                    aVar.f(Html.fromHtml("<p>Usted se ha conectado a una <strong>Wi-fi que no pertenece a ETECSA</strong>, puede acceder al portal de autenticación si presiona continuar, recuerde que puede <strong>comprometer</strong> su cuenta.</p>"));
                    aVar.i("Continuar", new e());
                    aVar.g("Cancelar", new f());
                    aVar.l();
                    return;
                }
                mainActivity = MainActivity.this;
                gVar = new g();
            }
            mainActivity.runOnUiThread(gVar);
            MainActivity.this.w.c1();
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.K(mainActivity.z, "El certificado no es válido.", R.color.cardviewerror);
        }
    }

    class l implements HostnameVerifier {
        l(MainActivity mainActivity) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return str.equals("enpserver.nauta.cu");
        }
    }

    class m implements e.d<ServicePostAp> {

        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e.l f2241b;

            a(e.l lVar) {
                this.f2241b = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.H(((ServicePostAp) this.f2241b.a()).getOk_response());
                Toast.makeText(MainActivity.this, ((ServicePostAp) this.f2241b.a()).getOk_response(), 1).show();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "Conectado a Wi-fi de ETECSA.", R.color.menucolor);
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "Su versión caducó, debe actualizarla.", R.color.cardviewerror);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f2245b;

            d(String str) {
                this.f2245b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.H(this.f2245b);
                Toast.makeText(MainActivity.this, this.f2245b, 1).show();
            }
        }

        class e implements DialogInterface.OnClickListener {
            e() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, (Class<?>) LoginPortalUsuario.class);
                intent.putExtra("portalusuario", "wifi");
                intent.putExtra("tendedera", true);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }

        class f implements DialogInterface.OnClickListener {
            f() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.w.c1();
            }
        }

        class g implements Runnable {
            g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "Error en el servidor.", R.color.cardviewerror);
            }
        }

        class h implements Runnable {
            h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "La conexión no es válida, intente de nuevo o cambie de ubicación.", R.color.cardviewerror);
            }
        }

        class i implements Runnable {
            i() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.K(mainActivity.z, "La conexion falló, inténtelo de nuevo.", R.color.cardviewerror);
            }
        }

        m() {
        }

        @Override // e.d
        public void a(e.b<ServicePostAp> bVar, Throwable th) {
            MainActivity mainActivity;
            Runnable iVar;
            MainActivity.this.w.c1();
            if (th.toString().contains("javax.net.ssl.SSLHandshakeException")) {
                mainActivity = MainActivity.this;
                iVar = new h();
            } else {
                mainActivity = MainActivity.this;
                iVar = new i();
            }
            mainActivity.runOnUiThread(iVar);
        }

        @Override // e.d
        public void b(e.b<ServicePostAp> bVar, e.l<ServicePostAp> lVar) {
            MainActivity mainActivity;
            Runnable gVar;
            if (lVar.b() == 200) {
                if (!lVar.a().getOk_response().equals("")) {
                    MainActivity.this.runOnUiThread(new a(lVar));
                }
                MainActivity.this.runOnUiThread(new b());
                if (MainActivity.this.y != null) {
                    MainActivity.this.v.open();
                    MainActivity.this.v.delete_sessionfake(MainActivity.this.y);
                    MainActivity.this.v.close();
                }
                MainActivity.this.w.c1();
                Intent intent = new Intent(MainActivity.this, (Class<?>) LoginPortalUsuario.class);
                intent.putExtra("portalusuario", "wifi");
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
                return;
            }
            MainActivity.this.w.c1();
            if (lVar.b() == 301) {
                if (MainActivity.this.x != null) {
                    MainActivity.this.v.open();
                    MainActivity.this.v.delete_session(MainActivity.this.x);
                    MainActivity.this.v.close();
                }
                if (MainActivity.this.y != null) {
                    MainActivity.this.v.open();
                    MainActivity.this.v.delete_sessionfake(MainActivity.this.y);
                    MainActivity.this.v.close();
                }
                mainActivity = MainActivity.this;
                gVar = new c();
            } else {
                if (lVar.b() == 403) {
                    if (lVar.d() != null) {
                        try {
                            String strI = lVar.d().I();
                            String strTrim = strI.substring(strI.indexOf(":") + 1, strI.indexOf("}")).replace('\"', ' ').trim();
                            if (!strTrim.equals("")) {
                                MainActivity.this.runOnUiThread(new d(strTrim));
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (MainActivity.this.x != null) {
                        MainActivity.this.v.open();
                        MainActivity.this.v.delete_session(MainActivity.this.x);
                        MainActivity.this.v.close();
                    }
                    android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(MainActivity.this);
                    aVar.f(Html.fromHtml("<p>Usted se ha conectado a una <strong>Wi-fi que no pertenece a ETECSA</strong>, puede acceder al portal de autenticación si presiona continuar, recuerde que puede <strong>comprometer</strong> su cuenta.</p>"));
                    aVar.i("Continuar", new e());
                    aVar.g("Cancelar", new f());
                    aVar.l();
                    return;
                }
                mainActivity = MainActivity.this;
                gVar = new g();
            }
            mainActivity.runOnUiThread(gVar);
        }
    }

    private class n extends AsyncTask<String, Void, Void> {
        private n() {
        }

        /* synthetic */ n(MainActivity mainActivity, e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            MainActivity.this.D(strArr[0]);
            return null;
        }
    }

    private class o extends AsyncTask<String, Void, Void> {
        private o() {
        }

        /* synthetic */ o(MainActivity mainActivity, e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            MainActivity.this.G(strArr[0]);
            return null;
        }
    }

    private class p extends AsyncTask<String, Void, Void> {
        private p() {
        }

        /* synthetic */ p(MainActivity mainActivity, e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            MainActivity.this.c0(strArr[0], strArr[1]);
            return null;
        }
    }

    private class q extends AsyncTask<String, Void, Void> {
        private q() {
        }

        /* synthetic */ q(MainActivity mainActivity, e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            MainActivity.this.d0(strArr[0], strArr[1]);
            return null;
        }
    }

    private class r extends BroadcastReceiver {
        private r() {
        }

        /* synthetic */ r(MainActivity mainActivity, e eVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RecyclerView recyclerView;
            cu.etecsa.enp_oficial.e.a.b bVar;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    ((MenuIconItem) MainActivity.this.u.get(1)).setIsenabled(true);
                    ((MenuIconItem) MainActivity.this.u.get(0)).setIsenabled(true);
                    recyclerView = MainActivity.this.q;
                    MainActivity mainActivity = MainActivity.this;
                    bVar = new cu.etecsa.enp_oficial.e.a.b(mainActivity, mainActivity.u, MainActivity.this);
                } else {
                    if (!activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                        return;
                    }
                    MainActivity.this.F();
                    MainActivity.this.A = false;
                    MainActivity.this.B = false;
                    ((MenuIconItem) MainActivity.this.u.get(1)).setIsenabled(true);
                    ((MenuIconItem) MainActivity.this.u.get(0)).setIsenabled(false);
                    recyclerView = MainActivity.this.q;
                    MainActivity mainActivity2 = MainActivity.this;
                    bVar = new cu.etecsa.enp_oficial.e.a.b(mainActivity2, mainActivity2.u, MainActivity.this);
                }
            } else if ((activeNetworkInfo == null || activeNetworkInfo.isConnected()) && activeNetworkInfo != null) {
                MainActivity.this.F();
                MainActivity.this.A = false;
                MainActivity.this.B = false;
                ((MenuIconItem) MainActivity.this.u.get(0)).setIsenabled(false);
                ((MenuIconItem) MainActivity.this.u.get(1)).setIsenabled(false);
                recyclerView = MainActivity.this.q;
                MainActivity mainActivity3 = MainActivity.this;
                bVar = new cu.etecsa.enp_oficial.e.a.b(mainActivity3, mainActivity3.u, MainActivity.this);
            } else {
                MainActivity.this.F();
                MainActivity.this.A = false;
                MainActivity.this.B = false;
                ((MenuIconItem) MainActivity.this.u.get(1)).setIsenabled(false);
                ((MenuIconItem) MainActivity.this.u.get(0)).setIsenabled(false);
                recyclerView = MainActivity.this.q;
                MainActivity mainActivity4 = MainActivity.this;
                bVar = new cu.etecsa.enp_oficial.e.a.b(mainActivity4, mainActivity4.u, MainActivity.this);
            }
            recyclerView.setAdapter(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str) {
        Intent intent;
        x xVarA = new x.b().a();
        a0.a aVar = new a0.a();
        aVar.i(str);
        aVar.c();
        try {
            c0 c0VarExecute = xVarA.a(aVar.b()).execute();
            this.w.c1();
            if (c0VarExecute.r() != 204) {
                if (this.x != null) {
                    this.v.open();
                    this.v.delete_session(this.x);
                    this.v.close();
                }
                this.w.c1();
                intent = new Intent(this, (Class<?>) LoginNautaPortal.class);
            } else {
                if (this.x == null) {
                    runOnUiThread(new b());
                    return;
                }
                intent = new Intent(this, (Class<?>) NautaInfoActivity.class);
            }
            startActivity(intent);
            finish();
        } catch (IOException unused) {
            this.w.c1();
            startActivity(new Intent(this, (Class<?>) LoginNautaPortal.class));
            finish();
        }
    }

    private boolean E(int i2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (UserAccountService.class.getName().equals(it.next().service.getClassName())) {
                stopService(new Intent(this, (Class<?>) UserAccountService.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        long jConvert;
        x xVarA = new x.b().a();
        a0.a aVar = new a0.a();
        aVar.i(str);
        aVar.c();
        try {
            c0 c0VarExecute = xVarA.a(aVar.b()).execute();
            this.w.c1();
            if (c0VarExecute.r() != 204) {
                if (this.y != null) {
                    this.v.open();
                    this.v.delete_sessionfake(this.y);
                    this.v.close();
                }
                Intent intent = new Intent(this, (Class<?>) LoginNautaPortal.class);
                String strSubstring = "";
                try {
                    String strI = c0VarExecute.b().I();
                    int iIndexOf = strI.indexOf("value") + 7;
                    strSubstring = strI.substring(iIndexOf, (strI.substring(iIndexOf).indexOf(">") + iIndexOf) - 1);
                } catch (Exception unused) {
                }
                intent.putExtra("tendedera", true);
                intent.putExtra("ip", strSubstring);
                startActivity(intent);
            } else if (this.y != null) {
                this.v.open();
                Cursor cursor = this.v.get_sessionsfake();
                this.v.close();
                String string = cursor.getString(3);
                try {
                    jConvert = TimeUnit.HOURS.convert(Math.abs(new Date().getTime() - new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(cursor.getString(4)).getTime()), TimeUnit.MILLISECONDS);
                } catch (Exception unused2) {
                    jConvert = 45;
                }
                if (!this.t.getConnectionInfo().getBSSID().equals(string) || jConvert >= 2) {
                    this.v.open();
                    this.v.delete_sessionfake(this.y);
                    this.v.close();
                    Intent intent2 = new Intent(this, (Class<?>) LoginNautaPortal.class);
                    intent2.putExtra("disableauth", true);
                    intent2.putExtra("tendedera", true);
                    startActivity(intent2);
                } else {
                    Intent intent3 = new Intent(this, (Class<?>) NautaInfoActivity.class);
                    intent3.putExtra("tendedera", true);
                    startActivity(intent3);
                }
            } else {
                Intent intent4 = new Intent(this, (Class<?>) LoginNautaPortal.class);
                intent4.putExtra("disableauth", true);
                intent4.putExtra("tendedera", true);
                startActivity(intent4);
            }
            finish();
        } catch (IOException unused3) {
            if (this.y != null) {
                this.v.open();
                this.v.delete_sessionfake(this.y);
                this.v.close();
            }
            this.w.c1();
            Intent intent5 = new Intent(this, (Class<?>) LoginNautaPortal.class);
            intent5.putExtra("tendedera", true);
            startActivity(intent5);
            finish();
        }
    }

    private String I(int i2) {
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
            i2 = Integer.reverseBytes(i2);
        }
        try {
            return InetAddress.getByAddress(BigInteger.valueOf(i2).toByteArray()).getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private void J() {
        r rVar;
        IntentFilter intentFilter;
        if (Build.VERSION.SDK_INT >= 23 && !android.provider.Settings.canDrawOverlays(this)) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2084);
        }
        this.z = (RelativeLayout) findViewById(R.id.rootrelative);
        Session session = Session.getInstance(this);
        this.v = session;
        session.open();
        if (!this.v.seen()) {
            M();
        }
        this.x = this.v.get_session_id();
        this.y = this.v.get_session_fake_id();
        this.v.close();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        A(toolbar);
        this.q = (RecyclerView) findViewById(R.id.recycler);
        ArrayList<MenuIconItem> arrayList = new ArrayList<>();
        this.u = arrayList;
        arrayList.add(new MenuIconItem(R.drawable.portalautenticacion, "Portal de autenticación", false));
        this.u.add(new MenuIconItem(R.drawable.portalusuario, "Portal de usuario", false));
        new LinearLayoutManager(this, 1, false).u2(0);
        this.q.setLayoutManager(new GridLayoutManager(this, 2));
        this.q.setHasFixedSize(true);
        this.q.setAdapter(new cu.etecsa.enp_oficial.e.a.b(this, this.u, this));
        cu.etecsa.enp_oficial.a aVar = new cu.etecsa.enp_oficial.a();
        this.w = aVar;
        aVar.f1(false);
        this.D = new r(this, null);
        this.t = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (Build.VERSION.SDK_INT > 22) {
            this.s = 0;
            boolean z = false;
            for (String str : this.r) {
                this.s += a.b.f.a.a.a(this, str);
                z = z || android.support.v4.app.a.h(this, str);
            }
            if (this.s != 0) {
                android.support.v4.app.a.g(this, this.r, 101);
                return;
            }
            if (getIntent().getExtras() != null) {
                this.A = getIntent().getExtras().getBoolean("this_time");
                this.B = getIntent().getExtras().getBoolean("allow_without_verified_internet");
                this.C = getIntent().getExtras().getBoolean("tendedera");
                String string = getIntent().getExtras().getString("message");
                if (string != null) {
                    K(this.z, string, R.color.cardviewerror);
                }
            }
            rVar = this.D;
            intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        } else {
            if (getIntent().getExtras() != null) {
                this.A = getIntent().getExtras().getBoolean("this_time");
                this.B = getIntent().getExtras().getBoolean("allow_without_verified_internet");
                this.C = getIntent().getExtras().getBoolean("tendedera");
                String string2 = getIntent().getExtras().getString("message");
                if (string2 != null) {
                    K(this.z, string2, R.color.cardviewerror);
                }
            }
            rVar = this.D;
            intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        }
        registerReceiver(rVar, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view, String str, int i2) {
        Snackbar snackbarW = Snackbar.w(view, str, 0);
        View viewK = snackbarW.k();
        cu.etecsa.enp_oficial.g.d.a((TextView) viewK.findViewById(R.id.snackbar_text), "RobotoCondensed-Regular", this);
        viewK.setBackgroundColor(getResources().getColor(i2));
        snackbarW.s();
    }

    private void L() {
        android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(this);
        aVar.f(Html.fromHtml("<strong>Condiciones de uso</strong><p>1. ETECSA presta el servicio de acceso a Internet a personas naturales, de acuerdo a las tarifas establecidas para las facilidades contratadas por el USUARIO.</p><p>2. EL USUARIO puede acceder, sin costo alguno, a las estadísticas de su cuenta en la opción <strong>Información de usuario</strong> y realizar operaciones a través del acceso al Portal de usuario. En el sitio web <a href=''>www.etecsa.cu</a> puede conocer la información del servicio. </p><p>3. EL USUARIO de una cuenta permanente (recargable), en la primera conexión debe cambiar la contraseña inicial entregada por ETECSA para garantizar la seguridad de su cuenta. También responderá de forma absoluta por la confidencialidad de su información, asociada a la cuenta por ser esta personal e intransferible.</p><p>4. Desde que el USUARIO se autentica, el sistema comienza a descontar el tiempo de conexión, independientemente de la acción que realice en su dispositivo. La información del tiempo consumido y el disponible se especifica en la propia aplicación, una vez autenticado.</p><p>5. EL USUARIO, al concluir el uso del servicio, debe cerrar su sesión en el botón que aparece con este mismo texto, para evitar que se consuma tiempo de conexión indebidamente.</p><p>6. EL USUARIO hará uso de los servicios que se ofrecen de acuerdo a los principios ético-morales regulados en la legislación vigente sobre este tema, sin perjuicio para la seguridad pública, la integridad, la economía y la independencia nacional.</p>"));
        aVar.i("Aceptar", new d(this));
        aVar.l();
    }

    private void M() {
        android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(this);
        aVar.f(Html.fromHtml("<strong>Términos de uso</strong><p><strong>Generales</strong><br/>La  Empresa de Telecomunicaciones de Cuba S.A., ETECSA, pone a su disposición la versión beta de la aplicación “<strong><i>nauta</i></strong>” para dispositivos móviles con sistema operativo android, la cual permite un acceso cómodo y seguro al servicio nauta. Por este motivo, se establecen  términos y condiciones respecto al uso de la aplicación para el acceso a internet a través de la red Wi-fi de ETECSA, y el acceso al Portal de usuario por  datos móviles o por la propia red Wi-fi.</p><p><strong>Información legal</strong><br/>Esta aplicación es propiedad intelectual de ETECSA quedando reservados todos los derechos. Cualquier utilización de la misma contraria a las normas en materia de propiedad intelectual e industrial será tratada con apego a la legislación vigente. </p><p><strong>Confidencialidad de la información</strong><br/>Las credenciales (usuario y contraseña) que se utilicen para acceder al servicio nauta, son de uso único y exclusivo del usuario. Solo se guarda la  información que se desee recordar, para futuros accesos. </p><p><strong>Seguridad</strong><br/>El servicio <i>nauta</i>, para el intercambio de datos, hace uso de un protocolo  de encriptación SSL/TLS para la protección de la información.</p><p><strong>Contacto</strong><br/>Para consultas generales podrán contactar a través del 118, servicio de Información Comercial, o por el correo electrónico <a href=''>atención.usuarios@etecsa.cu</a>.</p> <p><i>*  Se le recomienda consultar periódicamente los términos y condiciones establecidos; ETECSA se reserva el derecho de modificarlos cuando lo estime oportuno. Las modificaciones realizadas tendrán plena vigencia a partir de su publicación en la aplicación</i></p>"));
        aVar.i("Aceptar", new c());
        aVar.l();
    }

    public static void a0(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT < 26 || notificationManager.getNotificationChannel(E) != null) {
            return;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(E, F, 3));
    }

    public static String b0() {
        StringBuilder sb;
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        String hexString = Integer.toHexString(b2 & 255);
                        if (hexString.length() > 1) {
                            sb = new StringBuilder();
                            sb.append(hexString);
                            sb.append(":");
                        } else {
                            sb = new StringBuilder();
                            sb.append("0");
                            sb.append(hexString);
                            sb.append(":");
                        }
                        sb2.append(sb.toString());
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public void H(String str) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        a0(notificationManager);
        android.support.v4.app.x.b bVar = new android.support.v4.app.x.b(this, E);
        bVar.e("Nauta");
        bVar.d(str);
        bVar.f(android.R.drawable.ic_menu_view);
        notificationManager.notify(1, bVar.a());
    }

    /* JADX WARN: Code duplicated, block: B:159:0x033c A[PHI: r1
      0x033c: PHI (r1v73 android.content.Intent) = 
      (r1v14 android.content.Intent)
      (r1v26 android.content.Intent)
      (r1v51 android.content.Intent)
      (r1v63 android.content.Intent)
      (r1v90 android.content.Intent)
      (r1v111 android.content.Intent)
     binds: [B:173:0x039e, B:158:0x0335, B:125:0x029e, B:112:0x023c, B:57:0x0130, B:32:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00dd A[PHI: r1
      0x00dd: PHI (r1v95 android.content.Intent) = (r1v83 android.content.Intent), (r1v104 android.content.Intent) binds: [B:63:0x0171, B:38:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // cu.etecsa.enp_oficial.e.a.a
    public void c(View view, int i2) {
        int i3;
        Intent intent;
        android.support.v7.app.b.a aVar;
        DialogInterface.OnClickListener hVar;
        if (i2 != 1) {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT <= 22) {
                    if (E(1)) {
                        i3 = R.color.cardviewerror;
                        if (!E(0)) {
                            if (this.B && !this.A && !this.C) {
                                this.w.h1(l(), "custom");
                                new n(this, null).execute("http://connectivitycheck.android.com/generate_204");
                                return;
                            }
                            if (this.B && !this.A && this.C) {
                                this.w.h1(l(), "custom");
                                new o(this, null).execute("http://connectivitycheck.android.com/generate_204");
                                return;
                            }
                            if (this.B && this.A && this.C && this.y != null) {
                                intent = new Intent(this, (Class<?>) NautaInfoActivity.class);
                            } else if (!this.A) {
                                this.w.h1(l(), "custom");
                                WifiInfo connectionInfo = this.t.getConnectionInfo();
                                new p(this, null).execute(connectionInfo.getBSSID(), I(connectionInfo.getIpAddress()));
                                return;
                            } else if (this.C && this.y == null) {
                                this.w.h1(l(), "custom");
                                new o(this, null).execute("http://connectivitycheck.android.com/generate_204");
                                return;
                            } else if (!this.C || this.y == null) {
                                intent = this.x != null ? new Intent(this, (Class<?>) NautaInfoActivity.class) : new Intent(this, (Class<?>) LoginNautaPortal.class);
                            } else {
                                intent = new Intent(this, (Class<?>) NautaInfoActivity.class);
                            }
                            intent.putExtra("tendedera", true);
                        }
                        K(this.z, "Debe desactivar los datos móviles.", i3);
                        return;
                    }
                    K(this.z, "Debe conectarse a una red Wi-fi.", R.color.cardviewerror);
                    return;
                }
                this.s = 0;
                boolean z = false;
                for (String str : this.r) {
                    this.s += a.b.f.a.a.a(this, str);
                    z = z || android.support.v4.app.a.h(this, str);
                }
                if (this.s != 0) {
                    aVar = new android.support.v7.app.b.a(this);
                    aVar.f("Debe dar permisos a la aplicación para que funcione correctamente.");
                    aVar.i("Conceder", new g());
                    hVar = new h();
                    aVar.g("Cancelar", hVar);
                    aVar.l();
                    return;
                }
                if (E(1)) {
                    i3 = R.color.cardviewerror;
                    if (!E(0)) {
                        if (this.B && !this.A && !this.C) {
                            this.w.h1(l(), "custom");
                            new n(this, null).execute("http://connectivitycheck.android.com/generate_204");
                            return;
                        }
                        if (this.B && !this.A && this.C) {
                            this.w.h1(l(), "custom");
                            new o(this, null).execute("http://connectivitycheck.android.com/generate_204");
                            return;
                        }
                        if (this.B && this.A && this.C && this.y != null) {
                            intent = new Intent(this, (Class<?>) NautaInfoActivity.class);
                        } else if (!this.A) {
                            this.w.h1(l(), "custom");
                            WifiInfo connectionInfo2 = this.t.getConnectionInfo();
                            new p(this, null).execute(connectionInfo2.getBSSID(), I(connectionInfo2.getIpAddress()));
                            return;
                        } else if (this.C && this.y == null) {
                            this.w.h1(l(), "custom");
                            new o(this, null).execute("http://connectivitycheck.android.com/generate_204");
                            return;
                        } else if (!this.C || this.y == null) {
                            intent = this.x != null ? new Intent(this, (Class<?>) NautaInfoActivity.class) : new Intent(this, (Class<?>) LoginNautaPortal.class);
                        } else {
                            intent = new Intent(this, (Class<?>) NautaInfoActivity.class);
                        }
                        intent.putExtra("tendedera", true);
                    }
                    K(this.z, "Debe desactivar los datos móviles.", i3);
                    return;
                }
                K(this.z, "Debe conectarse a una red Wi-fi.", R.color.cardviewerror);
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT > 22) {
            this.s = 0;
            boolean z2 = false;
            for (String str2 : this.r) {
                this.s += a.b.f.a.a.a(this, str2);
                z2 = z2 || android.support.v4.app.a.h(this, str2);
            }
            if (this.s != 0) {
                aVar = new android.support.v7.app.b.a(this);
                aVar.f("Debe dar permisos a la aplicacion para que funcione correctamente.");
                aVar.i("Conceder", new e());
                hVar = new f();
                aVar.g("Cancelar", hVar);
                aVar.l();
                return;
            }
            if (E(1) && E(0)) {
                K(this.z, "Tiene habilitado los datos móviles y la Wi-Fi, debe desactivar uno de ellos para continuar.", R.color.cardviewerror);
                return;
            }
            if (!E(1)) {
                if (E(0)) {
                    intent = new Intent(this, (Class<?>) LoginPortalUsuario.class);
                }
                K(this.z, "Debe activar los datos móviles o conectarse a una red Wi-fi.", R.color.cardviewerror);
                return;
            }
            if (this.B && !this.A) {
                intent = new Intent(this, (Class<?>) LoginPortalUsuario.class);
                intent.putExtra("portalusuario", "wifi");
                if (this.C) {
                    intent.putExtra("tendedera", true);
                }
            } else if (!this.A) {
                this.w.h1(l(), "custom");
                WifiInfo connectionInfo3 = this.t.getConnectionInfo();
                new q(this, null).execute(connectionInfo3.getBSSID(), I(connectionInfo3.getIpAddress()));
                return;
            } else {
                intent = new Intent(this, (Class<?>) LoginPortalUsuario.class);
                intent.putExtra("portalusuario", "wifi");
                if (this.C) {
                    intent.putExtra("tendedera", true);
                }
                intent.putExtra("allow", true);
            }
        } else {
            if (E(1) && E(0)) {
                K(this.z, "Tiene habilitado los datos móviles y la Wi-fi, debe desactivar uno de ellos para continuar.", R.color.cardviewerror);
                return;
            }
            if (!E(1)) {
                if (E(0)) {
                    intent = new Intent(this, (Class<?>) LoginPortalUsuario.class);
                }
                K(this.z, "Debe activar los datos móviles o conectarse a una red Wi-fi.", R.color.cardviewerror);
                return;
            }
            if (this.B && !this.A) {
                intent = new Intent(this, (Class<?>) LoginPortalUsuario.class);
                intent.putExtra("portalusuario", "wifi");
                if (this.C) {
                    intent.putExtra("tendedera", true);
                }
            } else if (!this.A) {
                this.w.h1(l(), "custom");
                WifiInfo connectionInfo4 = this.t.getConnectionInfo();
                new q(this, null).execute(connectionInfo4.getBSSID(), I(connectionInfo4.getIpAddress()));
                return;
            } else {
                intent = new Intent(this, (Class<?>) LoginPortalUsuario.class);
                intent.putExtra("portalusuario", "wifi");
                if (this.C) {
                    intent.putExtra("tendedera", true);
                }
                intent.putExtra("allow", true);
            }
        }
        startActivity(intent);
        finish();
    }

    public void c0(String str, String str2) {
        try {
            x.b bVar = new x.b();
            bVar.f(20L, TimeUnit.SECONDS);
            bVar.d(20L, TimeUnit.SECONDS);
            bVar.b(20L, TimeUnit.SECONDS);
            bVar.e(cu.etecsa.enp_oficial.g.a.a(this).getSocketFactory());
            bVar.c(new i(this));
            x xVarA = bVar.a();
            b.a.a.g gVar = new b.a.a.g();
            gVar.c();
            b.a.a.f fVarB = gVar.b();
            e.m.b bVar2 = new e.m.b();
            bVar2.f(xVarA);
            bVar2.b("https://enpserver.nauta.cu/");
            bVar2.a(e.p.a.a.d(fVarB));
            ((WifiAPService) bVar2.d().d(WifiAPService.class)).sendToVerify(new ServicePostAp(str, "MESSAGE", str2, "1.2.0.1", b0())).u(new j());
        } catch (Exception unused) {
            runOnUiThread(new k());
            this.w.c1();
        }
    }

    public void d0(String str, String str2) {
        try {
            x.b bVar = new x.b();
            bVar.f(20L, TimeUnit.SECONDS);
            bVar.d(20L, TimeUnit.SECONDS);
            bVar.b(20L, TimeUnit.SECONDS);
            bVar.e(cu.etecsa.enp_oficial.g.a.a(this).getSocketFactory());
            bVar.c(new l(this));
            x xVarA = bVar.a();
            b.a.a.g gVar = new b.a.a.g();
            gVar.c();
            b.a.a.f fVarB = gVar.b();
            e.m.b bVar2 = new e.m.b();
            bVar2.f(xVarA);
            bVar2.b("https://enpserver.nauta.cu/");
            bVar2.a(e.p.a.a.d(fVarB));
            ((WifiAPService) bVar2.d().d(WifiAPService.class)).sendToVerify(new ServicePostAp(str, "MESSAGE", str2, "1.2.0.1", b0())).u(new m());
        } catch (Exception unused) {
            runOnUiThread(new a());
            this.w.c1();
        }
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 2084) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        J();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // android.support.v7.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        moveTaskToBack(true);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.about /* 2131230727 */:
                intent = new Intent(this, (Class<?>) About.class);
                startActivity(intent);
                break;
            case R.id.settings /* 2131230922 */:
                intent = new Intent(this, (Class<?>) Settings.class);
                startActivity(intent);
                break;
            case R.id.userconditions /* 2131230991 */:
                L();
                break;
            case R.id.userterms /* 2131230995 */:
                M();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.h, android.app.Activity, android.support.v4.app.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 101) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        if (i3 == 0) {
            registerReceiver(this.D, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            K(this.z, "No fueron otorgados los permisos a la aplicación", R.color.cardviewerror);
        }
    }
}
