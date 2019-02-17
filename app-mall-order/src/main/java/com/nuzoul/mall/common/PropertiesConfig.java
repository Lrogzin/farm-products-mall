package com.nuzoul.mall.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: nuzoul
 * @Date: 2019/2/17 22:51
 */
public class PropertiesConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final Properties properties = new Properties();
    private static final PropertiesConfig INSTANCE = new PropertiesConfig();

    private PropertiesConfig() {
        try {
            logger.info("PropertiesConfig:"+System.getProperty("cfg.env"));
            properties.load(getClass().getClassLoader().getResourceAsStream("cfg_"+System.getProperty("cfg.env")+".properties"));
        } catch (IOException e) {
            logger.error("load config file recharge_config.properties exception", e);
        }
    }

    public static PropertiesConfig getInstance() {
        return INSTANCE;
    }

    private String get(String key) {
        return properties.getProperty(key);
    }
}
