package uk.gov.dvla.identity.service;

import uk.gov.dvla.identity.constant.FileMimeType;
import uk.gov.dvla.identity.model.FileInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderService {

    private static final String DEFAULT_DIRECTORY = "c:\\RandomFiles";
    private static final List<String> SUPPORTED_MIME_TYPES = Arrays.asList(
            FileMimeType.OLD_EXCEL_OR_CSV,
            FileMimeType.NEW_EXCEL
    );

    public List<FileInfo> readFiles(String mimeType) throws IOException {
        return readFiles(DEFAULT_DIRECTORY, mimeType);
    }

    public List<FileInfo> readFiles(String directoryPath, String mimeType) throws IOException {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            throw new IOException("Directory does not exist");
        }

        if (!directory.isDirectory()) {
            throw new IOException("Path specified is not a directory");
        }

        if (!SUPPORTED_MIME_TYPES.contains(mimeType)) {
            throw new IllegalArgumentException(mimeType
                    + " is not supported. Supported mimeTypes are: " + SUPPORTED_MIME_TYPES);
        }

        File[] listOfFiles = directory.listFiles();
        List<FileInfo> listOfFileInfo = new ArrayList<>();

        for (File each : listOfFiles) {
            if (each.isFile()) {
                String fileName = each.getName();
                String filePath = each.getAbsolutePath();
                String fileMimeType = extractFileMimeType(each);
                String fileExtension = getFileExtension(fileName);
                long fileSize = each.length();

                if (fileMimeType.equals(mimeType)) {
                    FileInfo fileInfo = new FileInfo(fileName, filePath, fileMimeType, fileSize, fileExtension);
                    listOfFileInfo.add(fileInfo);
                }
            }
        }

        return listOfFileInfo;
    }

    private String extractFileMimeType(File eachFile) throws IOException {
        return Files.probeContentType(eachFile.toPath());
    }

    private String getFileExtension(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return fileName.substring(lastIndexOf + 1);
    }

}