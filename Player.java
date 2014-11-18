
class Player extends Person {
	@SuppressWarnings("unused")
	private int money;
	private int bet;

	public Player(int m) {
		this.hand.addObserver(bo);
		this.money = m;
		this.personType = 1;
	}
	
	public void bet(int b){
		this.bet = b;
	}
	
	public void lose(){
		this.money-=this.bet;
	}
	
	public void win(){
		this.money+=this.bet;
	}
	
}
