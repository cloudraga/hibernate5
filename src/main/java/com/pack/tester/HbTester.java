package com.pack.tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pack.entity.Vehicle;
import com.pack.utility.HbUtils;

public class HbTester {

	public static void main(String[] args) {
		// 1) obtain SessionFactory object
		SessionFactory factory = HbUtils.getSessionFactory();

		// 2) obtain Session object from SessionFactory reference
		Session session = factory.openSession();

		// 3) start the DB transaction , by using Sesison object
		Transaction transaction = session.beginTransaction();

		// 4) Create the object of ENTITY class
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		vehicle.setType("Public");
		vehicle.setModel("TATA");

		// 5) save the vehicle using Sesison object
		session.save(vehicle);

		// 6) close the session & SessionFactory objects.
		session.flush();
		session.close();
		factory.close();

	}

}
