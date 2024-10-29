package org.example.repository;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DaoGeneral<T> {

    private final Class<T> type;
    private final String filePath;

    public DaoGeneral(Class<T> type, String filePath) {
        this.type = type;
        this.filePath = filePath;
    }

    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            String[] headers = br.readLine().split(","); // First line for headers

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                T entity = createEntity(headers, values);
                entities.add(entity);
            }
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return entities;
    }

    private T createEntity(String[] headers, String[] values) throws ReflectiveOperationException {
        Constructor<T> constructor = type.getDeclaredConstructor();
        T instance = constructor.newInstance();

        for (int i = 0; i < headers.length; i++) {
            Field field = type.getDeclaredField(headers[i].trim());
            field.setAccessible(true);

            if (field.getType() == int.class) {
                field.set(instance, Integer.parseInt(values[i].trim()));
            } else if (field.getType() == String.class) {
                field.set(instance, values[i].trim());
            }
        }
        return instance;
    }
}