package uzletilogika;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLParserImp implements XMLParser {

	File xmlfile ;//= new File("../InGame/InGame.xml");
	
	
	
	public String basedir(){
				
		//Properties p = System.getProperties();
		//   p.list(System.out);
				
	String fileinput= System.getProperties().getProperty("user.dir").toString();
	Path path = FileSystems.getDefault().getPath(fileinput,"/classes/InGame/InGame.xml");
	
	xmlfile=new File(path.toString());
	return  path.toString();
	}
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuldar;
	
	@Override
	public NodeList openFile( String name) {
		Document doc = null;
		
		try {
			documentBuldar = factory.newDocumentBuilder();
		
			doc = documentBuldar.parse(xmlfile);

		
		
		NodeList list = doc.getElementsByTagName(name);
		return list;
		} catch (Exception e) {
			;
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
		
		
		return null;

	}

	@Override
	public List<Ansver> getAnsversToSituation(int situationid, int questinid) {
		
		List<Ansver> ansvers = new ArrayList<Ansver>();
		
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
						 Ansver ansver =new Ansver();
						 Element ans = (Element) element1.getElementsByTagName("Ansver").item(j);
					 ansver.setAnsverlines(ans.getElementsByTagName("p").item(0).getTextContent());
					 ansver.setEnergy(Integer.parseInt(ans.getElementsByTagName("energi").item(0).getTextContent()));
					 ansver.setFuel(Integer.parseInt(ans.getElementsByTagName("fuel").item(0).getTextContent()));
					 ansver.setId(Integer.parseInt(ans.getAttribute("id")));
					 ansver.setInteligenc(Integer.parseInt(ans.getElementsByTagName("inteligencia").item(0).getTextContent()));
					 ansver.setCategory(ans.getElementsByTagName("categori").item(0).getTextContent());
					
					 
					 ansvers.add(ansver);
					 }
				 }
				return ansvers;}
				}
				}
			}
		}catch (Exception e) {
					return null;
				}
		return null;
	}
}
