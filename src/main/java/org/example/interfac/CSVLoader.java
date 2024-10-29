package org.example.interfac;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader<T> {

    // Loads data from CSV and returns a list of T objects
    public List<T> loadFromCSV(String filePath, Class<T> clazz) {
        List<T> resultList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = br.readLine().split(","); // Read header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                T instance = clazz.getDeclaredConstructor().newInstance();

                for (int i = 0; i < headers.length; i++) {
                    Field field = clazz.getDeclaredField(headers[i].trim());
                    field.setAccessible(true);
                    if (field.getType() == int.class) {
                        field.set(instance, Integer.parseInt(values[i].trim()));
                    } else {
                        field.set(instance, values[i].trim());
                    }
                }
                resultList.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}