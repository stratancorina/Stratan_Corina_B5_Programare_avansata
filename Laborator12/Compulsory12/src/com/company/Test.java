package com.company;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * We are going to use this annotation to mark methods.
 * The marked methods will be subject to testing.
 * It will only work for static methods with no parameters...
 */
@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)

public @interface Test {
}