/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author Alakyan
 */
public class Arbol {
    private NodoArbol raiz;
    private int profundidad;

    public Arbol() {
        this.raiz = null;
        this.profundidad=-1;
    }
    
    public void insertar(Animal animal){
        if(this.raiz==null){
            this.raiz=new NodoArbol(animal);
        }else{
           this.raiz.insertar(animal);
        }
                
    }
    
    public int iniciarPreOrden(String animal){
        int longitudCamino=0;
        preOrden(this.raiz, longitudCamino,animal);
        longitudCamino=profundidad;
        profundidad=-1;
        return longitudCamino;
    }
    
    
    private void preOrden(NodoArbol nodo,int longitudCamino,String animal){
        if(nodo==null){
            return;
        }else{
            if(nodo.getAnimal().getRaza().equalsIgnoreCase(animal)){
                this.profundidad=longitudCamino;
            }else{  
           longitudCamino++;
            preOrden(nodo.getNodoIzq(),longitudCamino,animal);
            preOrden(nodo.getNodoDer(),longitudCamino,animal);
        }
        }
    }
    
    
    
    
    private NodoArbol buscar(NodoArbol actual, String nombre){
        
        if (actual == null){
        return null;    
        }
       
        if (actual.getAnimal().getRaza().equalsIgnoreCase(nombre)){
            return actual;
        }
        
        NodoArbol encontrado = buscar(actual.getNodoIzq(),nombre);
        if(encontrado ==null){
            encontrado = buscar(actual.getNodoDer(),nombre);
        }
        return encontrado;
    }
    
    public String determinarGanador(String nombre1, String nombre2){
        NodoArbol nodo1=buscar(raiz, nombre1);
        NodoArbol nodo2=buscar(raiz, nombre2);
        
        if(nodo1==null || nodo2==null){
        return "uno o ambos animales no se encontraron";
    }
        
        double puntaje1=(nodo1.getAnimal().getEntrada() + nodo1.getAnimal().getPiruetas())/2;
        double puntaje2=(nodo2.getAnimal().getEntrada() + nodo2.getAnimal().getPiruetas())/2;
    
    if(puntaje1>puntaje2){
        return nodo1.getAnimal().getRaza();
    }else if(puntaje2>puntaje1){
        return nodo2.getAnimal().getRaza();
    }else{
        return "Se empato con puntaje:"+puntaje1;
    }
    
    }
    
    
    
    
    
    
    
    
    
}
