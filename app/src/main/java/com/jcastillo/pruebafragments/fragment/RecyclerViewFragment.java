package com.jcastillo.pruebafragments.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jcastillo.pruebafragments.R;
import com.jcastillo.pruebafragments.adapter.ContactAdapter;
import com.jcastillo.pruebafragments.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Jonathan Castillo on 16,July,2020
 */


public class RecyclerViewFragment extends Fragment {

    private RecyclerView rvContactos;
    private ArrayList<Contacto> contactos;
    public ContactAdapter adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_reciclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
        inicializarDatos();
        inicializarAdaptador();

        return v;
    }

    private void inicializarDatos() {
        contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.funny_dog, "Jonathan Castillo", "23214542", "jcastillo@gmail.com"));
        contactos.add(new Contacto(R.drawable.funny_dog2, "Anahi Salgado", "92873912", "asalgado@gmail.com"));
        contactos.add(new Contacto(R.drawable.funny_dog3, "Pedro Sanchez", "934824349", "psanchez@gmail.com"));
        contactos.add(new Contacto(R.drawable.funny_dog4, "Mareya Lopez", "423423423", "mlopez@gmail.com"));
        contactos.add(new Contacto(R.drawable.funny_dog5, "Jual Lopez", "64564562", "jlopez@gmail.com"));
    }

    private void inicializarAdaptador() {
        adaptador = new ContactAdapter(contactos, getActivity());
        rvContactos.setAdapter(adaptador);
    }
}
