package edu.trial.itcompany.FactoryAndDI;

import edu.trial.itcompany.FactoryAndDI.DITest.Injector;
import edu.trial.itcompany.FactoryAndDI.factoryTest.factories.AnimalFactory;
import edu.trial.itcompany.FactoryAndDI.factoryTest.factories.impl.BearFactory;
import edu.trial.itcompany.FactoryAndDI.factoryTest.factories.impl.FoxesFactory;
import edu.trial.itcompany.FactoryAndDI.model.Animal;

public class Application {
    public static void main ( String[] args ) throws IllegalAccessException {
        AnimalFactory factory = new FoxesFactory ( );
        Animal animal1 = factory.createAnimal ( );
        animal1.doSomeAnimalStuff ();
        factory = new BearFactory ( );
        Animal animal2 = factory.createAnimal ( );
        animal2.doSomeAnimalStuff ();
        Injector injector = new Injector ( );
        var someClass=injector.inject ( new ClassContainingAnimal () );
        someClass.makeAnimalDoSmth ();


    }
}
