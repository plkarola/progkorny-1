package uzletilogika;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * This class implements the {@code XMLParser}. 
 */

public class XMLParserImp implements XMLParser {

	/**
	 * This is document builder factory which sets up the document builder.  
	 */
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	/**
	 * This is the document builder that builds the XML file in memory. 
	 */
	DocumentBuilder documentBuldar;
	
	/**
	 * This is the file which is used by the methods. 
	 */
	public File xmlfile ;
	
	@Override
	public String basedir(){

	String fileinput= System.getProperties().getProperty("user.dir").toString();
	Path path = FileSystems.getDefault().getPath(fileinput,"/classes/InGame/InGame.xml");
	xmlfile=new File(path.toString());
	if(!xmlfile.isFile())
		System.out.println("Please install game");
	return  path.toString();
	}
	
	
	@Override
	public NodeList openFile( String name) {
		Document doc = null;
		
		try {
			documentBuldar = factory.newDocumentBuilder();
		
			doc = documentBuldar.parse(xmlfile);

		
		
		NodeList list = doc.getElementsByTagName(name);
		return list;
		} catch (Exception e) {
			System.out.println("Please Install Game");;
			}
		return null;
		}

	
	@SuppressWarnings("unused")
	@Override
	public Question getQuestion(int qid , int sid) {
		
				
		int idq =-1;
		String status = null;
		List<String> questions =new ArrayList<String>();
		NodeList nodelist1 = openFile("Situation");
		if(nodelist1!=null){
		for(int i = 0 ; i<nodelist1.getLength();i++)
		{
			Node node = nodelist1.item(i);
			Element element = (Element) node;
			if(Integer.parseInt(element.getAttribute("id"))==sid)
			{
				try{ 
				status = element.getElementsByTagName("status").item(0).getTextContent();}catch(NullPointerException e ){;}
				for(int k = 0 ; k<=element.getElementsByTagName("Question").getLength();k++){
				Element element1 = (Element) element.getElementsByTagName("Question").item(k);
				if(Integer.parseInt(element1.getAttribute("id"))==qid)
				 {idq= qid;
				 for(int j = 0 ; j< element1.getElementsByTagName("p").getLength();j++)
					 questions.add(element1.getElementsByTagName("p").item(j).getTextContent());
				 }
				return new Question(idq , questions , status);
			}
				}
		}
		
			}
		return null;

	}
	
	@Override
	public List<Answer> getAnswersToSituation(int situationid, int questinid) {
		
		List<Answer> answers = new ArrayList<Answer>();
		
		NodeList nodelist1 = openFile("Situation");
		try{
		for(int i = 0 ; i<nodelist1.getLength();i++)
		{
			Node node = nodelist1.item(i);
			Element element = (Element) node;
			if(Integer.parseInt(element.getAttribute("id"))==situationid)
			{
				for(int k = 0 ; k<=element.getElementsByTagName("Ansvers").getLength();k++){
				Element element1 = (Element) element.getElementsByTagName("Ansvers").item(k);
				if(Integer.parseInt(element1.getAttribute("id"))==questinid)
				 {
				 for(int j = 0 ; j< element1.getElementsByTagName("Ansver").getLength();j++){
					 {
						 Answer answer =new Answer();
						 Element ans = (Element) element1.getElementsByTagName("Ansver").item(j);
					 answer.setAnswerlines(ans.getElementsByTagName("p").item(0).getTextContent());
					 answer.setEnergy(Integer.parseInt(ans.getElementsByTagName("energi").item(0).getTextContent()));
					 answer.setFuel(Integer.parseInt(ans.getElementsByTagName("fuel").item(0).getTextContent()));
					 answer.setId(Integer.parseInt(ans.getAttribute("id")));
					 answer.setIntelligence(Integer.parseInt(ans.getElementsByTagName("inteligencia").item(0).getTextContent()));
					 answer.setCategory(ans.getElementsByTagName("categori").item(0).getTextContent());
					
					 
					 answers.add(answer);
					 }
				 }
				return answers;}
				}
				}
			}
		}catch (Exception e) {
					return null;
				}
		return null;
	}
}
