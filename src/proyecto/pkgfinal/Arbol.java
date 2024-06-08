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
    private Animal animalE;
    private Animal animalProfundo;
    private int pMaxima;

    public Arbol() {
        this.raiz = null;
    }
    
     public void insertar(Animal animal){
        if(this.raiz==null){
            this.raiz=new NodoArbol(animal);
        }else{
           this.raiz.insertar(animal);
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
    
    private void posOrden(NodoArbol nodo,String nombreAnimal){
        if(nodo==null){
            return;
        }else{
        posOrden(nodo.getNodoIzq(),nombreAnimal);
        posOrden(nodo.getNodoDer(),nombreAnimal);
        if(nodo.getAnimal().getRaza().equalsIgnoreCase(nombreAnimal)){
            animalE=nodo.getAnimal();
        }
        }
    }

    public Animal buscarAnimalPosOrden(String nombreAnimalbuscar) {
        posOrden(this.raiz, nombreAnimalbuscar);
        Animal encontrado=animalE;
        this.animalE=null;
        return encontrado;
    }
    
    
    
    public String determinarGanador(String nombre1, String nombre2){
        Animal animal1= buscarAnimalPosOrden(nombre1);
        Animal animal2= buscarAnimalPosOrden(nombre2);
        
        if(animal1==null || animal2==null){
             return "uno o ambos animales no se encontraron";
        }else{
            double puntaje1=(animal1.getEntrada()+animal1.getPiruetas())/2;
            double puntaje2=(animal2.getEntrada()+animal2.getPiruetas())/2;
            System.out.println(animal1);
            System.out.println(animal2);
            if(puntaje1>puntaje2){
                return (animal1.getRaza()+" gana por: "+(puntaje1-puntaje2));
            }else if(puntaje1<puntaje2){
                return (animal2.getRaza()+" gana por: "+(puntaje2-puntaje1));
            }else{
                return("Empataron con: "+puntaje2);
            }  
        }
    }
    
    public boolean min2Animales(){
        return(this.raiz!=null && (this.raiz.getNodoDer()!=null || this.raiz.getNodoIzq()!=null));
    }
    
    
    public Animal obtenerAnimalMaxProfundidad() {
        calcularProfundidad(raiz, 0);
        Animal encontrado=animalProfundo;
        return encontrado;
    }

    private int calcularProfundidad(NodoArbol nodo, int profundidad) {
        if (nodo == null) {
            return profundidad;
        } else {
            int profundidadIzquierda = calcularProfundidad(nodo.getNodoIzq(), profundidad + 1);
            int profundidadDerecha = calcularProfundidad(nodo.getNodoDer(), profundidad + 1);

            if (profundidadIzquierda > profundidadDerecha && profundidadIzquierda > pMaxima) {
                pMaxima = profundidadIzquierda;
                animalProfundo = nodo.getAnimal();
            } else if (profundidadDerecha > pMaxima) {
                pMaxima = profundidadDerecha;
                animalProfundo = nodo.getAnimal();
            }

            return Math.max(profundidadIzquierda, profundidadDerecha);
        }
    }

    
    
    

}
