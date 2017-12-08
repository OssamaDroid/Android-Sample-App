package com.ossama.apps.androidsampleapp.listProducts.event;

import com.ossama.apps.androidsampleapp.model.entity.ItemData;

/**
 * Created by ossama on 12/8/17.
 */

public interface OnProductClickedListener {
    public void onProductClicked(ItemData item);
}
