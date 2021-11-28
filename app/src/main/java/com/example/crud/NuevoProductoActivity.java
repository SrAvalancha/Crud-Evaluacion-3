package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.crud.modelo.ComprasDatabaseHelper;
import com.example.crud.modelo.ListaDeCompras;
import com.example.crud.modelo.Producto;

public class NuevoProductoActivity extends AppCompatActivity {
    //private ListaDeCompras listaDeCompras=ListaDeCompras.getInstancia();
    private ComprasDatabaseHelper helper=new ComprasDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);
    }

    public void ingresarProducto(View view)
    {
        String nombre=((EditText) findViewById(R.id.ingresarNombre)).getText().toString();
        String cantidadStr=((EditText)findViewById(R.id.ingresarCantidad)).getText().toString();
        String unidad=((Spinner)findViewById(R.id.ingresarUnidad)).getSelectedItem().toString();
        String unidadNueva=((EditText)findViewById(R.id.otraUnidad)).getText().toString();
        int cantidad=0;
        try {
            cantidad=Integer.parseInt(cantidadStr);
        }catch (NumberFormatException ex)
        {
            Toast.makeText(this, "Debe ingresar un numero en la cantidad", Toast.LENGTH_SHORT).show();
        }
        if (cantidad>0)
        {
            if (unidad.equals("Otro"))
            {
                unidad=unidadNueva;
            }
            Producto producto=new Producto(nombre,cantidad,unidad);
            helper.ingresarProducto(producto);
            //.agregarProducto(producto);
            finish();
        }
        else
        {
            Toast.makeText(this, "La cantidad debe ser mayor a cero",Toast.LENGTH_SHORT).show();
        }


    }

}