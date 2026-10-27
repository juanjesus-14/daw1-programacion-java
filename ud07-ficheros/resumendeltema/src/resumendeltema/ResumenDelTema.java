//Resumen básico sobre Java.io

//Crear fichero
    // File fichero = new File("datos.txt");
    // fichero.createNewFile();

//Escribir fichero
    // FileWriter fw = new FileWriter("datos.txt", true);
    // fw.write("texto\n");
    // fw.close();

//Leer fichero
    // BufferedReader br = new BufferedReader(new FileReader("datos.txt"));

//Leer línea a línea
    // while((linea = br.readLine()) != null)

//Separar datos
    // String[] partes = linea.split(";");


//Apuntes sobre java.io
//1. BufferedReader
//BufferedReader permite leer texto de un flujo de entrada de manera eficiente.
//Métodos principales:
//    • readLine() → Lee una línea completa y devuelve un String (o null si se alcanza el final del archivo).
//    • close() → Cierra el BufferedReader y libera recursos.

//Ejemplo de uso:
//try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
//    String linea;
//    while ((linea = br.readLine()) != null) {
//        System.out.println(linea);
//    }
//} catch (IOException e) {
//    e.printStackTrace();
//}


//2. BufferedWriter
//BufferedWriter permite escribir texto en un archivo de manera eficiente.
//Métodos principales:
//    • write(String s) → Escribe una cadena en el archivo.
//    • newLine() → Escribe un salto de línea.
//    • flush() → Fuerza la escritura de los datos en el archivo.
//    • close() → Cierra el BufferedWriter y libera recursos.
//¿Cuándo usar flush()?
//    • flush() se usa cuando queremos asegurarnos de que los datos se escriban inmediatamente en el archivo sin esperar a que el buffer se llene.
//    • Es útil en escenarios donde la escritura debe ser inmediata, como en registros de logs o sistemas en tiempo real.
//    • No es necesario si se usa close(), ya que este método también vacía el buffer antes de cerrar el flujo.

//Ejemplo de uso:
//try (BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt", true))) {
//    bw.write("Hola, mundo!");
//    bw.newLine();
//    bw.flush(); // Asegura que los datos se escriban en el archivo inmediatamente
//} catch (IOException e) {
//    e.printStackTrace();
//}


//3. File
//La clase File representa archivos y directorios en el sistema de archivos.
//Métodos principales:
//    • exists() → Retorna true si el archivo o directorio existe.
//    • createNewFile() → Crea un nuevo archivo vacío.
//    • delete() → Elimina el archivo o directorio.
//    • mkdir() → Crea un directorio.
//    • getAbsolutePath() → Devuelve la ruta absoluta del archivo.
//    • length() → Devuelve el tamaño del archivo en bytes.

//Ejemplo de uso:
//File archivo = new File("archivo.txt");
//if (!archivo.exists()) {
//    try {
//        if (archivo.createNewFile()) {
//            System.out.println("Archivo creado con éxito.");
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//} else {
//    System.out.println("El archivo ya existe.");
//}


//4. Try-with-resources
//El try-with-resources es una estructura que permite manejar recursos como archivos o streams de manera automática, asegurando que se cierren correctamente.
//Ventajas:
//    • Evita la necesidad de cerrar los recursos manualmente en un bloque finally.
//    • Reduce el código y mejora la legibilidad.
//    • Minimiza errores relacionados con la gestión de recursos.

//Ejemplo sin try-with-resources:
//BufferedReader br = null;
//try {
//    br = new BufferedReader(new FileReader("archivo.txt"));
//    String linea;
//    while ((linea = br.readLine()) != null) {
//        System.out.println(linea);
//    }
//} catch (IOException e) {
//    e.printStackTrace();
//} finally {
//    try {
//        if (br != null) {
//            br.close();
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}

//Ejemplo con try-with-resources (más simple y seguro):
//try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
//    String linea;
//    while ((linea = br.readLine()) != null) {
//        System.out.println(linea);
//    }
//} catch (IOException e) {
//    e.printStackTrace();
//}

//Notas adicionales
//    • Usar try-with-resources (try (...) {}) es recomendable para cerrar automáticamente los recursos.
//    • BufferedReader y BufferedWriter son más eficientes que FileReader y FileWriter porque trabajan con buffers internos.
//    • Para añadir texto sin sobrescribir un archivo, usa new FileWriter("archivo.txt", true) en lugar de false.
//    • flush() es útil cuando queremos garantizar que los datos se escriban en el archivo inmediatamente sin esperar a que el buffer se llene.
