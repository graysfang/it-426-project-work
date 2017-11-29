package registrations;

/*
 * Nicholas Perez
 * 11/17/2017
 * TestObserver.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TestObserver
{
    public static void main(String[] args)
    {

        //objects of interest
        Student kyle = new Student("Kyle");
        Student tina = new Student("Tina");

        //have a class watch or observe our students
        Registrar grcRegistrar = new Registrar();
        Teacher grcTeacher = new Teacher();

        //attach observers
        tina.addObserver(grcRegistrar);
        tina.addObserver(grcTeacher);

        tina.registerForClass("IT 426");

        //be careful with our observers
        Classroom classroom = new Classroom();
        classroom.addObserver(grcTeacher);
        classroom.startClass();


    }
}
