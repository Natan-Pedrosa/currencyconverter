package com.currencyconverter.CurrencyConverter.util;


import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeRate {

    private final static String URL_WEB = "https://api.currencylayer.com/list\n" +
            "    ? access_key = xfOFJFEOebPGaWJSKLL04WYYBvSh31HS";
    private static HttpURLConnection request;
    public static Map<String, Double> exchangeRateFromCurrency(String currency) throws IOException {
        connection("latest/" +currency);

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        Map<String, Double> map = new Gson().fromJson(jsonobj.get("conversion_rates").toString(), Map.class);


         return map;
    }

    public static double exchangeRateFromCurrencyToAnother(String currencyActual, String currencyConverted) throws IOException{

        connection("pair/" +currencyActual +"/" + currencyConverted);

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        double conversionRate = jsonobj.get("conversion_rate").getAsDouble();
        return conversionRate;
    }

    private static void connection(String path)throws IOException{
        URL url = new URL(URL_WEB + path);
        request = (HttpURLConnection) url.openConnection();
        request.connect();
    }
}
