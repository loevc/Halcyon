package org.loevc.Halcyon.factory.client;


import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;

public class ApacheHttpClient implements NetworkClient {

    public ApacheHttpClient() {
        // TODO impl the apache http client
    }

    @Override
    public ConnectivityResult execRequest(UrlConnectivityDTO urlConnectivityDTO, String protocol, String visitMethod) {

        return null;
    }

    @Override
    public ConnectivityResult handle() {
        return null;
    }
}
