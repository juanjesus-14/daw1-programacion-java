package mainseleccionfutbol;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author DAW
 */
public class MainSeleccionFutbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        LinkedList<SeleccionFutbol> listaSeleccion = new LinkedList<>();
        int id = 0;

//        // Formato de fecha : dd/MM/yyyy
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//        System.out.println("Introduce la fecha de nacimiento (formato dd/MM/yyyy)");
//        String fechaN = System.console().readLine();
//        Date fechaNac = new Date();
//
//        try {
//            fechaNac = sdf.parse(fechaN);
//
//            Entrenador e1 = new Entrenador("España", 1, "Luis", "De la fuente", fechaNac);
//            System.out.println(e1);
//
//        } catch (Exception e) {
//            System.out.println("Introduce correctamente la variable.");
//        }
//
        ////        // Alta de Futbolista1
//        System.out.println("Dime la posicion del jugador: ");
//        String posic = System.console().readLine().toLowerCase();
//
//        Posicion ps = Posicion.portero;

// LocalDate: representa a fechas sin la hora y nos facilita su manejo para declararlas, sumar y restar fechas y compararlas.
// LocalTime: es idéntica a la anterior pero para el manejo de horas, sin ninguna fecha asociada, pudiendo así compararlas, sumar o restar tiempo a las mismas...
// LocalDateTime: como puedes suponer, es una combinación de las dos anteriores, que permite hacer lo mismo con fechas y horas simultáneamente.
// Instant: es muy parecida a la anterior pero a la vez muy diferente. Se usa para almacenar un punto determinado en el tiempo, o sea con fecha y hora, pero guarda su valor como un timestamp de UNIX, es decir, en nanosegundos desde el epoch de UNIX (1/1/1970 a las 00:00) y usando la zona horaria UTC. Es muy útil para manejar momentos en el tiempo de manera neutra e intercambiarlo entre aplicaciones y sistemas, por lo que lo verás utilizado muy a menudo.
// ZonedDateTime: esta clase es como la LocalDateTime pero teniendo en cuenta una zona horaria concreta, ya que las anteriores no la tienen en cuenta.
// Period: esta clase auxiliar nos ayuda a obtener diferencias entre fechas en distintos periodos (segundos, minutos, días...) y también a añadir esas diferencias a las fechas.
// Duration: esta es muy parecida a la anterior pero para manejo de horas exclusivamente.



//        try {
//            ps = Posicion.valueOf(posic);
//        } catch (IllegalArgumentException e) {
//            System.out.println("La posicion es incorrecta");
//        }
//
//        try {
//            fechaNac = sdf.parse("15/09/1995");
//
//            Futbolista f1 = new Futbolista(1, ps, 2, "David", "Raya", fechaNac);
//            System.out.println(f1);
//
//        } catch (ParseException e) {
//            System.out.println("Introduce correctamente la variable.");
//        }

