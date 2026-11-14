package cu.etecsa.enp_oficial;

import android.app.ActivityManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.k0;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import cu.etecsa.enp_oficial.model.Session;
import cu.etecsa.enp_oficial.model.SettingsItem;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * User preferences screen backed by enp.db settings table.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.Settings
 */
public class Settings extends android.support.v7.app.c implements cu.etecsa.enp_oficial.e.a.a {
    private ArrayList<SettingsItem> q;
    private Session r;

    private void D() {
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
        u().u("Configuración");
        Session session = Session.getInstance(this);
        this.r = session;
        session.open();
        Cursor settings = this.r.getSettings();
        this.r.close();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        ArrayList<SettingsItem> arrayList = new ArrayList<>();
        this.q = arrayList;
        arrayList.add(new SettingsItem("Activar botón flotante", "Activa el botón flotante que se muestra al autenticarse en el portal de autenticación.", Boolean.parseBoolean(settings.getString(1))));
        this.q.add(new SettingsItem("Mostrar estado de señal", "Muestra el estado de la señal de la conexión Wi-fi en el botón flotante.", Boolean.parseBoolean(settings.getString(3))));
        this.q.add(new SettingsItem("Mostrar velocidad de bajada", "Muestra la velocidad de bajada de la conexión Wi-fi en el botón flotante.", Boolean.parseBoolean(settings.getString(2))));
        this.q.add(new SettingsItem("Mostrar velocidad de subida", "Muestra la velocidad de subida de la conexión Wi-fi en el botón flotante.", Boolean.parseBoolean(settings.getString(4))));
        this.q.add(new SettingsItem("Recordar cuando reste 5 minutos a la cuenta", "Permite notificar cuando reste menos de 5 minutos de la cuenta mientras se está navegando.", Boolean.parseBoolean(settings.getString(5))));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.u2(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new cu.etecsa.enp_oficial.e.a.d(this, this.q, this));
        recyclerView.i(new k0(this, 1));
    }

    @Override // cu.etecsa.enp_oficial.e.a.a
    public void c(View view, int i) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        this.r.open();
        if (i == 0) {
            if (!zIsChecked) {
                D();
            }
            this.r.updatesettingswidget(zIsChecked);
        } else if (i == 1) {
            this.r.updatesettingssignal(zIsChecked);
        } else if (i == 2) {
            this.r.updatesettingsdownload(zIsChecked);
        } else if (i == 3) {
            this.r.updatesettingsupload(zIsChecked);
        } else if (i == 4) {
            this.r.updatesettingsremember(zIsChecked);
        }
        this.r.close();
    }

    @Override // android.support.v7.app.c, android.support.v4.app.h, android.support.v4.app.e0, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        E();
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
