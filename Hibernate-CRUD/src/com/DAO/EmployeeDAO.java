package com.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Entity.Employee;
import com.Util.HibernateUtil;

public class EmployeeDAO {

    // 1️⃣ Insert Employees
    public void insertEmployees(List<Employee> employees) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        for (Employee emp : employees) {
            session.save(emp);
        }
        
        tx.commit();
        session.close();
        System.out.println("✅ Employees inserted successfully!");
    }

    // 2️⃣ Fetch Employee by ID
    public Employee getEmployeeById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee emp = session.get(Employee.class, id);
        session.close();
        return emp;
    }

    // 3️⃣ Update Employee by ID
    public void updateEmployee(int id, String name, int age, double salary, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            emp.setName(name);
            emp.setAge(age);
            emp.setSalary(salary);
            emp.setEmail(email);
            session.update(emp);
            tx.commit();
            System.out.println("✅ Employee updated successfully!");
        } else {
            System.out.println("⚠️ Employee not found!");
        }
        
        session.close();
    }

    // 4️⃣ Delete Employee by ID
    public void deleteEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            tx.commit();
            System.out.println("✅ Employee deleted successfully!");
        } else {
            System.out.println("⚠️ Employee not found!");
        }

        session.close();
    }
}
