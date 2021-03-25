package util;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyHandlerTest {



    @Test
    void getExchangeRateByCurrency() throws IOException, JSONException {
        String currency = "UAH";
        JSONObject jsonObject = CurrencyHandler.getCurrencyFromAPI();
        Assertions.assertNotNull(CurrencyHandler.getExchangeRateByCurrency(currency));


    }

    @Test
    void getCurrencyFromAPI() throws IOException, JSONException {
        Assertions.assertNotNull(CurrencyHandler.getCurrencyFromAPI());
    }

    @Test
    void recurseKeys() throws IOException, JSONException {
        String currency = "UAH";
        JSONObject jsonObject = CurrencyHandler.getCurrencyFromAPI();
        Assertions.assertNotEquals(CurrencyHandler.recurseKeys(jsonObject, currency), "");
    }
}