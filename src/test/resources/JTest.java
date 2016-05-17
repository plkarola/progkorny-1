

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uzletilogika.*;

public class JTest {

	XMLParserImp xmlparser = new XMLParserImp();
	Main main =new Main();
	@Before
	public void inicialized(){
		xmlparser.basedir();
	}
	
	
	@Test
	public void getQuestionTest() {
		assertEquals(true,xmlparser.getQuestion(1, 1)!=null);
	}
	@Test
	public void getAnsverTest(){
		
		assertEquals(true,xmlparser.getAnsversToSituation(1, 1)==null);
	}
	@Test
	public void openFileTest(){
		assertEquals(true,xmlparser.openFile("Situation")!=null);
	}
	@Test
	public void succesTest1(){
		
		assertEquals(true, main.finis(true, 101).equals("Sikeresen teljesiteted a tárgyakat"));
	}
	@Test
	public void succesTest2(){
		
		assertEquals(true, main.finis(true, 99).equals("Eljutottál vizsgáig de az inteligenciád:99 tul kicsi minimum 100 kell ezért vizsgakurzusra kerültél"));
	}
	@Test
	public void caracterTest(){
		Caracter car = new Caracter("PB");
		boolean carbool = false , carbool2=false , carbool3 = false;
		if(car.getInteligent()==0 
				&& car.getEnergy()==100 
				&& car.getFuel()==100
				&& car.getName().equals("PB"))
			carbool=true;
		car.setEnergy(1);
		car.setInteligent(1);
		car.setFuel(1);
		
		if(carbool && car.getEnergy()==101 && car.getFuel()==101 && car.getInteligent()==1)
		carbool2=true;
			if(carbool2 && car.toString().equals("Caracter \n"
				+ "\tName=PB" 
				+ "\n\tInteligent=1" 
				+ "\n\tEnergy=101" 
				+ "\n\tfuel=101" ))
				carbool3=true;
		assertEquals(true, carbool3);
			
		
	}
	@Test
	public void MainTest(){
		String[] userName={"PunkBoy"};
		OverideMethode ov = new OverideMethode() {
		@Override
		public String input() {
			return "1";
			
		}
		};
		Main m = new Main(ov);
		
		
		assertEquals(true,m.engine(userName));
	}
	
}
