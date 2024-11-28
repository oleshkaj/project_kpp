package com.example.pizzeria;

import com.example.pizzeria.models.Recipe;
import com.fasterxml.jackson.core.type.TypeReference; // Для читання колекцій із JSON
import com.fasterxml.jackson.databind.ObjectMapper; // Для перетворення JSON у Java-об'єкти
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component // Spring автоматично створює об'єкт цього класу і керує ним -> можна використовувати в будь-якому іншому класі через Dependency Injection
public class PizzaMenuReader
{
    public List<Recipe> getAllRecipes() throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper(); // дозволяє перетворювати об'єкти Java у формат JSON і навпаки
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("pizza-menu.json");
        if (inputStream == null)
        {
            throw new IOException("Could not find pizza-menu.json resource");
        }
        return objectMapper.readValue(inputStream, new TypeReference<>() {}); // Зчитує JSON-дані та перетворює їх у список об'єктів Recipe. TypeReference для generics
    }
}