import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Staff {
       
	  String name;
	  String password;
	  LocalDate dob;
	  int staffId;
	  Long salary;
	  char gender;
//	  ArrayList<String> subjects = new ArrayList<String>();
	  String department;           
	  String designation;    // prof, asst prof, dean, hod
//	  HashMap<String,Classes> classes = new HashMap<String,Classes>();  // teaching slots day wise
	  
	  public Staff(String name,int id, Long salary,String designation, String department,char gender,String dob){
		  
		   this.name = name;
		   this.staffId =id;
		   this.salary = salary;
		   this.designation = designation;
		   this.department = department;
		   this.gender = gender;
		   this.dob = LocalDate.parse(dob);
		   this.password = dob;
		   
	  }
	  
	  public String getName() {
		  return this.name;
	  }
	  
	  // staff attendance updated by admin
}
