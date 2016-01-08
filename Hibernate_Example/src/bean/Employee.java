package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="emp1000")
public class Employee 
{  
//@Id
private int id;  
//private String firstName,lastName;  
private String name;
  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
//public String getFirstName() {  
//    return firstName;  
//}  
//public void setFirstName(String firstName) {  
//    this.firstName = firstName;  
//}  
//public String getLastName() {  
//    return lastName;  
//}  
//public void setLastName(String lastName) {  
//    this.lastName = lastName;  
//}  
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
  
}  