package com.example.tp08;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tp08.Package.SearchResponse;

public class ListadoFragment extends Fragment {
    private View layoutRoot = null;
    ListView listado;
    SearchResponse marcas = null;

    public ListadoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(layoutRoot == null) {
            layoutRoot = inflater.inflate(R.layout.fragment_listado, container, false);

            ObtenerReferencias();

            SetearListeners();

        }
        return layoutRoot;
    }

    public void mostrarMarcas(){
        if(marcas != null){
            listado = marcas;
        }
        else{
            Toast.makeText(getActivity(), "No existe", Toast.LENGTH_LONG);
        }
    }

    private void ObtenerReferencias(){
        listado = (ListView) layoutRoot.findViewById(R.id.listado);
    }

    private void SetearListeners(){

    }



}