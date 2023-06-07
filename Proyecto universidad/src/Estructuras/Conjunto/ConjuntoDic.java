package Estructuras.Conjunto;

public interface ConjuntoDic {
    void InicializarConjunto();
    void Agregar(int clave);
    int Elegir();
    boolean ConjuntoVacio();
    void Sacar(int clave);
    boolean Pertenece(int clave);
}

