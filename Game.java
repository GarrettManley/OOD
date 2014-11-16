import java.util.Arrays;
import java.util.Scanner;

public class Game {
	public static void main (String args[]) {
		Dealer dealer = new Dealer();
		Player player = new Player();
		Scanner scan = new Scanner(System.in);
		String hit = "y"; //for determining if the player wants to hit
		boolean bust = false; //for determining if the player busted
		int bet = 0; // the bet
		String cont = "y"; //continue condition
		
		while(cont.equals("y")) {
			
			//betting
			System.out.println("Money left: " + player.money + "\nhow much would you like to bet?");
			bet = Integer.parseInt(scan.nextLine());
			
			//dealing
			dealer.deal(player);
			System.out.println("dealer showing: " + dealer.getHand()[0].getValue() + dealer.getHand()[0].getSuite());
			player.printHand();
			
			//hitting round
			System.out.println("would you like to hit?(y/n)");
			hit = scan.nextLine();
			while(hit.equals("y")){
				player.hit(dealer.dealHit());
				player.printHand();
				
				if(checkBust(player)) {
					System.out.println("Bust!");
					bust = true;
					break;
				}
				
				System.out.println("would you like to hit?(y/n)");
				hit = scan.nextLine();
			}
			
			//determination of winner
			if(bust) {
				System.out.println("you lose!");
				player.money = player.money - bet;
			}
			else {
				dealer.play(player);
				System.out.print("you: ");
				player.printHand();
				System.out.print("dealer: ");
				dealer.printHand();
				
				if(player.getTotal() <= dealer.getTotal() && dealer.getTotal() <= 21){
					System.out.println("you lose!");
					player.money = player.money - bet;
				}
				else{
					System.out.println("you win!");
					player.money = player.money + bet;
				}
			}
			
			//check for remaining money
			if(player.money <= 0) {
				System.out.println("you're broke! Get outa here!");
				break;
			}
			
			System.out.println("Would you like to play again?(y/n)");
			cont = scan.nextLine();
			
			//resets hands, bust, and totals
			Arrays.fill(player.hand, null);
			player.place = 0;
			player.total = 0;
			Arrays.fill(dealer.hand, null);
			dealer.place = 0;
			dealer.total = 0;
			bust = false;
		}
		
		scan.close();
	}
	
	public static boolean checkBust(Person p){
		if (p.getTotal() > 21)
			return true;
		else
			return false;
	}
}
