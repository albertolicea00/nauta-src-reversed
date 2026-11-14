package cu.etecsa.enp_oficial;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class SplashScreenActivity extends android.support.v7.app.c {

    class a extends TimerTask {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Timer f2277b;

        a(Timer timer) {
            this.f2277b = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f2277b.cancel();
            SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this, (Class<?>) MainActivity.class));
            SplashScreenActivity.this.finish();
        }
    }

    private void D() {
        cu.etecsa.enp_oficial.g.d.a((TextView) findViewById(R.id.textlogo), "RobotoCondensed-Regular", this);
        TextView textView = (TextView) findViewById(R.id.appversion);
        textView.setText("Versión 1.2.0.1");
        cu.etecsa.enp_oficial.g.d.a(textView, "RobotoCondensed-Regular", this);
        Timer timer = new Timer();
        timer.schedule(new a(timer), 3000L);
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash_screen);
        D();
    }

    @Override // android.support.v7.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
