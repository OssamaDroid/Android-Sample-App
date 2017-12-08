package com.ossama.apps.androidsampleapp.listItems.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ossama.apps.androidsampleapp.R;
import com.ossama.apps.androidsampleapp.listItems.ListItemsContract;
import com.ossama.apps.androidsampleapp.listItems.adapter.ListItemsAdapter;
import com.ossama.apps.androidsampleapp.listItems.event.ItemClickedListener;
import com.ossama.apps.androidsampleapp.listItems.presenter.ListItemsPresenter;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListItemsActivity extends AppCompatActivity implements ListItemsContract.View, ItemClickedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.no_data_text) TextView noDataText;

    ListItemsContract.Presenter listItemsPresenter = new ListItemsPresenter();

    ListItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        // Binding the views
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listItemsPresenter.attachView(this);
        listItemsPresenter.loadProducts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToolbar();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listItemsPresenter.detachView();
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
        adapter = new ListItemsAdapter(this, items);
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
    public void showItemDetailsScreen(ItemData item) {
        // TODO Start the Item Details Activity
    }

    // Set the toolbar along with the title within it
    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(
                listener -> onBackPressed()
        );
        toolbar.setTitle(R.string.list_items_screen);
    }

    @Override
    public void onItemClicked(ItemData item) {
        showItemDetailsScreen(item);
    }
}
