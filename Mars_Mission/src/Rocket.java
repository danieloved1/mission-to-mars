import java.util.ArrayList;

abstract public class Rocket implements Loadable, Dispatchable {
	// constant fields
	private int cost;
	private final int selfWeight;
	private final int maxWeight;
	// not really needed, since it is a difference between net and brut weight
	private final int cargoLimit;
	// variable field => loaded cargo weight
	private int cargo;
	private ArrayList<Item> items;

	public Rocket(int cost, int selfWeight, int maxWeight) {
		this.cost = cost;
		this.selfWeight = selfWeight;
		this.maxWeight = maxWeight;
		this.cargoLimit = maxWeight - selfWeight;
		this.cargo = 0;
		this.items = new ArrayList<Item>();
	}

	public int getCost() {
		return cost;
	}

	// Interface(s) implementations
	@Override
	public boolean canCarry(Item item) {
		return item.getWeight() + cargo <= cargoLimit;
	}

	@Override
	public void carry(Item item) {
		cargo += item.getWeight();
		cost += item.getPrice();
		items.add(item);
	}

	// Calculate chance of explosion/crash
	protected boolean chance(int percent) {
		int random = (int)(Math.random() * 100); // we work in percents
		float threshold = (float) percent * cargo / cargoLimit;
//		System.out.println("In chance " + random + ", " + threshold);
		return random > threshold;
	}

	protected String fullString(String who, int launch, int land) {
		return String.format("%s\n"
						+ "Rocket cost = $%d Million\n"
						+ "Rocket weight = %d Tonnes\n"
						+ "Max weight (with cargo) = %d Tonnes\n"
						+ "Chance of launch explosion = %d%% * (cargo carried / cargo limit)\n"
						+ "Chance of landing crash = %d%% * (cargo carried / cargo limit)"
				, who, cost, selfWeight/1000, maxWeight/1000, launch, land);
	}

}
