package com.company.EMS;

import java.util.*;

//Abstract class (Abstraction)
abstract class Employee {

 protected int id;
 protected String name;

 public Employee(int id, String name) {
     this.id = id;
     this.name = name;
 }

 public void displayDetails() {
     System.out.println("Employee ID: " + id);
     System.out.println("Employee Name: " + name);
 }

 abstract double calculateSalary();
}

//Full Time Employee
class FullTimeEmployee extends Employee {

 private double baseSalary;
 private double bonus;

 public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
     super(id, name);
     this.baseSalary = baseSalary;
     this.bonus = bonus;
 }

 double calculateSalary() {
     return baseSalary + bonus;
 }

 public void display() {
     displayDetails();
     System.out.println("Type: Full Time Employee");
     System.out.println("Salary: " + calculateSalary());
     System.out.println("----------------------");
 }
}

//Intern Employee
class InternEmployee extends Employee {

 private double stipend;

 public InternEmployee(int id, String name, double stipend) {
     super(id, name);
     this.stipend = stipend;
 }

 double calculateSalary() {
     return stipend;
 }

 public void display() {
     displayDetails();
     System.out.println("Type: Intern Employee");
     System.out.println("Salary: " + calculateSalary());
     System.out.println("----------------------");
 }
}

//Main Class
public class EmployeeManagementSystem {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     ArrayList<Employee> employees = new ArrayList<>();

     int choice;

     do {
         System.out.println("\n===== Employee Management System =====");
         System.out.println("1. Add Full Time Employee");
         System.out.println("2. Add Intern Employee");
         System.out.println("3. Display Employees");
         System.out.println("4. Exit");

         System.out.print("Enter choice: ");
         choice = sc.nextInt();

         switch (choice) {

             case 1:
                 System.out.print("Enter ID: ");
                 int id = sc.nextInt();
                 sc.nextLine();

                 System.out.print("Enter Name: ");
                 String name = sc.nextLine();

                 System.out.print("Enter Base Salary: ");
                 double base = sc.nextDouble();

                 System.out.print("Enter Bonus: ");
                 double bonus = sc.nextDouble();

                 employees.add(new FullTimeEmployee(id, name, base, bonus));
                 System.out.println("Full Time Employee Added!");
                 break;

             case 2:
                 System.out.print("Enter ID: ");
                 int id2 = sc.nextInt();
                 sc.nextLine();

                 System.out.print("Enter Name: ");
                 String name2 = sc.nextLine();

                 System.out.print("Enter Stipend: ");
                 double stipend = sc.nextDouble();

                 employees.add(new InternEmployee(id2, name2, stipend));
                 System.out.println("Intern Employee Added!");
                 break;

             case 3:
                 System.out.println("\nEmployee List:");

                 for (Employee e : employees) {
                     e.displayDetails();
                     System.out.println("Salary: " + e.calculateSalary());
                     System.out.println("------------------");
                 }
                 break;

             case 4:
                 System.out.println("Exiting program...");
                 break;

             default:
                 System.out.println("Invalid choice");
         }

     } while (choice != 4);

     sc.close();
 }
}