package cu.etecsa.enp_oficial.model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class UserInfo implements Serializable {
    private ArrayList<String> sessioninfodata;
    private ArrayList<String> sessioninfohead;
    private ArrayList<String> sessiontrazashead;

    public UserInfo(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        this.sessioninfohead = arrayList;
        this.sessioninfodata = arrayList2;
        this.sessiontrazashead = arrayList3;
    }

    public ArrayList<String> getSessioninfodata() {
        return this.sessioninfodata;
    }

    public ArrayList<String> getSessioninfohead() {
        return this.sessioninfohead;
    }

    public ArrayList<String> getSessiontrazashead() {
        return this.sessiontrazashead;
    }
}
