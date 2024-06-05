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
        Scanner sc=new Scanner(System.in);
        ArrayList<String> maquina=new ArrayList<>();
        String nombreAnimal;
        Arbol arbol=new Arbol();
        int op=-1,puntaje;
        
        while(op!=6){
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
            
            
            switch(op){
                case 1:
                    arbol.listarInOrden();
                    System.out.println("Ingrese Raza del animal que no esté en la Lista: ");
                    do{
                    nombreAnimal=sc.nextLine();
                    }while(!arbol.buscarXRaza(nombreAnimal).equalsIgnoreCase(nombreAnimal));
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
                    Random random=new Random();
                    do{
                        
                        
//                        int num=random.nextInt(maquina.size()-1);
//                    Animal animalMaquina=maquina.get(num);
                    

                    }while(nombreAnimal.equalsIgnoreCase(animalMaquina));
                    
                    
                    
                    
                    }else{
                         System.out.println("El Arbol está Vacio, Ingrese Animales Primero!");
                     }
                    
                    
            }
            
            
        }
        
        
        
    

    }

}
