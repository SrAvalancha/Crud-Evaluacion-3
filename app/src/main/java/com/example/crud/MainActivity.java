package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.crud.modelo.ComprasDatabaseHelper;
import com.example.crud.modelo.ListaDeCompras;
import com.example.crud.modelo.Producto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private ListaDeCompras lista=ListaDeCompras.getInstancia();
    private ComprasDatabaseHelper helper=new ComprasDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLista(View view)
    {
        try {
            ArrayList<Producto> productos=(ArrayList<Producto>) helper.listaProductos();
            Intent intent = new Intent(this, ListaProductosActivity.class);
            startActivity(intent);
        }
        catch (Exception ex){
            Toast.makeText(this, "La lista de compras esta vacia",Toast.LENGTH_SHORT).show();
        }
    }

    public void ingresarNuevo(View view)
    {
        Intent intent= new Intent(this, NuevoProductoActivity.class);
        startActivity(intent);

    }

    public void eliminarComprados(View view)
    {
        String msg= helper.eliminarComprados();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}