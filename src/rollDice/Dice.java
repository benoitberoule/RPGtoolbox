package rollDice;
import java.util.Random;

public class Dice {
	
	protected int numberOfFace;
	protected int result;
	
	public Dice(int n){
		numberOfFace = n;
		
	}
	
	
	public void rollDice(){
		Random randomResult = new Random();
		
		result= randomResult.nextInt(numberOfFace)+1;
	}
		
}
