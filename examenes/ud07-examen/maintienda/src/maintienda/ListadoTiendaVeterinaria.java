package maintienda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class ListadoTiendaVeterinaria {

    private String cif;
    private String nombre;
    private ArrayList<Persona> persona;

    public ListadoTiendaVeterinaria(String cif, String nombre, ArrayList<Persona> persona) {
        this.cif = cif;
        this.nombre = nombre;
        this.persona = new ArrayList<>();
    }

    public ListadoTiendaVeterinaria() {
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getPersona() {
        return persona;
    }

    public void setPersona(ArrayList<Persona> persona) {
        this.persona = persona;
    }

    public void listaClientes() {
        System.out.print("\n--" + this.nombre + " " + this.cif + "--");
        for (int i = 0; i < persona.size(); i++) {
            System.out.println("\n<Persona " + (i + 1) + ">" + persona.get(i));
        }
    }

    public boolean insertaPersona(Persona persona) {
        this.persona.add(persona);
        return true;
    }

    public static void creaPeryMas(String linea, ArrayList<Persona> listaPersona, int contLinea) {

        String dni;
        String nombreM;
        int edad;
        String raza;
        String nombreP;
        String apellidos;
        String email;
        String telefono;
        String direccion;

        String[] lineaSeparar = linea.split(";");

        if (lineaSeparar.length == 9) {

            try {

                Persona pTemp;
                Mascota mTemp;

                dni = lineaSeparar[0];
                nombreP = lineaSeparar[1];
                apellidos = lineaSeparar[2];
                email = lineaSeparar[3];
                telefono = lineaSeparar[4];
                direccion = lineaSeparar[5];

                nombreM = lineaSeparar[6];
                edad = Integer.parseInt(lineaSeparar[7]);
                raza = lineaSeparar[8];

                mTemp = new Mascota(dni, nombreM, edad, raza);

                if (listaPersona.isEmpty()) {

                    pTemp = new Persona(dni, nombreP, apellidos, email, telefono, direccion);
                    pTemp.asignaMascota(mTemp);
                    listaPersona.add(pTemp);
                    mTemp.asignaPersona(pTemp);

                } else {

                    for (int i = 0; i < listaPersona.size(); i++) {

                        if (listaPersona.get(i).getDni().equals(dni)) {
                            listaPersona.get(i).asignaMascota(mTemp);
                            mTemp.asignaPersona(listaPersona.get(i));

                            break;

                        } else if ((i == (listaPersona.size() - 1)) && (!listaPersona.get(i).getDni().equals(dni))) {

                            pTemp = new Persona(dni, nombreP, apellidos, email, telefono, direccion);

                            pTemp.asignaMascota(mTemp);
                            listaPersona.add(pTemp);
                            mTemp.asignaPersona(pTemp);

                            break;
                        }
                    }
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Formato de numero en la linea " + contLinea + " incorrecto");
            }

        } else if (lineaSeparar.length < 9) {
            System.out.println("Parámetros de la linea " + contLinea + " insuficientes");

        } else {
            System.out.println("Demasiados parámetros en la línea " + contLinea);
        }
    }
}
