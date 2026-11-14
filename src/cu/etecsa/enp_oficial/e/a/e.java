package cu.etecsa.enp_oficial.e.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import cu.etecsa.enp_oficial.R;

/* JADX INFO: loaded from: classes.dex */
public class e extends RecyclerView.c0 {
    public TextView t;
    public TextView u;
    public CheckBox v;
    public cu.etecsa.enp_oficial.e.a.a w;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.w.c(view, eVar.j());
        }
    }

    public e(View view, cu.etecsa.enp_oficial.e.a.a aVar) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.settingsitemname);
        this.u = (TextView) view.findViewById(R.id.settingsitemdescripcion);
        this.v = (CheckBox) view.findViewById(R.id.settingsitemcheckbox);
        this.w = aVar;
        TextView textView = this.t;
        cu.etecsa.enp_oficial.g.d.a(textView, "RobotoCondensed-Bold", textView.getContext());
        cu.etecsa.enp_oficial.g.d.a(this.u, "RobotoCondensed-Regular", this.t.getContext());
        this.v.setOnClickListener(new a());
    }
}
