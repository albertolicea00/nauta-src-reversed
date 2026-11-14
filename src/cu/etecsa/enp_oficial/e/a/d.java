package cu.etecsa.enp_oficial.e.a;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cu.etecsa.enp_oficial.R;
import cu.etecsa.enp_oficial.model.SettingsItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.f<e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<SettingsItem> f2295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f2296d;

    public d(Activity activity, ArrayList<SettingsItem> arrayList, a aVar) {
        this.f2295c = arrayList;
        this.f2296d = aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public int c() {
        return this.f2295c.size();
    }

    @Override // android.support.v7.widget.RecyclerView.f
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void h(e eVar, int i) {
        eVar.t.setText(this.f2295c.get(i).getName());
        eVar.u.setText(this.f2295c.get(i).getDescription());
        eVar.v.setChecked(this.f2295c.get(i).isChecked());
    }

    @Override // android.support.v7.widget.RecyclerView.f
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public e j(ViewGroup viewGroup, int i) {
        return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.settingsitem, viewGroup, false), this.f2296d);
    }
}
