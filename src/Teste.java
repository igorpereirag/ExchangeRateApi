import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Teste {
    public static void main(String[] args) {
        String apiResponse = "{\n" +
                "    \"result\": \"success\",\n" +
                "    \"documentation\": \"https://www.exchangerate-api.com/docs\",\n" +
                "    \"terms_of_use\": \"https://www.exchangerate-api.com/terms\",\n" +
                "    \"time_last_update_unix\": 1585267200,\n" +
                "    \"time_last_update_utc\": \"Fri, 27 Mar 2020 00:00:00 +0000\",\n" +
                "    \"time_next_update_unix\": 1585353700,\n" +
                "    \"time_next_update_utc\": \"Sat, 28 Mar 2020 00:00:00 +0000\",\n" +
                "    \"base_code\": \"USD\",\n" +
                "    \"conversion_rates\": {\n" +
                "        \"USD\": 1,\n" +
                "        \"AUD\": 1.4817,\n" +
                "        \"BGN\": 1.7741,\n" +
                "        \"CAD\": 1.3168,\n" +
                "        \"CHF\": 0.9774,\n" +
                "        \"CNY\": 6.9454,\n" +
                "        \"EGP\": 15.7361,\n" +
                "        \"EUR\": 0.9013,\n" +
                "        \"GBP\": 0.7679,\n" +
                "        \"BRL\": 5.27\n" +
                "    }\n" +
                "}";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        ConversionRateRecord response = gson.fromJson(apiResponse, ConversionRateRecord.class);

        String currencyCode = "BRL"; 
        double rate = response.conversion_rates().getOrDefault(currencyCode, 0.0);
        double amountInBRL = 1000.0; 
        double convertedAmount = amountInBRL / rate; 

        System.out.printf("%.2f BRL é equivalente a %.2f %s\n", amountInBRL, convertedAmount, currencyCode);
    }
}
