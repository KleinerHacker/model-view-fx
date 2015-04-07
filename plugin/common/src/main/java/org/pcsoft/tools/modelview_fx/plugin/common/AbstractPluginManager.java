package org.pcsoft.tools.modelview_fx.plugin.common;

import org.apache.commons.io.FileUtils;
import org.pcsoft.tools.modelview_fx.plugin.common.exceptions.ModelViewFxPluginLoadingException;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Christoph on 09.11.2014.
 */
public abstract class AbstractPluginManager<I, T extends Plugin<I>, A extends Annotation> implements PluginManager<I, T> {
    private final Map<String, T> pluginMap = new LinkedHashMap<>();

    protected AbstractPluginManager(File pluginPath, Class<I> interfaceClass, Class<A> annotationClass) {
        final Collection<File> files = FileUtils.listFiles(pluginPath, new String[]{"jar"}, true);
        final ClassLoader classLoader = new URLClassLoader(
                files.stream().map(item -> {
                    try {
                        return item.toURI().toURL();
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList()).toArray(new URL[files.size()]),
                Thread.currentThread().getContextClassLoader()
        );

        final ServiceLoader<I> serviceLoader = ServiceLoader.load(interfaceClass, classLoader);
        for (final I instance : serviceLoader) {
            final A annotation = instance.getClass().getAnnotation(annotationClass);
            if (annotation == null) {
                throw buildLoadingException("Cannot find needed annotation '" +
                        annotationClass.getName() + "' on class: " + instance.getClass().getName());
            }

            putPlugin(pluginMap, annotation, instance);
        }
    }

    protected abstract ModelViewFxPluginLoadingException buildLoadingException(String message);

    protected abstract void putPlugin(Map<String, T> pluginMap, A annotation, I instance);

    @Override
    public final Map<String, T> getPluginMap() {
        return pluginMap;
    }

    @Override
    public final List<T> getPluginList() {
        return new ArrayList<>(pluginMap.values());
    }

}
