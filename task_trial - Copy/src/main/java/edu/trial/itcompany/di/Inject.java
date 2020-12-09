package edu.trial.itcompany.di;

import edu.trial.itcompany.factory.factories.JobFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * The class performs dependency injection
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class Inject {
    /**
     * Directory where to search for classes for injection
     */
    private static final String directory = "edu/trial/itcompany/factory/factories";

    /**
     * The method performs dependency injection
     * @param object object for dependency injection
     * @param <T> generic for dependency injection
     * @return object with dependency injection
     * @throws Exception to handle an injection error
     */
    public static <T> T inject(T object) throws Exception {
        for(Field  field : object.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Injection.class)){
                field.setAccessible(true);
                Injection injection = field.getAnnotation(Injection.class);
                JobFactory jobFactory = findFactory(object, injection.value());

                if(jobFactory != null){
                    field.set(object, jobFactory.createJob());
                }
            }
        }
        return object;
    }

    /**
     * The method searches for a factory to inject
     * @param o object for injection
     * @param name factory name
     * @return factory
     */
    private static JobFactory findFactory(Object o, String name){
        JobFactory jobFactory;

        try (DataInputStream dataInputStream = new DataInputStream ((InputStream) Objects.requireNonNull(
                o.getClass().getClassLoader().getResource(directory)).getContent())) {
            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(dataInputStream));
            String line = "";

            while (bufferedReader.readLine() != null) {
                line = bufferedReader.readLine();

                if (line.endsWith (name + "Factory.class" ) ) {
                    String className = directory.replace("/", ".") + "."
                            + line.substring (0, line.length () - 6);
                    jobFactory = (JobFactory)Class.forName(className).getConstructor().newInstance();

                    return jobFactory;
                }
            }
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException |
                ClassNotFoundException | IllegalAccessException e ) {
            System.out.println("Factory not found");
            throw new RuntimeException (e);
        }
        return null;
    }

}

