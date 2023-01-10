import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    
	private String name;
	private int age;
	int currentSem;                   // to be implemented
	private char gender;
	public Boolean isLoggedIn ;    // can be used to show green mark on profile if online
	private int rollno;
	LocalDate dob ;    
	LocalDate dateOfAdmission ;
	String address;
	String password ;  // let initially all have their dob as pswrd    
	// can also show birthday on portal on current day
	
	
	// can fetch any semester in constant time . map-> subject,marks
	ArrayList<Semester> semester = new ArrayList<Semester>();
	
	// assigning subjects to each semester
	
	public Student(String name, int age, char gender, int rollno,String dob, String address){
		
		this.name = name;
		this.age=age;
		this.gender=gender;
		this.rollno=rollno;
		this.dob=LocalDate.parse(dob);
		this.address=address;
		dateOfAdmission = LocalDate.now();          // 2023-01-07 format
		password  = dob;
		currentSem = 1;
		
		for(int i=1;i<=6;i++){
			semester.add(new Semester(i));
		}
	}  // note :- for loop needs to be in constructor or method else gives error
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
    public void setAge(int age) {
    	if(age<0)System.out.println("invalid age");
    	this.age=age ;
    }
    public int getAge() {
    	return this.age;
    }
	
    public void setGender(char gender) {
    	if(gender!='M' && gender!='F')System.out.println("invalid gender");
    	this.gender = gender;
    }
    public char getGender() {
    	return this.gender;
    }
    
    public int getRollNo() {
    	return this.rollno;
    }
    
    public void setDob(LocalDate date) {
    	this.dob = date;
    }
    public LocalDate getDob() {
    	return this.dob;
    }
	
	public void setAddress(String addr) {
		this.address=addr;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void setNewPassword(String pswrd) {
		this.password=pswrd;
	}
	
	public int getCurrentSem() {
		LocalDate currDate = LocalDate.now();
		currentSem = (int)(ChronoUnit.DAYS.between(dateOfAdmission, currDate)/180 + 1) ;
		
		return currentSem;
	}
}
