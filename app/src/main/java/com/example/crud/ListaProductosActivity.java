package com.example.crud;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crud.modelo.ComprasDatabaseHelper;
import com.example.crud.modelo.ListaDeCompras;
import com.example.crud.modelo.Producto;

import java.util.List;

public class ListaProductosActivity extends ListActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista()
    {
        lista=getListView();
        ComprasDatabaseHelper helper=new ComprasDatabaseHelper(this);
        List<Producto> productoList= helper.listaProductos();

        ArrayAdapter<Producto> listaAdapter = new ArrayAdapter<Producto>(this,
                android.R.layout.simple_list_item_1, productoList);
        lista.setAdapter(listaAdapter);
        lista.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Object ob=lista.getItemAtPosition(i);
                String linea=ob.toString();
                String[] separar=linea.split(":");
                Intent intent=new Intent(ListaProductosActivity.this, DetallesActivity.class);
                intent.putExtra("nombreProducto", separar[0]);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode==1)
        {
            if (resultCode == RESULT_OK)
            {
                cargarLista();
            }
        }
    }
}