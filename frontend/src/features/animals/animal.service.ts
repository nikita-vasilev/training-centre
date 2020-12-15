import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AnimalModel} from '../../model/AnimalModel';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  constructor(private readonly  httpClient: HttpClient) {
  }


  getAnimlas(): Observable<AnimalModel[]> {
    return this.httpClient.get<AnimalModel[]>(`${environment.animalRepo}/animals`);
  }

  deleteAnimal(id: number): Observable<any> {
    return this.httpClient.delete(`${environment.animalRepo}/animals/${id}`);
  }

  updateAnimal(animal: AnimalModel): Observable<any> {
    return this.httpClient.put(`${environment.animalRepo}/animals/${animal.id}`, animal);
  }

  addAnimal(animal: AnimalModel): Observable<any> {
    return this.httpClient.post(`${environment.animalRepo}/animals`, animal);
  }
}
