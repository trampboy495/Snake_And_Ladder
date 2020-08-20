import java.util.Random;

public class SnakeAndLadder{
	static int noOfDiceRolls = 0;
	static int noOfDiceRollsPlayer1 = 0;
	static int noOfDiceRollsPlayer2 = 0;
	static int positionOfPlayer1 = 0;
	static int positionOfPlayer2 = 0;
	static final int isSnake = 2;
	static final int isLadder = 1;
	static final int isNoPlay = 0;
	static int isPlayerOne = 1;
	static int isPlayerTwo = 2;
	static int whooseTurn = isPlayerOne;


	public static void playGame(){
		System.out.print("Dice Roll \t Player1 Position \t Player2 Position \n");
		while(positionOfPlayer1 < 100 && positionOfPlayer2 < 100){
			Random rand = new Random();
			int diceRoll = rand.nextInt(6) + 1;
			int checkCase = rand.nextInt(3);
			noOfDiceRolls++;
			updatePosition(whooseTurn , checkCase , diceRoll);
			System.out.print(noOfDiceRolls+" \t\t "+positionOfPlayer1+" \t\t\t "+positionOfPlayer2+"  \n");
		}
		if(positionOfPlayer1 == 100){
			System.out.println("Player 1 won and No of dice rolls required to win "+noOfDiceRollsPlayer1);
		}
		else{
			System.out.println("Player 2 won and No of dice rolls required to win "+noOfDiceRollsPlayer2);
		}
	}

	public static void updatePosition(int player, int checkCase , int diceRoll){
		switch(checkCase){
			case isLadder :
				if(player == isPlayerOne){
					positionOfPlayer1 += diceRoll;
					noOfDiceRollsPlayer1++;
					if(positionOfPlayer1 > 100){
						positionOfPlayer1 -= diceRoll;
					}
				}
				else{
					positionOfPlayer2 += diceRoll;
					noOfDiceRollsPlayer2++;
					if(positionOfPlayer2 > 100){
						positionOfPlayer2 -= diceRoll;
					}
				}
				break;
			case isSnake :
				if(player == isPlayerOne){
					positionOfPlayer1 -= diceRoll;
				}
				else{
					positionOfPlayer2 -= diceRoll;
				}
				changeTurn(player);
				break;
			default:
				changeTurn(player);
			}
	}

	public static void changeTurn(int player){
		if(player == isPlayerOne){
			noOfDiceRollsPlayer1++;
			if(positionOfPlayer1 < 0){
				positionOfPlayer1 = 0;
			}
			whooseTurn = isPlayerTwo;
		}
		else{
			noOfDiceRollsPlayer2++;
			if(positionOfPlayer2 < 0){
				positionOfPlayer2 = 0;
			}
			whooseTurn = isPlayerOne;
		}
	}

	public static void main(String[]args){
		playGame();
	}
}
