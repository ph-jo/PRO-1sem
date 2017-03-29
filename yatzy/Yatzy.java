package yatzy;


import java.util.Arrays;
import java.util.Random;

/**
 * Models a game of Yatzy.
 */
public class Yatzy {
	/**
	 * Face values of the 5 dice. <br/>
	 * 1 <= values[i] <= 6.
	 */
	private int[] values = new int[5];

	/**
	 * Number of times the 5 dice have been thrown. <br/>
	 * 0 <= throwCount <= 3.
	 */
	private int throwCount = 0;

	/**
	 * Random number generator.
	 */
	private Random random = new Random();

	/**
	 * Rolls the 5 dice. <br/>
	 * Only roll dice that are not hold. <br/>
	 * Requires: holds contain 5 boolean values.
	 */
	public void throwDice(boolean[] holds) {

		for(int i = 0; i < holds.length; i++) {
			if(!holds[i]) {
				int ran = random.nextInt(6) + 1;
				values[i] = ran;
				//System.out.println("Dice" + (i+1) + " = " + ran);
			}
		}

		throwCount++;
	}

	/**
	 * Returns the number of times the five dice have been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	/**
	 * Get current dice values
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Set the current dice values
	 */
	public void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns all results possible with the current face values. <br/>
	 * The order of the results is the same as on the score board.
	 */
	public int[] getPossibleResults() {
		int[] results = new int[15];
		for(int i = 0; i <= 5; i++) {
			results[i] = this.valueSpecificFace(i + 1);
		}
		results[6] = this.valueOnePair();
		results[7] = this.valueTwoPair();
		results[8] = this.valueThree();
		results[9] = this.valueFour();
		results[10] = this.valueFullHouse();
		results[11] = this.valueSmallStraight();
		results[12] = this.valueLargeStraight();
		results[13] = this.valueChance();
		results[14] = this.valueYatzy();
		return results;
	}

	/**
	 * Returns an int[7] containing the frequency of face values. <br/>
	 * Frequency at index v is the number of dice with the face value v, 1 <= v
	 * <= 6. <br/>
	 * Index 0 is not used.
	 */
	private int[] freqFaceValue() {

		int[] req = new int[7];
		for (int i = 0; i < values.length; i++){
			for(int j = 1; j < req.length; j++){
				if(j == values[i]){
					req[j]++;
				}
			}
			
		}
				
			
		

		return req;
		
	}

	/**
	 * Returns the total value for the dice currently showing the given face
	 * value
	 *
	 * @param face
	 *            the face value to return values for
	 */
	public int valueSpecificFace(int face) {

		
		
		int[] count = freqFaceValue();

		int numberToReturn = count[face];

		return numberToReturn*face;
	}

	/**
	 * Returns the maximum value for n-of-a-kind for the given n. <br/>
	 * For example, valueManyOfAKind(3) returns the maximum value for 3
	 * of-a-kind. <br/>
	 * Requires: 1 <= faceValue and faceValue <= 6
	 *
	 * @param n
	 *            number of kind
	 */
	public int valueManyOfAKind(int n) {
		int[] valuez = freqFaceValue();
		int sum = 0;
		for(int i = 1; i < valuez.length; i++){
			if(valuez[i] >= n){
				sum = n*i;
			}
		}
		return sum;
	}

	/**
	 * The current value if you try to score the current face values as Yatzy.
	 */
	public int valueYatzy() {
		boolean yatzy = true;
		int points = 0;
		int check = values[0];
		
		for(int i = 1; i < values.length; i++){
			if(values[i] != check) {
				yatzy = false;

			}
		}
		if(yatzy){
			points = 50;
		}
		return points;
		}

	/**
	 * Returns the current score if used as "chance".
	 */
	public int valueChance() {
		int sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum;
	}

	/**
	 * Returns the current score for one pair.
	 */
	public int valueOnePair() {
		int numberToCount = 0;
		int count = 0;
		int sum = 0;
		int highest = 0;

		for (int i = 0; i < values.length; i++) {

			numberToCount = values[i];

			for (int j = 0; j < values.length; j++) {

				if (values[j] == values[i] && values[j] == numberToCount) {
					if (j != i && values[j] > highest) {
						count++;
						highest = values[j];
					}
				}
			}

			if (count >= 1) {
				sum = highest;
				count = 0;
			}
		}

		return sum*2;
		
	}

