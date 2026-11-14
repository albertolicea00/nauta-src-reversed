package cu.etecsa.enp_oficial.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import cu.etecsa.enp_oficial.R;
import cu.etecsa.enp_oficial.g.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends ArrayAdapter<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b> f2298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Filter f2299c;

    /* JADX INFO: renamed from: cu.etecsa.enp_oficial.f.a$a, reason: collision with other inner class name */
    class C0059a extends Filter {
        C0059a() {
        }

        @Override // android.widget.Filter
        public CharSequence convertResultToString(Object obj) {
            return ((b) obj).b();
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            b bVar;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            if (charSequence == null || charSequence.length() == 0) {
                arrayList.addAll(a.this.f2298b);
            } else {
                String strTrim = charSequence.toString().toLowerCase().trim();
                int length = strTrim.split("@").length - 1;
                for (b bVar2 : a.this.f2298b) {
                    if (!bVar2.b().toLowerCase().trim().contains(strTrim) || strTrim.startsWith("@")) {
                        if (strTrim.contains("@") && !strTrim.startsWith("@") && length == 0) {
                            bVar = new b(strTrim.substring(0, strTrim.length() - 1) + bVar2.b(), a.this.getContext().getString(R.string.usericonautocomplete));
                        } else if (length == 0) {
                            bVar = new b(strTrim + bVar2.b(), a.this.getContext().getString(R.string.usericonautocomplete));
                        }
                        arrayList.add(bVar);
                    } else {
                        arrayList.add(bVar2);
                    }
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            a.this.clear();
            a.this.addAll((List) filterResults.values);
            a.this.notifyDataSetChanged();
        }
    }

    public a(Context context, List<b> list) {
        super(context, 0, list);
        this.f2299c = new C0059a();
        this.f2298b = new ArrayList(list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return this.f2299c;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_autocomplete_row, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.usernameautocompletetextview);
        TextView textView2 = (TextView) view.findViewById(R.id.usericonautocompletetextview);
        textView.setText(getItem(i).b());
        textView2.setText(getItem(i).a());
        d.a(textView, "RobotoCondensed-Regular", getContext());
        d.a(textView2, "fontawesome-webfont", textView2.getContext());
        return view;
    }
}
