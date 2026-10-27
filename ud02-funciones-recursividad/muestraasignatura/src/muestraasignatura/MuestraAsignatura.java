package muestraasignatura;

/**
 *
 * @author DAW
 */
public class MuestraAsignatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] asignaturas;

        System.out.println("Introduce el chorizo:");
        String chorizo = System.console().readLine();

//        if (chorizo.equals("")){
//        if (chorizo.isEmpty("")){
        if (chorizo.isEmpty()) {
            System.out.println("No has introducido nada.");
        } else if (chorizo.contains(";")) {
            //System.out.println(chorizo.charAt(0));
            asignaturas = chorizo.split(";");
            for (int i = 0; i < asignaturas.length; i++) {
                System.out.println("Asignatura:" + asignaturas[i].trim());
            }
        } else {
            System.out.println("No se pudo splitear la cadena, no existe ;");
        }
    }

}
