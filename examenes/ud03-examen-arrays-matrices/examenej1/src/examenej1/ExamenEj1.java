package examenej1;

/**
 *
 * @author DAW
 */
public class ExamenEj1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] abecedario = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM",
            "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "AZ",
            "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BK", "BL", "BM",
            "BN", "BO", "BP", "BQ", "BR", "BS", "BT", "BU", "BV", "BW", "BX", "BY", "BZ",
            "CA", "CB", "CC", "CD", "CE", "CF", "CG", "CH", "CI", "CJ", "CK", "CL", "CM",
            "CN", "CO", "CP", "CQ", "CR", "CS", "CT", "CU", "CV", "CW", "CX", "CY", "CZ"
        };

        String[] letras = new String[10];

        int random;
        int max = 25 + 78;
        int min = 0;

        for (int i = 0; i < letras.length; i++) {
            random = (int) (Math.random() * (max - min + 1)) + min;
            letras[i] = abecedario[random];
        }

        for (int i = 0; i < letras.length; i++) {
            if (i < letras.length - 1) {
                System.out.print(letras[i] + ",");
            } else {
                System.out.print(letras[i]);
            }
        }
    }

}
