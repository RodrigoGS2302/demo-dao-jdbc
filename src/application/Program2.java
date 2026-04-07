package application;

import java.util.List;
import java.util.Scanner;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department department = departmentDao.findById(1);	
		System.out.println(department);

		System.out.println("\n=== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TEST 3: department insert ====");
		Department dep = new Department(null, "Games");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());	
		
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.print("How many departments do you want to delete? ");

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();

		try {
		    departmentDao.deleteById(id);
		    System.out.println("Deleted id: " + id);
		}
		catch (DbException e) {
		    System.out.println("Error deleting id " + id + ": " + e.getMessage());
		}

		}

		System.out.println("Finished deletions");

		sc.close();
		
		}
	
	
		

		
	
		
		
}
