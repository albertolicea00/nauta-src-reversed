package cu.etecsa.enp_oficial;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class About extends android.support.v7.app.c {
    private void D() {
        A((Toolbar) findViewById(R.id.toolbar));
        u().s(true);
        u().u("Acerca de");
        TextView textView = (TextView) findViewById(R.id.appversion);
        textView.setText("Versión 1.2.0.1");
        cu.etecsa.enp_oficial.g.d.a(textView, "RobotoCondensed-Regular", this);
        cu.etecsa.enp_oficial.g.d.a((TextView) findViewById(R.id.etecsatext), "RobotoCondensed-Regular", this);
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_about);
        D();
    }

    @Override // android.support.v7.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
