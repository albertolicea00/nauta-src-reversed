package cu.etecsa.enp_oficial.model;

/* JADX INFO: loaded from: classes.dex */
public class NautaInfoData {
    private Integer hours;
    private String logout_url;
    private Integer minutes;
    private String remainig_time_url;
    private String remaining_time;
    private Integer seconds;

    public NautaInfoData(String str, String str2, String str3) {
        this.remainig_time_url = str;
        this.logout_url = str2;
        String[] strArrSplit = str3.split(":");
        this.hours = Integer.valueOf(strArrSplit[0]);
        this.minutes = Integer.valueOf(strArrSplit[1]);
        this.seconds = Integer.valueOf(strArrSplit[2]);
        this.remaining_time = "";
    }

    public void Decrement_Time() {
        int iValueOf;
        if (this.seconds.intValue() == 0 && this.minutes.intValue() == 0 && this.hours.intValue() == 0) {
            return;
        }
        if (this.seconds.intValue() != 0) {
            iValueOf = Integer.valueOf(this.seconds.intValue() - 1);
        } else if (this.minutes.intValue() > 0) {
            this.seconds = 59;
            this.minutes = Integer.valueOf(this.minutes.intValue() - 1);
            return;
        } else {
            if (this.hours.intValue() <= 0) {
                return;
            }
            this.hours = Integer.valueOf(this.hours.intValue() - 1);
            this.minutes = 59;
            iValueOf = 59;
        }
        this.seconds = iValueOf;
    }

    public String GetTimeToString() {
        return Integer.valueOf(this.hours.intValue() / 10).toString() + Integer.valueOf(this.hours.intValue() % 10).toString() + ":" + Integer.valueOf(this.minutes.intValue() / 10).toString() + Integer.valueOf(this.minutes.intValue() % 10).toString() + ":" + Integer.valueOf(this.seconds.intValue() / 10).toString() + Integer.valueOf(this.seconds.intValue() % 10).toString();
    }

    public void Increment_Time() {
        Integer numValueOf = Integer.valueOf(this.seconds.intValue() + 1);
        this.seconds = numValueOf;
        if (numValueOf.intValue() == 60) {
            this.seconds = 0;
            Integer numValueOf2 = Integer.valueOf(this.minutes.intValue() + 1);
            this.minutes = numValueOf2;
            if (numValueOf2.intValue() == 60) {
                this.minutes = 0;
                this.hours = Integer.valueOf(this.hours.intValue() + 1);
            }
        }
    }

    public Integer getHours() {
        return this.hours;
    }

    public String getLogout_url() {
        return this.logout_url;
    }

    public Integer getMinutes() {
        return this.minutes;
    }

    public String getRemainig_time_url() {
        return this.remainig_time_url;
    }

    public String getRemaining_time() {
        return this.remaining_time;
    }

    public Integer getSeconds() {
        return this.seconds;
    }

    public void setRemaining_time(String str) {
        String[] strArrSplit = str.split(":");
        this.hours = Integer.valueOf(strArrSplit[0]);
        this.minutes = Integer.valueOf(strArrSplit[1]);
        this.seconds = Integer.valueOf(strArrSplit[2]);
        this.remaining_time = str;
    }
}
