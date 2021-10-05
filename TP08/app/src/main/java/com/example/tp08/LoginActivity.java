package com.example.tp08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.security.AccessController.getContext;

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
        btnIngresar = (Button) layoutRoot.findViewById(R.id.btnActualizar);
        tvUserName = (TextView) layoutRoot.findViewById(R.id.tvIdNombre);
        edtUserName = (EditText) layoutRoot.findViewById(R.id.edtId);
        tvPassword = (TextView) layoutRoot.findViewById(R.id.tvIdNombre);
        edtPassword = (EditText) layoutRoot.findViewById(R.id.edtId);
    }

    private void SetearListeners(){
        btnIngresar.setOnClickListener(btnIngresar_Click);
    }

    private View.OnClickListener btnIngresar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    private class tareaAsincronicaMovies extends  AsyncTask<Void,Void,String> {

        private ProgressDialog dialog;
        private Context context;
        private String strURL = "http://api.polshu.com.ar/api/v1/login/usuario/password";

        public tareaAsincronicaMovies() {
            this.context = getContext();
            dialog = new ProgressDialog(context);
        }

        /*public void setURl(String strUrl) {
            strURL = strUrl;
        }*/

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.dialog.setMessage("Buscando la información...");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            HttpURLConnection conexion = null;
            URL strAPIUrl="";
            String strResultado = "";
            try {
                conexion = (HttpURLConnection) strAPIUrl.openConnection();
                conexion.setRequestMethod("GET");
                int intStatusCode = conexion.getResponseCode();
                if (intStatusCode == 200) {
                    strResultado = StreamHelper.GetFullStringFromInputReader(conexion.getInputStream());
                } else {
                    //OCURRIO ALGUN ERROR
                }
            } catch (MalformedURLException e) {
                Log.d("E", e.toString());
                e.printStackTrace();
            } catch (IOException e) {
                Log.d("E", e.toString());
                e.printStackTrace();
            } catch (InterruptedException e) {
                Log.d("E", e.toString());
                e.printStackTrace();
            } catch (Exception e) {
                Log.d("E", e.toString());
                //Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            } finally {
                if (conexion != null) {
                    conexion.disconnect();
                }
            }
            return strResultado;
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            ArrayList<Pelicula> listaPeliculas;
            listaPeliculas = ParseElResultado(strURL);
            PeliculaArrayAdapter adapter;
            adapter = new PeliculaArrayAdapter(getContext(), R.layout.fragment_movie, listaPeliculas);
            lvDatos.setAdapter(adapter);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            //Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
        }
    }

    }