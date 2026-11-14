package cu.etecsa.enp_oficial;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import b.a.a.f;
import b.a.a.g;
import c.x;
import cu.etecsa.enp_oficial.api.WifiAPService;
import cu.etecsa.enp_oficial.model.ServicePostUserClient;
import e.l;
import e.m;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public class SendAccountService extends Service {

    private class b extends AsyncTask<String, Void, Void> {

        class a implements HostnameVerifier {
            a(b bVar) {
            }

            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return str.equals("192.168.43.227:8000");
            }
        }

        /* JADX INFO: renamed from: cu.etecsa.enp_oficial.SendAccountService$b$b, reason: collision with other inner class name */
        class C0058b extends d<Void> {
            C0058b(b bVar) {
                super(SendAccountService.this);
            }

            @Override // e.d
            public void b(e.b<Void> bVar, l<Void> lVar) {
            }
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                x.b bVar = new x.b();
                bVar.f(20L, TimeUnit.SECONDS);
                bVar.d(20L, TimeUnit.SECONDS);
                bVar.b(20L, TimeUnit.SECONDS);
                bVar.e(cu.etecsa.enp_oficial.g.a.a(SendAccountService.this.getApplicationContext()).getSocketFactory());
                bVar.c(new a(this));
                bVar.a();
                g gVar = new g();
                gVar.c();
                f fVarB = gVar.b();
                m.b bVar2 = new m.b();
                bVar2.b("http://192.168.43.227:8000/");
                bVar2.a(e.p.a.a.d(fVarB));
                ((WifiAPService) bVar2.d().d(WifiAPService.class)).sendaccount(new ServicePostUserClient(strArr[0], strArr[1], strArr[2], strArr[3])).u(new C0058b(this));
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private class c extends AsyncTask<String, Void, Void> {

        class a implements HostnameVerifier {
            a(c cVar) {
            }

            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return str.equals("192.168.43.227:8000");
            }
        }

        class b extends d<Void> {
            b(c cVar) {
                super(SendAccountService.this);
            }

            @Override // e.d
            public void b(e.b<Void> bVar, l<Void> lVar) {
            }
        }

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            try {
                x.b bVar = new x.b();
                bVar.f(20L, TimeUnit.SECONDS);
                bVar.d(20L, TimeUnit.SECONDS);
                bVar.b(20L, TimeUnit.SECONDS);
                bVar.e(cu.etecsa.enp_oficial.g.a.a(SendAccountService.this.getApplicationContext()).getSocketFactory());
                bVar.c(new a(this));
                bVar.a();
                g gVar = new g();
                gVar.c();
                f fVarB = gVar.b();
                m.b bVar2 = new m.b();
                bVar2.b("http://192.168.43.227:8000/");
                bVar2.a(e.p.a.a.d(fVarB));
                ((WifiAPService) bVar2.d().d(WifiAPService.class)).sendaccountetecsa(new ServicePostUserClient(strArr[0], strArr[1], strArr[2], strArr[3])).u(new b(this));
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public abstract class d<T> implements e.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2276a = 0;

        public d(SendAccountService sendAccountService) {
        }

        private void c(e.b<T> bVar) {
            bVar.clone().u(this);
        }

        @Override // e.d
        public void a(e.b<T> bVar, Throwable th) {
            int i = this.f2276a;
            this.f2276a = i + 1;
            if (i < 5) {
                c(bVar);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String string = intent.getExtras().getString("account");
        String string2 = intent.getExtras().getString("mac");
        String string3 = intent.getExtras().getString("macdevice");
        String string4 = intent.getExtras().getString("ip");
        if (intent.getExtras().getBoolean("fake")) {
            new b().execute(string3, string, string4, string2);
        } else {
            new c().execute(string3, string, string4, string2);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
