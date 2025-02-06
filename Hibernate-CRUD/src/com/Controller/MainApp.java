package com.Controller;

import com.DAO.EmployeeDAO;
import com.Entity.Employee;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n🔹 Employee Management System");
            System.out.println("1. Insert 10 Employees");
            System.out.println("2. Fetch Employee by ID");
            System.out.println("3. Update Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<Employee> employees = Arrays.asList(
                        new Employee("John", 25, 50000, "john@gmail.com"),
                        new Employee("Alice", 28, 60000, "alice@gmail.com"),
                        new Employee("Bob", 30, 70000, "bob@gmail.com"),
                        new Employee("David", 24, 55000, "david@gmail.com"),
                        new Employee("Eve", 29, 62000, "eve@gmail.com"),
                        new Employee("Frank", 35, 75000, "frank@gmail.com"),
                        new Employee("Grace", 27, 58000, "grace@gmail.com"),
                        new Employee("Helen", 26, 56000, "helen@gmail.com"),
                        new Employee("Isaac", 32, 71000, "isaac@gmail.com"),
                        new Employee("Jack", 31, 73000, "jack@gmail.com")
                    );
                    dao.insertEmployees(employees);
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    Employee emp = dao.getEmployeeById(id);
                    System.out.println(emp != null ? emp : "⚠️ Employee Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    id = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String email = sc.nextLine();
                    dao.updateEmployee(id, name, age, salary, email);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    id = sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 5:
                    System.out.println("✅ Exiting... Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid Choice! Try again.");
            }
        }
    }
}
