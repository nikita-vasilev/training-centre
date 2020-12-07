package edu.trial.itcompany.FactoryAndDI.factoryTest.factories.impl;

import edu.trial.itcompany.FactoryAndDI.factoryTest.factories.AnimalFactory;
import edu.trial.itcompany.FactoryAndDI.model.Animal;
import edu.trial.itcompany.FactoryAndDI.model.Fox;

public class FoxesFactory implements AnimalFactory {
    @Override
    public Animal createAnimal ( ) {
        return new Fox ( );
    }
}
