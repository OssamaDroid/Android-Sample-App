package com.ossama.apps.androidsampleapp.model.data.remote;

import com.ossama.apps.androidsampleapp.model.data.api.APIClient;
import com.ossama.apps.androidsampleapp.model.data.api.service.DataService;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by ossama on 12/8/17.
 */

public class ItemsDataStore {

    private DataService dataService;

    public ItemsDataStore() {
        dataService = APIClient.getClient().create(DataService.class);
    }

    public void getItems(Callback<List<ItemData>> callback) {
        Call<List<ItemData>> call = dataService.getData();
        call.enqueue(callback);
    }
}
