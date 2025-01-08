package tests;

import org.junit.jupiter.api.Test;
import utils.Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResponseTimeTest extends BaseTest{

    @Test
    public void testResponseTime() {
        try {
            long responseTime = getResponseTime(Config.BASE_URL);
            assertTrue(responseTime < 3000, "Response time is too high!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSlowNetworkResponseTime() {
        try {
            long responseTime = getResponseTime(Config.BASE_URL);
            responseTime += 1000; // Simulate 1-second delay due to slow network connection
            assertTrue(responseTime < 3000, "Response time is too high!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getResponseTime(String urlString) throws IOException {
        long startTime = System.currentTimeMillis();

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
