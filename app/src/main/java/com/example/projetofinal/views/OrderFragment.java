package com.example.projetofinal.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetofinal.R;
import com.example.projetofinal.adapter.OrderAdapter;
import com.example.projetofinal.models.MenuItem;
import com.example.projetofinal.services.OrderService;

import java.util.List;

public class OrderFragment extends Fragment {

    private OrderService orderService;
    private TextView totalPriceTextView;
    private RecyclerView orderRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar o layout do fragment_order.xml
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        // Inicializar componentes de layout
        totalPriceTextView = view.findViewById(R.id.total_price);
        orderRecyclerView = view.findViewById(R.id.order_recycler_view);
        Button confirmOrderButton = view.findViewById(R.id.confirm_order_button);

        // Configuração do RecyclerView
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializa o serviço de pedidos
        orderService = new OrderService();
        updateOrderList();

        // Configuração do botão para confirmar pedido
        confirmOrderButton.setOnClickListener(v -> onConfirmOrder());

        return view;
    }

    private void updateOrderList() {
        // Obtém os itens do pedido
        List<MenuItem> orderItems = orderService.getOrderItems();

        // Configura o adaptador para a RecyclerView
        OrderAdapter adapter = new OrderAdapter(orderItems);
        orderRecyclerView.setAdapter(adapter);

        // Atualiza o preço total
        double total = orderService.getTotal();
        totalPriceTextView.setText(String.format("Total: R$%.2f", total));
    }

    private void onConfirmOrder() {
        if (orderService.getOrderItems().isEmpty()) {
            // Exibe mensagem se o pedido estiver vazio
            totalPriceTextView.setText("Nenhum item no pedido!");
        } else {
            // Realiza a ação de confirmação
            totalPriceTextView.setText("Pedido confirmado!");
            orderService.clearOrder(); // Limpa o pedido após confirmação
            updateOrderList(); // Atualiza a interface
        }
    }
}
