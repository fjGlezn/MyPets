package com.fjglezn.mypets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mascota> mascotas;

    private RecyclerView rvMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);


        //Creara la lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);//Define la orientación


        rvMascotas.setLayoutManager(llm);//Se comporte con Linear Layout
        inicializarListaContacto();
        inicializaAdaptador();
    }


    public void inicializarListaContacto(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota1, "Wally", 1));
        mascotas.add(new Mascota(R.drawable.mascota2, "Ronny", 0));
        mascotas.add(new Mascota(R.drawable.mascota3, "Pukky", 1));
        mascotas.add(new Mascota(R.drawable.mascota4, "Miky", 0));
        mascotas.add(new Mascota(R.drawable.mascota5, "Cuky", 2));
        mascotas.add(new Mascota(R.drawable.mascota6, "Crispi", 0));
        mascotas.add(new Mascota(R.drawable.mascota7, "Goffy", 5));
        mascotas.add(new Mascota(R.drawable.mascota8, "Goddy", 0));
        mascotas.add(new Mascota(R.drawable.mascota9, "Gommy", 2));
        mascotas.add(new Mascota(R.drawable.mascota10, "Waki", 0));

    }

    public void inicializaAdaptador() {

        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
        /*MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mStar)
        {
                Intent  intent = new Intent(this, MascotasFavoritas.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
