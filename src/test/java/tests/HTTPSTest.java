package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HTTPSTest extends BaseTest {
    public boolean checkHsts(String url) {
        try {
            URL website = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) website.openConnection();
            connection.setRequestMethod("GET");

            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();

            for (Map.Entry<String, java.util.List<String>> header : headers.entrySet()) {
                if ("Strict-Transport-Security".equalsIgnoreCase(header.getKey())) {
                    return true;
                }
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Test
    public void enforceHTTPSTest() {
        Assertions.assertTrue(checkHsts("https://www.imdb.com/"), "HSTS could not be detected!");
    }

//    @Test
//    public void enforceHTTPSUrlTest() throws InterruptedException {
//        driver.get("http://www.imdb.com/");
//        Thread.sleep(3000);
//        Assertions.assertEquals("https://www.imdb.com/", driver.getCurrentUrl(), "Not redirected to HTTPS!");
//    }
}