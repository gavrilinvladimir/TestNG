package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class Config {
    public static Properties readProperties() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/java/config/config.properties")) {
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return property;
    }
}
