public class U2 extends Rocket {
	// Class Data fields (all are constants)
	private static final int SELF_WEIGHT = 18 * 1000; // Tonnes
	private static final int MAX_WEIGHT = 29 * 1000; // Tonnes
	private static final int SELF_PRICE = 120; // $M
	private static final int LAUNCH_EXPLOSION_CHANCE = 12; // %
	private static final int LAND_CRASH_CHANCE = 16; // %

	public U2() {
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
		return super.fullString("U2", LAUNCH_EXPLOSION_CHANCE, LAND_CRASH_CHANCE);
	}
}
