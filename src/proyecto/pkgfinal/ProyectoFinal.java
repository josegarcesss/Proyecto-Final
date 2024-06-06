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
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> maquina=new ArrayList<>();
        String nombreAnimal,nombreMaquina,nombreAnimal2;
        Arbol arbol=new Arbol();
        int op=-1,puntaje;
        while(op!=5){
            System.out.println("--------------------------------------------------");
            System.out.println("-----------------------MENU-----------------------");
            System.out.println("<1> INSERTAR ANIMAL");
            System.out.println("<2> JUGAR CONTA MAQUINA");
            System.out.println("<3> JUGAR 2 JUGADORES");
            System.out.println("<4> ENCONTRAR EL ANIMAL CON MAYOR PROFUNDIDAD");
            System.out.println("<5> SALIR");
            System.out.println("--------------------------------------------------");
            System.out.print("SELECCIONE UNA OPCION: ");
            op=sc.nextInt();
            sc.nextLine();
            
            switch(op){
                
                case 1:
                    arbol.listarInOrden();
                    System.out.println("Ingrese Raza del animal que no esté en la Lista: ");
                    do{
                    nombreAnimal=sc.nextLine();
                    }while(arbol.buscarXRaza(nombreAnimal)!="-1");
                    Animal animal=new Animal(nombreAnimal);
                    System.out.println("Puntaje de Entrada:");
                    do{
                    puntaje=sc.nextInt();
                    if(puntaje<1 || puntaje>10){
                        System.out.println("ELIJA UN PUNTAJE DEL 1 AL 10");
                    }
                    }while(puntaje<1 || puntaje>10);
                    animal.setEntrada(puntaje);
                    System.out.println("Puntaje de Pirueta:");
                    do{
                    puntaje=sc.nextInt();
                    if(puntaje<1 || puntaje>10){
                        System.out.println("ELIJA UN PUNTAJE DEL 1 AL 10");
                    }
                    }while(puntaje<1 || puntaje>10);
                    animal.setPiruetas(puntaje);
                    maquina.add(nombreAnimal);
                    arbol.insertar(animal);
                    break;
                case 2:
                     if(!maquina.isEmpty()){
                        System.out.println("");
                    arbol.listarInOrden();
                    System.out.println("Ingrese Raza del animal Seleccionado: ");
                    do{
                    nombreAnimal=sc.nextLine();
                    }while(arbol.buscarXRaza(nombreAnimal).equalsIgnoreCase(nombreAnimal));
                        
                    maquina.remove(nombreAnimal);                        
                        if(!maquina.isEmpty()){
                            do{
                            Random random = new Random();
                            nombreMaquina=maquina.get(random.nextInt(maquina.size()));
                            }while(nombreMaquina.equalsIgnoreCase(nombreAnimal));
                            System.out.println("La maquina ha elegido al animal: " + nombreMaquina);
                            
                            System.out.println("el ganador es:" + arbol.determinarGanador(nombreAnimal, nombreMaquina));
                        }else{
                            System.out.println("No quedan animales para la maquina");
                        }
                    }else{
                         System.out.println("El Arbol está Vacio, Ingrese Animales Primero!");
                     }
                     break;
                
                case 3:     
              if(!maquina.isEmpty()){
                        System.out.println("");
                    arbol.listarInOrden();
                    System.out.println("Ingrese Raza del animal Seleccionado: ");
                    do{
                    nombreAnimal=sc.nextLine();
                    }while(arbol.buscarXRaza(nombreAnimal).equalsIgnoreCase(nombreAnimal));
                        System.out.println("Ingrese Raza del animal Seleccionado: ");
                    do{
                    nombreAnimal2=sc.nextLine();
                    }while(arbol.buscarXRaza(nombreAnimal2).equalsIgnoreCase(nombreAnimal2) && nombreAnimal2.equalsIgnoreCase(nombreAnimal));
            System.out.println("el ganador es:" + arbol.determinarGanador(nombreAnimal, nombreAnimal2));
                       
                    }else{
                         System.out.println("El Arbol está Vacio, Ingrese Animales Primero!");
                     }
                     break;
            
                case 4:
                    if(arbol.iniciarProfundidadPreOrden()==-1){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("el animal con mayor profundidad es: \n"+arbol.animalProfundidadPostOrden());
                    }
            break;
            
                case 5:
                    System.out.println("Gracias por jugar!!!!");
                    
            }
            
            
        }
        
        
       }

}
