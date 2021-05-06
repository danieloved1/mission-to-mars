public interface Dispatchable {
	/**
	 * Return success of launch attempt
	 * @return true/false
	 */
	boolean launch();

	/**
	 * Return success of land attempt
	 * @return true/false
	 */
	boolean land();
}
