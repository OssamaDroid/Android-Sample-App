package com.ossama.apps.androidsampleapp.base;

/**
 * Base interface that any class wanting to act as a Presenter in the MVP (Model View Presenter) pattern must implement.
 * Created by ossama on 12/7/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
