import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// to student , I will not give any button to Update attendance or I can use interface also
public class Main {
	
	 static int nextStudentId = 1;
	 static int nextStaffId = 1;
	 // use map because arrayList and linkedList takes O(n) if we remove student or staff.
	 static HashMap<Integer,Student> students = new HashMap<Integer,Student>();  // roll no -> key
	 static HashMap<Integer,Staff> staff = new HashMap<Integer,Staff>();   // employeeId -> key
	 static Scanner sc = new Scanner(System.in);
	 
	 static {
		 System.out.println("Welcome to Indian Institute Of Information Technology Prayagraj");
		 
	 }
	 
	 public static void addStudent() {
		    String name , dob, address;
		    int age , rollno = nextStudentId;
		    Character gender;
		    
		    System.out.println("Enter Student Name : ");
		    name = sc.next();
		    sc.nextLine();
		    System.out.println("Enter Student age : ");
		    age = sc.nextInt();
		    System.out.println("Enter Student gender 'M' or 'F' : ");
		    gender = sc.next().charAt(0);
		    System.out.println("Enter Student dob : ");
		    dob = sc.next();
		    sc.nextLine();
		    System.out.println("Enter Student Address : ");
		    address = sc.next();
		    sc.nextLine();
		    
		    students.put(nextStudentId, new Student(name,age,gender,rollno,dob,address));
		    nextStudentId++;
		    System.out.println("Student added Successfully");
		    return;
		    
	  }
	 public static void removeStudent() {
		  
		 System.out.println("Enter the id of Student to be deleted");
		 int id = sc.nextInt();
		 students.remove(id);
		 System.out.println("Student removed successfully");
		 return;
	  }
	 public static void addStaff() {
		 
		 String name , department , dob;
		 int staffid = nextStaffId;
		 Long salary;
		 String designation;
		 Character gender;
		 
		 System.out.println("Enter Staff Member Name : ");
		 name = sc.next();sc.nextLine();
		 System.out.println("Enter DOB : ");
		 dob = sc.next();sc.nextLine();
		 System.out.println("Enter designation ");
		 designation = sc.next();sc.nextLine();
		 System.out.println("Enter department ");
		 department = sc.next();sc.nextLine();
		 System.out.println(" Enter your gender : 'M' or 'F' ");
		 gender = sc.next().charAt(0);sc.nextLine();
		 System.out.println("Enter your Salary : ");
		 salary = sc.nextLong();
		 
		 staff.put(nextStaffId, new Staff(name,staffid,salary,designation,department,gender,dob));
		 System.out.println(" Staff member added Successfully");
		 return;
	 }
	 public static void removeStaff() {
		 System.out.println("Enter the id of Staff to be deleted");
		 int id = sc.nextInt();
		 staff.remove(id);
		 System.out.println("Staff member removed Successfully");
		 return;
	 }
	 
	 
	 public static void updateAttendance() {
		 System.out.println(" Enter the id of student ");
		 int id = sc.nextInt();
		 Student stud = students.get(id);
		 stud.semester.get(stud.getCurrentSem()).updateAttendance();
		 return;
	 }
	 
	 public static void updateMarks() {
		 System.out.println("Enter the student id ");
		 int id = sc.nextInt();
		 System.out.println("Enter the semester ");
		 int sem = sc.nextInt();
		 students.get(id).semester.get(sem).addMarks();
	 }
	 
     public static void adminLogin() {
    	 
    	 
    	 System.out.println("Press appropriate buttons from below options : ");
    	 System.out.println(" 1 : add Student , 2 : remove Student , 3 : add Staff , 4 : remove Staff ,  5 : update Attendance , 6 : check Attendace , 7 : List of All Students ,  8 : exit , 9 : show All Staff");
    	 int type = sc.nextInt();
    	 
    	 if(type == 1) {
    		 addStudent();
    	 }
    	 else if(type==2) {
    		 removeStudent();
    	 }
    	 else if(type==3) {
    		 addStaff();
    	 }
    	 else if(type==4) {
    		 removeStaff();
    	 }
    	 else if(type==5) {
    		 System.out.println("Enter the id of student to update attendance : ");
    		 int id = sc.nextInt();
    		 int currsem = students.get(id).getCurrentSem();
    		 students.get(id).semester.get(currsem).updateAttendance();
    	 }
    	 else if(type==6) {
    		 System.out.println("Enter the id of student to check attendance : ");
    		 int id = sc.nextInt();
    		 int currsem = students.get(id).getCurrentSem();
    		 students.get(id).semester.get(currsem).checkAttendance();
    	 }
    	 else if(type==7) {
    		 for(Map.Entry<Integer,Student> elem : students.entrySet()) {
   			  
   			  int id = elem.getKey();
   			  Student stud = elem.getValue();
   			  System.out.println("student Id is : " + id + " and name is : " + stud.getName());
   		  }
    	 }
    	 else if(type==8)return;
    	 else if(type==9) {
    		 for(Map.Entry<Integer,Staff> elem : staff.entrySet()) {
   			  
   			  int id = elem.getKey();
   			  Staff emp = elem.getValue();
   			  System.out.println("student Id is : " + id + " and name is : " + emp.getName());
   		  }
    	 }
    	 else {
    		 System.out.println("please Choose from available options only");
    	 }
		 adminLogin();

    	 return;
     }
     
