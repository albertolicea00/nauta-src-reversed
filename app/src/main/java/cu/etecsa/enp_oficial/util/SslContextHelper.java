package cu.etecsa.enp_oficial.util;

import android.content.Context;
import cu.etecsa.enp_oficial.R;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/**
 * Loads pinned X.509 certificate R.raw.server into a TLS SSLContext.
 *
 * @obfuscated_class cu.etecsa.enp_oficial.g.a
 */
public class SslContextHelper {
    public static SSLContext a(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(context.getResources().openRawResource(R.raw.server));
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", certificateGenerateCertificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sSLContext;
    }
}
