package cu.etecsa.enp_oficial;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.x;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cu.etecsa.enp_oficial.model.NautaInfoData;
import cu.etecsa.enp_oficial.model.Session;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class UserAccountService extends Service {
    private static String G = "default_channel";
    private static String H = "Default";
    private RotateAnimation F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WindowManager f2279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f2281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f2282e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private Runnable m;
    private NautaInfoData n;
    private Timer p;
    private WifiManager y;
    private Handler o = new Handler();
    private boolean q = false;
    private String r = "";
    private String s = "";
    private String t = "";
    private String u = "";
    private String v = "";
    private long w = 0;
    private long x = 0;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = true;
    private boolean D = false;
    private boolean E = false;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (UserAccountService.this.C && !UserAccountService.this.D) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHHH:mm:ss");
                    if (simpleDateFormat.parse(UserAccountService.this.n.GetTimeToString()).before(simpleDateFormat.parse("00:05:02"))) {
                        UserAccountService.this.E = true;
                        UserAccountService.this.D = true;
                    }
                } catch (Exception unused) {
                }
            }
            if (UserAccountService.this.B || UserAccountService.this.z || UserAccountService.this.A) {
                try {
                    UserAccountService.this.J();
                } catch (Exception unused2) {
                    UserAccountService.this.v = "----";
                    UserAccountService.this.s = "----";
                    UserAccountService.this.r = "----";
                    UserAccountService.this.u = "----";
                    UserAccountService.this.t = "----";
                }
            }
            if (UserAccountService.this.f2282e.getText().toString().equals("00:00:00")) {
                UserAccountService.this.q = true;
            } else {
                UserAccountService.this.n.Decrement_Time();
            }
            UserAccountService.this.o.post(UserAccountService.this.m);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UserAccountService.this.E) {
                NotificationManager notificationManager = (NotificationManager) UserAccountService.this.getSystemService("notification");
                UserAccountService.I(notificationManager);
                x.b bVar = new x.b(UserAccountService.this.getApplicationContext(), UserAccountService.G);
                bVar.e("Nauta");
                bVar.d("A su cuenta le queda menos de 5 minutos");
                bVar.f(android.R.drawable.ic_menu_view);
                notificationManager.notify(1, bVar.a());
                Toast.makeText(UserAccountService.this.getApplicationContext(), "A su cuenta le queda menos de 5 minutos", 1).show();
                UserAccountService.this.E = false;
            }
            if (UserAccountService.this.A) {
                UserAccountService.this.l.setText(UserAccountService.this.u + UserAccountService.this.t);
            }
            if (UserAccountService.this.B) {
                UserAccountService.this.j.setText(UserAccountService.this.s + UserAccountService.this.r);
            }
            if (UserAccountService.this.z) {
                UserAccountService.this.h.setText(UserAccountService.this.v);
            }
            if (UserAccountService.this.q) {
                ((LinearLayout) UserAccountService.this.f2280c.findViewById(R.id.floatinglayout)).setBackgroundColor(UserAccountService.this.getResources().getColor(R.color.cardviewerror));
            } else {
                UserAccountService.this.f2282e.setText(UserAccountService.this.n.GetTimeToString());
            }
        }
    }

    class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2287d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f2288e;
        final /* synthetic */ WindowManager.LayoutParams f;

        class a implements Animation.AnimationListener {
            a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                UserAccountService.this.stopService(new Intent(UserAccountService.this.getApplicationContext(), (Class<?>) UserAccountService.class));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        c(WindowManager.LayoutParams layoutParams) {
            this.f = layoutParams;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                UserAccountService.this.f2281d.findViewById(R.id.rootcontainer).setVisibility(0);
                WindowManager.LayoutParams layoutParams = this.f;
                this.f2285b = layoutParams.x;
                this.f2286c = layoutParams.y;
                this.f2287d = motionEvent.getRawX();
                this.f2288e = motionEvent.getRawY();
                return true;
            }
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                UserAccountService.this.f2281d.findViewById(R.id.rootcontainer).setVisibility(0);
                this.f.x = this.f2285b + ((int) (motionEvent.getRawX() - this.f2287d));
                this.f.y = this.f2286c + ((int) (motionEvent.getRawY() - this.f2288e));
                UserAccountService.this.f2279b.updateViewLayout(UserAccountService.this.f2280c, this.f);
                return true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            UserAccountService.this.f2280c.measure(0, 0);
            UserAccountService.this.f2280c.getLocationOnScreen(iArr);
            UserAccountService.this.f2281d.measure(0, 0);
            UserAccountService.this.f2281d.getLocationOnScreen(iArr2);
            if (iArr[0] < iArr2[0] + UserAccountService.this.f2281d.getMeasuredWidth() && iArr[0] + UserAccountService.this.f2280c.getMeasuredWidth() > iArr2[0] && iArr[1] < iArr2[1] + UserAccountService.this.f2281d.getMeasuredHeight() && iArr[1] + UserAccountService.this.f2280c.getMeasuredHeight() > iArr2[1]) {
                z = true;
            }
            UserAccountService userAccountService = UserAccountService.this;
            if (z) {
                userAccountService.f2280c.setVisibility(8);
                UserAccountService.this.F = new RotateAnimation(8.0f, -8.0f, 1, 0.5f, 1, 0.5f);
                UserAccountService.this.F.setDuration(500L);
                UserAccountService.this.F.setInterpolator(new LinearInterpolator());
                ((ImageView) UserAccountService.this.f2281d.findViewById(R.id.trash)).startAnimation(UserAccountService.this.F);
                UserAccountService.this.F.setAnimationListener(new a());
            } else {
                userAccountService.f2281d.findViewById(R.id.rootcontainer).setVisibility(8);
            }
            return true;
        }
    }

    public static void I(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT < 26 || notificationManager.getNotificationChannel(G) != null) {
            return;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(G, H, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        String str;
        if (this.z) {
            int rssi = this.y.getConnectionInfo().getRssi();
            if (rssi > -70) {
                str = "Excelente";
            } else {
                str = (rssi > -70 || rssi < -79) ? "Débil" : "Buena";
            }
            this.v = str;
        }
        if (this.B) {
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            long totalRxBytes2 = TrafficStats.getTotalRxBytes() - this.w;
            this.r = "B/s";
            this.s = Long.toString(totalRxBytes2);
            if (totalRxBytes2 >= 1024) {
                long j = totalRxBytes2 / 1024;
                this.r = "K/s";
                this.s = Long.toString(j);
                if (j >= 1024) {
                    long j2 = j / 1024;
                    this.r = "M/s";
                    this.s = Long.toString(j2);
                    if (j2 >= 1024) {
                        this.r = "G/s";
                        this.s = Long.toString(j2 / 1024);
                    }
                }
            }
            this.w = totalRxBytes;
        }
        if (this.A) {
            long totalTxBytes = TrafficStats.getTotalTxBytes();
            long totalTxBytes2 = TrafficStats.getTotalTxBytes() - this.x;
            this.t = "B/s";
            this.u = Long.toString(totalTxBytes2);
            if (totalTxBytes2 >= 1024) {
                long j3 = totalTxBytes2 / 1024;
                this.t = "K/s";
                this.u = Long.toString(j3);
                if (j3 >= 1024) {
                    long j4 = j3 / 1024;
                    this.t = "M/s";
                    this.u = Long.toString(j4);
                    if (j4 >= 1024) {
                        this.t = "G/s";
                        this.u = Long.toString(j4 / 1024);
                    }
                }
            }
            this.x = totalTxBytes;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f2280c = LayoutInflater.from(this).inflate(R.layout.floatinguseraccountlayout, (ViewGroup) null);
        this.f2281d = LayoutInflater.from(this).inflate(R.layout.trashingservice, (ViewGroup) null);
        Session session = Session.getInstance(getApplicationContext());
        session.open();
        Cursor settings = session.getSettings();
        this.z = Boolean.parseBoolean(settings.getString(3));
        this.B = Boolean.parseBoolean(settings.getString(2));
        this.A = Boolean.parseBoolean(settings.getString(4));
        this.C = Boolean.parseBoolean(settings.getString(5));
        session.close();
        this.y = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.f2282e = (TextView) this.f2280c.findViewById(R.id.tiemporestante);
        this.f = (TextView) this.f2280c.findViewById(R.id.tiemporestanteheader);
        this.j = (TextView) this.f2280c.findViewById(R.id.servicedownload);
        this.i = (TextView) this.f2280c.findViewById(R.id.servicedownloadicon);
        this.l = (TextView) this.f2280c.findViewById(R.id.serviceupload);
        this.k = (TextView) this.f2280c.findViewById(R.id.serviceuploadicon);
        this.h = (TextView) this.f2280c.findViewById(R.id.servicewifisignal);
        this.g = (TextView) this.f2280c.findViewById(R.id.servicewificon);
        cu.etecsa.enp_oficial.g.d.a(this.f2282e, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.l, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.j, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.h, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a(this.g, "fontawesome-webfont", this);
        cu.etecsa.enp_oficial.g.d.a(this.i, "fontawesome-webfont", this);
        cu.etecsa.enp_oficial.g.d.a(this.k, "fontawesome-webfont", this);
        cu.etecsa.enp_oficial.g.d.a(this.f, "RobotoCondensed-Bold", this);
        if (!this.z) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
        }
        if (!this.B) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        if (!this.A) {
            this.l.setVisibility(8);
            this.k.setVisibility(8);
        }
        WindowManager.LayoutParams layoutParams = Build.VERSION.SDK_INT < 26 ? new WindowManager.LayoutParams(-2, -2, 2002, 8, -3) : new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        WindowManager.LayoutParams layoutParams2 = Build.VERSION.SDK_INT < 26 ? new WindowManager.LayoutParams(-2, -2, 2002, 8, -3) : new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 100;
        layoutParams2.gravity = 81;
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.f2279b = windowManager;
        windowManager.addView(this.f2280c, layoutParams);
        WindowManager windowManager2 = (WindowManager) getSystemService("window");
        this.f2279b = windowManager2;
        windowManager2.addView(this.f2281d, layoutParams2);
        this.f2281d.findViewById(R.id.rootcontainer).setVisibility(8);
        this.f2280c.findViewById(R.id.rootcontainer).setOnTouchListener(new c(layoutParams));
    }

    @Override // android.app.Service
    public void onDestroy() {
        Intent intent = new Intent("time");
        intent.putExtra("notificated", this.D);
        a.b.f.a.c.b(this).d(intent);
        View view = this.f2280c;
        if (view != null) {
            this.f2279b.removeView(view);
            this.f2279b.removeView(this.f2281d);
            Timer timer = this.p;
            if (timer != null) {
                timer.cancel();
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || intent.getExtras() == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.D = intent.getExtras().getBoolean("notificated");
        this.f2282e.setText(intent.getExtras().getString("tiemporestante"));
        if (!intent.getExtras().getString("tiemporestante").equals("00:00:00")) {
            this.n = new NautaInfoData("", "", intent.getExtras().getString("tiemporestante"));
            this.o = new Handler();
            this.p = new Timer();
            this.p.schedule(new a(), 0L, 1000L);
            this.m = new b();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
