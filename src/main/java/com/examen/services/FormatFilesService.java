package com.examen.services;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class FormatFilesService {

	 private FileService fileService;
	    private StringBuilder allUsersData;

	    public FormatFilesService(String folderPath) {
	        this.fileService = new FileService(folderPath);
	        this.allUsersData = new StringBuilder(); 
	    }

	    public void processJSONFile(String jsonFilePath) {
	        try {
	            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
	            JSONArray jsonArray = new JSONArray(jsonContent);

	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                boolean estado = jsonObject.getBoolean("estado");
	                double saldo = jsonObject.getDouble("saldo");
	                String banco = jsonObject.getString("banco");

	                String userText = ""; 

	                if (estado) {
	                    userText += "Banco de origen: " + banco + "\n";
	                    userText += "La cuenta con el nro de cuenta: " + jsonObject.getInt("nro_cuenta") + " tiene un saldo de " + saldo + "\n";

	                    if (saldo > 5000.00) {
	                        userText += "Usted es apto a participar en el concurso de la SBS por 10000.00 soles.\n";
	                        userText += "Suerte!\n";
	                    } else {
	                        userText += "Lamentablemente no podrá acceder al concurso de la SBS por 10000.00 soles.\n";
	                        userText += "Gracias\n";
	                    }

	                    allUsersData.append(userText);
	                }
	            }

	            String fileName = "usuarios.txt";
	            String filePath = this.fileService.createFile(fileName, allUsersData.toString());

	            if (!filePath.isEmpty()) {
	                System.out.println("Archivo creado exitosamente en: " + filePath);
	            }

	        } catch (IOException e) {
	            System.out.println("Ocurrió un error al procesar el archivo JSON: " + e.getMessage());
	        }
	    }
}
