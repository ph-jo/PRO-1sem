package absence;

public class AbsenceSystem {
    /**
     * Print the absence table on the screen
     */
    public void printAbsence(int[][] absence) {
    	System.out.println("Absence stats for all students:");
        for(int row = 0; row < absence.length; row++){
        	for(int col = 0; col < absence[0].length; col++){
        		System.out.print(absence[row][col] + " ");
        	}
        	System.out.println();
        }
    }
  
    
    /**
     * Returns the total number of absent days for the given student during the last 12 months.
     */
    public int totalAbsence(int[][] absence, int studentNumber) {
    	int absentDays = 0;
    	if (studentNumber < absence.length){
        	for(int abs = 0; abs < absence[0].length; abs++){
        		if(absence[studentNumber][abs] != 0){
        			absentDays += absence[studentNumber][abs];
        		}
        	}
    	}
    	 return absentDays;
    }

    /**
     * Returns the average monthly number of absent days for the given student.
     */
    public double averageMonth(int[][] absence, int studentNumber) {
        double absentDays = 0;
        for (int abs = 0; abs < absence[0].length; abs++){
        	if(absence[studentNumber][abs] != 0){
        		absentDays += absence[studentNumber][abs];
        	}
        }
        return Math.round(absentDays/absence[0].length*100.00)/100.00;
    }

    /**
     * Returns the number of students without any absence during the last 12 months.
     * 
     */
    public int studentWithoutAbsenceCount(int[][] absence) {
    	int absFreeStu = 0;
        for(int row = 0; row < absence.length; row++){
        	int absentDays = 0;
        	for(int col = 0; col < absence[0].length; col++){
        		if(absence[row][col] != 0){
        			absentDays += absence[row][col];
        		}
        	}
        	if(absentDays == 0){
        		absFreeStu++;
        	}
        }
        return absFreeStu;
    }
    
   

    /**
     * Returns the student with the most absence during the last 12 months.
     * If more than one student has the most absence, return any one of them.
     */
    public int mostAbsentStudent(int[][] absence) {
    	int absentDays = 0;
    	int mostAbsent = 0;
        for(int stu = 0; stu < absence.length; stu++){
        	if(totalAbsence(absence, stu) > absentDays){
        		absentDays = totalAbsence(absence, stu);
        		mostAbsent = stu+1;
        	}
        }
        return mostAbsent;
    }

    /**
     * Resets the absence to 0 for the given student during the last 12 months.
     */
    public void reset(int[][] absence, int studentNumber) {
        for(int abs = 0; abs < absence[0].length; abs++){
        	absence[studentNumber-1][abs] = 0;
        }
        System.out.println("All absence for student #" + studentNumber + " has been removed");
    }
}
