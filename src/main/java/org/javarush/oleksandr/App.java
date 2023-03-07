package org.javarush.oleksandr;


import okhttp3.OkHttpClient;
import org.javarush.oleksandr.model.CryptoCurrencyEnum;
import org.javarush.oleksandr.services.CryptoCurrencyService;
import org.javarush.oleksandr.model.CryptoCurrency;

import java.io.IOException;

public class App
{
    public static void main(String[] args) throws IOException {
        CryptoCurrencyService cryptoService = new CryptoCurrencyService(new OkHttpClient());
        CryptoCurrencyEnum crypto = CryptoCurrencyEnum.BTC;

        CryptoCurrency btc = cryptoService.getCurrencyPrice(crypto.getCurrencyName(), crypto.getPair());
        System.out.println("Price of " + btc.getCurrencyName() + " is " + btc.getPrice() + " " + btc.getPair());
    }

}
