package cu.etecsa.enp_oficial.e.a;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import cu.etecsa.enp_oficial.R;
import cu.etecsa.enp_oficial.model.MenuIconItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends RecyclerView.f<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f2290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<MenuIconItem> f2291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f2292e;

    public b(Activity activity, ArrayList<MenuIconItem> arrayList, a aVar) {
        this.f2291d = arrayList;
        this.f2290c = activity;
        this.f2292e = aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public int c() {
        return this.f2291d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.f
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void h(c cVar, int i) {
        cVar.t.setText(this.f2291d.get(i).getName());
        cVar.w.setImageDrawable(this.f2290c.getResources().getDrawable(this.f2291d.get(i).getIcon()));
        if (this.f2291d.get(i).isenabled()) {
            return;
        }
        cVar.w.setBackgroundResource(R.drawable.roundbuttondisabled);
        cVar.t.setTextColor(this.f2290c.getResources().getColor(R.color.white));
        cVar.v.setBackgroundResource(R.drawable.layoutbottomborderdisabled);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c j(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu1, viewGroup, false), this.f2292e);
    }
}
