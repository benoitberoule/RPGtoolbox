package rollDice;



public class RollDice {
	
	public RollDice(){
	}
	
	public int[]roll (int[] listOfDice){
		int i;
		Dice[] resultOfDice = new Dice[listOfDice.length];
		
		for(i=0;i<resultOfDice.length;i++){
			resultOfDice[i]=new Dice (listOfDice[i]);
			resultOfDice[i].rollDice();
			listOfDice[i] = resultOfDice[i].result;
		}
		
		
		return listOfDice;
		
	}
	
	
}
