package uzletilogika;

import java.util.List;

import org.w3c.dom.NodeList;

/**
 * This interface is the formal requirement of the database's processing. 
 */


public interface XMLParser {
	/**
	 * Sets the file to a location.
	 * 
	 * @return the file location
	 */
	public String basedir();
	/**
	 * Returns the {@code NodeList} which contains all nodes ,
	 * whose tag's name equals to the input argument. 
	 * 
	 * @param name the node tag's name
	 * @return the list of the selected nodes
	 */
	public NodeList openFile(String name);
	/**
	 * Returns the question where the {@code sid} equals to the situation id,
	 * and whose {@code qid} equals to the question id.
	 * 
	 * @param qid is the id of Question
	 * @param sid is the id of Situation
	 * @return the {@code Question} from the questions
	 */
	public Question getQuestion(int qid , int sid);
	/**
	 * Returns the list of answers for the question given in this situation.
	 * @param questinid is the id of Question
	 * @param situationid is the id of Situation
	 * @return the {@code Answer} list of the selected answers on question
	 */
	public List<Answer> getAnswersToSituation(int situationid , int questinid);
	
	
}
