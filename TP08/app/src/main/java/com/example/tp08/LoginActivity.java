package com.example.tp08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp08.Package.SearchLogin;
import com.example.tp08.Utilis.LogHelper;
import com.example.tp08.Utilis.LoginHelper;
import com.example.tp08.Utilis.StreamHelper;
import com.example.tp08.Utilis.ValidacionesHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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
            tareaAsincronicaSearchLogin miTarea;
            String strSearchText;

        }
    };


    private class tareaAsincronicaSearchLogin extends AsyncTask<Void, String,String> {
        private ProgressDialog dialog;
        private Context context;
        private String strURL;

        public tareaAsincronicaSearchLogin(Context context){
            this.context = context;
            dialog = new ProgressDialog(context);
        }

        private void setURL(String setURL) {this.strURL = setURL;}

        public void getSearchLogin (String strSearch){
            String strURL;
            strURL = LoginHelper.getSearchURL(strSearch);
            setURL(strURL);
            execute();
        }

        @Override
        protected void onPreExecute(){
            this.dialog.setMessage("Buscando la informacion...");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(Void ...parametros){
            HttpURLConnection miconexion = null;
            URL urlApi;
            String strResultado = "";

            LogHelper.d("doInBackground");

            try {
                urlApi = new URL(this.strURL);
                miconexion = (HttpURLConnection) urlApi.openConnection();
                miconexion.setRequestMethod("GET");
                if (miconexion.getResponseCode() == 200) {

                    strResultado = StreamHelper.GetFullStringFromInputReader(miconexion.getInputStream());
                    Thread.sleep(500);
                    publishProgress("conectando");
                    Thread.sleep(500);
                    publishProgress("leyendo");
                    Thread.sleep(500);
                    publishProgress("comparando");
                    Thread.sleep(500);
                    publishProgress("cerrando");
                } else {

                }
            } catch (Exception e){
                LogHelper.d ("al Conectar o procesar ocurrio un error" + e.getMessage());
            } finally {
                if (miconexion !=null){
                    miconexion.disconnect();
                }
            }
            return strResultado;
        }

        @Override
        protected void onPostExecute(String resultado){
            super.onPostExecute(resultado);
            ArrayList<SearchLogin> listMarcas;
            listMarcas = JSON(resultado);
            ArrayAdapter<SearchLogin> arrayAdapterMarcas;
            arrayAdapterMarcas = new ArrayAdapter<SearchLogin>(getContext(), android.R.layout.simple_list_item_1, listMarcas);
            lvResultado.setAdapter(arrayAdapterMarcas);

            if (listMarcas.size()==0){
                Toast.makeText(getActivity(), "Error, No hay marcas",Toast.LENGTH_LONG);
            }
            else{
                Toast.makeText(getActivity(), "Se encontraron [" + listMarcas.size() + "]", Toast.LENGTH_LONG);
            }
        }

        private ArrayList <SearchLogin> JSON (String resultado) {
            ArrayList<SearchLogin> listReturn;
            SearchLogin marcas;
            JSONObject jsonResponse;
            JSONArray searchoJsonArray;
            int intTotalResults, intYear;
            boolean blnResponse;
            String strUsuario, strPassword, strMarcas;
            listReturn = new ArrayList<SearchLogin>();
            return listReturn;
        }
    }

    }