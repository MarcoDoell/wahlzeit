package org.wahlzeit.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface PatternInstance {
    String patternName();
    String[] participants();
}
