package Estructuras.Cola;

import Estructuras.Conjunto.ConjuntoD;
import Universidad.Peticion;

public interface ColaTDA {
    void InicializarCola();
    void Acolar(Peticion x,int prioridad);
    void Desacolar();
    boolean ColaVacia();
    Peticion Primero();

}
