package uzletilogika;

/**
* The Answer contains an answer.
*/
public class Answer {
	/**
 	*The id of the answer.
 	*/
	private int id;
	/**
	 *The answer text of the answer.
	 */
	private String answerlines;
	/**
	 *The modifier intelligence of the {@code Character}. 
	 */
	private int intelligence;
	/**
	 *The modifier energy of the {@code Character}.
	 */
	private int energy;
	/**
	 *The modifier fuel of the {@code Character}.
	 */
	private int fuel;
	/**
	 *The category which chooses of the next Question. 
	 */
	private String category;
	
	
	/**
	 * Constructs an {@code Answer} object.
	 */
	public Answer(){
		
	}

	@Override
	public String toString() {
		return "\nAnsver [id=" + id + ", \n\tansverlines=" + answerlines + ",\n\t inteligenc=" + intelligence + ",\n\t energy=" + energy
				+ ",\n\t fuel=" + fuel + ",\n\t category=" + category + "]";
	}
	/**
	 * Constructs an {@code Answer} object.
	 *
	 * @param id the id of the answer
	 * @param answerlines the text of the answer
	 * @param intelligence the modifier intelligence of the character
	 * @param energy the modifier energy of the character
	 * @param fuel the modifier fuel of the character
	 * @param category which chooses the new question
	 */
	public Answer(int id, String answerlines, int intelligence, int energy, int fuel, String category) {
		super();
		this.id = id;
		this.answerlines = answerlines;
		this.intelligence = intelligence;
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
	public String getAnswerlines() {
		return answerlines;
	}
	/**
	 * Sets the answer string of the answer.
	 *
	 * @param answerlines the answer string of this answer
	 */
	public void setAnswerlines(String answerlines) {
		this.answerlines = answerlines;
	}
	/**
	*Returns the modifiers value of intelligence.
	*
	*@return modifiers value of intelligence of {@code Caracter}
	*/
	public int getIntelligence() {
		return intelligence;
	}
	/**
	*Sets the value of intelligence which belongs to this answer.
	*
	*@param intelligence the value of intelligence of this answer
	*/
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	/**
	*Returns the modifiers value of energy.
	*
	*@return modifiers value of energy of {@code Character}
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
	*@return modifiers value of fuel of {@code Character}
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
