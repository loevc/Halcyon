package org.loevc.Halcyon;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.loevc.Halcyon.data.dto.UrlConnectivityDTO;
import org.loevc.Halcyon.data.entity.ConnectivityResult;
import org.loevc.Halcyon.factory.client.ClientFactory;
import org.loevc.Halcyon.factory.client.NetworkClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Service
@AllArgsConstructor
public class ConnectivityServiceImpl implements ConnectivityService {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    private static final int CONNECT_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;


    private final ClientFactory clientFactory;

    @Override
    public boolean checkConnectivity(String url) {
        return checkUrl(url);
    }

    @Override
    public ConnectivityResult checkConnectivity(UrlConnectivityDTO urlConnectivityDTO, String protocol, String visitMethod, String clientType) {
        NetworkClient networkClient = clientFactory.getInstance(clientType);
        return networkClient.execRequest(urlConnectivityDTO, protocol, visitMethod);
    }



    private boolean checkUrl(String url) {
        log.info("to visit url :{}", url);
        HttpURLConnection connection = null;
        try {
            URL targetUrl = new URL(url);
            connection = (HttpURLConnection) targetUrl.openConnection();
//            connection.setRequestMethod("HEAD");
//            connection.setRequestProperty("User-Agent", USER_AGENT);
//            connection.setConnectTimeout(CONNECT_TIMEOUT);
//            connection.setReadTimeout(READ_TIMEOUT);

            int responseCode = connection.getResponseCode();
            return (responseCode >= 200 && responseCode < 400);
        } catch (IOException e) {
            log.error("connect failed ", e);
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
