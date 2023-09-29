package com.examen.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	int auxCont = 0;
    String folderPath = "";

    public FileService(String folderPath) {
        this.folderPath = folderPath;
    }

    public boolean fileExists(String parFileName) {
        File f = new File(this.folderPath + parFileName);
        return f.exists();
    }

    public String createFile(String parFileName, String fileContent) {
        if (parFileName.isEmpty()) {
            auxCont++;
            parFileName = "test" + auxCont + ".txt";
        }

        String fullPath = this.folderPath + parFileName;
        if (fileExists(parFileName)) {
            return "";
        }
        try {
            FileWriter writer = new FileWriter(fullPath);
            writer.write(fileContent);
            writer.close();
            System.out.println("Archivo creado exitosamente en " + fullPath);
            return fullPath;
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
            return "";
        }
    }
}
