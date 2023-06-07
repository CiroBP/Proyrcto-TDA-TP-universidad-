package Universidad;


public class Materia {
    public static int nextId = 1;
    public int IdMateria;
    public int cupo;
    public String materiaNombre;
    public String horario;
    public boolean MRI;


    public Materia() {
        IdMateria = nextId;
        nextId++;

    }
}