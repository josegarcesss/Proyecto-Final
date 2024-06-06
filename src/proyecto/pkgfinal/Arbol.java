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
    
    public int iniciarProfundidadPreOrden(){
        int longitudCamino=0;
        preOrden(this.raiz, longitudCamino);
        longitudCamino=profundidad;
        profundidad=-1;
        return longitudCamino;
    }
    
    
    private void preOrden(NodoArbol nodo,int longitudCamino){
        if(nodo==null){
            return;
        }else{
           this.profundidad=longitudCamino;      
           longitudCamino++;
            preOrden(nodo.getNodoIzq(),longitudCamino);
            preOrden(nodo.getNodoDer(),longitudCamino);
        }
    }
    
    
    
    //LISTAR EN INORDEN LOS ANIMALES PARTICIPANTES
    public void listarInOrden(){
        inOrden(this.raiz);
    }
    private void inOrden(NodoArbol nodo){
        if(nodo==null){
            return;
        }else{
            inOrden(nodo.getNodoIzq());
            System.out.println(nodo.getAnimal().getRaza());     
            inOrden(nodo.getNodoDer());
        }
    }
    
    
    public String buscarXRaza(String nombreABuscar){
        NodoArbol nodoEncontrado=buscar(this.raiz,nombreABuscar);
        return nodoEncontrado.getAnimal().getRaza();
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
        return nodo1.getAnimal().getRaza()+ "gana con un puntaje de: " + puntaje1;
    }else if(puntaje2>puntaje1){
        return nodo2.getAnimal().getRaza() + "gana con un puntaje de: " + puntaje2;
    }else{
        return "Se empato con puntaje:"+puntaje1;
    }
    
    }
    
    
    
    
    
    
    
    
    
}
