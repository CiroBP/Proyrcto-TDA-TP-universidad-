package Estructuras.diccionarios;

import Estructuras.Conjunto.ConjuntoDic;
import Estructuras.Conjunto.ConjuntoLD;
import Universidad.Alumno;


public class DiccionarioSimpleA implements DiccionarioSimpleTDA{
    public class NodoClave{
        int clave;
        Alumno valor;
        NodoClave sigClave;
    }

    public NodoClave diccionario;

    public NodoClave Clave2NodoClave(int clave){
        NodoClave aux = diccionario; // Nodo Viajero para no perder dato
        while (aux != null && aux.clave != clave)
            aux=aux.sigClave;
        return aux;
    }

    public void InicializarDiccionario() {
        diccionario = null;
    }
    public void Agregar(int clave, Alumno valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null){
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = diccionario;
            diccionario = nc;
        }
        nc.valor = valor;
    }

    public void Eliminar(int clave) {
        if (diccionario != null){
            if (diccionario.clave == clave){
                diccionario = diccionario.sigClave;
            }else{
                NodoClave aux = diccionario;
                while (aux.sigClave!=null && aux.sigClave.clave != clave)
                    aux = aux.sigClave;
                if (aux.sigClave != null)
                    aux.sigClave= aux.sigClave.sigClave;
            }
        }
    }

    public Alumno Recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        return nc.valor;
    }

    public ConjuntoDic Claves() {
        ConjuntoDic c = new ConjuntoLD();
        c.InicializarConjunto();
        NodoClave aux = diccionario;
        while (aux != null){
            c.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }

}





