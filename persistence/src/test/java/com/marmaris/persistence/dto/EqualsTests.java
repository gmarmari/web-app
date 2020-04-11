package com.marmaris.persistence.dto;


import com.marmaris.common.utils.ClassUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.EqualsVerifierApi;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;
import java.util.stream.Stream;

class EqualsTests {

    @ParameterizedTest
    @MethodSource("getDtoClasses")
    void equalsContract(String className) throws Exception {
        // WHEN
        Class<?> clazz = Class.forName(className);

        // THEN
        EqualsVerifierApi<?> verifier = EqualsVerifier.forClass(clazz);

        // VERIFY
        verifier.verify();
    }

    private static Stream<Arguments> getDtoClasses() {
        RegexPatternTypeFilter filter = new RegexPatternTypeFilter(Pattern.compile(".*Dto$"));
        return ClassUtils.getClassesByPackage("com.marmaris.persistence.dto", filter)
                .stream()
                .map(Arguments::of);
    }


}