package cu.etecsa.enp_oficial.g;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.jsoup.nodes.Document;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static Map<Boolean, String> a(Document document, String str) {
        HashMap map = new HashMap();
        if (document.title().equals("Nauta") && document.body().toString().contains(str)) {
            map.put(Boolean.TRUE, "!!Usuario autenticado con éxito!!");
        } else {
            String string = document.select("#banner_promos ~ script").first().toString();
            map.put(Boolean.FALSE, "!!" + string.substring(string.indexOf("(\"") + 2, string.indexOf("\")") - 1) + "!!");
        }
        return map;
    }

    public static TreeMap<String, String> b(String str) {
        String[] strArrSplit = str.split("&");
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("=");
            if (strArrSplit2.length > 1) {
                treeMap.put(strArrSplit2[0], strArrSplit2[1]);
            } else {
                treeMap.put(strArrSplit2[0], "");
            }
        }
        return treeMap;
    }

    public static String c(String str) {
        return str.substring(str.indexOf("action=\"") + 8, str.indexOf("\">"));
    }

    public static String d(String str) {
        String strSubstring = str.substring(str.indexOf("pageOnunload"), str.indexOf("logoutToFirstPage"));
        return strSubstring.substring(strSubstring.indexOf("ATTRIBUTE_UUID"), strSubstring.indexOf("removeCookie;")).replace("\"", "").replace("\t", "").replace("\n", "").replace("+", "").replaceAll(" ", "").replaceAll("\r", "") + "1";
    }

    public static String e(String str) {
        String strSubstring = str.substring(str.indexOf("updateAvailableTime"), str.indexOf("EtecsaQueryServlet"));
        return strSubstring.substring(strSubstring.indexOf("op"), strSubstring.indexOf("g_httpRequest.open")).replace("\"", "").replace("\t", "").replace("\n", "").replace("+", "").replaceAll(" ", "").replaceAll("\r", "").split(";")[0];
    }
}
