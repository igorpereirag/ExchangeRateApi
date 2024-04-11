import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CurrencyConverter {

    private final HttpClient client;
    private final Gson gson;

    public CurrencyConverter() {
        this.client = HttpClient.newHttpClient();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void convertCurrency(int choice, String apiKey) {
        String responseBody = connectApi(apiKey);
        if (responseBody == null) {
            System.out.println("Falha ao conectar à API de taxa de câmbio.");
            return;
        }

        ConversionRateRecord response = responseToObject(responseBody);
        ConvertTo convert = new ConvertTo();

        switch (choice) {
            case 1:
                convert.convertUSDtoARS(response);
                break;
            case 2:
                convert.convertARStoUSD(response);
                break;
            case 3:
                convert.convertUSDtoBRL(response);
                break;
            case 4:
                convert.convertBRLtoUSD(response);
                break;
            case 5:
                convert.convertUSDtoCOP(response);
                break;
            case 6:
                convert.convertCOPtoUSD(response);
                break;
            case 7:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção não implementada.");
        }
    }

    private String connectApi(String apiKey) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> apiResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            return apiResponse.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ConversionRateRecord responseToObject(String response) {
        return gson.fromJson(response, ConversionRateRecord.class);
    }
}
