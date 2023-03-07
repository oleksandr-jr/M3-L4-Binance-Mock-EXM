package org.javarush.oleksandr.services;

import okhttp3.*;
import org.javarush.oleksandr.model.CryptoCurrency;
import org.javarush.oleksandr.model.CryptoCurrencyEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CryptoCurrencyServiceTest {
    @Test
    void testGetCryptoCurrencyWithMock() throws Exception {
        // Arrange
        OkHttpClient mockHttpClient = mock(OkHttpClient.class);
        Call mockCall = mock(Call.class);
        Response mockResponse = mock(Response.class);
        ResponseBody mockResponseBody = mock(ResponseBody.class);
        String mockResponseData = "{\"symbol\":\"BTCUSDT\",\"price\":\"50000.00\"}";

        when(mockHttpClient.newCall(any(Request.class))).thenReturn(mockCall);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(mockResponseBody);
        when(mockResponseBody.string()).thenReturn(mockResponseData);

        CryptoCurrencyService service = new CryptoCurrencyService(mockHttpClient);
        CryptoCurrencyEnum crypto = CryptoCurrencyEnum.BTC;

        // Act
        CryptoCurrency cryptoCurrency = service.getCurrencyPrice(crypto.getCurrencyName(), crypto.getPair());

        // Assert
        assertEquals(50000.00, cryptoCurrency.getPrice().doubleValue());
        verify(mockHttpClient).newCall(any(Request.class));
        verify(mockCall).execute();
        verify(mockResponse).isSuccessful();
        verify(mockResponseBody).string();
    }
}