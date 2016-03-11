import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
//

public class TestEmployee {

	public static void main(String[] args) {
		Configuration config = new Configuration()
		    .addAnnotatedClass(Employee.class)
		    .addAnnotatedClass(Location.class)
		    .configure("hibernate.cfg.xml");
		//config.addAnnotatedClass(Employee.class);
		//config.configure("hibernate.cfg.xml");
		
		//new SchemaExport(config).create(true, true);
		ServiceRegistryBuilder sRBuilder = new ServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(sRBuilder.buildServiceRegistry());
		Session s = factory.getCurrentSession();		
		s.beginTransaction();		
		Employee todd = new Employee();
		s.load(todd,10001);
		System.out.println("Todd's current location is " + todd.getLocation().getXLoc()
				           + ", " + todd.getLocation().getYLoc());
		todd.setEmpEmail("kelleyt@algonquincollege.com");
		todd.setEmpAddress("Algonquin College, Information and Communications Technology");
		todd.setEmpName("Todd Kelley");
		todd.setLocation(new Location(new Point(77,24)));
		s.save(todd);
		s.getTransaction().commit();
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		Session s2 = factory.getCurrentSession();
		s2.beginTransaction();
		Query q = s2.createQuery("from Employee where empId = :e");
		q.setParameter("e",10001);
        emps = (ArrayList<Employee>) q.list();
		s2.getTransaction().commit();
		for (Employee e: emps){
		    Location l = e.getLocation();
		    System.out.println(e.getEmpName() + "'s current location is " + l.getXLoc() + ", " + l.getYLoc());
		}
		/*
		s.beginTransaction();		
				
		Todd.setEmpId(10001);
		Todd.setEmpEmail("kelleyt@algonquincollege.com");
		Todd.setEmpAddress("Algonquin College, Information and Communications Technology");
		Todd.setEmpName("Todd Kelley");
		Todd.setLocation(new Location(new Point(43,24)));
		s.save(Todd);
		
		
		s.getTransaction().commit();
		
		ArrayList<Employee> emps = new ArrayList<Employee>();
		Session s2 = factory.getCurrentSession();
		s2.beginTransaction();
        emps = (ArrayList<Employee>) s2.createQuery("from Employee").list();
		s2.getTransaction().commit();
		for (Employee e: emps){
		    Location l = e.getLocation();
		    System.out.println(e.getEmpName() + "'s location is " + l.getXLoc() + ", " + l.getYLoc());
		}
		*/	
	}

}
