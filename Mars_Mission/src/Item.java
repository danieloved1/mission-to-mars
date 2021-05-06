public class Item {
	// Data fields
	private String name;// item name
	private int weight; // in kg
	int price; // for bonus stage


	public Item(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Item{'" + name + "', " + weight + '}';
	}
}
