import java.util.ArrayList;

public class Simulation {
	private static int totalSent;
	private static int totalLost;
	private static int totalCost;

	public Simulation() {
		this.totalSent = 0;
		this.totalLost = 0;
		this.totalCost = 0;
	}



	@Override
	public String toString() {
		return String.format("Simulation { totalSent = %d | totalLost = %d | totalCost = %d }",
				this.totalSent,
				this.totalLost,
				this.totalCost);
	}

	public static ArrayList<U1> loadU1(ArrayList<Item> items) {
		ArrayList<U1> u1s = new ArrayList<>();

		U1 u1 = new U1();
		for (Item item: items) {
			if (u1.cannotCarry(item)) {
				u1s.add(u1);
				u1 = new U1();
			}
			u1.carry(item);
		}
		u1s.add(u1);
		System.out.println("# of rockets loaded = " + u1s.size());
		return u1s;
	}

	public static ArrayList<U2> loadU2(ArrayList<Item> items) {
		ArrayList<U2> u2s = new ArrayList<>();

		U2 u2 = new U2();
		for (Item item: items) {
			if (u2.cannotCarry(item)) {
				u2s.add(u2);
				u2 = new U2();
			}
			u2.carry(item);
		}
		u2s.add(u2);
		System.out.println("# of rockets loaded = " + u2s.size());
		return u2s;
	}

	public static int runSimulation(ArrayList<? extends Rocket> rockets) {
		int cost = 0;
		int lost = 0;

		for (Rocket rocket : rockets) {
			while (!(rocket.launch() && rocket.land())) {
				cost += rocket.getCost();
				lost++;
			}
			cost += rocket.getCost();
		}

		totalSent += (lost + rockets.size());
		totalLost += lost;
		totalCost += cost;

		System.out.println("Total rockets lost " + lost);
		System.out.println("Total rockets sent " + (lost + rockets.size()));
		return cost;
	}

}