	/**
	 * Returns the current score for two pairs.
	 */
	public int valueTwoPair() {
		int[] valuez = freqFaceValue();
		int sum = 0;
		int count = 0;
		int sum1 = 0;
		int sum2 = 0;
		/*
		for(int i = 1; i <=6; i++){
			for(int j = 0; j < values.length; j++){
				if(valueOnePair()/2==i){
					count++;
				}
			}
			if(count>=2){
				sum1=valueOnePair();
				}
			count = 0;
			}
			
	
		for(int i = 1; i <=6; i++){
			for(int j = 0; j < values.length; j++){
				if(valueOnePair()/2==i && i != sum1/2){
					count++;
				}
			}
			if(count>=2){
				sum2=valueOnePair();
			}
			count = 0;
		}
		*/
		for(int i = 1; i < valuez.length; i++) {
			if(valuez[i] >= 2) {
				count++;
				sum1=2*i;
				}
			if(count >=2){
				sum = 0;
			}
			count=0;
		}
		for(int i = 1; i < valuez.length; i++){
			if(valuez[i]>=2 && i != sum1/2){
				count++;
				sum2=2*i;
			}
			if(count >= 2){
				sum = 0;
			}
			count=0;
		}
		
		if(sum1 > 0 && sum2 > 0){
			sum = sum1+sum2;
		}
		return sum;
	}
	public int valueOnePairFix(){
		int[] valuez = freqFaceValue();
		int count = 0;
		int sum = 0;
		int highest = Integer.MAX_VALUE;
		int amount = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (values[j] == values[i]) {
					if (j != i && values[j] <= highest) {
						count++;
						highest = values[j];
						amount = valuez[i];
					}
				}
			
			}

			if (count >= 1 && amount == 2) {
				sum = highest;
				count = 0;
			}
		}
		System.out.println(amount);

		return sum*2;
	}
	

	/**
	 * Returns the current score for three of a kind.
	 */
	public int valueThree() {
		return valueManyOfAKind(3);
	}

	/**
	 * Returns the current score for four of a kind.
	 */
	public int valueFour() {
		return valueManyOfAKind(4);
	}

	/**
	 * Returns the value of a small straight with the current face values.
	 */
	public int valueSmallStraight(){
		int[] valuez = freqFaceValue();
		int sum = 1;
		for(int i = 1; i <= values.length; i++)
		{
			if(valuez[i] == 1 && valuez[6] == 0 && sum != 0)
			{
				sum = 15;
			}
			else{
				sum = 0;
			}
		}
		return sum;
	}
	/**
	 * Returns the value of a large straight with the current face values.
	 */
	public int valueLargeStraight() {
		int[] valuez = freqFaceValue();
		int sum = 0;
		for(int i = 1; i <= values.length; i++){
			if(valuez[i] == 1 && valuez[1] == 0){
				sum = 20;
			}
			else{
				sum = 0;
			}
		}
		return sum;
	}

	/**
	 * Returns the value of a full house with the current face values.
	 */
	public int valueFullHouse() {
		boolean fullHouse = false;
		int[] valuez = freqFaceValue();
		int sum3= 0;
		int sum2 = 0;
		//forsøg 1
		//if(valueThree() > 0 && valueOnePair() > 0){
				//	return valueThree() + valueOnePair();
				//}else{
				//	return 0;
			//	}
		//forsøg 2
		/* if (valueThree() > 0 && valueOnePair()> 0){
			if(valueThree()/3 != valueOnePair()/2){
				fullHouse = true;
			}
		}
		if(fullHouse){
			return valueOnePair() + valueThree();
		}
		else{
			return 0;
		}*/
		for(int i = 0; i < values.length; i++){
			if(valueThree() > 0 && valuez[i]==2){
				sum3 = valueThree();
				sum2 = valuez[i]*i;
			}
		}
		if(sum2>0&&sum3>0){
			return sum2+sum3;
		}
		else{
			return 0;
		}
	
		//forsøg 3
		/*for (int i = 0; i < values.length; i++){
			if (valuez[i] == 2){
				sum2 = 2*values[i];
			}
			if (valuez[i] == 3){
				sum3= 3*values[i];
			}
		}
		if(sum2>0&&sum3>0){
			return sum2+sum3;
		}
		else{
			return 0;
			
		}
		*/
		
		//forsøg 4
		//int[]fullHouseArray = values;
		//Arrays.sort(fullHouseArray);
		//int tempSum = 0;
		//if(fullHouseArray[0] == fullHouseArray[1] && fullHouseArray[1] == fullHouseArray[2] && fullHouseArray[2] == fullHouseArray[3] && fullHouseArray[3] == fullHouseArray[4]){
		//	return fullHouseArray[0] + fullHouseArray[1] +fullHouseArray[2] +fullHouseArray[3] +fullHouseArray[4];
	//	}
		//else{
	//		return 0;
	//	}
	}

}
