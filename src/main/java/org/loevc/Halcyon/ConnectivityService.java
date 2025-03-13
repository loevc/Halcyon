package org.loevc.Halcyon;

import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface ConnectivityService {

    boolean checkConnectivity(String url);

    ConnectivityResult checkConnectivity(UrlConnectivityDTO urlConnectivityDTO,
                                         String protocol, String visitMethod, String clientType);

}
