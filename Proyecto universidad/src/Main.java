import Estructuras.Cola.Cola;
import Estructuras.Cola.ColaTDA;
import Estructuras.Conjunto.ConjuntoD;
import Estructuras.Conjunto.ConjuntoDic;
import Estructuras.Conjunto.ConjuntoLD;
import Estructuras.Conjunto.ConjuntoTDA;
import Estructuras.diccionarios.DiccionarioSimpleA;
import Estructuras.diccionarios.DiccionarioSimpleTDA;
import Extras.Sounds;
import Universidad.Alumno;
import Universidad.Materia;
import Universidad.Peticion;

import java.util.Scanner;

public class Main{


    public  static void agregarAlumno(DiccionarioSimpleTDA diccionario) {
        /*
        Usuario: ADMIN
        Esta funcion pide los datos del alumno incluyendo una instancia de conjuntoD
        el cual tiene todas las materias en las que  alumno esta inscripto.El objeto alumno se agregan al
        diccionario con el id del alumno como clave y el objeto alumno como valor
        */

        Scanner scn = new Scanner(System.in);
        Alumno alumno = new Alumno();
        ConjuntoD materiasAlumno = new ConjuntoD();
        System.out.print("Ingrese el nombre del alumno: ");
        alumno.nombre = scn.nextLine();
        System.out.print("Ingrese la edad del alumno: ");
        alumno.edad = scn.nextInt();
        scn.nextLine();
        System.out.print("Ingrese el Apellido del alumno: ");
        alumno.apellido = scn.nextLine();
        alumno.listamaterias = materiasAlumno;
        System.out.println("Alumno registrado, tu id asignado es: " + alumno.idAlumno);
        diccionario.Agregar(alumno.idAlumno,alumno);
        System.out.println("Alumno creado correctamente");
    }


    public static void mostrarMaterias(ConjuntoTDA conjunto){
        /*
        Usuario: ADMIN - ALUMNO
        Esta funcion la necesitamos para que el usuario
        sepa las materias que existen y sus id para seleccionarlas

        1- Esta funcion recibe una instancia de la interfaz de conjunto la cual puede ser el de las materias existentes
        o el conjunto del objeto alumno que contiene las materias en las que el alumno está inscripto.

        2- Luego de recibir ese conjunto se crea un bucle que termina cuando el conjunto está vacío.

        3- Dentro de ese bucle se usa la funcion Elegir la cual trae el ultimo elemento.

        4- Se agrega el valor que devuelve en elegir que es otra clase de ConjuntoD para no perder los datos

        5- Utilizamos la funcion Sacar para poder elegir el elemento que esta debajo del ultimo elegido

        Esto nos deja un conjunto auxiliar que posteriormente iteramos en el segundo bucle
        para volver a llenar el conjunto inicial.
        */
        ConjuntoTDA aux = new ConjuntoD();
        while (!conjunto.ConjuntoVacio()){
            Materia materia=conjunto.Elegir();
            System.out.println(materia.IdMateria+" "+materia.materiaNombre);
            aux.Agregar(materia);
            conjunto.Sacar(materia);
            //Termina De iterar
        }

        while (!aux.ConjuntoVacio()) {
            Materia materia = aux.Elegir();
            conjunto.Agregar(materia);
            aux.Sacar(materia);
        }
    }


    public static Materia evaluarMateria(ConjuntoTDA conjunto) {
        /*
        Usuario: ADMIN - ALUMNO
        Esta funcion la utilizamos porque necesitamos
        obtener materias por un id especifico en nuestro programa.

         1- Esta funcion recibe una instancia de la interfaz de conjunto que puede ser el de las materias existentes
        o el conjunto del objeto alumno que contiene las materias en las que el alumno está inscripto.

        2- Se informa al usuario las distintas materias existentes
        dentro del conjunto proporcionado y sus id's

        3- Pedimos el dato del id de la materia que desea obtener el usuario

        4- Devolvemos una instancia del objeto materia en donde el id coincide

         Esto se realiza utilizando la interfaz del conjunto que se pasa por parametro


        */

        ConjuntoTDA aux = new ConjuntoD();
        Materia materia2 = conjunto.Elegir();
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese el id de la materia: ");
        int id = scn.nextInt();
        scn.nextLine();
        while (!conjunto.ConjuntoVacio() && id != materia2.IdMateria) {
            materia2 = conjunto.Elegir();
            aux.Agregar(materia2);
            conjunto.Sacar(materia2);
        }
        Materia materiaSolicitada = materia2;
        while (!aux.ConjuntoVacio()) {
            Materia materia3 = aux.Elegir();
            conjunto.Agregar(materia3);
            aux.Sacar(materia3);
        }

        return materiaSolicitada;
    }


