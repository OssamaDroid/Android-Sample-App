package com.ossama.apps.androidsampleapp.utils;

import android.content.Context;

import com.ossama.apps.androidsampleapp.model.entity.Description;

/**
 * Created by ossama on 12/8/17.
 */

public class Utils {

    private final static String FR_CANADA_LOCALE = "fr_CA";
    private final static String EN_CANADA_LOCALE = "en_CA";

    /**
     * Formats the price with the corresponding currency --> [$100.00 (CAD)]
     * @param price
     * @param currency
     * @return The price formatted
     */
    public static String formatPrice(String price, String currency) {
        return String.format("$%s (%s)", price, currency);
    }

    /**
     * The description value depends on the device's language.
     * Languages supported are en-CA and fr-CA.
     * If the detected language is unsupported, the English description is used by default.
     * @param context
     * @param description
     * @return The appropriate description
     */
    public static String getRelevantDescription(Context context, Description description) {
        String localeToString = context.getResources().getConfiguration().locale.toString();

        switch (localeToString) {
            case FR_CANADA_LOCALE:
                return description.getFrenchDescription();

            case EN_CANADA_LOCALE:
            default:
                return description.getEnglishDescription();
        }
    }
}
