package Estructuras.diccionarios;

import Estructuras.Conjunto.ConjuntoDic;
import Universidad.Alumno;

public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void Agregar(int clave,Alumno valor);
    void Eliminar(int clave);
    Alumno Recuperar(int clave);
    ConjuntoDic Claves();

}


