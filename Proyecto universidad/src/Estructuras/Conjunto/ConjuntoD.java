package Estructuras.Conjunto;
import Universidad.Materia;

public class ConjuntoD implements ConjuntoTDA {
    private class Nodo {
        Materia info;
        Nodo sig;
    }

    private  Nodo conjunto;

    public void InicializarConjunto(){
        conjunto = null;

    }
    public Materia Elegir(){

        return conjunto.info;
    }
    public void Agregar(Materia x){
        if(!this.Pertenece(x)){
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = conjunto;
            conjunto = nuevo;
        }

    }
    public boolean Pertenece(Materia x){
        Nodo aux = conjunto;
        while (aux != null && aux.info !=x)
            aux = aux.sig;
        return (aux != null);
    }
    public void Sacar(Materia m){
        if (conjunto != null){
            if (conjunto.info.equals(m)){ //Es el primero
                conjunto = conjunto.sig;
            }else {  //No fue el primero
                Nodo aux = conjunto;
                while (aux.sig != null && !aux.sig.info.equals(m)){
                    aux = aux.sig;
                }
                if (aux.sig!=null) { //Encuentra
                    aux.sig = aux.sig.sig;
                }
            }
        }

    }
    public boolean ConjuntoVacio(){
        return (conjunto==null);
    }
}
