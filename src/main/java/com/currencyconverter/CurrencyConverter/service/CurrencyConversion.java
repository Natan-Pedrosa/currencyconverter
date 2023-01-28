package com.currencyconverter.CurrencyConverter.service;


import com.currencyconverter.CurrencyConverter.model.Currency;
import com.currencyconverter.CurrencyConverter.util.ValueCurrentConverter;
import com.currencyconverter.CurrencyConverter.util.CurrencyCombinationValid;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;


public class CurrencyConversion {

    private final static String url_api = "https://economia.awesomeapi.com.br/last/"; // USD-BRL De dollar para Real

    public static Currency conversionCurrencyActualToAnother(JsonNode currency)  {

        Currency objCurrency = new Currency( currency.get("from").asText(), currency.get("to").asText());

        objCurrency.setValue(getCorrectValueCurrent(objCurrency.getFrom(), objCurrency.getTo()));
        objCurrency.setValueFrom(currency.get("valueFrom").asDouble());
        objCurrency.setValueTo(objCurrency.getValue(), objCurrency.getValueFrom());

        return objCurrency;
    }
    private static double getCorrectValueCurrent(String from, String to){
        double valueCurrent = 0.00;

        switch (CurrencyCombinationValid.hasCombination(from, to)){
            case ValueCurrentConverter.PADRAO: valueCurrent = getValueCurrent(from, to);
                break;
            case ValueCurrentConverter.INVERSO: valueCurrent = 1 / getValueCurrent(to, from);
                break;
            case ValueCurrentConverter.USD: double valueFrom = getValueCurrent("USD", from);
                double valueTo = getValueCurrent("USD", to);
                valueCurrent = valueTo / valueFrom;
        }

        Logger logger = LoggerFactory.getLogger(CurrencyConversion.class);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        // necessário porque ao usar format() estava retornando valor com ',' ao invés de '.'
        String value = decimalFormat.format(valueCurrent);
        value = value.replace(',', '.');

        valueCurrent = Double.parseDouble(value);

        return valueCurrent;
    }
    
    // Verifica se a combinação das moedas para conversão é valido devido a limitações de conversão da api
    private static double getValueCurrent(String from, String to){
        String parameter = from + "-" +to;
        try {
            URL url = new URL(url_api + parameter);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.toString());

                double valueCurrent = jsonNode.get( from + to).get("high").asDouble();

                return valueCurrent;

            } else{
                // se entrar a
                System.out.println("erro 404");
                return 0.0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0.0;
    }


}