    public static void quitarMateria(ConjuntoTDA conjuntoG, DiccionarioSimpleTDA diccionario){
        /*
        Usuario: ADMIN
        Esta funcion elimina materias del conjunto general de materias

        1- Recibe la interfaz del  conjunto general de materias
        y el diccionario en donde se encuentran todos los alumnos

        2-Ejecuta la funcion evaluarMateria() para obtener la materia que se desea eliminar

        3-Saca la materia del conjunto general (Usando la interfaz de la clase ConjuntoD)

        4-Itera el conjunto de claves del diccionario para buscar cuales alumnos
        estan inscriptas en la materia que se eliminó del conjunto general

        5- Cuando encuentra un alumno que está inscripto en la materia eliminada obtiene
         el conjunto de materia de ese alumno y saca la instancia de materia que
         eliminamos previamente en el conjunto general

         */
        ConjuntoDic aux = new ConjuntoLD();
        Materia materiaEliminar = evaluarMateria(conjuntoG);//Devuelve el objeto que hay que sacar
        conjuntoG.Sacar(materiaEliminar);
        ConjuntoDic conjuntoClaves = diccionario.Claves();
        while(!conjuntoClaves.ConjuntoVacio()){ //  Por cada clave
            int clave = conjuntoClaves.Elegir();
            Alumno alumno = diccionario.Recuperar(clave);
            ConjuntoD listaMaterias = alumno.listamaterias;
            listaMaterias.Sacar(materiaEliminar);
            conjuntoClaves.Sacar(clave);
            aux.Agregar(clave);
        }

    }


    public static void quitarMateriaAlumno(ConjuntoTDA conjuntoG , DiccionarioSimpleTDA diccionario, int idAlumno){
        /*
        Usuario: ADMIN - ALUMNO
        Esta funcion da de baja a un alumno de una materia.

        1-Utiliza la funcion recuperar para traer la instancia del objeto
        alumno que coincida con la id del parametro

        2-Guarda el conjunto de materias del alumno.

        3-Muestra las materias de ese conjunto con la funcion mostrarMaterias

        4-Busca la instancia del objeto materia que se desea eliminar

        5-Utiliza la funcion Sacar del conjunto dentro del alumno
         para  eliminar la instancia devuelt paso 4
        */
        Alumno alumno = diccionario.Recuperar(idAlumno);
        ConjuntoD conjuntoAlumno = alumno.listamaterias;
        mostrarMaterias(conjuntoAlumno);
        Materia materiaElimnar = evaluarMateria(conjuntoG);
        conjuntoAlumno.Sacar(materiaElimnar);
    }


    public static void inscripcion(ConjuntoTDA conjuntoG, ColaTDA colaInscripcion, int idAlumno){
        /*
        Usuario: ALUMNO
        Esta funcion agrega a los alumnos a una cola para inscribirse en una materia determinada

        1- Recibe la interfaz del conjunto general de materias,
        la interfaz de la cola de inscripciones y el id del alumno que desea inscribirse

        2- Muestra los id de las materias disponibles para inscripcion utilizando mostrarMaterias.

        3- Recibe la id de la materia elegida por el alumno

        4- Busca la instancia del objeto materia que en su id coincide con la elegida.

        5- Añade el objeto materia en la peticion.

        6- En el caso de que la materia tenga un cupo mayor a 0, se añade a la cola una peticion
        de prioridad 1, la cual debe ser correspondida por el administrador usando la funcion desacolar()
        que en la interfaz de administrador aparece como Inscribir Alumno.
        En el caso de que la materia no tenga mas cupos disponibles se añade la peticion a la cola
        con una prioridad 0.
        Los cuales se inscribiran en la funcion desacolar en orden de llegada.


        */

        Scanner scn = new Scanner(System.in);
        Peticion peticion = new Peticion();
        System.out.println("Estas son las materias disponibles: ");
        mostrarMaterias(conjuntoG);
        System.out.println("Cual es la materia que desea agregar? Coloque el ID de la materia ");
        peticion.idAlumno = idAlumno;
        Materia materia = evaluarMateria(conjuntoG);
        peticion.materiaInscripcion = materia;

        if (peticion.materiaInscripcion.cupo > 0){
            colaInscripcion.Acolar(peticion,1);
        }else{
            colaInscripcion.Acolar(peticion,0);
        }
    }


