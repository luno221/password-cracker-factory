import java.net.HttpURLConnection;
import java.net.URL;

public class OnlineAuthenticator implements Target {

    private String login;

    public OnlineAuthenticator(String login) {
        this.login = login;
    }

    @Override
    public boolean authenticate(String password) {
        try {
            String urlStr = "http://localhost/login.php?login=" + login + "&password=" + password;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
