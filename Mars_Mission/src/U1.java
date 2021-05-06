public class U1 extends Rocket {
	// Class Data fields (all are constants)
	private static final int SELF_WEIGHT = 10 * 1000; // Tonnes
	private static final int MAX_WEIGHT = 18 * 1000; // Tonnes
	private static final int SELF_PRICE = 100; // $M
	private static final int LAUNCH_EXPLOSION_CHANCE = 15; // %
	private static final int LAND_CRASH_CHANCE = 5; // %

	public U1() {
		super(SELF_PRICE, SELF_WEIGHT, MAX_WEIGHT);
	}

	@Override
	public boolean launch() {
		return chance(LAUNCH_EXPLOSION_CHANCE);
	}

	@Override
	public boolean land() {
		return chance(LAND_CRASH_CHANCE);
	}

	@Override
	public String toString() {
		return super.fullString("U1", LAUNCH_EXPLOSION_CHANCE, LAND_CRASH_CHANCE);
	}
}
