package Estructuras.Cola;

import Estructuras.Conjunto.ConjuntoD;
import Universidad.Alumno;
import Universidad.Materia;
import Universidad.Peticion;

public class Cola implements Estructuras.Cola.ColaTDA{
    class Nodo{
        Peticion info;
        int prioridad;
        Nodo sig;
    }

    Nodo primero;

    public void InicializarCola(){
        primero = null;
    }
    public void Acolar(Peticion  x,int prioridad) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.prioridad=prioridad;
        nuevo.sig = null;
        if (primero == null || primero.prioridad < prioridad) {
            nuevo.sig = primero;
            primero = nuevo;
        }else{
            Nodo aux = primero;
            while(aux.sig != null && aux.sig.prioridad > prioridad){
                aux = aux.sig;
            }
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }

    }
    public void Desacolar() {
        primero = primero.sig;
    }
    public boolean ColaVacia() {
        return (primero == null);
    }
    public Peticion Primero(){
        return primero.info;
    }
    public int Prioridad(){
        return primero.prioridad;
    }
}
