package com.ossama.apps.androidsampleapp.listItems;

import com.ossama.apps.androidsampleapp.base.BasePresenter;
import com.ossama.apps.androidsampleapp.base.BaseView;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;

import java.util.List;

/**
 * Created by ossama on 12/7/17.
 */

public interface ListItemsContract {

    interface View extends BaseView {

        void showProgressBar();
        void hideProgressBar();
        void showItems(List<ItemData> items);
        void hideItems();
        void showNoDataText();
        void hideNoDataText();
        void showItemDetailsScreen(ItemData item);
    }

    interface Presenter extends BasePresenter<View> {

        void loadProducts();
    }
}
