package org.javarush.oleksandr.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.javarush.oleksandr.model.CryptoCurrency;

import java.io.IOException;
import java.math.BigDecimal;
public class CryptoCurrencyService {

    private final OkHttpClient httpClient;

    public CryptoCurrencyService(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CryptoCurrency getCurrencyPrice(String currencyName, String pair) throws IOException {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol=" + currencyName + pair;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String responseBody = response.body().string();

            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

            BigDecimal price = jsonObject.get("price").getAsBigDecimal();

            return new CryptoCurrency(currencyName, pair, price);
        }
    }
}