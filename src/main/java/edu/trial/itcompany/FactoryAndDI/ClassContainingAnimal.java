package edu.trial.itcompany.FactoryAndDI;

import edu.trial.itcompany.FactoryAndDI.annotations.Injectable;
import edu.trial.itcompany.FactoryAndDI.model.Animal;

public class ClassContainingAnimal {
    @Injectable
    private Animal fox;
    public void makeAnimalDoSmth(){
        fox.doSomeAnimalStuff ();
    }
}
