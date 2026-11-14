package cu.etecsa.enp_oficial;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.l;
import android.support.v4.app.q;
import android.support.v7.app.h;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class b extends h {
    private static boolean i0 = false;

    @Override // android.support.v4.app.f
    public void c1() {
        if (i0) {
            i0 = false;
            super.c1();
        }
    }

    @Override // android.support.v4.app.f
    public Dialog e1(Bundle bundle) {
        android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(f());
        View viewInflate = f().getLayoutInflater().inflate(R.layout.custom_progress_dialog, (ViewGroup) null);
        cu.etecsa.enp_oficial.g.d.a(viewInflate.findViewById(R.id.custom_progressdialog_textview), "RobotoCondensed-Regular", f());
        ((TextView) viewInflate.findViewById(R.id.custom_progressdialog_textview)).setText("Autenticando");
        aVar.k(viewInflate);
        return aVar.a();
    }

    public void h1(l lVar, String str) {
        if (i0) {
            return;
        }
        q qVarA = lVar.a();
        qVarA.b(this, str);
        qVarA.d();
        i0 = true;
    }
}