    public static void desacolar(ColaTDA colaInscripcion, DiccionarioSimpleTDA diccionarioAlumnos){// desacolarPeticion
        /*
        Usuario: ADMIN
        Esta función saca las peticiones de los alumnos en Cola y los inscribe a las materias.

        1- Evalua si la cola de inscripcion esta vacia.
        Ya que de ser así esta funcion no puede eliminar elementos de la misma.

        2- Guarda la instancia del objeto peticion encontrado en la primera posicion de la cola.

        3- De esa peticion extrae el idAlumno para recuperar la instancia del objeto
        alumno almacenado en el diccionario que coincida con la id obtenida.

        4- Extrae la instancia del objeto materia dentro de la peticion

        5- Evalua si el cupo de la materia es mayor a 0 y de ser así agrega la materia al
         conjunto de materias del alumno, resta el cupo y
         quita de la cola de inscripciones al alumno. Si no es asi quita de la cola al alumno
         y lo vuelve acolar con prioridad 0

         */
        if(!colaInscripcion.ColaVacia()){
            Peticion peticion = colaInscripcion.Primero();
            Alumno alumno = diccionarioAlumnos.Recuperar(peticion.idAlumno);
            Materia materia = peticion.materiaInscripcion;
            if (materia.cupo > 0){

                alumno.listamaterias.Agregar(materia);
                materia.cupo--;
                colaInscripcion.Desacolar();
            }
            else{
                colaInscripcion.Desacolar();
                colaInscripcion.Acolar(peticion,0);
            }
        }else{
            System.out.println("No hay alumnos en la cola de inscripción");
        }

    }


    public static void quitarAlumno(DiccionarioSimpleTDA diccionario, int clave){
        /*
        Usuario:ADMIN
        Esta funcion recibe la clave de un alumno y la interfaz de el diccionario
        en donde estan todos los alumnos y elimina el alumno que tiene esa id de la estructura
        */
       diccionario.Eliminar(clave);
       System.out.println("Alumno eliminado!");
   }


    public static void consultarMaterias(DiccionarioSimpleTDA diccionario, int idAlumno){
        /*
        Usuario:ALUMNO
        Esta funcion consulta la materia de un almuno en especifico

        1- Recibe el diccionario de los alumnos y el id del alumno

        2- Busca la instancia del objeto alumno usando la funcion de
        la interfaz de diccionario Recuperar, con la idAlumno recibida

        3- Muestra las materias de la instancia del objeto alumno con la funcion mostrarMaterias()
        */
        Alumno AlumnoSolicitud = diccionario.Recuperar(idAlumno);
        System.out.println("Las materias del alumno con la id "+idAlumno);
        mostrarMaterias(AlumnoSolicitud.listamaterias);
    }


    public static void crearMateria(ConjuntoTDA conjuntoG) {
        /*
        Usuario: ADMIN
        Esta funcion crea una instancia materia y las agregar al conjunto general de las materias

        1- Recibe el conjunto general de materias

        2- Instancia el nuevo objeto Materia

        3- Pide los datos que deberá tener la instancia del objeto Materia

        4- Modifica los atributos de la instancia por los recibidos

        5- Usa la funcion Agregar del conjunto recibido para añadir
        la instancia nueva de Materia al conjunto
        */
        Scanner scn = new Scanner(System.in);
        Materia materia = new Materia();
        System.out.print("Ingrese el nombre de la materia: ");
        materia.materiaNombre = scn.nextLine();
        System.out.print("Ingrese el horario de la materia: ");
        materia.horario = scn.nextLine();
        System.out.print("¿Es una materia intensiva? Responder(si/no)");
        String a = scn.nextLine();
        if (a.equals("si")){
            materia.MRI = true;
        } else if(a.equals("no")){
            materia.MRI = false;
        }
        System.out.print("Ingrese el cupo de la materia: ");
        materia.cupo = scn.nextInt();
        conjuntoG.Agregar(materia);
        System.out.println("Materia creada correctamente");


    }


