/*
------------------------------------------
DO not mix annotations levels 

------------------------------------------
HQL is the query language used in Hibernate which is an extension of SQL. 
HQL is very efficient, simple and flexible query language to do various type 
of operations on relational database without writing complex database queries.

------------------------------------------

Transient ---- Persistant ---- Detached 
*/


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



//import javax.management.Query;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
//



import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class UserTestProgram {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.addAnnotatedClass(User.class);		
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(false, true);

		ServiceRegistryBuilder sRBuilder = new ServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(sRBuilder.buildServiceRegistry());
		Session s1 = factory.openSession();
		
		s1.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setName("user" + i );
			s1.save(u);	
		}
		
		s1.getTransaction().commit();
		
		s1.close();

		Session s2 = factory.openSession();		
		s2.beginTransaction();		
		User MyUser = (User) s2.get(User.class, 6);
		System.out.println(MyUser.getName());		
		//s2.delete(MyUser);		
		MyUser.setName("CST");
		
		s2.update(MyUser);
		
		MyUser.setName("CST2");		
		MyUser.setName("CST3");
		MyUser.setName("CST4");
		MyUser.setName("CST5");
		MyUser.setName("CST6");
		MyUser.setName("CST7");
		
		s2.getTransaction().commit();
		s2.close();
		
		MyUser.setName("CST8");
	}

}
