package absence;

public class TestAbsenceSystem {

    public static void main(String[] args) {
        int[][] absence15t = 
            { { 2, 0, 0, 0, 3, 1, 0, 2,  0, 0, 0, 0 },
              { 0, 0, 0, 0, 0, 0, 0, 0,  0, 0, 0, 0 },
              { 2, 0, 0, 0, 3, 1, 0, 2,  0, 0, 0, 0 },
              { 1, 2, 1, 2, 1, 2, 0, 2,  0, 0, 4, 0 },
              { 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };

        AbsenceSystem absenceSystem = new AbsenceSystem();
        
        absenceSystem.printAbsence(absence15t);
        
        System.out.print("Total absence for student 1: ");
       	System.out.println(absenceSystem.totalAbsence(absence15t, 0) + " days");       	
        System.out.print("Total absence for student 2: ");
       	System.out.println(absenceSystem.totalAbsence(absence15t, 1) + " days");      	
        System.out.print("Total absence for student 3: ");
       	System.out.println(absenceSystem.totalAbsence(absence15t, 2) + " days");       	
        System.out.print("Total absence for student 4: ");
       	System.out.println(absenceSystem.totalAbsence(absence15t, 3) + " days");       	
        System.out.print("Total absence for student 5: ");
       	System.out.println(absenceSystem.totalAbsence(absence15t, 4) + " days");
       	 
       	System.out.print("Average monthly absence for student 1: ");
       	System.out.println(absenceSystem.averageMonth(absence15t, 0) + " days");       	
       	System.out.print("Average monthly absence for student 2: ");
       	System.out.println(absenceSystem.averageMonth(absence15t, 1) + " days");       	
       	System.out.print("Average monthly absence for student 3: ");
       	System.out.println(absenceSystem.averageMonth(absence15t, 2) + " days");      	
       	System.out.print("Average monthly absence for student 4: ");
       	System.out.println(absenceSystem.averageMonth(absence15t, 3) + " days");
       	System.out.print("Average monthly absence for student 5: ");
       	System.out.println(absenceSystem.averageMonth(absence15t, 4) + " days");
       	
       	System.out.print("Students with no absence: ");
       	System.out.println(absenceSystem.studentWithoutAbsenceCount(absence15t));
       	
       	System.out.print("Student with the most absense: #");
       	System.out.println(absenceSystem.mostAbsentStudent(absence15t));
        
       	absenceSystem.reset(absence15t, 4);
       	absenceSystem.printAbsence(absence15t);
       

    }
}
