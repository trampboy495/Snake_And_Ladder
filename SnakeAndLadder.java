import java.util.Random;

public class SnakeAndLadder{
	static int noOfDiceRolls=0;
	static int positionOfPlayer=0;
	static final int isSnake = 2;
	static final int isLadder = 1;
	static final int isNoPlay = 0;

	public static void playGame(){
		while(positionOfPlayer < 100 ){
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
			if(positionOfPlayer < 0 ){
				positionOfPlayer = 0;
			}
		}
	}

	public static void main(String[]args){
		playGame();
	}
}
