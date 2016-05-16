package uzletilogika;

import java.util.List;

import org.w3c.dom.NodeList;

public interface XMLParser {

	public String basedir();
	public NodeList openFile(String name);
	public Question getQuestion(int qid , int sid);
	public List<Ansver> getAnsversToSituation(int situationid , int questinid);
	
	
}
