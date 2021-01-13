import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  service = 'http://localhost:8080';

  constructor(private readonly http: HttpClient) {}

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.service}/employees`);
  }

  create(employee: Employee): Observable<any> {
    return this.http.post(`${this.service}/employees/create`, employee);
  }

  update(employee: Employee): Observable<any> {
    return this.http.put(`${this.service}/employees/update`, employee);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.service}/employees/delete/${id}`);
  }
}
