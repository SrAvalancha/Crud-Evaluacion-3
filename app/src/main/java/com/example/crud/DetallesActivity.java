package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crud.R;
import com.example.crud.modelo.ComprasDatabaseHelper;
import com.example.crud.modelo.ListaDeCompras;
import com.example.crud.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {

    public Producto producto;
    public Intent intent;
    public ComprasDatabaseHelper helper=new ComprasDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();
        String nombreProducto=(String) intent.getExtras().get("nombreProducto");
        producto= helper.getProducto(nombreProducto);
        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        TextView txtUnidad=(TextView) findViewById(R.id.txtUnidad);
        txtUnidad.setText(producto.getCantidad() + " "+ producto.getUnidad());

        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button cambiar=(Button) findViewById(R.id.estado);

        if (producto.isEstado()==Producto.PENDIENTE)
        {
            txtEstado.setText("Pendiente");
            cambiar.setText("Marcar como Comprado");
        }
        else
        {
            txtEstado.setText("Comprado");
            cambiar.setText("Marcar como Pendiente");
        }

    }
    public void cambiarEstado(View view)
    {
        producto.setEstado(!producto.isEstado());
        String mensaje= helper.cambiarEstado(producto);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, intent);
        finish();
    }
}