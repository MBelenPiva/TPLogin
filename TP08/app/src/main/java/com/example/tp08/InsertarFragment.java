package com.example.tp08;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InsertarFragment extends Fragment {
    private View layoutRoot = null;
    private TextView tvIdNombre;
    private EditText edtNombre;
    private Button btnIngresar;

    public InsertarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(layoutRoot == null) {
            layoutRoot = inflater.inflate(R.layout.fragment_insertar, container, false);

            ObtenerReferencias();

            SetearListeners();

        }
        return layoutRoot;
    }
    private void ObtenerReferencias() {
        tvIdNombre = (TextView) layoutRoot.findViewById(R.id.tvIdNombre);
        edtNombre = (EditText) layoutRoot.findViewById(R.id.edtNombre);
        btnIngresar = (Button) layoutRoot.findViewById(R.id.btnIngresar);
    }

    private void SetearListeners(){
        btnIngresar.setOnClickListener(btnIngresar_Click);
    }

    private View.OnClickListener btnIngresar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
}