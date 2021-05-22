package com.example.myapplication.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    public interface OnPeopleAdapterListener {
        void onViewClick(Person person, int position);

        void onEditClick(Person person, int position);

        void onRemoveClick(Person person, int position);
    }

    private final LayoutInflater inflater;
    private final List<Person> people;
    private final Context context;
    private OnPeopleAdapterListener onPeopleAdapterListener;

    public PeopleAdapter(Context context, List<Person> people) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.people = people;

        if (context instanceof OnPeopleAdapterListener) {
            onPeopleAdapterListener = (OnPeopleAdapterListener) context;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // получение Person
        Person person = people.get(position);
        Picasso.get()
                .load(person.getImagePath())
                .into(holder.imageViewPhoto);
        holder.tvFirstName.setText(person.getFirstName());
        holder.tvLastName.setText(person.getLastName());
        holder.tvBirth.setText(person.getBirth().toString());

        // -= обработка нажатия кнопок =-
        // просмотр
        holder.btnView.setOnClickListener(v -> {
            onPeopleAdapterListener.onViewClick(person, position);
        });
        // редактирование
        holder.btnEdit.setOnClickListener(v -> {
            onPeopleAdapterListener.onEditClick(person, position);
        });
        // удаление
        holder.btnRemove.setOnClickListener(v -> {
            onPeopleAdapterListener.onRemoveClick(person, position);
        });
        String[] items = new String[]{"Item 1", "Item 2", "Item 3"};
        holder.ivInfo.setOnClickListener(v -> {
            AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(context);
            AlertDialog dlg = dlgBuilder.setTitle(person.getLastName())
                    .setIcon(context.getDrawable(R.drawable.ic_launcher_foreground))
                    .setItems(items, (dialog, which) -> {
                        Toast.makeText(context, items[which], Toast.LENGTH_SHORT).show();
                    })
                    .setPositiveButton("Ok", (dialog, which) -> {

                    }).create();
            dlg.show();
        });
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPhoto, ivInfo;

        TextView tvFirstName, tvLastName, tvBirth;
        Button btnView, btnEdit, btnRemove;

        public ViewHolder(@NonNull View view) {
            super(view);

            imageViewPhoto = view.findViewById(R.id.ivPhoto);
            ivInfo = view.findViewById(R.id.ivInfo);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);
            tvBirth = view.findViewById(R.id.tvBirth);
            btnView = view.findViewById(R.id.btnView);
            btnEdit = view.findViewById(R.id.btnEdit);
            btnRemove = view.findViewById(R.id.btnRemove);
        }
    }
}
