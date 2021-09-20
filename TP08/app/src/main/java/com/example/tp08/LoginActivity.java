package com.example.tp08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    public SharedPreferences sharedPreferences;
    InsertarFragment insertarFragment;
    ListadoFragment listadoFragment;
    ActualizarEliminarFragment actualizarEliminarFragment;

    private View layoutRoot = null;
    private Button btnIngresar;
    private TextView tvUserName;
    private EditText edtUserName;
    private TextView tvPassword;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CrearFragments();

        ObtenerReferencias();

        SetearListeners();

     }

    private void CrearFragments() {
        insertarFragment = new InsertarFragment();
        listadoFragment = new ListadoFragment();
        actualizarEliminarFragment = new ActualizarEliminarFragment();
    }

    private void ObtenerReferencias(){
        btnIngresar = (Button) layoutRoot.findViewById(R.id.btnIngresar);
        tvUserName = (TextView) layoutRoot.findViewById(R.id.tvUserName);
        edtUserName = (EditText) layoutRoot.findViewById(R.id.edtUserName);
        tvPassword = (TextView) layoutRoot.findViewById(R.id.tvPassword);
        edtPassword = (EditText) layoutRoot.findViewById(R.id.edtPassword);
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