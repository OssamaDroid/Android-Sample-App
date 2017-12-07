package com.ossama.apps.androidsampleapp.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ossama on 12/7/17.
 */

public class APIClient {

    public static final String BASE_URL = "https://my-json-server.typicode.com/OssamaDroid/DummyJSONData";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
