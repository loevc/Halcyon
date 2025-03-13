package org.loevc.Halcyon.factory.client;

import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;
import org.loevc.Halcyon.handler.ProtocolHandler;

public interface NetworkClient extends ProtocolHandler {

    ConnectivityResult execRequest(UrlConnectivityDTO urlConnectivityDTO, String protocol, String visitMethod);
}
