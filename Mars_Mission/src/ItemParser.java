public class ItemParser implements Parser<Item> {
	// Parsing configuration
	private static final String DELIMITERS = "=";
	private static final int NAME = 0;
	private static final int WEIGHT = 1;
	private static final int PRICE = 2;

	// Create new Item from String
	@Override
	public Item parse(String record) {
		String[] fields = record.split(DELIMITERS, 3);
		return new Item(fields[NAME], Integer.parseInt(fields[WEIGHT]), Integer.parseInt(fields[PRICE]));
	}

}
