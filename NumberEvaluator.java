package model;

public class NumberEvaluator implements Evaluator {

	@Override
	public boolean isValid(String s) {
		String regex = "-?\\d*\\.?\\d+E?\\d*";
		if (s.matches(regex) && !s.equals("")) {
			return true;
		}
		return false;
	}
}
