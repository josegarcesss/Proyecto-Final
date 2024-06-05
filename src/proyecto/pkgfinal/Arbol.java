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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
