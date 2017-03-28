public int valueFullHouse() {
		boolean fullHouse = false;
		if (valueThree() > 0 && valueOnePair()> 0){
			if(valueThree()/3 != valueOnePair()/2){
				fullHouse = true;
			}
		}
		if (fullHouse){
			return valueOnePair() + valueThree();
		}
		else{
			return 0;
		}
	}
