package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("---- teste: department findById ------");
		Department department = departmentDao.findByID(1);
		System.out.println(department);
		
		System.out.println("---- teste: department findAll ------");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		scan.close();
	}

}
