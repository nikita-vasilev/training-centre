import {Component, OnInit} from '@angular/core';
import {AnimalModel} from '../../model/AnimalModel';
import {AnimalService} from '../../features/animals/animal.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-animal-list',
  templateUrl: './animal-list.component.html',
  styleUrls: ['./animal-list.component.css']
})
export class AnimalListComponent implements OnInit {

  constructor(private readonly  animalService: AnimalService) {
  }

  animals: AnimalModel[];
  newAnimal: AnimalModel = new AnimalModel();
  editingId = -1;
  newAnimalForm = new FormGroup(
    {
      name: new FormControl(),
      species: new FormControl(),
      weight: new FormControl()
    },
  );
  updateAnimalForm = new FormGroup(
    {
      id: new FormControl(),
      name: new FormControl(),
      species: new FormControl(),
      weight: new FormControl()
    },
  );

  ngOnInit(): void {
    this.animalService.getAnimlas().subscribe(
      (animal) => {
        this.animals = animal;
      }
    );
  }

  addAnimal(): void {
    this.newAnimal.species = this.newAnimalForm.get('species').value;
    this.newAnimal.weight = this.newAnimalForm.get('weight').value;
    this.newAnimal.name = this.newAnimalForm.get('name').value;
    console.log(this.newAnimal);
    this.animalService.addAnimal(this.newAnimal).subscribe(
      () => {
        this.ngOnInit();
      }
    );

  }

  deleteAnimal(id: number): void {
    this.animalService.deleteAnimal(id).subscribe(
      () => {
        this.ngOnInit();
      }
    );
  }

  showEditForm(animal: AnimalModel): void {
    this.updateAnimalForm.get('name').setValue(animal.name);
    this.updateAnimalForm.get('id').setValue(animal.id);
    this.updateAnimalForm.get('species').setValue(animal.species);
    this.updateAnimalForm.get('weight').setValue(animal.weight);
    this.editingId = animal.id;
  }

  editAnimal(): void {
    this.newAnimal.species = this.updateAnimalForm.get('species').value;
    this.newAnimal.weight = this.updateAnimalForm.get('weight').value;
    this.newAnimal.name = this.updateAnimalForm.get('name').value;
    this.newAnimal.id = this.updateAnimalForm.get('id').value;
    this.animalService.updateAnimal(this.newAnimal).subscribe(
      () => {
        this.ngOnInit();
      }
    );
  }


}
