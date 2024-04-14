package co.edu.uptc.Ejercicio1Backend.services;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class PropiertiesService {
   private String filePath="src/main/resources/application.properties";

    public String getValue(String Key) {
        Properties properties = new Properties();
        String value = "";
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
            value=properties.getProperty(Key);
        } catch (IOException e) {
            System.out.println("Error al leer propiedades: " + e.getMessage());
        }
        return value;
    }   



 
}
