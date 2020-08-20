import java.util.Random;

public class SnakeAndLadder{
	static int noOfDiceRolls=0;
	static int positionOfPlayer=0;
	static final int isSnake = 2;
	static final int isLadder = 1;
	static final int isNoPlay = 0;

	public static void playGame(){
		Random rand = new Random();
		int diceRoll = rand.nextInt(6) + 1;
		int checkCase = rand.nextInt(3);
		switch(checkCase){
			case isLadder :
				positionOfPlayer += diceRoll;
				break;
			case isSnake :
				positionOfPlayer -= diceRoll;
				break;
		}
		System.out.println(positionOfPlayer);
	}

	public static void main(String[]args){
		playGame();
	}
}
