package ejercicio6profesores;

import java.time.*;

public class EJERCICIO6PROFESORES {

    public static void main(String[] args) {

        ListinProfesores lp = new ListinProfesores();

        Profesor t1 = new ProfesorTitular("Ana", "Lopez", 45, "T-100");
        Profesor i1 = new ProfesorInterino("Juan", "Perez", 32, "I-200",
                LocalDate.of(2024, 9, 1));

        lp.addProfesor(t1);
        lp.addProfesor(i1);

        lp.imprimirListin();

        System.out.println("\nTotal nómina profesorado = " + lp.importeTotalNominaProfesorado());
    }
}
