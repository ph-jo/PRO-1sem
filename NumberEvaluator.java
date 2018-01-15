package model;

public class NumberEvaluator implements Evaluator {

	@Override
	public boolean isValid(String s) {
		try {
			Double.parseDouble(s);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}