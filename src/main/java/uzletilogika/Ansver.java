package uzletilogika;

public class Ansver {

	private int id;
	private String ansverlines;
	private int inteligenc;
	private int energy;
	private int fuel;
	private String category;
	
	
	
	public Ansver(){
		
	}
	
	@Override
	public String toString() {
		return "\nAnsver [id=" + id + ", \n\tansverlines=" + ansverlines + ",\n\t inteligenc=" + inteligenc + ",\n\t energy=" + energy
				+ ",\n\t fuel=" + fuel + ",\n\t category=" + category + "]";
	}

	public Ansver(int id, String ansverlines, int inteligenc, int energy, int fuel, String category) {
		super();
		this.id = id;
		this.ansverlines = ansverlines;
		this.inteligenc = inteligenc;
		this.energy = energy;
		this.fuel = fuel;
		this.category = category;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnsverlines() {
		return ansverlines;
	}
	public void setAnsverlines(String ansverlines) {
		this.ansverlines = ansverlines;
	}
	public int getInteligenc() {
		return inteligenc;
	}
	public void setInteligenc(int inteligenc) {
		this.inteligenc = inteligenc;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getFuel() {
		return fuel;
	}
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

	
	
}
