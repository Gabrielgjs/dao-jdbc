package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("---- teste1: seller findById ------");
		Seller seller = sellerDao.findByID(3);
		System.out.println(seller);
		
		System.out.println("\n---- teste: seller findByDepartment ------");
		Department department = new Department(2,null);
		List<Seller> list =  sellerDao.findByDepartment(department);
		for(Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n---- teste: seller findByAll ------");
		list =  sellerDao.findAll();
		for(Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n---- teste: seller insert ------");
		Seller newSeller = new Seller(null, "abner", "abner@gmail.com", new Date(), 4000.0,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
	}

}
