package com.example.tp08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

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

        ReemplazarFragments(R.id.main,listadoFragment, false);

    }

    private void ObtenerReferencias(){
        main = (FrameLayout)findViewById(R.id.main);
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

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)  {
        //  Infla  el  menu:
        //    Agrega  los  items  a  la  action  bar,  si  se  encuentra presente.
        getMenuInflater().inflate(R.menu.menu,  menu);

        //  You  must  return  true  for  the  menu  to  be  displayed;
        //  if  you  return  false  it  will  not  be  shown.
        return  true; }


    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean blnReturn = true;
        String strTitle;

        strTitle = item.getTitle().toString(); //  Obtengo el  Titulo  de  MenuItem  presionado.
        switch (item.getItemId()) {
            case R.id.action_IrAListado:
                Toast.makeText(getApplicationContext(), strTitle, Toast.LENGTH_LONG).show();
                ReemplazarFragments(R.id.main,listadoFragment,false);
                break;
            case R.id.action_IrAInsertar:
                Toast.makeText(getApplicationContext(), strTitle, Toast.LENGTH_LONG).show();
                ReemplazarFragments(R.id.main,insertarFragment,false);
                break;
            default:
                blnReturn = false;
                break;
        }
        return blnReturn;
    }


    @Override
    public  boolean onPrepareOptionsMenu(Menu  menu)  {
        MenuItem  item  =  menu.findItem(R.id.action_IrAListado);
        item.setEnabled(false);
        return  super.onPrepareOptionsMenu(menu);
    }
}