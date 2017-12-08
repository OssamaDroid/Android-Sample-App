package com.ossama.apps.androidsampleapp.utils;

/**
 * Created by ossama on 12/8/17.
 */

public class Utils {

    /**
     * Formats the price with the corresponding currency --> [$100.00 (CAD)]
     * @param price
     * @param currency
     * @return The price formatted
     */
    public static String formatPrice(String price, String currency) {
        return String.format("$%s (%s)", price, currency);
    }
}
