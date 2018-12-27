package com.xmg.jscompile;

import org.apache.commons.io.IOUtils;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ConfigUtil {

    public static <T extends Config> T buildConfig(Class<T> configClass,
                                                   URL configURL) {
        if (configClass == null) {
            throw new IllegalArgumentException("Config class cannot be null!");
        }
        if (configURL == null) {
            throw new IllegalArgumentException("Config URL cannot be null!");
        }
//        if (logger.isInfoEnabled()) {
//            logger.info("Load config [" + configClass + "] from [" + configURL
//                    + "]");
//        }
        T _config = null;
        try {
            _config = configClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        IScriptEngine _jsEngine = new JSScriptManagerImpl("UTF-8");
        Map<String, Object> _bindings = new HashMap<>();
        _bindings.put("config", _config);
        Reader _r = null;
        String _scriptContent = null;
        try {
            _r = new InputStreamReader(configURL.openStream(), "UTF-8");
            _scriptContent = IOUtils.toString(_r);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(_r);
        }
        _jsEngine.runScript(_bindings, _scriptContent);
        _config.validate();
        return _config;

    }


    public static String getConfigPath(String fileName) {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        return classLoader.getResource(fileName).getPath();
    }

    public static URL getConfigURL(String fileName) {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        return classLoader.getResource(fileName);
    }
}
