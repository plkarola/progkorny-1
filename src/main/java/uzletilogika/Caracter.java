package uzletilogika;

/**
 *This class contains informations of the player's character.
 */

public class Caracter {

	/**
	 *The character's intelligence level. 
	 */
	private int inteligent;
	/**
	 *The character's intelligence level. 
	 */
	private int energy;
	/**
	 *The character's energy level. 
	 */
	private int fuel;
	/**
	 *The character's nick name. 
	 */
	public String name;
	
	/**
	 * Constructs a {@code Caracter} object.
	 *
	 * @param name the name of the character
	 */
	public Caracter(String name) {
		super();
		this.name = name;
		inteligent=0;
		fuel=100;
		energy=100;
	}
	/**
	 *Returns the character's intelligence. 
	 * 
	 * @return the intelligence of the character
	 */
	public int getInteligent() {
		return inteligent;
	}
	/**
	 *Sets the character's intelligence. 
	 * 
	 * @param inteligent the intelligence of the character
	 */
	public void setInteligent(int inteligent) {
		this.inteligent += inteligent;
	}
	/**
	 * Returns the character's energy.
	 * 
	 * @return the energy of the character
	 */
	public int getEnergy() {
		return energy;
	}
	/**
	 *Sets the character's energy. 
	 * 
	 * @param energy the energy of the character
	 */
	public void setEnergy(int energy) {
		this.energy += energy;
	}
	/**
	 * Returns the character's fuel.
	 * 
	 * @return the fuel of the character
	 */
	public int getFuel() {
		return fuel;
	}
	/**
	 *Sets the character's fuel. 
	 * 
	 * @param fuel the fuel of the character
	 */
	public void setFuel(int fuel) {
		this.fuel += fuel;
	}
	/**
	 * Returns the character's name.
	 * 
	 * @return the name of the character
	 */

	public String getName() {
		return name;
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
