package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "bob","bob@gmail.com",sdf.parse("04/09/2022"), 3000.00, obj);
		
		System.out.println(obj);
		
		System.out.println(seller);
	}

}
