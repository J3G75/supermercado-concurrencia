package com.iudigital.supermercado;

/**
 * Esta clase se utiliza para determinar el cliente y el producto que se van a
 * procesar
 *
 * @author juan3
 */
public class ClienteProducto {

    /*
        *
        * Atributo para definir el nombre del cliente
     */
    private String nombre;

    /*
        *
        * Atributo para definir el nombre del producto
     */
    private int[] idProducto;

    /**
     * Metodo constructor
     *
     * @param nombre Nombre del cliente
     * @param idProducto Identificacion del producto
     */
    public ClienteProducto(String nombre, int[] idProducto) {
        this.nombre = nombre;
        this.idProducto = idProducto;

    }

    /**
     * Metodo que retorna el nombre del cliente
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para settear el nombre del cliente
     *
     * @param nombre Identificacion del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para retornar el id del producto
     *
     * @return
     */
    public int[] getIdProducto() {
        return idProducto;
    }

    /**
     * Metodo para settear el id del producto
     *
     * @param idProducto Identificacion del producto
     */
    public void setIdProducto(int[] idProducto) {
        this.idProducto = idProducto;
    }

}
