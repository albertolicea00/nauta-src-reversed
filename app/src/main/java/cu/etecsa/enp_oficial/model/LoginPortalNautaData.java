package cu.etecsa.enp_oficial.model;

/**
 * Captive portal login state model (URL and status message).
 *
 * @obfuscated_class cu.etecsa.enp_oficial.model.LoginPortalNautaData
 */
public class LoginPortalNautaData {
    int color;
    int drawable;
    private String message;
    private String redirect_url;

    public LoginPortalNautaData(String str, String str2) {
        this.redirect_url = str;
        this.message = str2;
    }

    public int getColor() {
        return this.color;
    }

    public int getDrawable() {
        return this.drawable;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRedirect_url() {
        return this.redirect_url;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setDrawable(int i) {
        this.drawable = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRedirect_url(String str) {
        this.redirect_url = str;
    }
}
