package com.ossama.apps.androidsampleapp.listProducts.presenter;

import com.ossama.apps.androidsampleapp.listProducts.ListProductsContract;
import com.ossama.apps.androidsampleapp.model.data.remote.ItemsDataStore;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ossama on 12/7/17.
 */

public class ListProductsPresenter implements ListProductsContract.Presenter {

    private ListProductsContract.View listItemsView;
    private ItemsDataStore dataStore;

    public ListProductsPresenter() {
        dataStore = new ItemsDataStore();
    }

    @Override
    public void attachView(ListProductsContract.View view) {
        listItemsView = view;
    }

    @Override
    public void detachView() {
        listItemsView = null;
    }

    @Override
    public void loadProducts() {
        if (listItemsView != null) {
            // Showing the Progress bar
            listItemsView.showProgressBar();
            listItemsView.hideNoDataText();
            listItemsView.hideItems();

            dataStore.getItems(new Callback<List<ItemData>>() {
                @Override
                public void onResponse(Call<List<ItemData>> call, Response<List<ItemData>> response) {
                    // Hiding the Progress bar
                    listItemsView.hideProgressBar();

                    List<ItemData> items = response.body();
                    if (items != null && items.size() > 0) {
                        // Showing the items after getting the response
                        listItemsView.showItems(items);
                    } else {
                        // Showing "No data" description
                        listItemsView.hideItems();
                        listItemsView.showNoDataText();
                    }
                }

                @Override
                public void onFailure(Call<List<ItemData>> call, Throwable t) {
                    // We just implement showing no data instead of showing some failure message
                    listItemsView.hideProgressBar();
                    listItemsView.showNoDataText();
                }
            });
        }

    }
}
