package com.iudigital.supermercado;

/**
 * Esta clase define la atencion de cada una de las cajeras e implementa la
 * interfaz Runnable
 *
 * @author juan3
 */
public class Cajera implements Runnable {

    /*
        *
        * Atributo cliente de la clase ClienteProducto
     */
    private ClienteProducto cliente;
    /*
        *
        * Atributo initialTime para iniciar el tiempo de los procesos
     */

    private long initialTime;

    /**
     * Metodo constructor de la clase Cajera
     *
     * @param cliente Recibe el cliente
     * @param initialTime Recibe el tiempo inicial del proceso
     */
    public Cajera(ClienteProducto cliente, long initialTime) {
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    /**
     * Metodo implementado de la clase Runnable
     */
    @Override
    public void run() {
        System.out.println("LA CAJERA No " + Thread.currentThread().getId()
                + " HA COMENZADO A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre()
                + " A LOS: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " SEGUNDOS");

        for (int i = 0; i < this.cliente.getIdProducto().length; i++) {
            // Se procesa el pedido en X segundos 
            this.esperarXsegundos(cliente.getIdProducto()[i]);
            System.out.println("Se ha procesado el producto "
                    + cliente.getIdProducto()[i]
                    +" del " + this.cliente.getNombre()
                    +"->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000
                    +" segundos");
        }

        System.out.println("LA CAJERA No " + Thread.currentThread().getId() +
                " HA TERMINADO DE PROCESAR "
                +this.cliente.getNombre() + " EN: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + " SEGUNDOS");

    }

    /*
        *
        * Metodo para que el hilo espere 1 segundo antes de la siguiente ejecucion
     */
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
