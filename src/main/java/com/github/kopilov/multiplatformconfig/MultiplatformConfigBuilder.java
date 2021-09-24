package com.github.kopilov.multiplatformconfig;

import java.io.File;
import java.io.IOException;
import net.harawata.appdirs.AppDirsFactory;
import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Kopilov
 */
public class MultiplatformConfigBuilder {
    
    private static void addPropertiesFile(CompositeConfiguration config, File configFile, boolean autoSave) throws ConfigurationException {
        final var paramsFactory = new Parameters();
        final var configProperties = paramsFactory.properties();
        configProperties.setFile(configFile);
        final var configBuilder = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class).configure(configProperties);
        if (autoSave && !configFile.exists()) {
            try {
                
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
            } catch (IOException ex) {
                throw new ConfigurationException("Could not create config in autosave mode", ex);
            }
        }
        if (!configFile.exists()) {
            return;
        }
        configBuilder.setAutoSave(autoSave);
        config.addConfiguration(configBuilder.getConfiguration());
    }
    
    public static Configuration buildConfig(
            boolean portableByDefault,
            boolean autosaveByDefault,
            String appName,
            String appVersion,
            String configFileName
    ) throws ConfigurationException {
        final var systemConfiguration = new SystemConfiguration();
        final var config = new CompositeConfiguration();

        config.addConfiguration(systemConfiguration); //systemConfiguration always has high priority
        
        final var portable = systemConfiguration.getBoolean("multiplatformconfig.portable", portableByDefault);
        final var autosave = systemConfiguration.getBoolean("multiplatformconfig.autosave", autosaveByDefault);
        if (portable) {
            //read configuration from file in current working directory, enable autosave
            addPropertiesFile(config, new File(configFileName + ".properties"), autosave);
        } else {
            final var appDirs = AppDirsFactory.getInstance();
            //read configuration from file in user home directory, enable autosave
            final var userConfigFile = new File(appDirs.getUserConfigDir(appName, appVersion, null) + File.separator + configFileName + ".properties");
            addPropertiesFile(config, userConfigFile, autosave);
            //read configuration from file in system distribution, do not save
            for (String directory: appDirs.getSiteConfigDir(appName, appVersion, null, true).split(":")) {
                final var systemConfigFile = new File(directory + File.separator + configFileName + ".properties");
                addPropertiesFile(config, systemConfigFile, false);
            }
        }
        return config;
    }
    
}
