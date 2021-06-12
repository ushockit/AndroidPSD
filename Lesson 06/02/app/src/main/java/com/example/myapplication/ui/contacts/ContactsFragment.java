package com.example.myapplication.ui.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.home.HomeFragment;

public class ContactsFragment extends Fragment {
    ContactsViewModel contactsViewModel;
    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contactsViewModel =
                new ViewModelProvider(this).get(ContactsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        NavController navController = Navigation.findNavController(root);
        final TextView textView = root.findViewById(R.id.text_contacts);
        final Button btnBackHome = root.findViewById(R.id.btn_back_home);

        contactsViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));
        btnBackHome.setOnClickListener(v -> {
            navController.navigate(R.id.nav_home);
        });

        return root;
    }
}
