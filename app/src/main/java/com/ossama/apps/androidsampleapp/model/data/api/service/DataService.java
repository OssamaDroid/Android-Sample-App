package com.ossama.apps.androidsampleapp.model.data.api.service;

import com.ossama.apps.androidsampleapp.model.entity.ItemData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ossama on 12/7/17.
 */

public interface DataService {

    @GET("data/")
    Call<List<ItemData>> getData();
}
