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
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cu.etecsa.enp_oficial.model.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Displays user profile and Nauta account status.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.InfoUser
 */
public class InfoUser extends android.support.v7.app.c {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private b K;
    private RelativeLayout L;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intent intent2;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str = "No existe conexión con la red Wifi";
            if (activeNetworkInfo == null) {
                InfoUser.this.D();
                intent2 = new Intent(InfoUser.this, (Class<?>) MainActivity.class);
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                InfoUser.this.D();
                intent2 = new Intent(InfoUser.this, (Class<?>) MainActivity.class);
                str = "Se habilitaron los datos móviles";
            } else {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return;
                }
                InfoUser.this.D();
                intent2 = new Intent(InfoUser.this, (Class<?>) MainActivity.class);
            }
            intent2.putExtra("message", str);
            InfoUser.this.startActivity(intent2);
            InfoUser.this.finish();
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Información del usuario");
        A(toolbar);
        u().s(true);
        this.K = new b();
        UserInfo userInfo = (UserInfo) getIntent().getSerializableExtra("userinfo");
        this.L = (RelativeLayout) findViewById(R.id.rootrelative);
        this.q = (TextView) findViewById(R.id.statecolumn);
        this.r = (TextView) findViewById(R.id.state);
        this.s = (TextView) findViewById(R.id.creditcolumn);
        this.t = (TextView) findViewById(R.id.credit);
        this.u = (TextView) findViewById(R.id.accesscolumn);
        this.v = (TextView) findViewById(R.id.access);
        this.w = (TextView) findViewById(R.id.expirationcolumn);
        this.x = (TextView) findViewById(R.id.expiration);
        this.H = (TextView) findViewById(R.id.desdecolumn);
        this.y = (TextView) findViewById(R.id.desde1);
        this.z = (TextView) findViewById(R.id.desde2);
        this.A = (TextView) findViewById(R.id.desde3);
        this.I = (TextView) findViewById(R.id.hastacolumn);
        this.B = (TextView) findViewById(R.id.hasta1);
        this.C = (TextView) findViewById(R.id.hasta2);
        this.D = (TextView) findViewById(R.id.hasta3);
        this.J = (TextView) findViewById(R.id.tiempocolumn);
        this.E = (TextView) findViewById(R.id.tiempo1);
        this.F = (TextView) findViewById(R.id.tiempo2);
        this.G = (TextView) findViewById(R.id.tiempo3);
        ArrayList<String> sessioninfodata = userInfo.getSessioninfodata();
        ArrayList<String> sessioninfohead = userInfo.getSessioninfohead();
        ArrayList<String> sessiontrazashead = userInfo.getSessiontrazashead();
        this.q.setText(sessioninfohead.get(0));
        this.s.setText(sessioninfohead.get(1));
        this.w.setText(sessioninfohead.get(2));
        this.u.setText(sessioninfohead.get(3));
        this.r.setText(sessioninfodata.get(0));
        this.t.setText(sessioninfodata.get(1));
        this.x.setText(sessioninfodata.get(2));
        this.v.setText(sessioninfodata.get(3));
        this.H.setText(sessiontrazashead.get(0));
        this.I.setText(sessiontrazashead.get(1));
        this.J.setText(sessiontrazashead.get(2));
        this.y.setText(sessiontrazashead.get(3));
        this.z.setText(sessiontrazashead.get(6));
        this.A.setText(sessiontrazashead.get(9));
        this.B.setText(sessiontrazashead.get(4));
        this.C.setText(sessiontrazashead.get(7));
        this.D.setText(sessiontrazashead.get(10));
        this.E.setText(sessiontrazashead.get(5));
        this.F.setText(sessiontrazashead.get(8));
        this.G.setText(sessiontrazashead.get(11));
        if (!this.r.getText().toString().equals("Activa")) {
            this.r.setTextColor(getResources().getColor(R.color.cardviewerror));
        }
        cu.etecsa.enp_oficial.g.d.a(this.q, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.s, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.w, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.u, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.H, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.I, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.J, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a((TextView) findViewById(R.id.ultimas_sesiones), "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.r, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.t, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.x, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.v, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.y, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.z, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.A, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.B, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.C, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.D, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.E, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.F, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.G, "RobotoCondensed-Regular", this);
        registerReceiver(this.K, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        F(this.L, "Datos cargados con éxito", R.color.menucolor);
    }

    private void F(View view, String str, int i) {
        Snackbar snackbarW = Snackbar.w(view, str, 0);
        View viewK = snackbarW.k();
        cu.etecsa.enp_oficial.g.d.a((TextView) viewK.findViewById(R.id.snackbar_text), "RobotoCondensed-Regular", this);
        viewK.setBackgroundColor(getResources().getColor(i));
        snackbarW.s();
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_info_user);
        E();
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
        if (16908332 == menuItem.getItemId()) {
            startActivity(new Intent(this, (Class<?>) LoginNautaPortal.class));
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
