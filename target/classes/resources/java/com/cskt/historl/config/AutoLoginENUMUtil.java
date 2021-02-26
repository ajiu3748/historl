package com.cskt.historl.config;

public enum AutoLoginENUMUtil {
    SHOP_APPID("wx28b1c0692ac859a3"),
    SHOP_SECRET("ecfe7050ec7ae67f726642f962bd466e"),
    SHOP_MUCHID(""),
    SHOP_DEVICE_INFO(""),
    SHOP_SIGN_TYPE(""),
    SHOP_FEE_TYPE(""),
    SHOP_NOTIFY_URL(""),
    SHOP_TRADE_TYPE(""),
    SHOP_LIMIT_PAY(""),
    API_KEY(""),
    API_BODY("");

    private String name;

    private AutoLoginENUMUtil(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
