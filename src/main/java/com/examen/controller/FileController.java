package com.examen.controller;

import com.examen.services.FileService;
import com.examen.services.FormatFilesService;

public class FileController {

	private String folderPath;
    private FileService fileService;
    private FormatFilesService formatFilesService;

    public FileController(String folderPath) {
        this.folderPath = folderPath;
        this.fileService = new FileService(this.folderPath);
        this.formatFilesService = new FormatFilesService(this.folderPath);
    }

    public boolean fileExists(String fileName) {
        return fileService.fileExists(fileName);
    }

    public String createFile(String jsonFilePath) {
        formatFilesService.processJSONFile(jsonFilePath);
        return "Archivos creados exitosamente.";
    }
}
