
public class Game {
	private Dealer dealer = new Dealer();
	private Player player = new Player(10000);
	
	public Game(){}
	
	public void initialDeal(){
		dealer.deal(player);
		dealer.deal(dealer);
		dealer.deal(player);
		dealer.deal(dealer);
	}
	
	public static void main(String[] args){
		Game g = new Game();
		
		g.initialDeal();
		
		System.out.println("Dealer Hand Value:\t" + g.dealer.hand.getHandValue());
		System.out.println("Player Hand Value:\t" + g.player.hand.getHandValue());
	}
	
}
