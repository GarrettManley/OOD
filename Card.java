
public abstract class Card {
	public final void makeCard(int v){
		assignSuite();
		assignValue(v);
	}
	public abstract void assignSuite();
	public abstract void assignValue(int v);
	public abstract int getNumValue();
	public abstract String getValue();
	public abstract String getSuite();
}
