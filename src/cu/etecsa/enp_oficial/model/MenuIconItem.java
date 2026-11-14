package cu.etecsa.enp_oficial.model;

/* JADX INFO: loaded from: classes.dex */
public class MenuIconItem {
    private int icon;
    private boolean isenabled;
    private String name;

    public MenuIconItem(int i, String str, boolean z) {
        this.icon = i;
        this.name = str;
        this.isenabled = z;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public boolean isenabled() {
        return this.isenabled;
    }

    public void setIcon(int i) {
        this.icon = i;
    }

    public void setIsenabled(boolean z) {
        this.isenabled = z;
    }

    public void setName(String str) {
        this.name = str;
    }
}
