import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ApiMonedas {

    // Metodo para obtener la tasa de conversion de la API
    public double obtenerTasaDeConversion(String monedaBase, String monedaObjetivo) {
        String url = "https://v6.exchangerate-api.com/v6/9316770db56dcd4bc18d97c7/latest/" + monedaBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Parseo el JSON para obtener la tasa de conversión usando Gson
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            return jsonObject.getAsJsonObject("conversion_rates").get(monedaObjetivo).getAsDouble();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener la tasa de conversión", e);
        }
    }
}
