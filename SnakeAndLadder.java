import java.util.Random;

public class SnakeAndLadder{
	static int diceRoll=0;
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
		while(positionOfPlayer1 < 100 && positionOfPlayer2 < 100){
			Random rand = new Random();
			diceRoll = rand.nextInt(6) + 1;
			int checkCase = rand.nextInt(3);
			noOfDiceRolls++;
			updatePosition(whooseTurn , checkCase , diceRoll);
		}
		if(positionOfPlayer1 == 100){
			System.out.print("Player 1 won and No of dice rolls required to win "+noOfDiceRollsPlayer1+
				"\n Player 2 dice rolls are "+noOfDiceRollsPlayer2+" \n Total Dice rolls are "+noOfDiceRolls);
		}
		else{
			System.out.print("Player 2 won and No of dice rolls required to win "+noOfDiceRollsPlayer2+
			        "\n Player 1 dice rolls are "+noOfDiceRollsPlayer1+" \n Total Dice rolls are "+noOfDiceRolls);
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
					System.out.println("player 1 landed on ladder dice no is "+diceRoll+" and current position of player 1 is "+positionOfPlayer1);
				}
				else{
					positionOfPlayer2 += diceRoll;
					noOfDiceRollsPlayer2++;
					if(positionOfPlayer2 > 100){
						positionOfPlayer2 -= diceRoll;
					}
					System.out.println("player 2 landed on ladder dice no is "+diceRoll+" and current position of player 2 is "+positionOfPlayer2);
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
				String whichPlayer = (player == isPlayerOne) ? ("Player 1") : ("Player 2");
				if(player == isPlayerOne){
					noOfDiceRollsPlayer1++;
					whooseTurn = isPlayerTwo;
				} else {
					noOfDiceRollsPlayer2++;
					whooseTurn = isPlayerOne;
				}
				System.out.println(whichPlayer+" landed on no play");
			}
	}

	public static void changeTurn(int player){
		if(player == isPlayerOne){
			noOfDiceRollsPlayer1++;
			if(positionOfPlayer1 < 0){
				positionOfPlayer1 = 0;
			}
			System.out.println("player 1 landed on snake dice no is "+diceRoll+" and current position of player 1 is "+positionOfPlayer1);
			whooseTurn = isPlayerTwo;
		}
		else{
			noOfDiceRollsPlayer2++;
			if(positionOfPlayer2 < 0){
				positionOfPlayer2 = 0;
			}
			System.out.println("player 2 landed on snake dice no is "+diceRoll+" and current position of player 2 is "+positionOfPlayer2);
			whooseTurn = isPlayerOne;
		}
	}

	public static void main(String[]args){
		playGame();
	}
}
