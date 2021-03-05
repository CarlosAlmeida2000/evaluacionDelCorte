package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maps.WebServices.Asynchtask;
import com.example.maps.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends FragmentActivity implements Asynchtask, AdapterView.OnItemSelectedListener{
    Intent intent;
    Bundle b;

    Spinner spListaPaises;
    String[] lsPaises = new String[]{"EC", "BB", "BN", "TM", "RO", "JQ", "JP"};
    ArrayAdapter<String> comboAdapter;
    String paisSeleccionado;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spListaPaises = (Spinner) findViewById(R.id.spCodigoPaises);
        comboAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lsPaises);
        spListaPaises.setAdapter(comboAdapter);
        spListaPaises.setOnItemSelectedListener(this);
        textView = (TextView)findViewById(R.id.textView);
       /* Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json", datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");*/
    }

    public  void verMapa(View view){
        intent = new Intent(MainActivity.this, VerMapa.class);
        b= new Bundle();
        b.putString("CountryCode", paisSeleccionado);
        intent.putExtras(b);
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        paisSeleccionado = lsPaises[position];
        textView.setText("Seleccionado " +paisSeleccionado);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void processFinish(String result) throws JSONException {

    }
}