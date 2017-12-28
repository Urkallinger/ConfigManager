package de.urkallinger.config;

import static de.urkallinger.config.data.DataUtils.createComplexData;
import static de.urkallinger.config.data.DataUtils.createSimpleData;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import de.urkallinger.config.data.ComplexData;
import de.urkallinger.config.data.SimpleData;

public class ConfigManagerTest {
    @After
    public void cleanUp() throws Exception {
        File configFile = new File(ConfigManager.getConfigFileName());
        if(configFile.exists()) {
            if(!configFile.delete()) {
                String format = "Could not delete configuration file \"%s\".";
                throw new IOException(String.format(format, configFile.getName()));
            }
        }
    }

    @Test
    public void readWriteSimpleDataTest() throws Exception {
        // ARRANGE
        SimpleData expectation = createSimpleData();
        SimpleData toWrite = createSimpleData();

        // ACT
        ConfigManager.writeConfig(toWrite);
        SimpleData readConfig = ConfigManager.readConfig(toWrite.getClass());

        // ASSERT
        assertEquals(expectation, readConfig);
    }

    @Test
    public void readWriteComplexDataTest() throws Exception {
        // ARRANGE
        ComplexData expectation = createComplexData();
        ComplexData toWrite = createComplexData();

        // ACT
        ConfigManager.writeConfig(toWrite);
        ComplexData readConfig = ConfigManager.readConfig(toWrite.getClass());

        // ASSERT
        assertEquals(expectation, readConfig);
    }

    @Test
    public void readWriteEmptyDataTest() throws Exception {
        // ARRANGE
        ComplexData expectation = new ComplexData();

        // ACT
        ConfigManager.writeConfig(new ComplexData());
        ComplexData readConfig = ConfigManager.readConfig(expectation.getClass());

        // ASSERT
        assertEquals(expectation, readConfig);
    }

    @Test
    public void configFileCreationTest() throws Exception {
        // ARRANGE
        String fileName = "supercool.dat";

        // ACT
        ConfigManager.setConfigFileName(fileName);
        ConfigManager.writeConfig(new SimpleData());
        File config = new File(fileName);

        // ASSERT
        assertTrue("Config-File could not be created.", config.exists());
    }
}
