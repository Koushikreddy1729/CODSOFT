import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class LiveCurrencyExchange {

    // Personal API key from exchangerate-api.com
    private static final String KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Base currency (e.g. USD, INR): ");
        String fromCurrency = input.next().trim().toUpperCase();

        System.out.print("Target currency (e.g. EUR, JPY): ");
        String toCurrency = input.next().trim().toUpperCase();

        System.out.print("Amount to convert: ");
        double amount = input.nextDouble();

        try {
            double exchangeRate = fetchRate(fromCurrency, toCurrency);
            if (exchangeRate > 0) {
                double result = Math.round(amount * exchangeRate * 100.0) / 100.0;
                System.out.println("Converted: " + result + " " + toCurrency);
            } else {
                System.out.println("Unable to get exchange rate for given currencies.");
            }
        } catch (Exception e) {
            System.out.println("Conversion failed: " + e.getMessage());
        }

        input.close();
    }

    private static double fetchRate(String from, String to) throws Exception {
        String endpoint = BASE_URL + KEY + "/latest/" + from;
        URL link = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonResponse.append(line);
            }
            JSONObject data = new JSONObject(jsonResponse.toString());
            if ("success".equalsIgnoreCase(data.getString("result"))) {
                return data.getJSONObject("conversion_rates").getDouble(to);
            }
        }
        return -1;
    }
}
