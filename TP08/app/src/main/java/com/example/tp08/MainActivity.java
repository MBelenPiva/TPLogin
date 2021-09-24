package com.example.tp08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences sharedPreferences;
    ListadoFragment listadoFragment;
    InsertarFragment insertarFragment;
    ActualizarEliminarFragment actualizarEliminarFragment;
    FrameLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrearFragments();

        ObtenerReferencias();

        ReemplazarFragments();

    }

    private void ObtenerReferencias(){
        main = (FrameLayout)findViewById(R.id.);
    }

    private void CrearFragments() {
        insertarFragment = new InsertarFragment();
        listadoFragment = new ListadoFragment();
        actualizarEliminarFragment = new ActualizarEliminarFragment();
    }

    private void ReemplazarFragments(int container, Fragment frag, boolean addBackToStack){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        String reempplazarFragment;
        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(
                addBackToStack
        ){
            reempplazarFragment = frag.getClass().getName();
            fragmentTransaction.replace(container, frag, reempplazarFragment);
            fragmentTransaction.addToBackStack(reempplazarFragment);
        }else{
            fragmentTransaction.replace(container, frag);
        }
    }


}