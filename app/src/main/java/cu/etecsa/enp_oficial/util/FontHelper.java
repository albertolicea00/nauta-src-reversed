package cu.etecsa.enp_oficial.util;

import cu.etecsa.enp_oficial.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

/**
 * Applies bundled assets/fonts/*.ttf Typeface onto TextView instances.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.g.d
 */
public class FontHelper {
    public static void a(View view, String str, Context context) {
        ((TextView) view).setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/" + str + ".ttf"));
    }
}
