package uzletilogika;

public class Caracter {

	private int inteligent;
	private int energy;
	private int fuel;
	public String name;
	public Caracter(String name) {
		super();
		this.name = name;
		inteligent=0;
		fuel=100;
		energy=100;
	}
	public int getInteligent() {
		return inteligent;
	}
	public void setInteligent(int inteligent) {
		this.inteligent += inteligent;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy += energy;
	}
	public int getFuel() {
		return fuel;
	}
	public void setFuel(int fuel) {
		this.fuel += fuel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Caracter \n"
				+ "\tName=" + name
				+ "\n\tInteligent=" + inteligent 
				+ "\n\tEnergy=" + energy 
				+ "\n\tfuel=" + fuel ;
	}
	
	
	
}
