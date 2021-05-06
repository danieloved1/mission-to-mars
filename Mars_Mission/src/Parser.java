public interface Parser<T> {
	/**
	 * Parse string representation into a new instance of class T
	 * @param record string representation of T object
	 * @return new instance
	 */
	T parse(String record);
}