     public static void staffLogin() {
    	 
    	  System.out.println(" Press appropriate button from below options : ");
    	  System.out.println(" 1 : addStudent , 2 : removeStudent , 3 : update Marks , 4 : check Marks , 5 : exit");
    	  
    	  int type = sc.nextInt();
    	  
    	  if(type == 1) {
    		  addStudent();
    	  }
    	  else if(type==2) {
    		  removeStudent();
    	  }
    	  else if(type==3) {
    		  updateMarks();
    	  }
    	  else if(type==4) {
    		  System.out.println("Enter the id of student : ");
    		  int id = sc.nextInt();
    		  int currsem = students.get(id).getCurrentSem();
    		  students.get(id).semester.get(currsem).showAllMarks();
    	  }
    	  else if(type==5)return;
    	  
    	  staffLogin();
     }
     
     public static void studentLogin(int id) {
    	 
    	 System.out.println(" Press appropriate button from below options : ");
   	     System.out.println(" 1 : check Semester Marks , 2 : check entire Attendance , 3 : exit");
         
   	     int type = sc.nextInt();
   	     
   	     if(type==1) {
   	    	 int currsem = students.get(id).getCurrentSem();
   	    	 students.get(id).semester.get(currsem).showAllMarks();
   	     }
   	     else if(type==2) {
   	    	  int currsem = students.get(id).getCurrentSem();
   		      students.get(id).semester.get(currsem).showAttendance();
   	     }
   	     else if(type==3) {
   	    	 return;
   	     }
         studentLogin(id);
     }
     
	 public static void main(String[] args) {
		   
		   String admin_username = "hritik" ;
		   String admin_Password = "hritik123";
		   		   
		   // We can also take List for storing name, id to check id corresponding to name for specific tasks
		   		   
		   while(true) {
			   
			   System.out.println("press 1 to login as Admin \n" + "Press 2 to login as Staff \n" + "Press 3 to login as Student");
			   
			   int userType;
			   
			   userType = sc.nextInt(); 
			   
			   if(userType == 1) {  // admin login
				   System.out.println("Enter your username : ");
				   String uname = sc.next();
				   System.out.println("Enter your password : ");
				   String pswrd = sc.next();
				   
				   if(uname.equals(admin_username) && pswrd.equals(admin_Password)) {
					   adminLogin();
				   }
				   else System.out.println("You are not an Authorised Admin");
			   }
			   else if(userType == 2) {  // staff login
				   
				   System.out.println("Enter your Employee id : ");
				   int id = sc.nextInt();
				   System.out.println("Enter your password : ");
				   String pswrd = sc.next();
				   sc.nextLine();
				   
				   if(staff.containsKey(id) && staff.get(id).password.equals(pswrd)) {
					   staffLogin();
				   }
				   else {
					   System.out.println("You are not an Authorised Employee");
				   }
			   }
			   else if(userType==3) {   // student login
				   
				   System.out.println("Enter your Student id : ");
				   int id = sc.nextInt();
				   System.out.println("Enter your password : ");
				   String pswrd = sc.next();
				   
				   if(students.containsKey(id) && students.get(id).password.equals(pswrd)) {
					   studentLogin(id);
				   }
				   else {
					   System.out.println("You are not a Registered Student");
				   }
			   }
			   else continue;
			   
		   }
		   
		   
		   // teacher can update attendance of all students by reading from a file
		   // teacher can check attendance of particular student on a date.
	 }
}
