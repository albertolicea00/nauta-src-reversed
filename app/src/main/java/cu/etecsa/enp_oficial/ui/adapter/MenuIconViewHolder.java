package cu.etecsa.enp_oficial.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cu.etecsa.enp_oficial.R;

/**
 * RecyclerView ViewHolder for dashboard menu tiles.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.e.a.c
 */
public class MenuIconViewHolder extends RecyclerView.c0 {
    public TextView t;
    public cu.etecsa.enp_oficial.e.a.a u;
    public RelativeLayout v;
    public ImageView w;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.u.c(view, cVar.j());
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.u.c(view, cVar.j());
        }
    }

    public MenuIconViewHolder(View view, cu.etecsa.enp_oficial.e.a.a aVar) {
        super(view);
        this.w = (ImageView) view.findViewById(R.id.menuicon);
        this.t = (TextView) view.findViewById(R.id.menuname);
        this.v = (RelativeLayout) view.findViewById(R.id.relativelayoutmenuitem);
        this.u = aVar;
        TextView textView = this.t;
        cu.etecsa.enp_oficial.g.d.a(textView, "RobotoCondensed-Regular", textView.getContext());
        view.setOnClickListener(new a());
        this.w.setOnClickListener(new b());
    }
}
