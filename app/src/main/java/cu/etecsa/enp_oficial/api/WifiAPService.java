package cu.etecsa.enp_oficial.api;

import cu.etecsa.enp_oficial.model.ServicePostAp;
import cu.etecsa.enp_oficial.model.ServicePostUserClient;
import e.b;
import e.q.a;
import e.q.l;

/**
 * Retrofit interface for api-enp/checkmac/, api-enp/userfakeap/, and api-enp/useretecsaap/.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.api.WifiAPService
 */
public interface WifiAPService {
    @l("api-enp/checkmac/")
    b<ServicePostAp> sendToVerify(@a ServicePostAp servicePostAp);

    @l("api-enp/userfakeap/")
    b<Void> sendaccount(@a ServicePostUserClient servicePostUserClient);

    @l("api-enp/useretecsaap/")
    b<Void> sendaccountetecsa(@a ServicePostUserClient servicePostUserClient);
}
