package controller;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;  

import bean.Contract_Employee;
import bean.Employee;
import bean.Regular_Employee;
  
public class StoreData {  
public static void main(String[] args)
{  
      
    /*//creating configuration object  
    Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating seession factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          */
	/*
	Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	Transaction t=session.beginTransaction();
    Employee e1=new Employee();  
    e1.setId(114);  
    e1.setFirstName("peppy");  
    e1.setLastName("nalla");  
    Employee e2=new Employee();  
    e2.setId(117);  
    e2.setFirstName("sonu");  
    e2.setLastName("Mahankali");  */
	Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	
		Transaction  t=session.beginTransaction();
		Employee e=new Employee();
         e.setName("poojitha");	
	
         Regular_Employee re=new Regular_Employee();
         re.setBonus(6);
         re.setSalary(20000);
         
         Contract_Employee ce=new Contract_Employee();
         ce.setContract_duration("10");
         ce.setPay_per_hour(1000);
    session.persist(e);//persisting the object  
    session.persist(re);  
    session.persist(ce); 
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
}  