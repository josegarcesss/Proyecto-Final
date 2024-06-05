/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author Alakyan
 */
public class NodoArbol {
    private Animal animal;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;

    public NodoArbol(Animal animal) {
        this.animal = animal;
        this.nodoDer=null;
        this.nodoIzq=null;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    public void insertar(Animal animal){
        double puntajeNodo=(this.animal.getEntrada()+this.animal.getPiruetas())/2;
        double puntajeNuevo=(animal.getEntrada()+animal.getPiruetas())/2;
        if(puntajeNuevo <= puntajeNodo){
            //INSERTAR EN NODO IZQUIERDO
            if(this.nodoIzq == null){
                this.nodoIzq=new NodoArbol(animal);
            }else{
                this.nodoIzq.insertar(animal);
            }
        }else{
            //INSERTAR EN NODO DERECHO
            if(this.nodoDer== null){
                this.nodoDer=new NodoArbol(animal);
            }else{
                this.nodoDer.insertar(animal);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
