package org.loevc.Halcyon.factory.client;

import lombok.extern.slf4j.Slf4j;
import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientFactory {
    public NetworkClient getInstance(String clientType) {
        switch (clientType){
            case "apache-http":
                return new ApacheHttpClient();
            case "http-url-connection":
                return new HttpUrlConnectionClient();
            default:
                return new NetworkClient() {
                    @Override
                    public ConnectivityResult handle() {
                        return null;
                    }

                    @Override
                    public ConnectivityResult execRequest(UrlConnectivityDTO urlConnectivityDTO, String protocol, String visitMethod) {
                        log.warn("no client to select client_type:{}", clientType);
                        return null;
                    }
                };
        }

    }
}
