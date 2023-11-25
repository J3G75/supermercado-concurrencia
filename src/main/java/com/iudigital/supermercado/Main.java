package com.iudigital.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Esta es la clase principal del proyecto y es quien lo ejectuta
 *
 * @author juan3
 */
public class Main {

    /*
    * Atributo tipo constante
    * que define el numero de cajeras que atienden
     */
    private static final int NUM_CAJERAS = 3;

    /**
     * Metodo principal crea un objeto de tipo lista llamado clientes gestiona
     * toda la ejecucion de los hilos
     *
     * @param args
     */
    public static void main(String[] args) {

        List<ClienteProducto> clientes = new ArrayList<>();
        clientes.add(new ClienteProducto("Cliente 1", new int[]{2, 8, 9, 3, 1}));
        clientes.add(new ClienteProducto("Cliente 2", new int[]{1, 4, 3, 5, 6}));
        clientes.add(new ClienteProducto("Cliente 3", new int[]{7, 4, 3, 9, 2}));
        clientes.add(new ClienteProducto("Cliente 4", new int[]{9, 6, 3, 1, 5}));
        clientes.add(new ClienteProducto("Cliente 5", new int[]{1, 3, 7, 5, 2}));
        clientes.add(new ClienteProducto("Cliente 6", new int[]{2, 4, 6, 8, 3}));
        clientes.add(new ClienteProducto("Cliente 7", new int[]{1, 2, 3, 5, 7}));
        clientes.add(new ClienteProducto("Cliente 8", new int[]{4, 1, 2, 9, 5}));

        /*
        * Atributo para iniciar el tiempo
         */
        long init = System.currentTimeMillis();

        /*
        *
        * Fija el numero de cajeras a ejecturar
         */
        ExecutorService executor = Executors.newFixedThreadPool(NUM_CAJERAS);

        /*
        *
        * Ciclo para encolar a los cliente
        * y asignarselos a cada cajera
        *executor es quien gestiona la cola
         */
        for (ClienteProducto cliente : clientes) {
            Runnable cajera = new Cajera(cliente, init);
            executor.execute(cajera);
        }
        /*
        *Apagar el executor para que no siga preguntando
         */
        executor.shutdown();
        while (!executor.isTerminated()) {

        }

        /*
        * Atributo para finalizar el tiempo
         */
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de procesamiento: " + (fin - init) / 1000 + " Segundos");
    }

}
