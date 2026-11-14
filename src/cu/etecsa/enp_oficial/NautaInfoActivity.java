package cu.etecsa.enp_oficial;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.x;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a0;
import c.c0;
import c.q;
import cu.etecsa.enp_oficial.model.NautaInfoData;
import cu.etecsa.enp_oficial.model.Session;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class NautaInfoActivity extends android.support.v7.app.c implements View.OnClickListener {
    private static String I = "default_channel";
    private static String J = "Default";
    private boolean A;
    private Intent B;
    private NautaInfoData q;
    private Timer r;
    private TextView s;
    private cu.etecsa.enp_oficial.c t;
    private f u;
    private Session w;
    private String x;
    private String y;
    private RelativeLayout z;
    private boolean v = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private BroadcastReceiver H = new e();

    class a extends TimerTask {

        /* JADX INFO: renamed from: cu.etecsa.enp_oficial.NautaInfoActivity$a$a, reason: collision with other inner class name */
        class RunnableC0055a implements Runnable {
            RunnableC0055a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity.this.s.setText(NautaInfoActivity.this.q.GetTimeToString());
                if (NautaInfoActivity.this.E) {
                    if (!NautaInfoActivity.this.F()) {
                        NotificationManager notificationManager = (NotificationManager) NautaInfoActivity.this.getSystemService("notification");
                        NautaInfoActivity.k0(notificationManager);
                        x.b bVar = new x.b(NautaInfoActivity.this, NautaInfoActivity.I);
                        bVar.e("Nauta");
                        bVar.d("A su cuenta le queda menos de 5 minutos");
                        bVar.f(android.R.drawable.ic_menu_view);
                        notificationManager.notify(1, bVar.a());
                        NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                        nautaInfoActivity.K(nautaInfoActivity.z, "A su cuenta le queda menos de 5 minutos", R.color.cardviewerror);
                    }
                    NautaInfoActivity.this.E = false;
                }
                if (NautaInfoActivity.this.q.GetTimeToString().equals("00:00:00")) {
                    NautaInfoActivity.this.r.cancel();
                    NautaInfoActivity.this.v = false;
                    NautaInfoActivity nautaInfoActivity2 = NautaInfoActivity.this;
                    nautaInfoActivity2.K(nautaInfoActivity2.z, "El tiempo de su cuenta ha expirado", R.color.cardviewerror);
                }
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            NautaInfoActivity.this.q.Decrement_Time();
            if (NautaInfoActivity.this.F && !NautaInfoActivity.this.D) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHHH:mm:ss");
                    if (simpleDateFormat.parse(NautaInfoActivity.this.q.GetTimeToString()).before(simpleDateFormat.parse("00:05:02"))) {
                        NautaInfoActivity.this.E = true;
                        NautaInfoActivity.this.D = true;
                    }
                } catch (Exception unused) {
                }
            }
            NautaInfoActivity.this.runOnUiThread(new RunnableC0055a());
        }
    }

    class b implements c.f {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "No se pudo obtener el tiempo restante de la cuenta, inténtelo de nuevo.", R.color.cardviewerror);
                NautaInfoActivity.this.q.setRemaining_time("00:00:00");
                NautaInfoActivity.this.s.setText("00:00:00");
                NautaInfoActivity.this.t.c1();
            }
        }

        /* JADX INFO: renamed from: cu.etecsa.enp_oficial.NautaInfoActivity$b$b, reason: collision with other inner class name */
        class RunnableC0056b implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f2261b;

            RunnableC0056b(String str) {
                this.f2261b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoData nautaInfoData;
                String str;
                if (this.f2261b.equals("00:00:00")) {
                    NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                    nautaInfoActivity.K(nautaInfoActivity.z, "Su cuenta no tiene saldo no podrá navegar hasta que la recargue", R.color.cardviewerror);
                    NautaInfoActivity.this.q.setRemaining_time("00:00:00");
                    NautaInfoActivity.this.s.setText("00:00:00");
                    return;
                }
                if (this.f2261b.equals("errorop")) {
                    NautaInfoActivity nautaInfoActivity2 = NautaInfoActivity.this;
                    nautaInfoActivity2.K(nautaInfoActivity2.z, "Error al obtener tiempo intente nuevamente", R.color.cardviewerror);
                    str = "--:--:--";
                    NautaInfoActivity.this.s.setText("--:--:--");
                    nautaInfoData = NautaInfoActivity.this.q;
                } else {
                    NautaInfoActivity nautaInfoActivity3 = NautaInfoActivity.this;
                    nautaInfoActivity3.K(nautaInfoActivity3.z, "Datos obtenidos satisfactoriamente.", R.color.menucolor);
                    NautaInfoActivity.this.s.setText(this.f2261b);
                    nautaInfoData = NautaInfoActivity.this.q;
                    str = this.f2261b;
                }
                nautaInfoData.setRemaining_time(str);
                NautaInfoActivity.this.l0();
                NautaInfoActivity.this.v = true;
            }
        }

        b() {
        }

        @Override // c.f
        public void a(c.e eVar, c0 c0Var) throws IOException {
            try {
                NautaInfoActivity.this.t.c1();
                if (c0Var != null) {
                    NautaInfoActivity.this.runOnUiThread(new RunnableC0056b(c0Var.b().I()));
                }
            } catch (Exception unused) {
                NautaInfoActivity.this.t.c1();
                NautaInfoActivity.this.startActivity(new Intent(NautaInfoActivity.this, (Class<?>) MainActivity.class));
                NautaInfoActivity.this.finish();
            }
        }

        @Override // c.f
        public void b(c.e eVar, IOException iOException) {
            NautaInfoActivity.this.runOnUiThread(new a());
        }
    }

    class c implements c.f {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "No se pudo obtener el tiempo restante de la cuenta, inténtelo de nuevo.", R.color.cardviewerror);
                NautaInfoActivity.this.t.c1();
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f2265b;

            b(String str) {
                this.f2265b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2265b.equals("00:00:00")) {
                    NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                    nautaInfoActivity.K(nautaInfoActivity.z, "Su cuenta no tiene saldo no podrá navegar hasta que la recargue", R.color.cardviewerror);
                    NautaInfoActivity.this.q.setRemaining_time("00:00:00");
                    NautaInfoActivity.this.s.setText("00:00:00");
                    NautaInfoActivity.this.v = false;
                    if (NautaInfoActivity.this.r != null) {
                        NautaInfoActivity.this.r.cancel();
                        return;
                    }
                    return;
                }
                if (this.f2265b.equals("errorop")) {
                    NautaInfoActivity nautaInfoActivity2 = NautaInfoActivity.this;
                    nautaInfoActivity2.K(nautaInfoActivity2.z, "No se pudo obtener el tiempo restante de la cuenta, inténtelo de nuevo.", R.color.cardviewerror);
                    return;
                }
                NautaInfoActivity nautaInfoActivity3 = NautaInfoActivity.this;
                nautaInfoActivity3.K(nautaInfoActivity3.z, "Tiempo restante obtenido satisfactoriamente.", R.color.menucolor);
                NautaInfoActivity.this.s.setText(this.f2265b);
                NautaInfoActivity.this.q.setRemaining_time(this.f2265b);
                if (NautaInfoActivity.this.v) {
                    return;
                }
                NautaInfoActivity.this.l0();
            }
        }

        c() {
        }

        @Override // c.f
        public void a(c.e eVar, c0 c0Var) throws IOException {
            try {
                NautaInfoActivity.this.t.c1();
                if (c0Var != null) {
                    NautaInfoActivity.this.runOnUiThread(new b(c0Var.b().I()));
                }
            } catch (Exception unused) {
                NautaInfoActivity.this.t.c1();
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "No se pudo obtener el tiempo restante de la cuenta, inténtelo de nuevo.", R.color.cardviewerror);
            }
        }

        @Override // c.f
        public void b(c.e eVar, IOException iOException) {
            NautaInfoActivity.this.runOnUiThread(new a());
        }
    }

    class d implements c.f {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "No se pudo cerrar la sesión, inténtelo de nuevo.", R.color.cardviewerror);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "No se pudo cerrar la sesión, inténtelo de nuevo.", R.color.cardviewerror);
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "Sesión cerrada con éxito.", R.color.menucolor);
            }
        }

        /* JADX INFO: renamed from: cu.etecsa.enp_oficial.NautaInfoActivity$d$d, reason: collision with other inner class name */
        class RunnableC0057d implements Runnable {
            RunnableC0057d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NautaInfoActivity nautaInfoActivity = NautaInfoActivity.this;
                nautaInfoActivity.K(nautaInfoActivity.z, "No se pudo cerrar la sesión, inténtelo de nuevo.", R.color.cardviewerror);
            }
        }

        d() {
        }

        @Override // c.f
        public void a(c.e eVar, c0 c0Var) throws IOException {
            NautaInfoActivity nautaInfoActivity;
            try {
                NautaInfoActivity.this.t.c1();
                if (c0Var.b().toString().contains("ERROR")) {
                    NautaInfoActivity.this.runOnUiThread(new b());
                    return;
                }
                NautaInfoActivity.this.t.c1();
                if (NautaInfoActivity.this.r != null) {
                    NautaInfoActivity.this.r.cancel();
                }
                NautaInfoActivity.this.C = true;
                if (NautaInfoActivity.this.A) {
                    NautaInfoActivity.this.w.open();
                    NautaInfoActivity.this.w.delete_sessionfake(NautaInfoActivity.this.y);
                    NautaInfoActivity.this.y = null;
                    nautaInfoActivity = NautaInfoActivity.this;
                } else {
                    NautaInfoActivity.this.w.open();
                    NautaInfoActivity.this.w.delete_session(NautaInfoActivity.this.x);
                    NautaInfoActivity.this.x = null;
                    nautaInfoActivity = NautaInfoActivity.this;
                }
                nautaInfoActivity.w.close();
                NautaInfoActivity.this.runOnUiThread(new c());
                if (NautaInfoActivity.this.G) {
                    NautaInfoActivity.this.unregisterReceiver(NautaInfoActivity.this.u);
                    ((WifiManager) NautaInfoActivity.this.getApplicationContext().getSystemService("wifi")).disconnect();
                    Intent intent = new Intent(NautaInfoActivity.this, (Class<?>) MainActivity.class);
                    intent.putExtra("message", "Sesión cerrada con éxito.");
                    NautaInfoActivity.this.startActivity(intent);
                } else {
                    Intent intent2 = new Intent(NautaInfoActivity.this, (Class<?>) LoginNautaPortal.class);
                    if (NautaInfoActivity.this.A) {
                        intent2.putExtra("tendedera", true);
                    }
                    NautaInfoActivity.this.startActivity(intent2);
                }
                NautaInfoActivity.this.finish();
            } catch (Exception unused) {
                NautaInfoActivity.this.t.c1();
                NautaInfoActivity.this.runOnUiThread(new RunnableC0057d());
            }
        }

        @Override // c.f
        public void b(c.e eVar, IOException iOException) {
            NautaInfoActivity.this.t.c1();
            NautaInfoActivity.this.runOnUiThread(new a());
        }
    }

    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NautaInfoActivity.this.D = intent.getExtras().getBoolean("notificated");
        }
    }

    private class f extends BroadcastReceiver {
        private f() {
        }

        /* synthetic */ f(NautaInfoActivity nautaInfoActivity, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intent intent2;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str = "No existe conexión con la Wi-fi de ETECSA";
            if (activeNetworkInfo == null) {
                NautaInfoActivity.this.t.c1();
                intent2 = new Intent(NautaInfoActivity.this, (Class<?>) MainActivity.class);
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                NautaInfoActivity.this.t.c1();
                intent2 = new Intent(NautaInfoActivity.this, (Class<?>) MainActivity.class);
                str = "Se habilitaron los datos móviles";
            } else {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return;
                }
                NautaInfoActivity.this.t.c1();
                intent2 = new Intent(NautaInfoActivity.this, (Class<?>) MainActivity.class);
            }
            intent2.putExtra("message", str);
            NautaInfoActivity.this.startActivity(intent2);
            NautaInfoActivity.this.finish();
        }
    }

    private void D() {
        this.w.open();
        boolean z = Boolean.parseBoolean(this.w.getSettings().getString(1));
        this.w.close();
        if (this.C || this.s.getText().toString().equals("00:00:00") || !z) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) UserAccountService.class);
        this.B = intent;
        intent.putExtra("tiemporestante", this.s.getText().toString());
        this.B.putExtra("notificated", this.D);
        startService(this.B);
    }

    private void E() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (UserAccountService.class.getName().equals(it.next().service.getClassName())) {
                stopService(new Intent(this, (Class<?>) UserAccountService.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (UserAccountService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void G(String str) {
        q.a aVar = new q.a();
        for (Map.Entry<String, String> entry : cu.etecsa.enp_oficial.g.c.b(str).entrySet()) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        q qVarC = aVar.c();
        c.x xVar = new c.x();
        a0.a aVar2 = new a0.a();
        aVar2.i("https://secure.etecsa.net:8443/LogoutServlet");
        aVar2.g(qVarC);
        xVar.a(aVar2.b()).r(new d());
    }

    private void H(String str) {
        q.a aVar = new q.a();
        for (Map.Entry<String, String> entry : cu.etecsa.enp_oficial.g.c.b(str).entrySet()) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        q qVarC = aVar.c();
        c.x xVar = new c.x();
        a0.a aVar2 = new a0.a();
        aVar2.i("https://secure.etecsa.net:8443/EtecsaQueryServlet");
        aVar2.g(qVarC);
        xVar.a(aVar2.b()).r(new c());
    }

    private void I() {
        NautaInfoData nautaInfoData;
        a.b.f.a.c.b(this).c(this.H, new IntentFilter("time"));
        A((Toolbar) findViewById(R.id.toolbar));
        u().s(true);
        u().u("Tiempo restante");
        this.u = new f(this, null);
        this.z = (RelativeLayout) findViewById(R.id.rootrelative);
        TextView textView = (TextView) findViewById(R.id.errorcardviewicon);
        TextView textView2 = (TextView) findViewById(R.id.errorcardviewtext);
        cu.etecsa.enp_oficial.g.d.a(textView, "fontawesome-webfont", this);
        cu.etecsa.enp_oficial.g.d.a(textView2, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.c cVar = new cu.etecsa.enp_oficial.c();
        this.t = cVar;
        cVar.f1(false);
        Button button = (Button) findViewById(R.id.logoutbtn);
        Button button2 = (Button) findViewById(R.id.refreshtimebtn);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.w = Session.getInstance(this);
        if (getIntent() == null || getIntent().getExtras() == null) {
            this.w.open();
            Cursor cursor = this.w.get_sessions();
            this.x = cursor.getString(0);
            nautaInfoData = new NautaInfoData(cursor.getString(1), cursor.getString(2), "00:00:00");
        } else {
            this.A = getIntent().getExtras().getBoolean("tendedera");
            this.w.open();
            Cursor cursor2 = this.w.get_sessionsfake();
            this.y = cursor2.getString(0);
            nautaInfoData = new NautaInfoData(cursor2.getString(1), cursor2.getString(2), "00:00:00");
        }
        this.q = nautaInfoData;
        Cursor settings = this.w.getSettings();
        this.F = Boolean.parseBoolean(settings.getString(5));
        this.G = Boolean.parseBoolean(settings.getString(6));
        this.w.close();
        this.s = (TextView) findViewById(R.id.remaining_time);
        cu.etecsa.enp_oficial.g.d.a(button, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(button2, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.s, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a((TextView) findViewById(R.id.remaining_time_label), "RobotoCondensed-Bold", this);
        registerReceiver(this.u, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.t.h1(l(), "custom");
        J(this.q.getRemainig_time_url());
    }

    private void J(String str) {
        q.a aVar = new q.a();
        for (Map.Entry<String, String> entry : cu.etecsa.enp_oficial.g.c.b(str).entrySet()) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        q qVarC = aVar.c();
        c.x xVar = new c.x();
        a0.a aVar2 = new a0.a();
        aVar2.i("https://secure.etecsa.net:8443/EtecsaQueryServlet");
        aVar2.g(qVarC);
        xVar.a(aVar2.b()).r(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view, String str, int i) {
        Snackbar snackbarW = Snackbar.w(view, str, 0);
        View viewK = snackbarW.k();
        cu.etecsa.enp_oficial.g.d.a((TextView) viewK.findViewById(R.id.snackbar_text), "RobotoCondensed-Regular", this);
        viewK.setBackgroundColor(getResources().getColor(i));
        snackbarW.s();
    }

    public static void k0(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT < 26 || notificationManager.getNotificationChannel(I) != null) {
            return;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(I, J, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        if (!this.q.getRemaining_time().equals("00:00:00")) {
            this.r = new Timer();
            this.r.schedule(new a(), 0L, 1000L);
        } else {
            Timer timer = this.r;
            if (timer != null) {
                timer.cancel();
                this.v = false;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.logoutbtn) {
            this.t.h1(l(), "custom");
            G(this.q.getLogout_url());
        } else {
            if (id != R.id.refreshtimebtn) {
                return;
            }
            this.t.h1(l(), "custom");
            H(this.q.getRemainig_time_url());
        }
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_nauta_info);
        I();
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.u);
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
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("this_time", true);
        if (this.A) {
            intent.putExtra("tendedera", true);
        }
        startActivity(intent);
        finish();
        return true;
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            D();
        } catch (Exception unused) {
        }
    }

    @Override // android.support.v4.app.h, android.app.Activity
    protected void onResume() {
        E();
        super.onResume();
    }
}
