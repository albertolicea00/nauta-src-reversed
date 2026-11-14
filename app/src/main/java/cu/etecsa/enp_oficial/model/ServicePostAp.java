package cu.etecsa.enp_oficial.model;

import b.a.a.x.a;
import b.a.a.x.c;

/**
 * Retrofit request/response DTO for AP MAC verification.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.model.ServicePostAp
 */
public class ServicePostAp {

    @c("app_version")
    @a
    private String app_version;

    @c("ipdispositivo")
    @a
    private String ipdispositivo;

    @c("mac")
    @a
    private String mac;

    @c("macdispositivo")
    @a
    private String macdispositivo;

    @c("ok_response")
    @a
    private String ok_response;

    public ServicePostAp(String str, String str2, String str3, String str4, String str5) {
        this.mac = str;
        this.ok_response = str2;
        this.ipdispositivo = str3;
        this.app_version = str4;
        this.macdispositivo = str5;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getIpdispositivo() {
        return this.ipdispositivo;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMacdispositivo() {
        return this.macdispositivo;
    }

    public String getOk_response() {
        return this.ok_response;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setIpdispositivo(String str) {
        this.ipdispositivo = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMacdispositivo(String str) {
        this.macdispositivo = str;
    }

    public void setOk_response(String str) {
        this.ok_response = str;
    }
}
