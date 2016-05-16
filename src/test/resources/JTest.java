

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uzletilogika.*;

public class JTest {

	XMLParserImp xmlparser = new XMLParserImp();
	Main main = new Main();
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
}
