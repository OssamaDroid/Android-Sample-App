package com.ossama.apps.androidsampleapp.productDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ossama.apps.androidsampleapp.R;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;
import com.ossama.apps.androidsampleapp.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailsActivity extends AppCompatActivity {

    public final static String PRODUCT_DETAILS_EXTRA_KEY = "product.details.extra.key";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.item_title_value) TextView itemTitle;
    @BindView(R.id.price_value) TextView priceValue;
    @BindView(R.id.description_value) TextView descriptionValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Binding the views
        ButterKnife.bind(this);

        if (getIntent() == null || getIntent().getExtras() == null) {
            throw new IllegalArgumentException("Product Details extra has not been sent");
        }

        // Handles the intent and gets the underlying data being sent
        ItemData item = (ItemData) getIntent().getExtras().get(PRODUCT_DETAILS_EXTRA_KEY);
        setData(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToolbar();
    }

    // Set the toolbar along with the title within it
    private void setToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(
                listener -> {
                    onBackPressed();
                    overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                }
        );
        toolbar.setTitle(R.string.product_details_screen_title);
    }

    private void setData(ItemData item) {
        itemTitle.setText(item.getTitle());
        priceValue.setText(Utils.formatPrice(item.getValue(), item.getCurrency()));
    }
}
