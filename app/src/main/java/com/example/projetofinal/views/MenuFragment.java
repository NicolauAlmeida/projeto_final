package com.example.projetofinal.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetofinal.adapter.MenuAdapter;
import com.example.projetofinal.models.MenuItem;
import com.example.projetofinal.presenter.MenuPresenter;
import com.example.projetofinal.R;

import java.util.List;

public class MenuFragment extends Fragment {
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        MenuPresenter presenter = new MenuPresenter();
        List<MenuItem> menuItems = presenter.getMenuItems();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MenuAdapter(menuItems));

        return view;
    }
}
