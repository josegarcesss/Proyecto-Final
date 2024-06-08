/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkgfinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProyectoFinal {
    //@param args the command line arguments

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Animal> maquina = new ArrayList<>();
        String nombreAnimal1, nombreMaquina, nombreAnimal2;
        Arbol arbol = new Arbol();
        int op = -1, puntaje;

        //SECTOR DE PRUEBAS
        for (int i = 1; i <= 10; i++) {
            Animal animal = new Animal("perro" + i);
            animal.setEntrada(i);
            animal.setPiruetas(i);
            arbol.insertar(animal);
            maquina.add(animal);
        }

        while (op != 5) {
            System.out.println("--------------------------------------------------");
            System.out.println("-----------------------MENU-----------------------");
            System.out.println("<1> INSERTAR ANIMAL");
            System.out.println("<2> JUGAR CONTA MAQUINA");
            System.out.println("<3> JUGAR 2 JUGADORES");
            System.out.println("<4> ENCONTRAR EL ANIMAL CON MAYOR PROFUNDIDAD");
            System.out.println("<5> SALIR");
            System.out.println("--------------------------------------------------");
            System.out.print("SELECCIONE UNA OPCION: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    arbol.listarInOrden();
                    System.out.println("Ingrese Raza del animal que no esté en la Lista: ");
                    do {
                        nombreAnimal1 = sc.nextLine();
                    } while (arbol.buscarAnimalPosOrden(nombreAnimal1) != null);
                    Animal animal = new Animal(nombreAnimal1);
                    System.out.println("Puntaje de Entrada:");
                    do {
                        puntaje = sc.nextInt();
                        if (puntaje < 1 || puntaje > 10) {
                            System.out.println("ELIJA UN PUNTAJE DEL 1 AL 10");
                        }
                    } while (puntaje < 1 || puntaje > 10);
                    animal.setEntrada(puntaje);
                    System.out.println("Puntaje de Pirueta:");
                    do {
                        puntaje = sc.nextInt();
                        if (puntaje < 1 || puntaje > 10) {
                            System.out.println("ELIJA UN PUNTAJE DEL 1 AL 10");
                        }
                    } while (puntaje < 1 || puntaje > 10);
                    animal.setPiruetas(puntaje);
                    maquina.add(animal);
                    arbol.insertar(animal);
                    break;
                case 2:
                    if (arbol.min2Animales()) {
                        System.out.println("");
                        arbol.listarInOrden();
                        System.out.println("Ingrese Raza del animal Seleccionado: ");
                        do {
                            nombreAnimal1 = sc.nextLine();
                        } while (arbol.buscarAnimalPosOrden(nombreAnimal1) == null);
                        if (arbol.min2Animales()) {
                            do {
                                Random random = new Random();
                            nombreMaquina=maquina.get(random.nextInt(maquina.size())).getRaza();
                            } while (nombreMaquina.equalsIgnoreCase(nombreAnimal1));
                            System.out.println("La maquina ha elegido al animal: " + nombreMaquina);

                            System.out.println(arbol.determinarGanador(nombreAnimal1, nombreMaquina));
                        } else {
                            System.out.println("No quedan animales para la maquina");
                        }
                    } else {
                        System.out.println("El Arbol está Vacio, Ingrese Animales Primero!");
                    }
                    break;

                case 3:
                    if (arbol.min2Animales()) {
                        System.out.println("");
                        arbol.listarInOrden();
                        System.out.println("[JUGADOR 1] - Ingrese Raza del animal Seleccionado: ");
                        do {
                            nombreAnimal1 = sc.nextLine();
                        } while (arbol.buscarAnimalPosOrden(nombreAnimal1) == null);
                        System.out.println("[JUGADOR 2] - Ingrese Raza del animal Seleccionado: ");
                        do {
                            nombreAnimal2 = sc.nextLine();
                        } while (arbol.buscarAnimalPosOrden(nombreAnimal2) == null || nombreAnimal2.equalsIgnoreCase(nombreAnimal1));
                        System.out.println("el ganador es:" + arbol.determinarGanador(nombreAnimal1, nombreAnimal2));
                    } else {
                        System.out.println("El Arbol está Vacio, Ingrese Animales Primero!");
                    }
                    break;

                case 4:
                    System.out.println("el animal con mayor profundidad es: \n" + arbol.obtenerAnimalMaxProfundidad());

                    break;

                case 5:
                    System.out.println("Gracias por jugar!!!!");

            }

        }

    }

}
