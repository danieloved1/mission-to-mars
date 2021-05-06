public interface Loadable {
	/**
	 *  Return true if there is enough capacity for the specified item
	 * @param item to check
	 * @return true/false
	 */
	boolean canCarry(Item item);

	/**
	 * Load the specified item on the rocket
	 * Note: the caller SHOULD check via canCarry() in advance
	 * If there is not enough space, the result is undefined
	 * @param item to load
	 */
	void carry(Item item);

	/**
	 * Convenience method to check negative status
	 * @param item to check
	 * @return opposite to canCarry()
	 */
	default boolean cannotCarry(Item item) {
		return !canCarry(item);
	}
}
