package cu.etecsa.enp_oficial.model;

import cu.etecsa.enp_oficial.R;

/**
 * Autocomplete suggestion entry holding username prefix and Nauta domain.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.f.b
 */
public class DomainSuggestionItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2302b;

    public DomainSuggestionItem(String str, String str2) {
        this.f2301a = str;
        this.f2302b = str2;
    }

    public String a() {
        return this.f2302b;
    }

    public String b() {
        return this.f2301a;
    }
}
