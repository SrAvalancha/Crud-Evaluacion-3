package com.example.crud.modelo;

import java.util.ArrayList;

public class ListaDeCompras
{
    private static ListaDeCompras instancia= new ListaDeCompras();
    private ArrayList<Producto> listaDeCompras;

    private ListaDeCompras()
    {
        listaDeCompras=new ArrayList<>();

    }
    public static ListaDeCompras getInstancia()
    {
        return instancia;
    }

    public void agregarProducto(Producto producto)
    {
        listaDeCompras.add(producto);
    }

    public Producto getProducto(int id)
    {
        return listaDeCompras.get(id);
    }

    public ArrayList<Producto> getListaDeCompras()
    {
        return listaDeCompras;
    }

    public void eliminarComprados()
    {
        for (int i=0; i<listaDeCompras.size(); i++)
        {
            if (!listaDeCompras.get(i).isEstado()==Producto.PENDIENTE)
            {
                listaDeCompras.remove(i);
                i--;
            }
        }
    }

}
