package com.ossama.apps.androidsampleapp.listItems.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ossama.apps.androidsampleapp.R;
import com.ossama.apps.androidsampleapp.listItems.event.ItemClickedListener;
import com.ossama.apps.androidsampleapp.model.entity.ItemData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ossama on 12/7/17.
 */

public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.ViewHolder> {

    private List<ItemData> listItems;
    private ItemClickedListener listener;

    public ListItemsAdapter(ItemClickedListener listener, List<ItemData> listItems) {
        this.listener = listener;
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemData itemData = listItems.get(position);
        holder.title.setText(itemData.getTitle());
        holder.price.setText(itemData.getValue() + " " + itemData.getCurrency());
        holder.viewContainer.setOnClickListener(
                v -> listener.onItemClicked(listItems.get(holder.getAdapterPosition()))
        );
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_container) CardView viewContainer;
        @BindView(R.id.item_title) TextView title;
        @BindView(R.id.item_price) TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
