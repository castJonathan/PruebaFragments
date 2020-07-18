package com.jcastillo.pruebafragments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcastillo.pruebafragments.R;
import com.jcastillo.pruebafragments.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 17,July,2020
 */


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContatViewHolder> {

    ArrayList<Contacto> contacts;
    Context ctx;

    public ContactAdapter(ArrayList<Contacto> contacts, Context context) {
        this.contacts = contacts;
        this.ctx = context;
    }

    @NonNull
    @Override
    public ContatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacts, parent, false);
        return new ContatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContatViewHolder contactViewHolder, final int position) {
        final Contacto contacto = contacts.get(position);
        contactViewHolder.ivFoto.setImageResource(contacto.getFoto());
        contactViewHolder.tvNombre.setText(contacto.getNombre());
        contactViewHolder.tvTelefono.setText(contacto.getTelefono());

        contactViewHolder.ivLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Le diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContatViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private ImageView ivLike;
        private TextView tvNombre;
        private TextView tvTelefono;

        public ContatViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            ivLike = (ImageView) itemView.findViewById(R.id.ivLike);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvTelefono =(TextView) itemView.findViewById(R.id.tvTelefono);
        }
    }

}
