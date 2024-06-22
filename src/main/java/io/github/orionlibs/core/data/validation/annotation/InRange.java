package io.github.orionlibs.core.data.validation.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(
{java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InRange
{
    int min() default Integer.MIN_VALUE;


    int max() default Integer.MAX_VALUE;
}