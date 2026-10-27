package ejercicio6profesores;

import java.util.ArrayList;

public class ListinProfesores {

    private ArrayList<Profesor> listin = new ArrayList<>();

    public void addProfesor(Profesor p) {
        listin.add(p);
    }

    public void imprimirListin() {
        System.out.println("\n--- LISTIN PROFESORES ---");
        if (listin.isEmpty()) {
            System.out.println("(vacio)");
            return;
        }

        for (Profesor p : listin) {
            if (p instanceof ProfesorInterino) {
                System.out.println("TIPO: INTERINO -> " + p);
            } else if (p instanceof ProfesorTitular) {
                System.out.println("TIPO: TITULAR -> " + p);
            } else {
                System.out.println("TIPO: PROFESOR -> " + p);
            }
        }
    }

    public float importeTotalNominaProfesorado() {
        float total = 0f;
        for (Profesor p : listin) {
            total += p.importeNomina(); // lo delpolimorfismo +  lo der método abstracto
        }
        return total;
    }
}
