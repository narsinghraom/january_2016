package controll;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDao;
import dao.EmployeePreparedDao;
import bean.*;

public class Test {
	public static void main(String[] args) {  
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContect.xml");  
	      
	    /*EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
	    EmployeeBean empbean=new EmployeeBean();
	    empbean.setId(100);
	    empbean.setName("narsingh");
	    empbean.setSalary(18000);
	    int status=dao.saveEmployee(empbean); 
	    empbean.setName("dhatri");
	   // int update=dao.updateEmployeeBean(empbean);
	    int delete=dao.deleteEmployeeBean(empbean);
	    System.out.println(delete);  */
	    
	    //using prepare statement of JDBCTemplate
	    /*EmployeeBean bean=new EmployeeBean();
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("enter your ID");
	    bean.setId(scanner.nextInt());
	    System.out.println("Enter you Name");
	    bean.setName(scanner.next());
	    System.out.println("Enter your Salary");
	    bean.setSalary(scanner.nextFloat());
	    EmployeePreparedDao epd=(EmployeePreparedDao)ctx.getBean("edao");
	   Boolean flag= epd.saveEmployeeByPreparedStatement(bean);
	   System.out.println("inserted Sucessuflly" +flag);*/
	    
	    
	    
	    EmployeePreparedDao epd=(EmployeePreparedDao)ctx.getBean("edao");
	    List<EmployeeBean> list=epd.getAllEmployees();
	  System.out.println(list);
	 Iterator<EmployeeBean> itr=list.iterator();
	 while(itr.hasNext())
	 {
		 EmployeeBean e=itr.next();
		   System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()); 
	 }
	}

}
