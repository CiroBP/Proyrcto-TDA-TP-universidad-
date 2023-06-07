package Estructuras.Conjunto;

import Universidad.Materia;

public interface ConjuntoTDA {
    void InicializarConjunto();
    void Agregar(Materia x);
    Materia Elegir();
    boolean ConjuntoVacio();
    void Sacar(Materia x);
    boolean Pertenece(Materia x);
}

