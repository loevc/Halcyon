package org.loevc.Halcyon.factory.client;


import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;

public class HttpUrlConnectionClient implements NetworkClient {
    @Override
    public ConnectivityResult execRequest(UrlConnectivityDTO urlConnectivityDTO, String protocol, String visitMethod) {
        return null;
    }

    @Override
    public ConnectivityResult handle() {
        return null;
    }
}
