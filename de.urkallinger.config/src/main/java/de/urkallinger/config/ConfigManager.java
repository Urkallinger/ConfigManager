package de.urkallinger.config;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ConfigManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);

    private static String configFileName = "cfg.dat";

    private ConfigManager() {

    }

    public static synchronized void setConfigFileName(String fileName) {
        configFileName = fileName;
    }

    public static String getConfigFileName() {
        return configFileName;
    }

    public static synchronized void writeConfig(Object config) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(config);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(configFileName))) {
            bw.write(json);
        } catch (IOException e) {
            String format = "Could not write to configuration file \"%s\".";
            LOGGER.error(String.format(format, configFileName), e);
        }
    }

    public static synchronized <CONFIG_TYPE> CONFIG_TYPE readConfig(Class<CONFIG_TYPE> configType)
            throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(configFileName));
        CONFIG_TYPE data = gson.fromJson(reader, configType);
        reader.close();
        return data;
    }
}
