package nodosr;

import java.util.Scanner;

public class NodosR {

    public static class Nodo {

        int numero;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(int numero) {
            this.numero = numero;
            izquierdo = null;
            derecho = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de nodos: ");
        int cantidadNodos = scanner.nextInt();

        System.out.println("Ingrese los valores de los nodos:");

        Nodo raiz = null;
        for (int i = 0; i < cantidadNodos; i++) {
            int valor = scanner.nextInt();
            raiz = insertar(raiz, valor);
        }

        System.out.println("Recorrido Enorden:");
        recorridoEnorden(raiz);
        System.out.println();

        System.out.println("Recorrido Posorden:");
        recorridoPosorden(raiz);
        System.out.println();

        System.out.println("Recorrido Preorden:");
        recorridoPreorden(raiz);
        System.out.println();
    }

    private static Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.numero) {
            raiz.izquierdo = insertar(raiz.izquierdo, valor);
        } else if (valor > raiz.numero) {
            raiz.derecho = insertar(raiz.derecho, valor);
        }

        return raiz;
    }

    private static void recorridoPosorden(Nodo nodo) {
        if (nodo != null) {
            recorridoPosorden(nodo.izquierdo);
            recorridoPosorden(nodo.derecho);
            System.out.print(nodo.numero + " ");
        }
    }

    private static void recorridoEnorden(Nodo nodo) {
        if (nodo != null) {
            recorridoEnorden(nodo.izquierdo);
            System.out.print(nodo.numero + " ");
            recorridoEnorden(nodo.derecho);
        }
    }

    private static void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.numero + " ");
            recorridoPreorden(nodo.izquierdo);
            recorridoPreorden(nodo.derecho);
        }
    }

}
