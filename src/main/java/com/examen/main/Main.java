package com.examen.main;

import java.util.Scanner;
import com.examen.controller.*;

public class Main {

	  public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        String folderPath = "C:\\Users\\KEVIN\\Downloads\\Test";
	        FileController controller = new FileController(folderPath);

	        boolean salir = false;
	        int opcion;

	        do {
	            System.out.println("1. Crear Archivos desde JSON");
	            System.out.println("2. Salir");
	            System.out.println("Escribe una de las opciones");
	            opcion = sc.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.println("Ingrese la ruta del archivo JSON:");
	                    sc.nextLine(); 
	                    String jsonFilePath = sc.nextLine();
	                    String resultado = controller.createFile(jsonFilePath);
	                    System.out.println(resultado);
	                    break;
	                case 2:
	                    salir = true;
	                    break;
	                default:
	                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
	            }
	        } while (!salir);
	    }
	

}
