package cu.etecsa.enp_oficial.model;

import b.a.a.x.a;
import b.a.a.x.c;

/* JADX INFO: loaded from: classes.dex */
public class ServicePostUserClient {

    @c("account")
    @a
    private String account;

    @c("ip")
    @a
    private String ip;

    @c("mac")
    @a
    private String mac;

    @c("macdevice")
    @a
    private String macdevice;

    public ServicePostUserClient(String str, String str2, String str3, String str4) {
        this.mac = str4;
        this.account = str2;
        this.ip = str3;
        this.macdevice = str;
    }

    public String getAccount() {
        return this.account;
    }

    public String getIp() {
        return this.ip;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMacdevice() {
        return this.macdevice;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMacdevice(String str) {
        this.macdevice = str;
    }
}
