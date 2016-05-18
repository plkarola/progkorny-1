package uzletilogika;

/**
* The Ansver contains an answer.
*/
public class Ansver {
	/**
 	*The id of the answer.
 	*/
	private int id;
	/**
	 *The answer text of the answer.
	 */
	private String ansverlines;
	/**
	 *The modifier intelligence of the {@code Caracter}. 
	 */
	private int inteligenc;
	/**
	 *The modifier energy of the {@code Caracter}.
	 */
	private int energy;
	/**
	 *The modifier fuel of the {@code Caracter}.
	 */
	private int fuel;
	/**
	 *The category which chooses of the next Question. 
	 */
	private String category;
	
	
	/**
	 * Constructs an {@code Ansver} object.
	 */
	public Ansver(){
		
	}

	@Override
	public String toString() {
		return "\nAnsver [id=" + id + ", \n\tansverlines=" + ansverlines + ",\n\t inteligenc=" + inteligenc + ",\n\t energy=" + energy
				+ ",\n\t fuel=" + fuel + ",\n\t category=" + category + "]";
	}
	/**
	 * Constructs an {@code Ansver} object.
	 *
	 * @param id the id of the answer
	 * @param ansverlines the text of the answer
	 * @param inteligenc the modifier intelligence of the character
	 * @param energy the modifier energy of the character
	 * @param fuel the modifier fuel of the character
	 * @param category which chooses the new question
	 */
	public Ansver(int id, String ansverlines, int inteligenc, int energy, int fuel, String category) {
		super();
		this.id = id;
		this.ansverlines = ansverlines;
		this.inteligenc = inteligenc;
		this.energy = energy;
		this.fuel = fuel;
		this.category = category;
	}
	/**
	*Returns the Id of this answer.
	*
	*@return the id of this answer
	*/	
	
	public int getId() {
		return id;
	}
	/**
	*Sets the Id of this answer.
	*
	*@param id the id of this answer
	*/
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the answer string of this answer.
	 *
	 * @return the string of this answer
	 */
	public String getAnsverlines() {
		return ansverlines;
	}
	/**
	 * Sets the answer string of the answer.
	 *
	 * @param ansverlines the answer string of this answer
	 */
	public void setAnsverlines(String ansverlines) {
		this.ansverlines = ansverlines;
	}
	/**
	*Returns the modifiers value of intelligence.
	*
	*@return modifiers value of intelligence of {@code Caracter}
	*/
	public int getInteligenc() {
		return inteligenc;
	}
	/**
	*Sets the value of intelligence which belongs to this answer.
	*
	*@param inteligenc the value of intelligence of this answer
	*/
	public void setInteligenc(int inteligenc) {
		this.inteligenc = inteligenc;
	}
	/**
	*Returns the modifiers value of energy.
	*
	*@return modifiers value of energy of {@code Caracter}
	*/	
	public int getEnergy() {
		return energy;
	}
	/**
	*Sets the value of energy which belongs to this answer.
	*
	*@param energy the value of energy of this answer
	*/
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	/**
	*Returns the modifiers value of fuel.
	*
	*@return modifiers value of fuel of {@code Caracter}
	*/
	public int getFuel() {
		return fuel;
	}
	/**
	*Sets the value of fuel which belongs to this answer.
	*
	*@param fuel the value of fuel of this answer
	*/
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	/**
	*Returns the category which tells the next question.
	*
	*@return category which tells the next question 
	*/
	public String getCategory() {
		return category;
	}
	/**
	*Sets the category  which belongs to this answer.
	*
	*@param category the category this answer
	*/
	public void setCategory(String category) {
		this.category = category;
	}
	

	
	
}
