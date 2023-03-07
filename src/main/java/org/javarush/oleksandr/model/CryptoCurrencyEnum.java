package org.javarush.oleksandr.model;

public enum CryptoCurrencyEnum {
    BTC("BTC", "USDT"),
    ETH("ETH", "USDT"),
    BNB("BNB", "USDT"),
    ADA("ADA", "USDT"),
    XRP("XRP", "USDT"),
    DOGE("DOGE", "USDT"),
    DOT("DOT", "USDT"),
    UNI("UNI", "USDT"),
    LTC("LTC", "USDT"),
    LINK("LINK", "USDT");

    private final String currencyName;
    private final String pair;

    CryptoCurrencyEnum(String currencyName, String pair) {
        this.currencyName = currencyName;
        this.pair = pair;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getPair() {
        return pair;
    }
}
