package cu.etecsa.enp_oficial;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cu.etecsa.enp_oficial.model.LoginPortalNautaData;
import cu.etecsa.enp_oficial.model.Session;
import cu.etecsa.enp_oficial.model.UserInfo;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes.dex */
public class LoginNautaPortal extends android.support.v7.app.c implements View.OnClickListener {
    private CheckBox A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private boolean G = false;
    private boolean H = false;
    private EditText q;
    Button r;
    Button s;
    private cu.etecsa.enp_oficial.b t;
    private LoginPortalNautaData u;
    private g v;
    private Session w;
    private RelativeLayout x;
    private AutoCompleteTextView y;
    private CheckBox z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginNautaPortal.this.t.h1(LoginNautaPortal.this.l(), "custom");
            new e(LoginNautaPortal.this, null).execute(LoginNautaPortal.this.y.getText().toString(), LoginNautaPortal.this.q.getText().toString());
        }
    }

    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Button button;
            Resources resources;
            int i;
            Button button2;
            int color;
            boolean z = LoginNautaPortal.this.y.getText().toString().length() > 5 && LoginNautaPortal.this.q.getText().toString().length() > 3;
            if (!z || LoginNautaPortal.this.G) {
                LoginNautaPortal loginNautaPortal = LoginNautaPortal.this;
                loginNautaPortal.r.setBackgroundColor(loginNautaPortal.getApplicationContext().getResources().getColor(R.color.disableditemcardview));
                LoginNautaPortal loginNautaPortal2 = LoginNautaPortal.this;
                button = loginNautaPortal2.r;
                resources = loginNautaPortal2.getApplicationContext().getResources();
                i = R.color.disableditemcardviewlight;
            } else {
                LoginNautaPortal loginNautaPortal3 = LoginNautaPortal.this;
                loginNautaPortal3.r.setBackgroundColor(loginNautaPortal3.getApplicationContext().getResources().getColor(R.color.colorPrimary));
                LoginNautaPortal loginNautaPortal4 = LoginNautaPortal.this;
                button = loginNautaPortal4.r;
                resources = loginNautaPortal4.getApplicationContext().getResources();
                i = R.color.white;
            }
            button.setTextColor(resources.getColor(i));
            if (z) {
                LoginNautaPortal loginNautaPortal5 = LoginNautaPortal.this;
                button2 = loginNautaPortal5.s;
                color = loginNautaPortal5.getApplicationContext().getResources().getColor(R.color.colorPrimary);
            } else {
                LoginNautaPortal loginNautaPortal6 = LoginNautaPortal.this;
                button2 = loginNautaPortal6.s;
                color = loginNautaPortal6.getApplicationContext().getResources().getColor(R.color.disableditemcardview);
            }
            button2.setTextColor(color);
            LoginNautaPortal loginNautaPortal7 = LoginNautaPortal.this;
            loginNautaPortal7.r.setEnabled(z && !loginNautaPortal7.G);
            LoginNautaPortal loginNautaPortal8 = LoginNautaPortal.this;
            loginNautaPortal8.s.setEnabled(loginNautaPortal8.y.getText().toString().length() > 5 && LoginNautaPortal.this.q.getText().toString().length() > 3);
            LoginNautaPortal.this.w.open();
            LoginNautaPortal loginNautaPortal9 = LoginNautaPortal.this;
            loginNautaPortal9.B = loginNautaPortal9.w.get_user_password(LoginNautaPortal.this.y.getText().toString());
            if (LoginNautaPortal.this.B != null) {
                LoginNautaPortal.this.q.setText(LoginNautaPortal.this.B);
                LoginNautaPortal.this.A.setChecked(true);
            } else {
                LoginNautaPortal.this.A.setChecked(false);
            }
            LoginNautaPortal.this.w.close();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Button button;
            Resources resources;
            int i;
            Button button2;
            int color;
            boolean z = LoginNautaPortal.this.y.getText().toString().length() > 5 && LoginNautaPortal.this.q.getText().toString().length() > 3;
            if (!z || LoginNautaPortal.this.G) {
                LoginNautaPortal loginNautaPortal = LoginNautaPortal.this;
                loginNautaPortal.r.setBackgroundColor(loginNautaPortal.getApplicationContext().getResources().getColor(R.color.disableditemcardview));
                LoginNautaPortal loginNautaPortal2 = LoginNautaPortal.this;
                button = loginNautaPortal2.r;
                resources = loginNautaPortal2.getApplicationContext().getResources();
                i = R.color.disableditemcardviewlight;
            } else {
                LoginNautaPortal loginNautaPortal3 = LoginNautaPortal.this;
                loginNautaPortal3.r.setBackgroundColor(loginNautaPortal3.getApplicationContext().getResources().getColor(R.color.colorPrimary));
                LoginNautaPortal loginNautaPortal4 = LoginNautaPortal.this;
                button = loginNautaPortal4.r;
                resources = loginNautaPortal4.getApplicationContext().getResources();
                i = R.color.white;
            }
            button.setTextColor(resources.getColor(i));
            if (z) {
                LoginNautaPortal loginNautaPortal5 = LoginNautaPortal.this;
                button2 = loginNautaPortal5.s;
                color = loginNautaPortal5.getApplicationContext().getResources().getColor(R.color.colorPrimary);
            } else {
                LoginNautaPortal loginNautaPortal6 = LoginNautaPortal.this;
                button2 = loginNautaPortal6.s;
                color = loginNautaPortal6.getApplicationContext().getResources().getColor(R.color.disableditemcardview);
            }
            button2.setTextColor(color);
            LoginNautaPortal loginNautaPortal7 = LoginNautaPortal.this;
            loginNautaPortal7.r.setEnabled(z && !loginNautaPortal7.G);
            LoginNautaPortal loginNautaPortal8 = LoginNautaPortal.this;
            loginNautaPortal8.s.setEnabled(loginNautaPortal8.y.getText().toString().length() > 5 && LoginNautaPortal.this.q.getText().toString().length() > 3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LoginNautaPortal.this.q.setInputType(z ? 1 : 129);
        }
    }

    private class e extends AsyncTask<String, Void, Void> {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoginNautaPortal loginNautaPortal = LoginNautaPortal.this;
                loginNautaPortal.G(loginNautaPortal.x, "Usuario o contraseña incorrectos", R.color.cardviewerror);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Intent f2203b;

            b(Intent intent) {
                this.f2203b = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!LoginNautaPortal.this.A.isChecked()) {
                    if (LoginNautaPortal.this.B != null) {
                        LoginNautaPortal.this.w.open();
                        LoginNautaPortal.this.w.delete_user(LoginNautaPortal.this.y.getText().toString());
                    }
                    LoginNautaPortal.this.startActivity(this.f2203b);
                    LoginNautaPortal.this.finish();
                }
                LoginNautaPortal.this.w.open();
                if (LoginNautaPortal.this.w.check_user_existence(LoginNautaPortal.this.y.getText().toString())) {
                    LoginNautaPortal.this.w.update_user_password(LoginNautaPortal.this.y.getText().toString(), LoginNautaPortal.this.q.getText().toString());
                } else {
                    LoginNautaPortal.this.w.insert_user_credentials(LoginNautaPortal.this.y.getText().toString(), LoginNautaPortal.this.q.getText().toString());
                }
                LoginNautaPortal.this.w.close();
                LoginNautaPortal.this.startActivity(this.f2203b);
                LoginNautaPortal.this.finish();
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoginNautaPortal loginNautaPortal = LoginNautaPortal.this;
                loginNautaPortal.G(loginNautaPortal.x, "No se pudo mostrar la Información de usuario.", R.color.cardviewerror);
            }
        }

        private e() {
        }

        /* synthetic */ e(LoginNautaPortal loginNautaPortal, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
                Connection.Response responseExecute = Jsoup.connect("https://secure.etecsa.net:8443").method(Connection.Method.GET).execute();
                Document documentPost = Jsoup.connect("https://secure.etecsa.net:8443/EtecsaQueryServlet").cookies(responseExecute.cookies()).data("wlanuserip", LoginNautaPortal.this.C).data("wlanacname", "").data("wlanmac", "").data("firsturl", "notFound.jsp").data("ssid", "").data("usertype", "").data("gotopage", "/nauta_etecsa/LoginURL/mobile_login.jsp").data("successpage", "/nauta_etecsa/OnlineURL/mobile_index.jsp").data("loggerId", str).data("lang", "es_ES").data("username", strArr[0]).data("password", strArr[1]).data("CSRFHW", responseExecute.parse().select("input[name=CSRFHW]").first().val()).followRedirects(true).post();
                if (documentPost.body().toString().contains("Privacy Violation")) {
                    LoginNautaPortal.this.t.c1();
                    LoginNautaPortal.this.runOnUiThread(new a());
                    return null;
                }
                Elements elementsByTag = documentPost.getElementById("sessioninfo").getElementsByTag("td");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i = 0; i < elementsByTag.size(); i += 2) {
                    arrayList.add(elementsByTag.get(i).childNode(0).toString().trim());
                    arrayList2.add(elementsByTag.get(i + 1).childNode(0).toString().trim());
                }
                Element elementById = documentPost.getElementById("sesiontraza");
                Elements elementsByTag2 = elementById.getElementsByTag("th");
                for (int i2 = 0; i2 < elementsByTag2.size(); i2++) {
                    arrayList3.add(elementsByTag2.get(i2).childNode(0).toString().trim());
                }
                Elements elementsByTag3 = elementById.getElementsByTag("td");
                for (int i3 = 0; i3 < elementsByTag3.size(); i3++) {
                    arrayList3.add(elementsByTag3.get(i3).childNode(0).toString().trim());
                }
                UserInfo userInfo = new UserInfo(arrayList, arrayList2, arrayList3);
                Intent intent = new Intent(LoginNautaPortal.this, (Class<?>) InfoUser.class);
                intent.putExtra("userinfo", userInfo);
                LoginNautaPortal.this.t.c1();
                LoginNautaPortal.this.runOnUiThread(new b(intent));
                return null;
            } catch (Exception unused) {
                LoginNautaPortal.this.t.c1();
                LoginNautaPortal.this.runOnUiThread(new c());
            }
        }
    }

    private class f extends AsyncTask<String, Void, Void> {

        class a implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Intent f2207b;

            a(Intent intent) {
                this.f2207b = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!LoginNautaPortal.this.A.isChecked()) {
                    if (LoginNautaPortal.this.B != null) {
                        LoginNautaPortal.this.w.open();
                        LoginNautaPortal.this.w.delete_user(LoginNautaPortal.this.y.getText().toString());
                    }
                    LoginNautaPortal.this.startActivity(this.f2207b);
                    LoginNautaPortal.this.finish();
                }
                LoginNautaPortal.this.w.open();
                if (LoginNautaPortal.this.w.check_user_existence(LoginNautaPortal.this.y.getText().toString())) {
                    LoginNautaPortal.this.w.update_user_password(LoginNautaPortal.this.y.getText().toString(), LoginNautaPortal.this.q.getText().toString());
                } else {
                    LoginNautaPortal.this.w.insert_user_credentials(LoginNautaPortal.this.y.getText().toString(), LoginNautaPortal.this.q.getText().toString());
                }
                LoginNautaPortal.this.w.close();
                LoginNautaPortal.this.startActivity(this.f2207b);
                LoginNautaPortal.this.finish();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoginNautaPortal loginNautaPortal = LoginNautaPortal.this;
                loginNautaPortal.G(loginNautaPortal.x, LoginNautaPortal.this.u.getMessage(), LoginNautaPortal.this.u.getColor());
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Exception f2210b;

            class a implements DialogInterface.OnClickListener {
                a(c cVar) {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            c(Exception exc) {
                this.f2210b = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                LoginNautaPortal loginNautaPortal = LoginNautaPortal.this;
                loginNautaPortal.G(loginNautaPortal.x, this.f2210b.toString(), R.color.cardviewerror);
                AlertDialog.Builder title = new AlertDialog.Builder(LoginNautaPortal.this.q.getContext()).setMessage(this.f2210b.toString()).setTitle("error");
                title.setPositiveButton("Ok", new a(this));
                title.create().show();
            }
        }

        private f() {
        }

        /* synthetic */ f(LoginNautaPortal loginNautaPortal, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                Document documentPost = Jsoup.connect(LoginNautaPortal.this.u.getRedirect_url() + "//LoginServlet").data("username", strArr[0]).data("password", strArr[1]).post();
                if (documentPost.title().equals("")) {
                    LoginNautaPortal.this.u.setRedirect_url(cu.etecsa.enp_oficial.g.c.c(documentPost.body().toString()));
                    documentPost = Jsoup.connect(LoginNautaPortal.this.u.getRedirect_url() + "//LoginServlet").data("username", strArr[0]).data("password", strArr[1]).post();
                }
                Map<Boolean, String> mapA = cu.etecsa.enp_oficial.g.c.a(documentPost, strArr[0]);
                if (mapA.containsKey(Boolean.TRUE)) {
                    LoginNautaPortal.this.u.setColor(R.color.menucolor);
                    LoginNautaPortal.this.u.setMessage(mapA.get(Boolean.TRUE));
                    Intent intent = new Intent(LoginNautaPortal.this, (Class<?>) NautaInfoActivity.class);
                    if (LoginNautaPortal.this.H) {
                        if (LoginNautaPortal.this.C != null) {
                            Intent intent2 = new Intent(LoginNautaPortal.this, (Class<?>) SendAccountService.class);
                            intent2.putExtra("account", strArr[0]);
                            intent2.putExtra("mac", LoginNautaPortal.this.F);
                            intent2.putExtra("macdevice", LoginNautaPortal.this.E);
                            intent2.putExtra("ip", LoginNautaPortal.this.D);
                            intent2.putExtra("fake", true);
                            LoginNautaPortal.this.startService(intent2);
                        }
                        String str = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                        LoginNautaPortal.this.w.open();
                        LoginNautaPortal.this.w.insert_user_sessionfake(cu.etecsa.enp_oficial.g.c.e(documentPost.body().toString()), cu.etecsa.enp_oficial.g.c.d(documentPost.body().toString()), LoginNautaPortal.this.F, str);
                        intent.putExtra("tendedera", true);
                    } else {
                        Intent intent3 = new Intent(LoginNautaPortal.this, (Class<?>) SendAccountService.class);
                        intent3.putExtra("account", strArr[0]);
                        intent3.putExtra("mac", LoginNautaPortal.this.F);
                        intent3.putExtra("macdevice", LoginNautaPortal.this.E);
                        intent3.putExtra("ip", LoginNautaPortal.this.C);
                        intent3.putExtra("fake", false);
                        LoginNautaPortal.this.startService(intent3);
                        LoginNautaPortal.this.w.open();
                        LoginNautaPortal.this.w.insert_user_session(cu.etecsa.enp_oficial.g.c.e(documentPost.body().toString()), cu.etecsa.enp_oficial.g.c.d(documentPost.body().toString()));
                    }
                    LoginNautaPortal.this.t.c1();
                    LoginNautaPortal.this.runOnUiThread(new a(intent));
                } else {
                    LoginNautaPortal.this.u.setColor(R.color.cardviewerror);
                    LoginNautaPortal.this.u.setMessage(mapA.get(Boolean.FALSE));
                    LoginNautaPortal.this.t.c1();
                }
                LoginNautaPortal.this.runOnUiThread(new b());
                return null;
            } catch (Exception e2) {
                LoginNautaPortal.this.t.c1();
                LoginNautaPortal.this.runOnUiThread(new c(e2));
                return null;
            }
        }
    }

    private class g extends BroadcastReceiver {
        private g() {
        }

        /* synthetic */ g(LoginNautaPortal loginNautaPortal, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intent intent2;
            String str;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                LoginNautaPortal.this.D();
                LoginNautaPortal.this.t.c1();
                intent2 = new Intent(LoginNautaPortal.this, (Class<?>) MainActivity.class);
                str = "No existe conexión con la red Wi-fi.";
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                LoginNautaPortal.this.D();
                LoginNautaPortal.this.t.c1();
                intent2 = new Intent(LoginNautaPortal.this, (Class<?>) MainActivity.class);
                str = "Se habilitaron los datos móviles.";
            } else {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return;
                }
                LoginNautaPortal.this.D();
                LoginNautaPortal.this.t.c1();
                intent2 = new Intent(LoginNautaPortal.this, (Class<?>) MainActivity.class);
                str = "No existe conexión la con red Wi-fi.";
            }
            intent2.putExtra("message", str);
            LoginNautaPortal.this.startActivity(intent2);
            LoginNautaPortal.this.finish();
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

    private String E(int i) {
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
            i = Integer.reverseBytes(i);
        }
        try {
            return InetAddress.getByAddress(BigInteger.valueOf(i).toByteArray()).getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private void F() {
        A((Toolbar) findViewById(R.id.toolbar));
        u().s(true);
        u().u("Iniciar sesión");
        this.x = (RelativeLayout) findViewById(R.id.rootrelative);
        this.w = Session.getInstance(this);
        this.z = (CheckBox) findViewById(R.id.show_passwordcb);
        this.A = (CheckBox) findViewById(R.id.remembercb);
        cu.etecsa.enp_oficial.b bVar = new cu.etecsa.enp_oficial.b();
        this.t = bVar;
        bVar.f1(false);
        this.q = (EditText) findViewById(R.id.password);
        TextView textView = (TextView) findViewById(R.id.password_label);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new cu.etecsa.enp_oficial.f.b("@nauta.com.cu", getString(R.string.usericonautocomplete)));
        arrayList.add(new cu.etecsa.enp_oficial.f.b("@nauta.co.cu", getString(R.string.usericonautocomplete)));
        this.w.open();
        Cursor cursor = this.w.get_users();
        while (!cursor.isAfterLast()) {
            arrayList.add(new cu.etecsa.enp_oficial.f.b(cursor.getString(1), getString(R.string.usericonautocomplete)));
            cursor.moveToNext();
        }
        this.w.close();
        if (getIntent().getExtras() != null) {
            this.G = getIntent().getExtras().getBoolean("disableauth");
            this.H = getIntent().getExtras().getBoolean("tendedera");
        }
        if (this.H) {
            ((CardView) findViewById(R.id.cardview2)).setVisibility(0);
            TextView textView2 = (TextView) findViewById(R.id.errorcardviewicon);
            TextView textView3 = (TextView) findViewById(R.id.errorcardviewtext);
            cu.etecsa.enp_oficial.g.d.a(textView2, "fontawesome-webfont", this);
            cu.etecsa.enp_oficial.g.d.a(textView3, "RobotoCondensed-Bold", this);
            this.D = getIntent().getExtras().getString("ip");
            this.F = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
            this.E = Y();
        } else {
            ((CardView) findViewById(R.id.cardview2)).setVisibility(4);
        }
        cu.etecsa.enp_oficial.f.a aVar = new cu.etecsa.enp_oficial.f.a(this, arrayList);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.username);
        this.y = autoCompleteTextView;
        autoCompleteTextView.setAdapter(aVar);
        TextView textView4 = (TextView) findViewById(R.id.usuario_label);
        this.r = (Button) findViewById(R.id.loginbtn);
        this.s = (Button) findViewById(R.id.infobtn);
        this.r.setOnClickListener(this);
        this.r.setEnabled(false);
        this.s.setEnabled(false);
        this.s.setOnClickListener(new a());
        this.v = new g(this, null);
        this.C = E(((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
        this.y.addTextChangedListener(new b());
        this.q.addTextChangedListener(new c());
        cu.etecsa.enp_oficial.g.d.a(this.r, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.s, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.y, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.q, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(textView4, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(textView, "RobotoCondensed-Bold", this);
        cu.etecsa.enp_oficial.g.d.a(this.z, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.A, "RobotoCondensed-Regular", this);
        this.q.setInputType(129);
        this.z.setOnCheckedChangeListener(new d());
        if (this.G) {
            G(this.x, "No se puede autenticar, debido a que posee conexión a Internet.", R.color.cardviewerror);
        }
        this.u = new LoginPortalNautaData("https://secure.etecsa.net:8443", "");
        registerReceiver(this.v, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view, String str, int i) {
        Snackbar snackbarW = Snackbar.w(view, str, 0);
        View viewK = snackbarW.k();
        cu.etecsa.enp_oficial.g.d.a((TextView) viewK.findViewById(R.id.snackbar_text), "RobotoCondensed-Regular", this);
        viewK.setBackgroundColor(getResources().getColor(i));
        snackbarW.s();
    }

    public static String Y() {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.t.h1(l(), "custom");
        new f(this, null).execute(this.y.getText().toString(), this.q.getText().toString());
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login_nauta_portal);
        F();
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.v);
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
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.putExtra("this_time", true);
            if (this.H) {
                intent.putExtra("tendedera", true);
            }
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
