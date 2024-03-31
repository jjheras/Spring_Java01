package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<String> listaAlumnos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        menu(teclado);
    }

    public static void crearArchivo(Scanner teclado) throws IOException {
        listaAlumnos.clear();
        // aqui creamos el archivos con los nombres que ha escrito por terminal separado por comas
        BufferedWriter writer = new BufferedWriter(new FileWriter("listado de alumnos.txt"));
        System.out.println("Introduce los nombres de los alumnos.");
        System.out.println("¡¡IMPORTANTE¡¡ separados por comas");
        String alumnos = teclado.nextLine();

        String[] nombres = alumnos.split(",");

        for(String nombre : nombres){
            listaAlumnos.add(nombre.trim());
        }

        writer.write("Lista de alumnos");
        writer.newLine();
        //recorremos la lista y la escribimos en el archivo en distintas lineas
        for (int i = 0; i< listaAlumnos.size(); i++){
            writer.write(listaAlumnos.get(i).trim());
            writer.newLine();
        }

        writer.close();
        System.out.println("Alumnos guardados con exito");

    }
    public static void menu(Scanner teclado) throws IOException {
        /*mostramos el menú dentro de un do while, con el fin de que se ejecute una vez y dependiendo de la opción
        elegida haga una cosa u otra, y no salga del bucle hasta que el usuario de la opción salir.*/
        String opcion;
        do {
            System.out.println("--------------------------");
            System.out.println("********** MENÚ **********");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Mostrar alumno");
            System.out.println("3. Salir");
            System.out.println("---------------------------");
            opcion = teclado.nextLine();
            //aqui evaluamos la opción elegida y ejecutamos la acción correspondiente.
            switch (opcion.trim()){
                case "1":
                    //addAlumno(teclado);
                    crearArchivo(teclado);
                    break;
                case "2":
                    mostrarAlumnos();
                    break;
                case "3":
                    System.out.println("Saliendo de la aplicación");
                    teclado.close();
                    break;
                default:
                    System.out.println("Tienes que elegir una de las opciones del menú");
            }

        }while (!opcion.equals("3"));
        teclado.close();
    }
    public static void mostrarAlumnos() throws IOException{
        //leemos el archivo y imprimimos en pantalla su contenido
        BufferedReader reader = new BufferedReader(new FileReader("listado de alumnos.txt"));

        String line;

        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }

}