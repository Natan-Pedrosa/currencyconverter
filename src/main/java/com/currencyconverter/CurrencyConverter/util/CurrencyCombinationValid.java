package com.currencyconverter.CurrencyConverter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class CurrencyCombinationValid {
    private static String jsonValidCombinationCurrency = "{\n" +
            "  \"USD-BRL\": \"Dólar Americano/Real Brasileiro\",\n" +
            "  \"USD-BRLT\": \"Dólar Americano/Real Brasileiro Turismo\",\n" +
            "  \"CAD-BRL\": \"Dólar Canadense/Real Brasileiro\",\n" +
            "  \"EUR-BRL\": \"Euro/Real Brasileiro\",\n" +
            "  \"GBP-BRL\": \"Libra Esterlina/Real Brasileiro\",\n" +
            "  \"ARS-BRL\": \"Peso Argentino/Real Brasileiro\",\n" +
            "  \"BTC-BRL\": \"Bitcoin/Real Brasileiro\",\n" +
            "  \"LTC-BRL\": \"Litecoin/Real Brasileiro\",\n" +
            "  \"JPY-BRL\": \"Iene Japonês/Real Brasileiro\",\n" +
            "  \"CHF-BRL\": \"Franco Suíço/Real Brasileiro\",\n" +
            "  \"AUD-BRL\": \"Dólar Australiano/Real Brasileiro\",\n" +
            "  \"CNY-BRL\": \"Yuan Chinês/Real Brasileiro\",\n" +
            "  \"ILS-BRL\": \"Novo Shekel Israelense/Real Brasileiro\",\n" +
            "  \"ETH-BRL\": \"Ethereum/Real Brasileiro\",\n" +
            "  \"XRP-BRL\": \"XRP/Real Brasileiro\",\n" +
            "  \"EUR-USD\": \"Euro/Dólar Americano\",\n" +
            "  \"CAD-USD\": \"Dólar Canadense/Dólar Americano\",\n" +
            "  \"GBP-USD\": \"Libra Esterlina/Dólar Americano\",\n" +
            "  \"ARS-USD\": \"Peso Argentino/Dólar Americano\",\n" +
            "  \"JPY-USD\": \"Iene Japonês/Dólar Americano\",\n" +
            "  \"CHF-USD\": \"Franco Suíço/Dólar Americano\",\n" +
            "  \"AUD-USD\": \"Dólar Australiano/Dólar Americano\",\n" +
            "  \"CNY-USD\": \"Yuan Chinês/Dólar Americano\",\n" +
            "  \"ILS-USD\": \"Novo Shekel Israelense/Dólar Americano\",\n" +
            "  \"BTC-USD\": \"Bitcoin/Dólar Americano\",\n" +
            "  \"LTC-USD\": \"Litecoin/Dólar Americano\",\n" +
            "  \"ETH-USD\": \"Ethereum/Dólar Americano\",\n" +
            "  \"XRP-USD\": \"XRP/Dólar Americano\",\n" +
            "  \"BRL-USD\": \"Real Brasileiro/Dólar Americano\",\n" +
            "  \"BRL-EUR\": \"Real Brasileiro/Euro\",\n" +
            "  \"USD-EUR\": \"Dólar Americano/Euro\",\n" +
            "  \"CAD-EUR\": \"Dólar Canadense/Euro\",\n" +
            "  \"GBP-EUR\": \"Libra Esterlina/Euro\",\n" +
            "  \"ARS-EUR\": \"Peso Argentino/Euro\",\n" +
            "  \"JPY-EUR\": \"Iene Japonês/Euro\",\n" +
            "  \"CHF-EUR\": \"Franco Suíço/Euro\",\n" +
            "  \"AUD-EUR\": \"Dólar Australiano/Euro\",\n" +
            "  \"CNY-EUR\": \"Yuan Chinês/Euro\",\n" +
            "  \"ILS-EUR\": \"Novo Shekel Israelense/Euro\",\n" +
            "  \"BTC-EUR\": \"Bitcoin/Euro\",\n" +
            "  \"LTC-EUR\": \"Litecoin/Euro\",\n" +
            "  \"ETH-EUR\": \"Ethereum/Euro\",\n" +
            "  \"XRP-EUR\": \"XRP/Euro\",\n" +
            "  \"DOGE-BRL\": \"Dogecoin/Real Brasileiro\",\n" +
            "  \"DOGE-EUR\": \"Dogecoin/Euro\",\n" +
            "  \"DOGE-USD\": \"Dogecoin/Dólar Americano\",\n" +
            "  \"USD-JPY\": \"Dólar Americano/Iene Japonês\",\n" +
            "  \"USD-CHF\": \"Dólar Americano/Franco Suíço\",\n" +
            "  \"USD-CAD\": \"Dólar Americano/Dólar Canadense\",\n" +
            "  \"NZD-USD\": \"Dólar Neozelandês/Dólar Americano\",\n" +
            "  \"USD-ZAR\": \"Dólar Americano/Rand Sul-Africano\",\n" +
            "  \"USD-TRY\": \"Dólar Americano/Nova Lira Turca\",\n" +
            "  \"USD-MXN\": \"Dólar Americano/Peso Mexicano\",\n" +
            "  \"USD-PLN\": \"Dólar Americano/Zlóti Polonês\",\n" +
            "  \"USD-SEK\": \"Dólar Americano/Coroa Sueca\",\n" +
            "  \"USD-SGD\": \"Dólar Americano/Dólar de Cingapura\",\n" +
            "  \"USD-DKK\": \"Dólar Americano/Coroa Dinamarquesa\",\n" +
            "  \"USD-NOK\": \"Dólar Americano/Coroa Norueguesa\",\n" +
            "  \"USD-ILS\": \"Dólar Americano/Novo Shekel Israelense\",\n" +
            "  \"USD-HUF\": \"Dólar Americano/Florim Húngaro\",\n" +
            "  \"USD-CZK\": \"Dólar Americano/Coroa Checa\",\n" +
            "  \"USD-THB\": \"Dólar Americano/Baht Tailandês\",\n" +
            "  \"USD-AED\": \"Dólar Americano/Dirham dos Emirados\",\n" +
            "  \"USD-JOD\": \"Dólar Americano/Dinar Jordaniano\",\n" +
            "  \"USD-KWD\": \"Dólar Americano/Dinar Kuwaitiano\",\n" +
            "  \"USD-HKD\": \"Dólar Americano/Dólar de Hong Kong\",\n" +
            "  \"USD-SAR\": \"Dólar Americano/Riyal Saudita\",\n" +
            "  \"USD-INR\": \"Dólar Americano/Rúpia Indiana\",\n" +
            "  \"USD-KRW\": \"Dólar Americano/Won Sul-Coreano\",\n" +
            "  \"FJD-USD\": \"Dólar de Fiji/Dólar Americano\",\n" +
            "  \"GHS-USD\": \"Cedi Ganês/Dólar Americano\",\n" +
            "  \"KYD-USD\": \"Dólar das Ilhas Cayman/Dólar Americano\",\n" +
            "  \"SGD-USD\": \"Dólar de Cingapura/Dólar Americano\",\n" +
            "  \"USD-ALL\": \"Dólar Americano/Lek Albanês\",\n" +
            "  \"USD-AMD\": \"Dólar Americano/Dram Armênio\",\n" +
            "  \"USD-ANG\": \"Dólar Americano/Guilder das Antilhas\",\n" +
            "  \"USD-ARS\": \"Dólar Americano/Peso Argentino\",\n" +
            "  \"USD-AUD\": \"Dólar Americano/Dólar Australiano\",\n" +
            "  \"USD-BBD\": \"Dólar Americano/Dólar de Barbados\",\n" +
            "  \"USD-BDT\": \"Dólar Americano/Taka de Bangladesh\",\n" +
            "  \"USD-BGN\": \"Dólar Americano/Lev Búlgaro\",\n" +
            "  \"USD-BHD\": \"Dólar Americano/Dinar do Bahrein\",\n" +
            "  \"USD-BIF\": \"Dólar Americano/Franco Burundinense\",\n" +
            "  \"USD-BND\": \"Dólar Americano/Dólar de Brunei\",\n" +
            "  \"USD-BOB\": \"Dólar Americano/Boliviano\",\n" +
            "  \"USD-BSD\": \"Dólar Americano/Dólar das Bahamas\",\n" +
            "  \"USD-BWP\": \"Dólar Americano/Pula de Botswana\",\n" +
            "  \"USD-BZD\": \"Dólar Americano/Dólar de Belize\",\n" +
            "  \"USD-CLP\": \"Dólar Americano/Peso Chileno\",\n" +
            "  \"USD-CNY\": \"Dólar Americano/Yuan Chinês\",\n" +
            "  \"USD-COP\": \"Dólar Americano/Peso Colombiano\",\n" +
            "  \"USD-CRC\": \"Dólar Americano/Colón Costarriquenho\",\n" +
            "  \"USD-CUP\": \"Dólar Americano/Peso Cubano\",\n" +
            "  \"USD-DJF\": \"Dólar Americano/Franco do Djubouti\",\n" +
            "  \"USD-DOP\": \"Dólar Americano/Peso Dominicano\",\n" +
            "  \"USD-DZD\": \"Dólar Americano/Dinar Argelino\",\n" +
            "  \"USD-EGP\": \"Dólar Americano/Libra Egípcia\",\n" +
            "  \"USD-ETB\": \"Dólar Americano/Birr Etíope\",\n" +
            "  \"USD-FJD\": \"Dólar Americano/Dólar de Fiji\",\n" +
            "  \"USD-GBP\": \"Dólar Americano/Libra Esterlina\",\n" +
            "  \"USD-GEL\": \"Dólar Americano/Lari Georgiano\",\n" +
            "  \"USD-GHS\": \"Dólar Americano/Cedi Ganês\",\n" +
            "  \"USD-GMD\": \"Dólar Americano/Dalasi da Gâmbia\",\n" +
            "  \"USD-GNF\": \"Dólar Americano/Franco de Guiné\",\n" +
            "  \"USD-GTQ\": \"Dólar Americano/Quetzal Guatemalteco\",\n" +
            "  \"USD-HNL\": \"Dólar Americano/Lempira Hondurenha\",\n" +
            "  \"USD-HRK\": \"Dólar Americano/Kuna Croata\",\n" +
            "  \"USD-HTG\": \"Dólar Americano/Gourde Haitiano\",\n" +
            "  \"USD-IDR\": \"Dólar Americano/Rupia Indonésia\",\n" +
            "  \"USD-IQD\": \"Dólar Americano/Dinar Iraquiano\",\n" +
            "  \"USD-IRR\": \"Dólar Americano/Rial Iraniano\",\n" +
            "  \"USD-ISK\": \"Dólar Americano/Coroa Islandesa\",\n" +
            "  \"USD-JMD\": \"Dólar Americano/Dólar Jamaicano\",\n" +
            "  \"USD-KES\": \"Dólar Americano/Shilling Queniano\",\n" +
            "  \"USD-KHR\": \"Dólar Americano/Riel Cambojano\",\n" +
            "  \"USD-KMF\": \"Dólar Americano/Franco Comorense\",\n" +
            "  \"USD-KZT\": \"Dólar Americano/Tengue Cazaquistanês\",\n" +
            "  \"USD-LAK\": \"Dólar Americano/Kip Laosiano\",\n" +
            "  \"USD-LBP\": \"Dólar Americano/Libra Libanesa\",\n" +
            "  \"USD-LKR\": \"Dólar Americano/Rúpia de Sri Lanka\",\n" +
            "  \"USD-LSL\": \"Dólar Americano/Loti do Lesoto\",\n" +
            "  \"USD-LYD\": \"Dólar Americano/Dinar Líbio\",\n" +
            "  \"USD-MAD\": \"Dólar Americano/Dirham Marroquino\",\n" +
            "  \"USD-MDL\": \"Dólar Americano/Leu Moldavo\",\n" +
            "  \"USD-MGA\": \"Dólar Americano/Ariary Madagascarense\",\n" +
            "  \"USD-MKD\": \"Dólar Americano/Denar Macedônio\",\n" +
            "  \"USD-MMK\": \"Dólar Americano/Kyat de Mianmar\",\n" +
            "  \"USD-MOP\": \"Dólar Americano/Pataca de Macau\",\n" +
            "  \"USD-MRO\": \"Dólar Americano/Ouguiya Mauritana\",\n" +
            "  \"USD-MUR\": \"Dólar Americano/Rúpia Mauriciana\",\n" +
            "  \"USD-MVR\": \"Dólar Americano/Rufiyaa Maldiva\",\n" +
            "  \"USD-MWK\": \"Dólar Americano/Kwacha Malauiana\",\n" +
            "  \"USD-MYR\": \"Dólar Americano/Ringgit Malaio\",\n" +
            "  \"USD-NAD\": \"Dólar Americano/Dólar Namíbio\",\n" +
            "  \"USD-NGN\": \"Dólar Americano/Naira Nigeriana\",\n" +
            "  \"USD-NIO\": \"Dólar Americano/Córdoba Nicaraguense\",\n" +
            "  \"USD-NPR\": \"Dólar Americano/Rúpia Nepalesa\",\n" +
            "  \"USD-NZD\": \"Dólar Americano/Dólar Neozelandês\",\n" +
            "  \"USD-OMR\": \"Dólar Americano/Rial Omanense\",\n" +
            "  \"USD-PAB\": \"Dólar Americano/Balboa Panamenho\",\n" +
            "  \"USD-PEN\": \"Dólar Americano/Sol do Peru\",\n" +
            "  \"USD-PGK\": \"Dólar Americano/Kina Papua-Nova Guiné\",\n" +
            "  \"USD-PHP\": \"Dólar Americano/Peso Filipino\",\n" +
            "  \"USD-PKR\": \"Dólar Americano/Rúpia Paquistanesa\",\n" +
            "  \"USD-PYG\": \"Dólar Americano/Guarani Paraguaio\",\n" +
            "  \"USD-QAR\": \"Dólar Americano/Rial Catarense\",\n" +
            "  \"USD-RON\": \"Dólar Americano/Leu Romeno\",\n" +
            "  \"USD-RSD\": \"Dólar Americano/Dinar Sérvio\",\n" +
            "  \"USD-RWF\": \"Dólar Americano/Franco Ruandês\",\n" +
            "  \"USD-SCR\": \"Dólar Americano/Rúpias de Seicheles\",\n" +
            "  \"USD-SDG\": \"Dólar Americano/Libra Sudanesa\",\n" +
            "  \"USD-SOS\": \"Dólar Americano/Shilling Somaliano\",\n" +
            "  \"USD-STD\": \"Dólar Americano/Dobra São Tomé/Príncipe\",\n" +
            "  \"USD-SVC\": \"Dólar Americano/Colon de El Salvador\",\n" +
            "  \"USD-SYP\": \"Dólar Americano/Libra Síria\",\n" +
            "  \"USD-SZL\": \"Dólar Americano/Lilangeni Suazilandês\",\n" +
            "  \"USD-TND\": \"Dólar Americano/Dinar Tunisiano\",\n" +
            "  \"USD-TTD\": \"Dólar Americano/Dólar de Trinidad\",\n" +
            "  \"USD-TWD\": \"Dólar Americano/Dólar Taiuanês\",\n" +
            "  \"USD-TZS\": \"Dólar Americano/Shilling Tanzaniano\",\n" +
            "  \"USD-UAH\": \"Dólar Americano/Hryvinia Ucraniana\",\n" +
            "  \"USD-UGX\": \"Dólar Americano/Shilling Ugandês\",\n" +
            "  \"USD-UYU\": \"Dólar Americano/Peso Uruguaio\",\n" +
            "  \"USD-UZS\": \"Dólar Americano/Som Uzbequistanês\",\n" +
            "  \"USD-VEF\": \"Dólar Americano/Bolívar Venezuelano\",\n" +
            "  \"USD-VND\": \"Dólar Americano/Dong Vietnamita\",\n" +
            "  \"USD-VUV\": \"Dólar Americano/Vatu de Vanuatu\",\n" +
            "  \"USD-XAF\": \"Dólar Americano/Franco CFA Central\",\n" +
            "  \"USD-XCD\": \"Dólar Americano/Dólar do Caribe Oriental\",\n" +
            "  \"USD-XOF\": \"Dólar Americano/Franco CFA Ocidental\",\n" +
            "  \"USD-XPF\": \"Dólar Americano/Franco CFP\",\n" +
            "  \"USD-YER\": \"Dólar Americano/Riyal Iemenita\",\n" +
            "  \"USD-ZMK\": \"Dólar Americano/Kwacha Zambiana\",\n" +
            "  \"AED-USD\": \"Dirham dos Emirados/Dólar Americano\",\n" +
            "  \"DKK-USD\": \"Coroa Dinamarquesa/Dólar Americano\",\n" +
            "  \"HKD-USD\": \"Dólar de Hong Kong/Dólar Americano\",\n" +
            "  \"MXN-USD\": \"Peso Mexicano/Dólar Americano\",\n" +
            "  \"NOK-USD\": \"Coroa Norueguesa/Dólar Americano\",\n" +
            "  \"PLN-USD\": \"Zlóti Polonês/Dólar Americano\",\n" +
            "  \"RUB-USD\": \"Rublo Russo/Dólar Americano\",\n" +
            "  \"SAR-USD\": \"Riyal Saudita/Dólar Americano\",\n" +
            "  \"SEK-USD\": \"Coroa Sueca/Dólar Americano\",\n" +
            "  \"TRY-USD\": \"Nova Lira Turca/Dólar Americano\",\n" +
            "  \"TWD-USD\": \"Dólar Taiuanês/Dólar Americano\",\n" +
            "  \"ZAR-USD\": \"Rand Sul-Africano/Dólar Americano\",\n" +
            "  \"UYU-USD\": \"Peso Uruguaio/Dólar Americano\",\n" +
            "  \"PYG-USD\": \"Guarani Paraguaio/Dólar Americano\",\n" +
            "  \"CLP-USD\": \"Peso Chileno/Dólar Americano\",\n" +
            "  \"COP-USD\": \"Peso Colombiano/Dólar Americano\",\n" +
            "  \"PEN-USD\": \"Sol do Peru/Dólar Americano\",\n" +
            "  \"NIO-USD\": \"Córdoba Nicaraguense/Dólar Americano\",\n" +
            "  \"BOB-USD\": \"Boliviano/Dólar Americano\",\n" +
            "  \"KRW-USD\": \"Won Sul-Coreano/Dólar Americano\",\n" +
            "  \"EGP-USD\": \"Libra Egípcia/Dólar Americano\",\n" +
            "  \"USD-BYN\": \"Dólar Americano/Rublo Bielorrusso\",\n" +
            "  \"USD-MZN\": \"Dólar Americano/Metical de Moçambique\",\n" +
            "  \"INR-USD\": \"Rúpia Indiana/Dólar Americano\",\n" +
            "  \"JOD-USD\": \"Dinar Jordaniano/Dólar Americano\",\n" +
            "  \"KWD-USD\": \"Dinar Kuwaitiano/Dólar Americano\",\n" +
            "  \"USD-AZN\": \"Dólar Americano/Manat Azeri\",\n" +
            "  \"USD-CNH\": \"Dólar Americano/Yuan chinês offshore\",\n" +
            "  \"USD-KGS\": \"Dólar Americano/Som Quirguistanês\",\n" +
            "  \"USD-TJS\": \"Dólar Americano/Somoni do Tajiquistão\",\n" +
            "  \"USD-RUB\": \"Dólar Americano/Rublo Russo\",\n" +
            "  \"MYR-USD\": \"Ringgit Malaio/Dólar Americano\",\n" +
            "  \"UAH-USD\": \"Hryvinia Ucraniana/Dólar Americano\",\n" +
            "  \"HUF-USD\": \"Florim Húngaro/Dólar Americano\",\n" +
            "  \"IDR-USD\": \"Rupia Indonésia/Dólar Americano\",\n" +
            "  \"USD-AOA\": \"Dólar Americano/Kwanza Angolano\",\n" +
            "  \"VND-USD\": \"Dong Vietnamita/Dólar Americano\",\n" +
            "  \"BYN-USD\": \"Rublo Bielorrusso/Dólar Americano\",\n" +
            "  \"XBR-USD\": \"Brent Spot/Dólar Americano\",\n" +
            "  \"THB-USD\": \"Baht Tailandês/Dólar Americano\",\n" +
            "  \"PHP-USD\": \"Peso Filipino/Dólar Americano\",\n" +
            "  \"USD-TMT\": \"Dólar Americano/TMT\",\n" +
            "  \"XAGG-USD\": \"XPrata/Dólar Americano\",\n" +
            "  \"USD-MNT\": \"Dólar Americano/Mongolian Tugrik\",\n" +
            "  \"USD-AFN\": \"Dólar Americano/Afghani do Afeganistão\",\n" +
            "  \"AFN-USD\": \"Afghani do Afeganistão/Dólar Americano\",\n" +
            "  \"SYP-USD\": \"Libra Síria/Dólar Americano\",\n" +
            "  \"IRR-USD\": \"Rial Iraniano/Dólar Americano\",\n" +
            "  \"IQD-USD\": \"Dinar Iraquiano/Dólar Americano\",\n" +
            "  \"USD-NGNI\": \"Dólar Americano/Naira Nigeriana\",\n" +
            "  \"USD-ZWL\": \"Dólar Americano/Dólar Zimbabuense\",\n" +
            "  \"BRL-ARS\": \"Real Brasileiro/Peso Argentino\",\n" +
            "  \"BRL-AUD\": \"Real Brasileiro/Dólar Australiano\",\n" +
            "  \"BRL-CAD\": \"Real Brasileiro/Dólar Canadense\",\n" +
            "  \"BRL-CHF\": \"Real Brasileiro/Franco Suíço\",\n" +
            "  \"BRL-CLP\": \"Real Brasileiro/Peso Chileno\",\n" +
            "  \"BRL-DKK\": \"Real Brasileiro/Coroa Dinamarquesa\",\n" +
            "  \"BRL-HKD\": \"Real Brasileiro/Dólar de Hong Kong\",\n" +
            "  \"BRL-JPY\": \"Real Brasileiro/Iene Japonês\",\n" +
            "  \"BRL-MXN\": \"Real Brasileiro/Peso Mexicano\",\n" +
            "  \"BRL-SGD\": \"Real Brasileiro/Dólar de Cingapura\",\n" +
            "  \"SGD-BRL\": \"Dólar de Cingapura/Real Brasileiro\",\n" +
            "  \"AED-BRL\": \"Dirham dos Emirados/Real Brasileiro\",\n" +
            "  \"BRL-AED\": \"Real Brasileiro/Dirham dos Emirados\",\n" +
            "  \"BRL-BBD\": \"Real Brasileiro/Dólar de Barbados\",\n" +
            "  \"BRL-BHD\": \"Real Brasileiro/Dinar do Bahrein\",\n" +
            "  \"BRL-CNY\": \"Real Brasileiro/Yuan Chinês\",\n" +
            "  \"BRL-CZK\": \"Real Brasileiro/Coroa Checa\",\n" +
            "  \"BRL-EGP\": \"Real Brasileiro/Libra Egípcia\",\n" +
            "  \"BRL-GBP\": \"Real Brasileiro/Libra Esterlina\",\n" +
            "  \"BRL-HUF\": \"Real Brasileiro/Florim Húngaro\",\n" +
            "  \"BRL-IDR\": \"Real Brasileiro/Rupia Indonésia\",\n" +
            "  \"BRL-ILS\": \"Real Brasileiro/Novo Shekel Israelense\",\n" +
            "  \"BRL-INR\": \"Real Brasileiro/Rúpia Indiana\",\n" +
            "  \"BRL-ISK\": \"Real Brasileiro/Coroa Islandesa\",\n" +
            "  \"BRL-JMD\": \"Real Brasileiro/Dólar Jamaicano\",\n" +
            "  \"BRL-JOD\": \"Real Brasileiro/Dinar Jordaniano\",\n" +
            "  \"BRL-KES\": \"Real Brasileiro/Shilling Queniano\",\n" +
            "  \"BRL-KRW\": \"Real Brasileiro/Won Sul-Coreano\",\n" +
            "  \"BRL-LBP\": \"Real Brasileiro/Libra Libanesa\",\n" +
            "  \"BRL-LKR\": \"Real Brasileiro/Rúpia de Sri Lanka\",\n" +
            "  \"BRL-MAD\": \"Real Brasileiro/Dirham Marroquino\",\n" +
            "  \"BRL-MYR\": \"Real Brasileiro/Ringgit Malaio\",\n" +
            "  \"BRL-NAD\": \"Real Brasileiro/Dólar Namíbio\",\n" +
            "  \"BRL-NOK\": \"Real Brasileiro/Coroa Norueguesa\",\n" +
            "  \"BRL-NPR\": \"Real Brasileiro/Rúpia Nepalesa\",\n" +
            "  \"BRL-NZD\": \"Real Brasileiro/Dólar Neozelandês\",\n" +
            "  \"BRL-OMR\": \"Real Brasileiro/Rial Omanense\",\n" +
            "  \"BRL-PAB\": \"Real Brasileiro/Balboa Panamenho\",\n" +
            "  \"BRL-PHP\": \"Real Brasileiro/Peso Filipino\",\n" +
            "  \"BRL-PKR\": \"Real Brasileiro/Rúpia Paquistanesa\",\n" +
            "  \"BRL-PLN\": \"Real Brasileiro/Zlóti Polonês\",\n" +
            "  \"BRL-QAR\": \"Real Brasileiro/Rial Catarense\",\n" +
            "  \"BRL-RON\": \"Real Brasileiro/Leu Romeno\",\n" +
            "  \"BRL-RUB\": \"Real Brasileiro/Rublo Russo\",\n" +
            "  \"BRL-SAR\": \"Real Brasileiro/Riyal Saudita\",\n" +
            "  \"BRL-SEK\": \"Real Brasileiro/Coroa Sueca\",\n" +
            "  \"BRL-THB\": \"Real Brasileiro/Baht Tailandês\",\n" +
            "  \"BRL-TRY\": \"Real Brasileiro/Nova Lira Turca\",\n" +
            "  \"BRL-VEF\": \"Real Brasileiro/Bolívar Venezuelano\",\n" +
            "  \"BRL-XAF\": \"Real Brasileiro/Franco CFA Central\",\n" +
            "  \"BRL-XCD\": \"Real Brasileiro/Dólar do Caribe Oriental\",\n" +
            "  \"BRL-XOF\": \"Real Brasileiro/Franco CFA Ocidental\",\n" +
            "  \"BRL-ZAR\": \"Real Brasileiro/Rand Sul-Africano\",\n" +
            "  \"BRL-TWD\": \"Real Brasileiro/Dólar Taiuanês\",\n" +
            "  \"DKK-BRL\": \"Coroa Dinamarquesa/Real Brasileiro\",\n" +
            "  \"HKD-BRL\": \"Dólar de Hong Kong/Real Brasileiro\",\n" +
            "  \"MXN-BRL\": \"Peso Mexicano/Real Brasileiro\",\n" +
            "  \"NOK-BRL\": \"Coroa Norueguesa/Real Brasileiro\",\n" +
            "  \"NZD-BRL\": \"Dólar Neozelandês/Real Brasileiro\",\n" +
            "  \"PLN-BRL\": \"Zlóti Polonês/Real Brasileiro\",\n" +
            "  \"SAR-BRL\": \"Riyal Saudita/Real Brasileiro\",\n" +
            "  \"SEK-BRL\": \"Coroa Sueca/Real Brasileiro\",\n" +
            "  \"THB-BRL\": \"Baht Tailandês/Real Brasileiro\",\n" +
            "  \"TRY-BRL\": \"Nova Lira Turca/Real Brasileiro\",\n" +
            "  \"TWD-BRL\": \"Dólar Taiuanês/Real Brasileiro\",\n" +
            "  \"ZAR-BRL\": \"Rand Sul-Africano/Real Brasileiro\",\n" +
            "  \"BRL-PYG\": \"Real Brasileiro/Guarani Paraguaio\",\n" +
            "  \"BRL-UYU\": \"Real Brasileiro/Peso Uruguaio\",\n" +
            "  \"BRL-COP\": \"Real Brasileiro/Peso Colombiano\",\n" +
            "  \"BRL-PEN\": \"Real Brasileiro/Sol do Peru\",\n" +
            "  \"BRL-BOB\": \"Real Brasileiro/Boliviano\",\n" +
            "  \"CLP-BRL\": \"Peso Chileno/Real Brasileiro\",\n" +
            "  \"PYG-BRL\": \"Guarani Paraguaio/Real Brasileiro\",\n" +
            "  \"UYU-BRL\": \"Peso Uruguaio/Real Brasileiro\",\n" +
            "  \"COP-BRL\": \"Peso Colombiano/Real Brasileiro\",\n" +
            "  \"PEN-BRL\": \"Sol do Peru/Real Brasileiro\",\n" +
            "  \"BOB-BRL\": \"Boliviano/Real Brasileiro\",\n" +
            "  \"RUB-BRL\": \"Rublo Russo/Real Brasileiro\",\n" +
            "  \"INR-BRL\": \"Rúpia Indiana/Real Brasileiro\",\n" +
            "  \"EUR-GBP\": \"Euro/Libra Esterlina\",\n" +
            "  \"EUR-JPY\": \"Euro/Iene Japonês\",\n" +
            "  \"EUR-CHF\": \"Euro/Franco Suíço\",\n" +
            "  \"EUR-AUD\": \"Euro/Dólar Australiano\",\n" +
            "  \"EUR-CAD\": \"Euro/Dólar Canadense\",\n" +
            "  \"EUR-NOK\": \"Euro/Coroa Norueguesa\",\n" +
            "  \"EUR-DKK\": \"Euro/Coroa Dinamarquesa\",\n" +
            "  \"EUR-PLN\": \"Euro/Zlóti Polonês\",\n" +
            "  \"EUR-NZD\": \"Euro/Dólar Neozelandês\",\n" +
            "  \"EUR-SEK\": \"Euro/Coroa Sueca\",\n" +
            "  \"EUR-ILS\": \"Euro/Novo Shekel Israelense\",\n" +
            "  \"EUR-TRY\": \"Euro/Nova Lira Turca\",\n" +
            "  \"EUR-THB\": \"Euro/Baht Tailandês\",\n" +
            "  \"EUR-ZAR\": \"Euro/Rand Sul-Africano\",\n" +
            "  \"EUR-MXN\": \"Euro/Peso Mexicano\",\n" +
            "  \"EUR-SGD\": \"Euro/Dólar de Cingapura\",\n" +
            "  \"EUR-HUF\": \"Euro/Florim Húngaro\",\n" +
            "  \"EUR-HKD\": \"Euro/Dólar de Hong Kong\",\n" +
            "  \"EUR-CZK\": \"Euro/Coroa Checa\",\n" +
            "  \"EUR-KRW\": \"Euro/Won Sul-Coreano\",\n" +
            "  \"BHD-EUR\": \"Dinar do Bahrein/Euro\",\n" +
            "  \"EUR-AED\": \"Euro/Dirham dos Emirados\",\n" +
            "  \"EUR-AFN\": \"Euro/Afghani do Afeganistão\",\n" +
            "  \"EUR-ALL\": \"Euro/Lek Albanês\",\n" +
            "  \"EUR-ANG\": \"Euro/Guilder das Antilhas\",\n" +
            "  \"EUR-ARS\": \"Euro/Peso Argentino\",\n" +
            "  \"EUR-BAM\": \"Euro/Marco Conversível\",\n" +
            "  \"EUR-BBD\": \"Euro/Dólar de Barbados\",\n" +
            "  \"EUR-BDT\": \"Euro/Taka de Bangladesh\",\n" +
            "  \"EUR-BGN\": \"Euro/Lev Búlgaro\",\n" +
            "  \"EUR-BHD\": \"Euro/Dinar do Bahrein\",\n" +
            "  \"EUR-BIF\": \"Euro/Franco Burundinense\",\n" +
            "  \"EUR-BND\": \"Euro/Dólar de Brunei\",\n" +
            "  \"EUR-BOB\": \"Euro/Boliviano\",\n" +
            "  \"EUR-BSD\": \"Euro/Dólar das Bahamas\",\n" +
            "  \"EUR-BWP\": \"Euro/Pula de Botswana\",\n" +
            "  \"EUR-BYN\": \"Euro/Rublo Bielorrusso\",\n" +
            "  \"EUR-BZD\": \"Euro/Dólar de Belize\",\n" +
            "  \"EUR-CLP\": \"Euro/Peso Chileno\",\n" +
            "  \"EUR-CNY\": \"Euro/Yuan Chinês\",\n" +
            "  \"EUR-COP\": \"Euro/Peso Colombiano\",\n" +
            "  \"EUR-CRC\": \"Euro/Colón Costarriquenho\",\n" +
            "  \"EUR-CUP\": \"Euro/Peso Cubano\",\n" +
            "  \"EUR-CVE\": \"Euro/Escudo cabo-verdiano\",\n" +
            "  \"EUR-DJF\": \"Euro/Franco do Djubouti\",\n" +
            "  \"EUR-DOP\": \"Euro/Peso Dominicano\",\n" +
            "  \"EUR-DZD\": \"Euro/Dinar Argelino\",\n" +
            "  \"EUR-EGP\": \"Euro/Libra Egípcia\",\n" +
            "  \"EUR-ETB\": \"Euro/Birr Etíope\",\n" +
            "  \"EUR-FJD\": \"Euro/Dólar de Fiji\",\n" +
            "  \"EUR-GHS\": \"Euro/Cedi Ganês\",\n" +
            "  \"EUR-GMD\": \"Euro/Dalasi da Gâmbia\",\n" +
            "  \"EUR-GNF\": \"Euro/Franco de Guiné\",\n" +
            "  \"EUR-GTQ\": \"Euro/Quetzal Guatemalteco\",\n" +
            "  \"EUR-HNL\": \"Euro/Lempira Hondurenha\",\n" +
            "  \"EUR-HRK\": \"Euro/Kuna Croata\",\n" +
            "  \"EUR-HTG\": \"Euro/Gourde Haitiano\",\n" +
            "  \"EUR-IDR\": \"Euro/Rupia Indonésia\",\n" +
            "  \"EUR-INR\": \"Euro/Rúpia Indiana\",\n" +
            "  \"EUR-IQD\": \"Euro/Dinar Iraquiano\",\n" +
            "  \"EUR-IRR\": \"Euro/Rial Iraniano\",\n" +
            "  \"EUR-ISK\": \"Euro/Coroa Islandesa\",\n" +
            "  \"EUR-JMD\": \"Euro/Dólar Jamaicano\",\n" +
            "  \"EUR-JOD\": \"Euro/Dinar Jordaniano\",\n" +
            "  \"EUR-KES\": \"Euro/Shilling Queniano\",\n" +
            "  \"EUR-KHR\": \"Euro/Riel Cambojano\",\n" +
            "  \"EUR-KWD\": \"Euro/Dinar Kuwaitiano\",\n" +
            "  \"EUR-KYD\": \"Euro/Dólar das Ilhas Cayman\",\n" +
            "  \"EUR-KZT\": \"Euro/Tengue Cazaquistanês\",\n" +
            "  \"EUR-LAK\": \"Euro/Kip Laosiano\",\n" +
            "  \"EUR-LBP\": \"Euro/Libra Libanesa\",\n" +
            "  \"EUR-LKR\": \"Euro/Rúpia de Sri Lanka\",\n" +
            "  \"EUR-LSL\": \"Euro/Loti do Lesoto\",\n" +
            "  \"EUR-LYD\": \"Euro/Dinar Líbio\",\n" +
            "  \"EUR-MAD\": \"Euro/Dirham Marroquino\",\n" +
            "  \"EUR-MDL\": \"Euro/Leu Moldavo\",\n" +
            "  \"EUR-MGA\": \"Euro/Ariary Madagascarense\",\n" +
            "  \"EUR-MKD\": \"Euro/Denar Macedônio\",\n" +
            "  \"EUR-MMK\": \"Euro/Kyat de Mianmar\",\n" +
            "  \"EUR-MOP\": \"Euro/Pataca de Macau\",\n" +
            "  \"EUR-MRO\": \"Euro/Ouguiya Mauritana\",\n" +
            "  \"EUR-MUR\": \"Euro/Rúpia Mauriciana\",\n" +
            "  \"EUR-MWK\": \"Euro/Kwacha Malauiana\",\n" +
            "  \"EUR-MYR\": \"Euro/Ringgit Malaio\",\n" +
            "  \"EUR-NAD\": \"Euro/Dólar Namíbio\",\n" +
            "  \"EUR-NGN\": \"Euro/Naira Nigeriana\",\n" +
            "  \"EUR-NIO\": \"Euro/Córdoba Nicaraguense\",\n" +
            "  \"EUR-NPR\": \"Euro/Rúpia Nepalesa\",\n" +
            "  \"EUR-OMR\": \"Euro/Rial Omanense\",\n" +
            "  \"EUR-PAB\": \"Euro/Balboa Panamenho\",\n" +
            "  \"EUR-PEN\": \"Euro/Sol do Peru\",\n" +
            "  \"EUR-PGK\": \"Euro/Kina Papua-Nova Guiné\",\n" +
            "  \"EUR-PHP\": \"Euro/Peso Filipino\",\n" +
            "  \"EUR-PKR\": \"Euro/Rúpia Paquistanesa\",\n" +
            "  \"EUR-PYG\": \"Euro/Guarani Paraguaio\",\n" +
            "  \"EUR-QAR\": \"Euro/Rial Catarense\",\n" +
            "  \"EUR-RON\": \"Euro/Leu Romeno\",\n" +
            "  \"EUR-RSD\": \"Euro/Dinar Sérvio\",\n" +
            "  \"EUR-RWF\": \"Euro/Franco Ruandês\",\n" +
            "  \"EUR-SAR\": \"Euro/Riyal Saudita\",\n" +
            "  \"EUR-SCR\": \"Euro/Rúpias de Seicheles\",\n" +
            "  \"EUR-SDG\": \"Euro/Libra Sudanesa\",\n" +
            "  \"EUR-SDR\": \"Euro/DSE\",\n" +
            "  \"EUR-SOS\": \"Euro/Shilling Somaliano\",\n" +
            "  \"EUR-STD\": \"Euro/Dobra São Tomé/Príncipe\",\n" +
            "  \"EUR-SVC\": \"Euro/Colon de El Salvador\",\n" +
            "  \"EUR-SYP\": \"Euro/Libra Síria\",\n" +
            "  \"EUR-SZL\": \"Euro/Lilangeni Suazilandês\",\n" +
            "  \"EUR-TND\": \"Euro/Dinar Tunisiano\",\n" +
            "  \"EUR-TTD\": \"Euro/Dólar de Trinidad\",\n" +
            "  \"EUR-TWD\": \"Euro/Dólar Taiuanês\",\n" +
            "  \"EUR-TZS\": \"Euro/Shilling Tanzaniano\",\n" +
            "  \"EUR-UAH\": \"Euro/Hryvinia Ucraniana\",\n" +
            "  \"EUR-UGX\": \"Euro/Shilling Ugandês\",\n" +
            "  \"EUR-UYU\": \"Euro/Peso Uruguaio\",\n" +
            "  \"EUR-UZS\": \"Euro/Som Uzbequistanês\",\n" +
            "  \"EUR-VEF\": \"Euro/Bolívar Venezuelano\",\n" +
            "  \"EUR-VND\": \"Euro/Dong Vietnamita\",\n" +
            "  \"EUR-XAF\": \"Euro/Franco CFA Central\",\n" +
            "  \"EUR-XOF\": \"Euro/Franco CFA Ocidental\",\n" +
            "  \"EUR-XPF\": \"Euro/Franco CFP\",\n" +
            "  \"EUR-ZMK\": \"Euro/Kwacha Zambiana\",\n" +
            "  \"GHS-EUR\": \"Cedi Ganês/Euro\",\n" +
            "  \"NZD-EUR\": \"Dólar Neozelandês/Euro\",\n" +
            "  \"SGD-EUR\": \"Dólar de Cingapura/Euro\",\n" +
            "  \"AED-EUR\": \"Dirham dos Emirados/Euro\",\n" +
            "  \"DKK-EUR\": \"Coroa Dinamarquesa/Euro\",\n" +
            "  \"EUR-XCD\": \"Euro/Dólar do Caribe Oriental\",\n" +
            "  \"HKD-EUR\": \"Dólar de Hong Kong/Euro\",\n" +
            "  \"MXN-EUR\": \"Peso Mexicano/Euro\",\n" +
            "  \"NOK-EUR\": \"Coroa Norueguesa/Euro\",\n" +
            "  \"PLN-EUR\": \"Zlóti Polonês/Euro\",\n" +
            "  \"RUB-EUR\": \"Rublo Russo/Euro\",\n" +
            "  \"SAR-EUR\": \"Riyal Saudita/Euro\",\n" +
            "  \"SEK-EUR\": \"Coroa Sueca/Euro\",\n" +
            "  \"TRY-EUR\": \"Nova Lira Turca/Euro\",\n" +
            "  \"TWD-EUR\": \"Dólar Taiuanês/Euro\",\n" +
            "  \"ZAR-EUR\": \"Rand Sul-Africano/Euro\",\n" +
            "  \"MAD-EUR\": \"Dirham Marroquino/Euro\",\n" +
            "  \"KRW-EUR\": \"Won Sul-Coreano/Euro\",\n" +
            "  \"EGP-EUR\": \"Libra Egípcia/Euro\",\n" +
            "  \"EUR-MZN\": \"Euro/Metical de Moçambique\",\n" +
            "  \"INR-EUR\": \"Rúpia Indiana/Euro\",\n" +
            "  \"JOD-EUR\": \"Dinar Jordaniano/Euro\",\n" +
            "  \"KWD-EUR\": \"Dinar Kuwaitiano/Euro\",\n" +
            "  \"EUR-AZN\": \"Euro/Manat Azeri\",\n" +
            "  \"EUR-AMD\": \"Euro/Dram Armênio\",\n" +
            "  \"EUR-TJS\": \"Euro/Somoni do Tajiquistão\",\n" +
            "  \"EUR-RUB\": \"Euro/Rublo Russo\",\n" +
            "  \"HUF-EUR\": \"Florim Húngaro/Euro\",\n" +
            "  \"GEL-EUR\": \"Lari Georgiano/Euro\",\n" +
            "  \"EUR-GEL\": \"Euro/Lari Georgiano\",\n" +
            "  \"IDR-EUR\": \"Rupia Indonésia/Euro\",\n" +
            "  \"EUR-AOA\": \"Euro/Kwanza Angolano\",\n" +
            "  \"BYN-EUR\": \"Rublo Bielorrusso/Euro\",\n" +
            "  \"XAGG-EUR\": \"XPrata/Euro\",\n" +
            "  \"PEN-EUR\": \"Sol do Peru/Euro\"\n" +
            "}";

    private static String flags = "{\"AED\": \"Dirham dos Emirados\",\n" +
            "  \"AFN\": \"Afghani do Afeganistão\",\n" +
            "  \"ALL\": \"Lek Albanês\",\n" +
            "  \"AMD\": \"Dram Armênio\",\n" +
            "  \"ANG\": \"Guilder das Antilhas\",\n" +
            "  \"AOA\": \"Kwanza Angolano\",\n" +
            "  \"ARS\": \"Peso Argentino\",\n" +
            "  \"AUD\": \"Dólar Australiano\",\n" +
            "  \"AZN\": \"Manat Azeri\",\n" +
            "  \"BAM\": \"Marco Conversível\",\n" +
            "  \"BBD\": \"Dólar de Barbados\",\n" +
            "  \"BDT\": \"Taka de Bangladesh\",\n" +
            "  \"BGN\": \"Lev Búlgaro\",\n" +
            "  \"BHD\": \"Dinar do Bahrein\",\n" +
            "  \"BIF\": \"Franco Burundinense\",\n" +
            "  \"BND\": \"Dólar de Brunei\",\n" +
            "  \"BOB\": \"Boliviano\",\n" +
            "  \"BRL\": \"Real Brasileiro\",\n" +
            "  \"BRLT\": \"Real Brasileiro Turismo\",\n" +
            "  \"BSD\": \"Dólar das Bahamas\",\n" +
            "  \"BTC\": \"Bitcoin\",\n" +
            "  \"BWP\": \"Pula de Botswana\",\n" +
            "  \"BYN\": \"Rublo Bielorrusso\",\n" +
            "  \"BZD\": \"Dólar de Belize\",\n" +
            "  \"CAD\": \"Dólar Canadense\",\n" +
            "  \"CHF\": \"Franco Suíço\",\n" +
            "  \"CHFRTS\": \"Franco Suíço\",\n" +
            "  \"CLP\": \"Peso Chileno\",\n" +
            "  \"CNH\": \"Yuan chinês offshore\",\n" +
            "  \"CNY\": \"Yuan Chinês\",\n" +
            "  \"COP\": \"Peso Colombiano\",\n" +
            "  \"CRC\": \"Colón Costarriquenho\",\n" +
            "  \"CUP\": \"Peso Cubano\",\n" +
            "  \"CVE\": \"Escudo cabo-verdiano\",\n" +
            "  \"CZK\": \"Coroa Checa\",\n" +
            "  \"DJF\": \"Franco do Djubouti\",\n" +
            "  \"DKK\": \"Coroa Dinamarquesa\",\n" +
            "  \"DOGE\": \"Dogecoin\",\n" +
            "  \"DOP\": \"Peso Dominicano\",\n" +
            "  \"DZD\": \"Dinar Argelino\",\n" +
            "  \"EGP\": \"Libra Egípcia\",\n" +
            "  \"ETB\": \"Birr Etíope\",\n" +
            "  \"ETH\": \"Ethereum\",\n" +
            "  \"EUR\": \"Euro\",\n" +
            "  \"FJD\": \"Dólar de Fiji\",\n" +
            "  \"GBP\": \"Libra Esterlina\",\n" +
            "  \"GEL\": \"Lari Georgiano\",\n" +
            "  \"GHS\": \"Cedi Ganês\",\n" +
            "  \"GMD\": \"Dalasi da Gâmbia\",\n" +
            "  \"GNF\": \"Franco de Guiné\",\n" +
            "  \"GTQ\": \"Quetzal Guatemalteco\",\n" +
            "  \"HKD\": \"Dólar de Hong Kong\",\n" +
            "  \"HNL\": \"Lempira Hondurenha\",\n" +
            "  \"HRK\": \"Kuna Croata\",\n" +
            "  \"HTG\": \"Gourde Haitiano\",\n" +
            "  \"HUF\": \"Florim Húngaro\",\n" +
            "  \"IDR\": \"Rupia Indonésia\",\n" +
            "  \"ILS\": \"Novo Shekel Israelense\",\n" +
            "  \"INR\": \"Rúpia Indiana\",\n" +
            "  \"IQD\": \"Dinar Iraquiano\",\n" +
            "  \"IRR\": \"Rial Iraniano\",\n" +
            "  \"ISK\": \"Coroa Islandesa\",\n" +
            "  \"JMD\": \"Dólar Jamaicano\",\n" +
            "  \"JOD\": \"Dinar Jordaniano\",\n" +
            "  \"JPY\": \"Iene Japonês\",\n" +
            "  \"JPYRTS\": \"Iene Japonês\",\n" +
            "  \"KES\": \"Shilling Queniano\",\n" +
            "  \"KGS\": \"Som Quirguistanês\",\n" +
            "  \"KHR\": \"Riel Cambojano\",\n" +
            "  \"KMF\": \"Franco Comorense\",\n" +
            "  \"KRW\": \"Won Sul-Coreano\",\n" +
            "  \"KWD\": \"Dinar Kuwaitiano\",\n" +
            "  \"KYD\": \"Dólar das Ilhas Cayman\",\n" +
            "  \"KZT\": \"Tengue Cazaquistanês\",\n" +
            "  \"LAK\": \"Kip Laosiano\",\n" +
            "  \"LBP\": \"Libra Libanesa\",\n" +
            "  \"LKR\": \"Rúpia de Sri Lanka\",\n" +
            "  \"LSL\": \"Loti do Lesoto\",\n" +
            "  \"LTC\": \"Litecoin\",\n" +
            "  \"LYD\": \"Dinar Líbio\",\n" +
            "  \"MAD\": \"Dirham Marroquino\",\n" +
            "  \"MDL\": \"Leu Moldavo\",\n" +
            "  \"MGA\": \"Ariary Madagascarense\",\n" +
            "  \"MKD\": \"Denar Macedônio\",\n" +
            "  \"MMK\": \"Kyat de Mianmar\",\n" +
            "  \"MNT\": \"Mongolian Tugrik\",\n" +
            "  \"MOP\": \"Pataca de Macau\",\n" +
            "  \"MRO\": \"Ouguiya Mauritana\",\n" +
            "  \"MUR\": \"Rúpia Mauriciana\",\n" +
            "  \"MVR\": \"Rufiyaa Maldiva\",\n" +
            "  \"MWK\": \"Kwacha Malauiana\",\n" +
            "  \"MXN\": \"Peso Mexicano\",\n" +
            "  \"MYR\": \"Ringgit Malaio\",\n" +
            "  \"MZN\": \"Metical de Moçambique\",\n" +
            "  \"NAD\": \"Dólar Namíbio\",\n" +
            "  \"NGN\": \"Naira Nigeriana\",\n" +
            "  \"NGNI\": \"Naira Nigeriana\",\n" +
            "  \"NGNPARALLEL\": \"Naira Nigeriana\",\n" +
            "  \"NIO\": \"Córdoba Nicaraguense\",\n" +
            "  \"NOK\": \"Coroa Norueguesa\",\n" +
            "  \"NPR\": \"Rúpia Nepalesa\",\n" +
            "  \"NZD\": \"Dólar Neozelandês\",\n" +
            "  \"OMR\": \"Rial Omanense\",\n" +
            "  \"PAB\": \"Balboa Panamenho\",\n" +
            "  \"PEN\": \"Sol do Peru\",\n" +
            "  \"PGK\": \"Kina Papua-Nova Guiné\",\n" +
            "  \"PHP\": \"Peso Filipino\",\n" +
            "  \"PKR\": \"Rúpia Paquistanesa\",\n" +
            "  \"PLN\": \"Zlóti Polonês\",\n" +
            "  \"PYG\": \"Guarani Paraguaio\",\n" +
            "  \"QAR\": \"Rial Catarense\",\n" +
            "  \"RON\": \"Leu Romeno\",\n" +
            "  \"RSD\": \"Dinar Sérvio\",\n" +
            "  \"RUB\": \"Rublo Russo\",\n" +
            "  \"RUBTOD\": \"Rublo Russo\",\n" +
            "  \"RUBTOM\": \"Rublo Russo\",\n" +
            "  \"RWF\": \"Franco Ruandês\",\n" +
            "  \"SAR\": \"Riyal Saudita\",\n" +
            "  \"SCR\": \"Rúpias de Seicheles\",\n" +
            "  \"SDG\": \"Libra Sudanesa\",\n" +
            "  \"SDR\": \"DSE\",\n" +
            "  \"SEK\": \"Coroa Sueca\",\n" +
            "  \"SGD\": \"Dólar de Cingapura\",\n" +
            "  \"SOS\": \"Shilling Somaliano\",\n" +
            "  \"STD\": \"Dobra São Tomé/Príncipe\",\n" +
            "  \"SVC\": \"Colon de El Salvador\",\n" +
            "  \"SYP\": \"Libra Síria\",\n" +
            "  \"SZL\": \"Lilangeni Suazilandês\",\n" +
            "  \"THB\": \"Baht Tailandês\",\n" +
            "  \"TJS\": \"Somoni do Tajiquistão\",\n" +
            "  \"TMT\": \"TMT\",\n" +
            "  \"TND\": \"Dinar Tunisiano\",\n" +
            "  \"TRY\": \"Nova Lira Turca\",\n" +
            "  \"TTD\": \"Dólar de Trinidad\",\n" +
            "  \"TWD\": \"Dólar Taiuanês\",\n" +
            "  \"TZS\": \"Shilling Tanzaniano\",\n" +
            "  \"UAH\": \"Hryvinia Ucraniana\",\n" +
            "  \"UGX\": \"Shilling Ugandês\",\n" +
            "  \"USD\": \"Dólar Americano\",\n" +
            "  \"USDT\": \"Dólar Americano\",\n" +
            "  \"UYU\": \"Peso Uruguaio\",\n" +
            "  \"UZS\": \"Som Uzbequistanês\",\n" +
            "  \"VEF\": \"Bolívar Venezuelano\",\n" +
            "  \"VND\": \"Dong Vietnamita\",\n" +
            "  \"VUV\": \"Vatu de Vanuatu\",\n" +
            "  \"XAF\": \"Franco CFA Central\",\n" +
            "  \"XAGG\": \"XPrata\",\n" +
            "  \"XBR\": \"Brent Spot\",\n" +
            "  \"XCD\": \"Dólar do Caribe Oriental\",\n" +
            "  \"XOF\": \"Franco CFA Ocidental\",\n" +
            "  \"XPF\": \"Franco CFP\",\n" +
            "  \"XRP\": \"XRP\",\n" +
            "  \"YER\": \"Riyal Iemenita\",\n" +
            "  \"ZAR\": \"Rand Sul-Africano\",\n" +
            "  \"ZMK\": \"Kwacha Zambiana\",\n" +
            "  \"ZWL\": \"Dólar Zimbabuense\"}";

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, String> map = null;

        try {
            map = objectMapper.readValue(flags, new TypeReference<Map<String, String>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(map.size());

        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator iterator = set.iterator();
        int padrao = 0, inverso = 0, usd = 0, semCo = 0;

        while (iterator.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();

            if(entry.getKey().equals("USD") || entry.getKey().equals("EUR") || entry.getKey().equals("BRL")){
                continue;
            }

            switch (hasCombination(entry.getKey(), "USD")){
                case "padrao": padrao++; break;
                case "inversa": inverso++; break;
                case "usd": usd++; break;
                default:
                    System.out.println(entry.getKey());semCo++;
            }
        }

        System.out.println("p:"+padrao);
        System.out.println("i:"+inverso);
        System.out.println("u:"+usd);
        System.out.println("s:"+semCo);


    }
    public static String hasCombination(String from, String to){

        if(isValid(from, to)){
            //System.out.println("combinação padrão");
            return ValueCurrentConverter.PADRAO;
        }

        if(isInversionValid(from, to)){
            //System.out.println("combinação inverso");
            return ValueCurrentConverter.INVERSO;
        }

        if(hasCombinationWithUSD(from, to)){
            ///System.out.println("combinação com USD");
            return ValueCurrentConverter.USD;
        }

        //System.out.println("não tem uma combinação valida na api");
        return ValueCurrentConverter.SEMCOMBINACAO;
    }

    // Tendo uma combinação com USD, assim encontra a conversão de USD-FROM e USD-TO e depois com a relação encontra FROM-TO
    private static boolean hasCombinationWithUSD(String from, String to){
        return isValid("USD", from) && isValid("USD", to);
    }

    private static boolean isValid(String from, String to){
        Map<String, String> map = getAll();

        boolean isValid = map.containsKey(from + "-" + to);

        return isValid;
    }

    private static boolean isInversionValid(String from, String to){
        Map<String, String> map = getAll();

        boolean isValid = map.containsKey(to + "-" + from);

        return isValid;
    }

    public static Map<String, String> getAll(){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = null;

        try{
            map =  objectMapper.readValue(jsonValidCombinationCurrency, new TypeReference<Map<String, String>>() {
            });
        }catch (Exception e){
            System.out.println("erro no json");
            e.printStackTrace();
        }

        return map;
    }

}
