

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uzletilogika.Character;
import uzletilogika.Main;
import uzletilogika.OverrideMethod;
import uzletilogika.XMLParserImp;

public class JTest {

	XMLParserImp xmlparser = new XMLParserImp();
	Main main =new Main();
	@Before
	public void initialized(){
		xmlparser.basedir();
	}
	
	
	@Test
	public void getQuestionTest() {
		assertEquals(true,xmlparser.getQuestion(1, 1)!=null);
	}
	@Test
	public void getAnswerTest(){
		
		assertEquals(true,xmlparser.getAnswersToSituation(xmlparser.getQuestion(1, 1).getId(), 1)==null);
	}
	@Test
	public void getAnswerTest2(){
		
		assertEquals(true,xmlparser.getAnswersToSituation(2, 1).get(0).getId()==1);
	}
	@Test
	public void openFileTest(){
		assertEquals(true,xmlparser.openFile("Situation")!=null);
	}
	@Test
	public void successTest1(){
		
		assertEquals(true, main.finish(true, 101).equals("Sikeresen teljesítetted a tárgyakat"));
	}
	@Test
	public void successTest2(){
		
		assertEquals(true, main.finish(true, 99).equals("Eljutottál vizsgáig de az intelligenciád:99 túl kicsi, minimum 100 kell, ezért vizsgakurzusra kerültél"));
	}
	@Test
	public void characterTest(){
		Character car = new Character("PB");
		boolean carbool = false , carbool2=false , carbool3 = false;
		if(car.getIntelligence()==0 
				&& car.getEnergy()==100 
				&& car.getFuel()==100
				&& car.getName().equals("PB"))
			carbool=true;
		car.setEnergy(1);
		car.setIntelligence(1);
		car.setFuel(1);
		
		if(carbool && car.getEnergy()==101 && car.getFuel()==101 && car.getIntelligence()==1)
		carbool2=true;
			if(carbool2 && car.toString().equals("Character \n"
				+ "\tName=PB" 
				+ "\n\tIntelligence=1" 
				+ "\n\tEnergy=101" 
				+ "\n\tFuel=101" ))
				carbool3=true;
		assertEquals(true, carbool3);
			
		
	}
	@Test
	public void MainTest(){
		String[] userName={"PunkBoy"};
		OverrideMethod ov = new OverrideMethod() {
		@Override
		public String input() {
			return "1";
			
		}
		};
		Main m = new Main(ov);
		
		
		assertEquals(true,m.engine(userName));
	}
	

}
