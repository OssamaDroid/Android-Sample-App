package com.ossama.apps.androidsampleapp.listProducts.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ossama.apps.androidsampleapp.R;
import com.ossama.apps.androidsampleapp.listProducts.ListProductsContract;
import com.ossama.apps.androidsampleapp.listProducts.adapter.ListProductsAdapter;
import com.ossama.apps.androidsampleapp.listProducts.event.OnProductClickedListener;
import com.ossama.apps.androidsampleapp.listProducts.presenter.ListProductsPresenter;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;
import com.ossama.apps.androidsampleapp.productDetails.ProductDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ossama.apps.androidsampleapp.productDetails.ProductDetailsActivity.PRODUCT_DETAILS_EXTRA_KEY;

public class ListProductsActivity extends AppCompatActivity implements ListProductsContract.View, OnProductClickedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    @BindView(R.id.no_data_text) TextView noDataText;

    ListProductsContract.Presenter listProductsPresenter = new ListProductsPresenter();

    ListProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        // Binding the views
        ButterKnife.bind(this);

        listProductsPresenter.attachView(this);
        listProductsPresenter.loadProducts();
    }

    @Override
    protected void onStart() {
        super.onStart();
        listProductsPresenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToolbar();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listProductsPresenter.detachView();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showItems(List<ItemData> items) {
        adapter = new ListProductsAdapter(this, items);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideItems() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showNoDataText() {
        noDataText.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoDataText() {
        noDataText.setVisibility(View.GONE);
    }

    @Override
    public void showProductDetailsScreen(ItemData item) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(PRODUCT_DETAILS_EXTRA_KEY, item);
        startActivity(intent);
    }

    // Set the toolbar along with the title within it
    private void setToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(
                listener -> onBackPressed()
        );
        toolbar.setTitle(R.string.list_products_screen_title);
    }

    @Override
    public void onProductClicked(ItemData item) {
        showProductDetailsScreen(item);
    }
}
