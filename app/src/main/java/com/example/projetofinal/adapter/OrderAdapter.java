package com.example.projetofinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetofinal.R;
import com.example.projetofinal.models.MenuItem;

import java.util.List;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private final List<MenuItem> orderItems;

    public OrderAdapter(List<MenuItem> orderItems) {
        this.orderItems = orderItems;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        MenuItem item = orderItems.get(position);
        holder.nameTextView.setText(item.getName());
        holder.priceTextView.setText(String.format(Locale.getDefault(), "R$%.2f", item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    // Torne explicitamente pública ou proteja a visibilidade, se necessário
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, priceTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.item_name);
            priceTextView = itemView.findViewById(R.id.item_price);
        }
    }
}
