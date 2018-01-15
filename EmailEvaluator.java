package model;

public class EmailEvaluator implements Evaluator {

	@Override
	public boolean isValid(String s) {
	    boolean erStrengenEnMail = false;
		try {
			if (s.matches("[A-Z0-9._%+-]@*[A-Z0-9.-].*[A-Z]")) {
				erStrengenEnMail = true;
			}
			return erStrengenEnMail;
		}
		catch (Exception e) {
	    	return false;
		}
	}

}
