package Estructuras.Conjunto;

public class ConjuntoLD implements ConjuntoDic{
    private class Nodo {
        int info;
        ConjuntoLD.Nodo sig;
    }

    private ConjuntoLD.Nodo conjunto;

    public void InicializarConjunto(){
        conjunto = null;
    }
    public int Elegir(){

        return conjunto.info;
    }
    public void Agregar(int clave){
        if(!this.Pertenece(clave)){
            ConjuntoLD.Nodo nuevo = new ConjuntoLD.Nodo();
            nuevo.info = clave;
            nuevo.sig = conjunto;
            conjunto = nuevo;
        }

    }
    public boolean Pertenece(int clave){
        ConjuntoLD.Nodo aux = conjunto;
        while (aux != null && aux.info !=clave)
            aux = aux.sig;
        return (aux != null);
    }
    public void Sacar(int clave){
        if (conjunto != null){
            if (conjunto.info == clave){ //Es el primero
                conjunto = conjunto.sig;
            }else {  //No fue el primero
                ConjuntoLD.Nodo aux = conjunto;
                while (aux.sig != null && aux.sig.info != clave){
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
