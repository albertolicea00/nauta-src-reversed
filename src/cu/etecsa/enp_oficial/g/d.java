package cu.etecsa.enp_oficial.g;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(View view, String str, Context context) {
        ((TextView) view).setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/" + str + ".ttf"));
    }
}
