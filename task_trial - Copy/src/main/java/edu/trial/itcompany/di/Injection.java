package edu.trial.itcompany.di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for creating a job
 * @author Maksim Shcherbakov
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Injection {
    /**
     * Job name
     * @return job name
     */
    String value();
}