//        // Alta de Futbolista2 (En vez de demarcacion como el profe yo uso poscicion)
//        System.out.println("Dime la demaración del jugador: ");
//        String demarc = System.console().readLine().toLowerCase();
//        
//        Demarcacion dm = Demarcacion.portero;
//        
//        try{
//            dm = Demarcacion.valueOf(demarc);
//        
//            Date fechaNac = sdf.parse("15/09/1995");
//            
//            Futbolista f1 = new Futbolista(1, dm, 2, "David", "Raya",  fechaNac);
//            System.out.println(f1);           
//        } catch (IllegalArgumentException ie){
//            System.out.println("Demarcación introducida no es correcta.");
//        } catch (ParseException e){
//            System.out.println("Introduce correctamente la variable.");
//        } catch (Exception e){
//            System.out.println("Se ha producido un error, revise todos los datos.");
//        }
        // Menú del proyecto: Alta (incluye submenú para alta de futbolista, entrenador y masajista), 
        // Baja (realizada a través del id, con lo cual hay que presentar una lista incluyendo el id).
        // Listar selección (submenu que permita mostrar todos, mostrar futbolistas, o entrenadores, o masajistas).
        //Nota creamos una funcion para cada opcion alta baja y listar.
        String opcion;
        boolean terminar = false;

        do {
            System.out.println("-- MENÚ --");
            System.out.println("Pulsa 1 para alta, 2 para baja, 3 para listar y escribe salir para terminar");
            opcion = System.console().readLine();

            if (opcion.equalsIgnoreCase("salir")) {
                terminar = true;
            } else {
                try {
                    int op = Integer.parseInt(opcion);

                    switch (op) {

                        // --- ALTA ---
                        case 1:
                            System.out.println("Pulsa 1 Futbolista, 2 Entrenador, 3 Masajista");
                            int nuevaPersona = obtenNumeroEntero(System.console().readLine());
                            id++;

                            System.out.println("Nombre:");
                            String nombre = System.console().readLine();
                            System.out.println("Apellidos:");
                            String apellidos = System.console().readLine();
                            System.out.println("Fecha nacimiento (dd/MM/yyyy):");
                            Date fecha = obtenFecha(System.console().readLine());

                            if (nuevaPersona == 1) {
                                System.out.println("Dorsal:");
                                int dorsal = obtenNumeroEntero(System.console().readLine());
                                System.out.println("Posición:");
                                Posicion pos = Posicion.valueOf(System.console().readLine().toLowerCase());
                                listaSeleccion.add(new Futbolista(id, pos, dorsal, nombre, apellidos, fecha));

                            } else if (nuevaPersona == 2) {
                                System.out.println("País:");
                                String pais = System.console().readLine();
                                listaSeleccion.add(new Entrenador(pais, id, nombre, apellidos, fecha));

                            } else if (nuevaPersona == 3) {
                                System.out.println("Titulación:");
                                String titulacion = System.console().readLine();
                                System.out.println("Años experiencia:");
                                int aniosExperiencia = obtenNumeroEntero(System.console().readLine());
                                listaSeleccion.add(new Masajista(titulacion, aniosExperiencia, id, nombre, apellidos, fecha));
                            }
                            break;

                        // --- BAJA ---
                        case 2:
                            System.out.println("Introduce el ID a eliminar:");
                            int idElim = obtenNumeroEntero(System.console().readLine());
                            boolean eliminado = false;

                            for (int i = 0; i < listaSeleccion.size(); i++) {
                                if (listaSeleccion.get(i).getID() == idElim) {
                                    listaSeleccion.remove(i);
                                    eliminado = true;
                                    System.out.println("Integrante eliminado.");
                                    break;
                                }
                            }

                            if (!eliminado) {
                                System.out.println("No existe ese ID.");
                            }
                            break;

                        // --- LISTAR ---
                        case 3:
                            System.out.println("Pulsa 1 Todos, 2 Futbolistas, 3 Entrenadores, 4 Masajistas");
                            int modo = obtenNumeroEntero(System.console().readLine());

                            for (SeleccionFutbol s : listaSeleccion) {
                                if (modo == 1 || s.getTipoPersona() == modo) {
                                    System.out.println("\n" + s);
                                }
                            }
                            break;

                        default:
                            System.out.println("Opción incorrecta.");
                    }

                } catch (Exception e) {
                    System.out.println("Introduce un valor válido.");
                }
            }

        } while (!terminar);
    }

    public static Date obtenFecha(String texto) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    fecha = sdf.parse(texto);
                } else {
                    correcto = true;
                    fecha = sdf.parse(System.console().readLine());
                }
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto.");
                correcto = false;
            }
        } while (!correcto);
        return fecha;
    }

    public static void bajaIntegrante(int id, LinkedList<SeleccionFutbol> listaSeleccion) {
        Iterator<SeleccionFutbol> it = listaSeleccion.iterator();

        while (it.hasNext()) {
            SeleccionFutbol p = it.next();

            if (p.ID == id) {
                it.remove();
                System.out.println("Integrante con id " + id + " eliminado.");
                return;
            }
        }
        System.out.println("No existe ningún integrante con id " + id);
    }

    public static int obtenNumeroEntero(String texto) {
        int num = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    num = Integer.parseInt(texto);
                } else {
                    correcto = true;
                    num = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato incorrecto.");
                correcto = false;
            }
        } while (!correcto);
        return num;
    }
}