    public static int solicitarId(){
        /*
            Usuario: ADMIN - ALUMNO
            Esta función pide un id al usuario.
            Creamos esta funcion para reutilizarla en quitarAlumno y quitarMateriaAlumno
        */
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese el ID del alumno:");
        int idAlumno = scn.nextInt();
        scn.nextLine();
        return idAlumno;
    }


    public static void inicioDeSesion(DiccionarioSimpleTDA diccionario, ConjuntoTDA conjunto, ColaTDA colaInscripcion  ){
        /*Esta funcion es el menú. Hay dos menús, el de usuario y el de admin. Cada menú tiene funciones distintas. */
        Scanner scn = new Scanner(System.in);

        System.out.println("---Bienvenido al Webcampus ---\n");
        System.out.println("Coloque su ID: ");
        String respuesta = scn.nextLine();
        ConjuntoDic conjuntoClaves= diccionario.Claves();
        if (respuesta.equals("admin")) {

            int eleccionAdmin;
            do {
                System.out.println("--|Menú Admin|--\n");
                System.out.println("1 .. Crear alumno\n");
                System.out.println("2 .. Eliminar alumno\n");
                System.out.println("3 .. Crear materia\n");
                System.out.println("4 .. Eliminar materia\n");
                System.out.println("5 .. Inscribir alumno\n");
                System.out.println("6 .. Mostrar Materias\n");
                System.out.println("7 .. Eliminar Materia Alumno\n");
                System.out.println("--Escriba 8 para salir--\n");
                eleccionAdmin = scn.nextInt();
                scn.nextLine();

                switch (eleccionAdmin) {
                    case 1 -> agregarAlumno(diccionario);
                    case 2 -> {
                        int id_ = solicitarId();
                        quitarAlumno(diccionario, id_);
                    }
                    case 3 -> crearMateria(conjunto);
                    case 4 -> quitarMateria(conjunto, diccionario);
                    case 5 -> desacolar(colaInscripcion, diccionario);
                    case 6 -> mostrarMaterias(conjunto);
                    case 7 -> {
                        int id = solicitarId();
                        quitarMateriaAlumno(conjunto, diccionario, id);
                    }
                }

            }
            while (eleccionAdmin > 0 && eleccionAdmin < 8);


        }else {
            int idAlumno = Integer.parseInt(respuesta);
            if (conjuntoClaves.Pertenece(idAlumno)){
                Alumno alumno = diccionario.Recuperar(idAlumno);
                int eleccionAlumno;
               do{
                    System.out.println("--|Menú Alumno|--\n");
                    System.out.println("1 .. Mostrar mis materias\n");
                    System.out.println("2 .. Inscribirse en materia\n");
                    System.out.println("3 .. Desinscribirse en materia\n");
                   System.out.println("-- Pulse 4 para salir --\n");

                    eleccionAlumno = scn.nextInt();
                    scn.nextLine();
                   switch (eleccionAlumno) {
                       case 1 -> consultarMaterias(diccionario, alumno.idAlumno);
                       case 2 -> inscripcion(conjunto, colaInscripcion, idAlumno);
                       case 3 -> quitarMateriaAlumno(conjunto, diccionario, idAlumno);
                   }
                }while (eleccionAlumno > 0 && eleccionAlumno < 4);

            }
    }

    }


    public static void main(String[] args) {
        DiccionarioSimpleA diccionario = new DiccionarioSimpleA();
        ColaTDA colaInscripcion = new Cola();
        ConjuntoTDA conjuntoG = new ConjuntoD();

        diccionario.InicializarDiccionario();
        colaInscripcion.InicializarCola();
        conjuntoG.InicializarConjunto();
        Sounds reproductor = new Sounds();
        reproductor.reproducirSonido();

        int eleccion;
        do {
            inicioDeSesion(diccionario, conjuntoG, colaInscripcion);
            System.out.println("Desea Apagar el Sistema ? \n 1-SI \n 2-NO");
            Scanner scn = new Scanner(System.in);
            eleccion = scn.nextInt();
            scn.nextLine();
        }
        while (eleccion != 1);
        reproductor.reproducirSonido2();

    }
}
