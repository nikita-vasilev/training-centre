import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../services/company.service';
import { Employee } from '../model/employee.model';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  columns = ['id', 'name', 'department', 'function'];
  employees: Employee[] = [];
  employee: Employee | undefined;

  employeeForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    department: new FormControl()
  });

  constructor(private readonly companyService: CompanyService) {}

  ngOnInit(): void {
    this.companyService.getAllEmployees().subscribe((employee) => {
      this.employees = employee;
    });
  }

  _c(row: unknown): Employee {
    return row as Employee;
  }

  createEmployee(): void {
    this.employee = this.employeeForm.value;
    if (this.employee) {
      this.companyService.create(this.employee).subscribe(() => {
        this.ngOnInit();
        this.clear();
      });
    }
  }

  updateEmployee(employee: Employee): void {
    this.employee = employee;
    this.employeeForm.setValue(employee);
  }

  update(): void {
    this.employee = this.employeeForm.value;
    if (this.employee) {
      this.companyService.update(this.employee).subscribe(() => {
        this.ngOnInit();
        this.clear();
      });
    }
  }

  delete(id: number): void {
    this.companyService.delete(id).subscribe(() => {
      this.ngOnInit();
    });
  }

  clear(): void {
    this.employee = undefined;
    this.employeeForm.setValue({ id: 0, name: '', department: '' });
  }
}
