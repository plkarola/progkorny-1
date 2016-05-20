package uzletilogika;

import java.util.List;
/**
* The Question contains a question.
*/
public class Question {
	/**
 	*The id of the question.
 	*/
	private int id;
    /**
 	*The text of the question.
 	*/
	private List<String> questinoline;
	/**
 	*The day.
 	*/
	private String status;
    /**
    * Constructs a {@code Question} object.
    *
	* @param id the id of the question
	* @param questinoline the text of the question
	* @param status the day
	*/
	public Question(int id, List<String> questinoline, String status) {
		super();
		this.id = id;
		this.questinoline = questinoline;
		this.status = status;
	}
	/**
	*Returns the Id of this question.
	*
	*@return the id of this question
	*/
	public int getId() {
		return id;
	}
	/**
	*Sets the Id of this question.
	*
	*@param id the id of this question
	*/
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Returns the question string of this question.
	 *
	 * @return the string of this question
	 */
	public List<String> getQuestinoline() {
		return questinoline;
	}
	/**
	 * Sets the question string of the question.
	 *
	 * @param questinoline the question string of this question
	 */
	public void setQuestinoline(List<String> questinoline) {
		this.questinoline = questinoline;
	}
	/**
	 * Returns the day of this question.
	 *
	 * @return the day of this question
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Sets the day of the question.
	 *
	 * @param status the day of this question
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ",\n questinoline=" + questinoline + ", \nstatus=" + status + "]";
	}
}
