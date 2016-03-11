
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
//

public class HibernateExample2 
{

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.addAnnotatedClass(P.class);
		config.addAnnotatedClass(Teacher.class);
		config.addAnnotatedClass(Courses.class);
		config.addAnnotatedClass(University.class);
		
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		ServiceRegistryBuilder sRBuilder = new ServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(sRBuilder.buildServiceRegistry());
		Session s1 = factory.openSession();
		
		s1.beginTransaction();
		
		University u1 = new University();
		u1.setName("Carleton University");
		s1.save(u1);		
		
		Teacher T1 = new Teacher();
		T1.setFirst_name("Michel");
		T1.setLast_name("Smid");
		T1.setSalary(20000);
		T1.setDegree("PhD in CS");
		T1.setUniv(u1);
		s1.save(T1);
			
		Teacher T2 = new Teacher();
		T2.setFirst_name("Norman");
		T2.setLast_name("Zhe");
		T2.setSalary(30000);
		T2.setDegree("Master in CS");		
		T2.setUniv(u1);
		s1.save(T2);
		
		Courses C1 = new Courses();
		C1.setCourseName("Algorithm ");
		C1.setYear(2012);
		C1.setT(T1);		
		s1.save(C1);
	
		Courses C2 = new Courses();
		C2.setCourseName("Data Structure");
		C2.setYear(2013);
		C2.setT(T2);		
		s1.save(C2);
		
		s1.getTransaction().commit();
	/*	
		
		Session s2 = factory.openSession();
		
	
		try {
			 s2.beginTransaction();
		    	List courses = s2.createQuery("from Courses").list();
			for (Iterator iterator = courses.iterator(); iterator.hasNext();)
			{
				Courses c = (Courses) iterator.next();
				System.out.println("Course is: " + c.getCourseName());
			}
			s2.getTransaction().commit();
		} catch (HibernateException e) {
			
		} finally {
			s2.close();
		}
		*/
		
	}

}
