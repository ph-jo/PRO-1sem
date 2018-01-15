package model;

public class EmailEvaluator implements Evaluator {

	@Override
	public boolean isValid(String s) {
		String regex = "\\w+\\d*.*\\w*\\d*@+\\w+\\d*.*\\w+\\d*";
		if (s.matches(regex) && !s.equals("") && !s.contains("\\s")) {
			return true;
		}
		return false;
	}

}
