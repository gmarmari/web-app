package com.marmaris.persistence.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Set;
import java.util.stream.Collectors;

public final class ClassUtils {

    private ClassUtils() {

    }

    public static Set<String> getClassesByPackage(String packageName, TypeFilter filter) {
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(filter);
        return provider.findCandidateComponents(packageName).stream()
                .map(BeanDefinition::getBeanClassName)
                .collect(Collectors.toSet());
    }
}
