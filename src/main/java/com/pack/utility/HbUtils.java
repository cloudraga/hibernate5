package com.pack.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HbUtils {

	private static StandardServiceRegistry reg;
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			try {
				reg = new StandardServiceRegistryBuilder().configure().build();

				MetadataSources mds = new MetadataSources(reg);

				Metadata md = mds.getMetadataBuilder().build();

				sf = md.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sf;
	}	

}
