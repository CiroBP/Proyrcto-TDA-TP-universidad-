package Universidad;

import Estructuras.Conjunto.ConjuntoD;
import Estructuras.Conjunto.ConjuntoTDA;

public class Alumno {
    public static int nextIdAlumno = 001;
    public int idAlumno;
    public String nombre;
    public String apellido;
    public int edad;
    public ConjuntoD listamaterias;


    public Alumno() {
        idAlumno = nextIdAlumno;
        nextIdAlumno++;

    }



}
