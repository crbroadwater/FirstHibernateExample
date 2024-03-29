package firsthb.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class CustomerData {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setFirstName("Cha");
		c1.setLastName("Car");
		c1.setAddress("Sa");
		c1.setEmail("Cha");
		session.save(c1);
		tran.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

}
