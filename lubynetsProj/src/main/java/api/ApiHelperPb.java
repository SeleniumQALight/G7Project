package api;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ApiHelperPb {
    private Response apiResponse;
    private String apiExchangeRateSell;

    public void sendGetRequestForCurrencyExchangeRates() {
        apiResponse = RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
        apiResponse.then().statusCode(200);
    }

    public void extractExchangeRateForCurrency(String currency) {
        String jsonResponse = apiResponse.getBody().asString();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            for (JsonNode currencyNode : jsonNode) {
                String currencyCode = currencyNode.get("ccy").asText();

                if (currencyCode.equalsIgnoreCase(currency)) {
                    String saleValue = currencyNode.get("sale").asText();

                    try {
                        double parsedRate = Double.parseDouble(saleValue);
                        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
                        DecimalFormat decimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);

                        apiExchangeRateSell = decimalFormat.format(parsedRate);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getApiExchangeRateSell() {
        return apiExchangeRateSell;



    }

    public String rememberExchangeRateForCurrency(String currency, String transaction) {
        String rate = apiResponse.jsonPath().getString("find { it.ccy == '" + currency + "' }." + transaction);
        if (rate != null && !rate.isEmpty()) {
            double parsedRate = Double.parseDouble(rate);
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
            DecimalFormat decimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);
            return decimalFormat.format(parsedRate);
        } else {
            return null;
        }
    }
}


