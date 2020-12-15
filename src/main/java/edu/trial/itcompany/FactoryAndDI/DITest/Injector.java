package edu.trial.itcompany.FactoryAndDI.DITest;

import edu.trial.itcompany.FactoryAndDI.annotations.Injectable;
import edu.trial.itcompany.FactoryAndDI.factoryTest.factories.AnimalFactory;
import edu.trial.itcompany.FactoryAndDI.model.Animal;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Injector {
    private static final String FATORIES_DIRECTORY = "edu.trial.itcompany.FactoryAndDI.factoryTest.factories.impl".replace ( ".", "/" );
    private List<AnimalFactory> factories;

    public Injector ( ) {
        factories = new ArrayList<> ( );

        try (DataInputStream dataInputStream = new DataInputStream ( (InputStream) Objects.requireNonNull ( this.getClass ( ).getClassLoader ( ).getResource ( FATORIES_DIRECTORY ) ).getContent ( ) )) {

            var bufferedReader = new BufferedReader ( new InputStreamReader ( dataInputStream ) );
            String line = null;
            while ( ( line = bufferedReader.readLine ( ) ) != null ) {
                if ( line.endsWith ( "Factory.class" ) ) {
                    var className = FATORIES_DIRECTORY.replace ( "/", "." ) + "." + line.substring ( 0, line.length ( ) - 6 );
                    factories.add ( (AnimalFactory) Class.forName ( className ).getConstructor ( ).newInstance ( ) );
                }

            }
            System.out.println ( factories );
        } catch ( IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | IllegalAccessException e ) {
            System.out.println ( "Error finding factories" );
            throw new RuntimeException ( e );
        }
    }

    public <T> T inject ( T object ) throws IllegalAccessException {
        var fields = object.getClass ( ).getDeclaredFields ( );
        for (var field : fields
        ) {
            if ( field.getAnnotation ( Injectable.class ) != null ) {
                if ( field.getType ( ).isAssignableFrom ( Animal.class ) )
                    field.trySetAccessible ( );
                field.set ( object, factories.get ( 1 ).createAnimal ( ) );

            }
        }
        return object;

    }

}
