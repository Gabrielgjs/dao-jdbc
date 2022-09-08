package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("---- teste1: department findById ------");
		Department department = departmentDao.findByID(1);
		System.out.println(department);
	}

}
