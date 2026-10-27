/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex4;

/**
 *
 * @author juand
 */
public class Ex4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//4. (3,5 puntos) Si hay algo típico y entrañable en la época navideña es el nacimiento con La Virgen María, El Niño
//Jesús y San José. Realiza un programa que pinte por pantalla un nacimiento teniendo en cuenta las siguientes
//premisas:

    //a) (0,5 puntos) El portal es siempre el mismo, no varía en anchura ni en altura ni en los caracteres que se pintan
    //(guiones y asteriscos). Debe salir exactamente igual a como se indica en los ejemplos.
    
    //b) La Virgen María se representa con una V, San José con una S y el Niño Jesús con una o minúscula.
   
    //c) Los tres personajes deben aparecer colocados de forma aleatoria en la misma línea, apoyados en el suelo (no
    //pueden levitar), en alguna de las 5 posiciones posibles.
  
    //d) Cada uno de los personajes debe aparecer en una posición distinta (no se pueden superponer).
 
    //e) El Niño Jesús siempre debe aparecer en medio de La Virgen y de San José. Sin embargo, tanto la Virgen
    //como San José pueden aparecer a la derecha o a la izquierda del Niño Jesús.
  
    //Nota: obligatorio el uso de una matriz, y obligatorio el uso de posiciones aleatorias para el niño, la Virgen y San
    //José.

        
        // Crear la matriz que representa el portal
        char[][] portal = {
            {'*','*','*','*','*','*','*'},
            {'*',' ',' ',' ',' ',' ','*'},
            {'*',' ',' ',' ',' ',' ','*'}
        };

        // Generar una posición aleatoria para la Virgen (0 a 4)
        int virgen = (int)(Math.random()*5);

        // Generar una posición aleatoria para San José
        int jose;

        // Repetir mientras coincida con la Virgen
        do{
            jose = (int)(Math.random()*5);
        }while(jose == virgen);

        // Generar una posición aleatoria para el Niño Jesús
        int nino;

        // Repetir mientras coincida con la Virgen o San José
        do{
            nino = (int)(Math.random()*5);
        }while(nino == virgen || nino == jose);

        // Guardar las tres posiciones en un array
        int[] pos = {virgen, jose, nino};

        // Ordenar las posiciones de menor a mayor
        for(int i = 0; i < pos.length - 1; i++){

            for(int j = i + 1; j < pos.length; j++){
                // Intercambiar posiciones si están desordenadas
                if(pos[i] > pos[j]){
                    int aux = pos[i];
                    pos[i] = pos[j];
                    pos[j] = aux;
                }
            }
        }

        // Decidir aleatoriamente si la Virgen va a la izquierda
        // o a la derecha de San José
        if(Math.random() < 0.5){

            // Virgen izquierda
            portal[2][pos[0] + 1] = 'V';

            // Niño siempre en medio
            portal[2][pos[1] + 1] = 'o';

            // San José derecha
            portal[2][pos[2] + 1] = 'S';

        }else{

            // San José izquierda
            portal[2][pos[0] + 1] = 'S';

            // Niño siempre en medio
            portal[2][pos[1] + 1] = 'o';

            // Virgen derecha
            portal[2][pos[2] + 1] = 'V';

        }

        // Mostrar el portal por pantalla
        for(int i = 0; i < portal.length; i++){

            for(int j = 0; j < portal[i].length; j++){

                System.out.print(portal[i][j] + " ");
            }

            // Salto de línea al terminar cada fila
            System.out.println();
        }

        // Dibujar el suelo del portal
        System.out.println("-------------");
    }
}