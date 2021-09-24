package com.example.tp08;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActualizarEliminarFragment extends Fragment {
    private View layoutRoot = null;
    private TextView tvId, tvNombre;
    private EditText edtId, edtNombre;
    private Button btnActualizar, btnEliminar;

    public ActualizarEliminarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(layoutRoot == null) {
            layoutRoot = inflater.inflate(R.layout.fragment_actualizar_eliminar, container, false);

            ObtenerReferencias();

            SetearListeners();

        }
        return layoutRoot;
    }

    private void ObtenerReferencias() {
        tvId = (TextView) layoutRoot.findViewById(R.id.tvIdNombre);
        tvNombre = (TextView) layoutRoot.findViewById(R.id.tvNombre);
        edtId = (EditText) layoutRoot.findViewById(R.id.edtId);
        edtNombre = (EditText) layoutRoot.findViewById(R.id.edtNombre);
        btnActualizar = (Button) layoutRoot.findViewById(R.id.btnActualizar);
        btnEliminar = (Button) layoutRoot.findViewById(R.id.btnEliminar);
    }

    private void SetearListeners(){
        btnEliminar.setOnClickListener(btnActualizar_Click);
        btnActualizar.setOnClickListener(btnEliminar_Click);
    }

    private View.OnClickListener btnActualizar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private View.OnClickListener btnEliminar_Click= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

}