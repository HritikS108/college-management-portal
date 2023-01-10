import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// using enum so that i can iterate on them easily and store in map, also provides readability.

enum Sem1{
	Linear_Algebra,
	Introduction_To_Programming, 
	Physics, Principles_Of_Management, 
	Professional_Communication,
	Fundamentals_Of_Electrical_Engineering;
}

enum Sem2{
   Discrete_Mathematics,
   Data_Structures,
   Principle_Of_Economics,
   Computer_Organization_And_Architecture,
   Univariate_And_Multivariate_Calculus;
}

enum Sem3{
	Probability_And_Statistics,
	Introduction_To_Finance,
	Operating_System,
	Marketing,
	Object_Oriented_programming;
}

enum Sem4{
	Software_Engineering,
	Database_Management,
	Computer_Networks,
	Design_And_Analysis_Of_Algorithms,
	principles_Of_Programming_Languages;
}

enum Sem5{
	Network_Security,
	Artificial_Intelligence,
	Image_And_Video_Processing,
	Introduction_To_Machine_learning,
	Mini_Project;
}

enum Sem6{
	Data_Mining,
	Major_Project;
}

public class Semester {

	HashMap<String,Double> subject = new HashMap<String,Double>();   // subject,marks -> using map because arrayList don't have string index
    
	HashMap<LocalDate,Character> attendance = new HashMap<LocalDate,Character>();  
	Scanner sc = new Scanner(System.in);
	
	LocalDate startDate , endDate;
	
	   
	   public Semester(int sem){
		   
		    if(sem == 1) {
//		    	Conversion of enum to set and applying forEach
		        startDate = LocalDate.now();
		        endDate =  LocalDate.now().plusMonths(6);
		        		
		    	EnumSet.allOf(Sem1.class).forEach(sub -> subject.put(sub.toString(), 0.0));
		    }
		    else if(sem == 2) {
		    	startDate = LocalDate.now().plusMonths(6);
			    endDate =  LocalDate.now().plusMonths(12);
		    	EnumSet.allOf(Sem2.class).forEach(sub -> subject.put(sub.toString(), 0.0));
		    }
		    else if(sem == 3) {
		    	startDate = LocalDate.now().plusMonths(12);
			    endDate =  LocalDate.now().plusMonths(18);
		    	EnumSet.allOf(Sem3.class).forEach(sub -> subject.put(sub.toString(), 0.0));
		    }
		    else if(sem == 4) {
		    	startDate = LocalDate.now().plusMonths(18);
			    endDate =  LocalDate.now().plusMonths(24);
		    	EnumSet.allOf(Sem4.class).forEach(sub -> subject.put(sub.toString(), 0.0));
		    }
		    else if(sem == 5) {
		    	startDate = LocalDate.now().plusMonths(24);
			    endDate =  LocalDate.now().plusMonths(30);
		    	EnumSet.allOf(Sem5.class).forEach(sub -> subject.put(sub.toString(), 0.0));
		    }
		    else if(sem == 6) {
		    	startDate = LocalDate.now().plusMonths(30);
			    endDate =  LocalDate.now().plusMonths(36);
		    	EnumSet.allOf(Sem6.class).forEach(sub -> subject.put(sub.toString(), 0.0));
		    }
		    
	   }
	   

		public void checkAttendance() {
			 System.out.println("enter the date in yyyy-mm-dd : ");
			 String date = sc.next();
			 sc.nextLine();
			 System.out.println(attendance.get(LocalDate.parse(date)));
			 return;
		}
		public void updateAttendance() {
			System.out.println("Enter the date in yyyy-mm-dd ");
			String date = sc.next();
			sc.nextLine();
			System.out.println("Enter 'P' or 'A' :");
			char val = sc.next().charAt(0);
			attendance.put(LocalDate.parse(date), val);
			return ;
		}
	   public void addMarks() {
		   System.out.println("Choose the subject whose marks to be updated : ");
		   for(Map.Entry<String,Double> elem : subject.entrySet()) {
				  
				  String subj = elem.getKey();
				  System.out.print(subj + "  ");
			  }
		   
		   String subjectName = sc.next();
		   sc.nextLine();
		   System.out.println("Enter the marks : ");
		   Double marks = sc.nextDouble();
		   
		   subject.put(subjectName,marks);
		   return;
	   }
	   
	   public void showAllMarks() {
		   System.out.println("Below are the marks of given candidate : ");
		   for(Map.Entry<String,Double> elem : subject.entrySet()) {
				  System.out.println(elem.getKey() + "   " + elem.getValue());
			  }
	   }
	   
	   public void showAttendance() {
		   
		   for(Map.Entry<LocalDate,Character> elem : attendance.entrySet()) {
				  
				  String date = elem.getKey().toString();
				  System.out.print(date + "  " + elem.getValue());
			  }
		   return;
	   }
}

