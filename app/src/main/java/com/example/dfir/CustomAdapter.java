package com.example.dfir;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    Activity activity;
    ArrayList id, names, description, documents;
    CustomAdapter (Context context,
                   ArrayList id,
                   ArrayList names,
                   ArrayList description,
                   ArrayList documents){
        this.context = context;
        this.activity = activity;
        this.id = id;
        this.names = names;
        this.description = description;
        this.documents = documents;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(names.get(position)));
        holder.description.setText(String.valueOf(description.get(position)));
        holder.document.setText(String.valueOf(documents.get(position)));
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("names", String.valueOf(names.get(position)));
                intent.putExtra("description", String.valueOf(description.get(position)));
                intent.putExtra("documents", String.valueOf(documents.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, description, document;
        LinearLayout mainlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.names);
            description = itemView.findViewById(R.id.description);
            document = itemView.findViewById(R.id.documents);
            mainlayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
