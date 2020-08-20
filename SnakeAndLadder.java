import java.util.Random;

public class SnakeAndLadder{
	static int noOfDiceRolls=0;
	static int positionOfPlayer=0;

	public static void playGame(){
		Random rand = new Random();
		int diceRoll = rand.nextInt(6) + 1;
	}

	public static void main(String[]args){
		playGame();
	}
}
