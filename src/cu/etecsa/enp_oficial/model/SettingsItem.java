package cu.etecsa.enp_oficial.model;

/* JADX INFO: loaded from: classes.dex */
public class SettingsItem {
    private boolean checked;
    private String description;
    private String name;

    public SettingsItem(String str, String str2, boolean z) {
        this.name = str;
        this.description = str2;
        this.checked = z;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
