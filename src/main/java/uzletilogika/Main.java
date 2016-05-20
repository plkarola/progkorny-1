package uzletilogika;





import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *This class contains the executable file and the main method. 
 */
public class Main  {

	/**
	 *The player gives the answer for the questions with this.  
	 */
	private OverrideMethod ov ;
	/**
	 *The logger creates log information of the {@code Main} class. 
	 */
	private static Logger	logger = LoggerFactory.getLogger(Main.class);
	
	/**
	 *Constructs a {@code Main} object.
	 */
	public Main(){
	 ov = new OverrideMethod() {
	};
	 }
	/**
	 *Constructs a {@code Main} object.This constructor uses {@code ov}.
	 *
	 * @param ov who gives the answer
	 */
	 public Main(OverrideMethod ov){
		this.ov=ov;
		
	}
	/**
	 *Returns the method's correct ending. This method is the game's engine, 
	 *contains the logical deduction of the game.  
	 * 
	 *@param args arguments object which contains the player's name
	 *@return  the boolean value which tells method's correct ending
	 */
	 public boolean engine(String[] args){
		 	int situationid = 1;
			int questionid = 1;
			XMLParserImp parser = new XMLParserImp();
			Character character;
			if (args.length > 0)
				character = new Character(args[0]);
			else
				character = new Character("default");
			parser.basedir();
			if(parser.getQuestion(questionid, situationid)!=null){
			for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
				System.out.println("\t\t"+parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
			situationid++;
			for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
				System.out.println(parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
			int i = 0;
			List<Answer> anwers =  parser.getAnswersToSituation(situationid, questionid);
			for (Answer answer : anwers) {
				i++;
				System.out.println("\t" + i + answer.getAnswerlines());
			}

			while (true) {
				System.out.println("Character information 0  or choose answer number");
				int hope;
				try{
				hope = Integer.parseInt(ov.input()) - 1;
				if(hope>i) continue;
				}
				catch(Exception e){logger.info("Error number"); continue;}
				while (hope == -1) {
					i = 0;
					System.out.println(character);
					for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
						System.out.println(parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
					for (Answer answer : anwers) {
						i++;
						System.out.println("\n\t\t" + i + answer.getAnswerlines());
					}
					try{
						hope = Integer.parseInt(ov.input()) - 1;
						}
						catch(Exception e){
							logger.info("Error number");
							
						continue;}
					if(hope>i) continue;
						}
				character.setEnergy(anwers.get(hope).getEnergy());
				character.setFuel(anwers.get(hope).getFuel());
				character.setIntelligence(anwers.get(hope).getIntelligence());
				String nexthope = anwers.get(hope).getCategory();

				if (nexthope.equals("true"))
					{finish(true ,character.getIntelligence());
					break;
					}
				else if (nexthope.equals("false"))
					{finish(false ,character.getIntelligence());
					break;}
				else {
					String[] splitednexthope = nexthope.split(" ");
					situationid = Integer.parseInt(splitednexthope[0]);
					questionid = Integer.parseInt(splitednexthope[1]);
					try {
						for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
							System.out.println(parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
					} catch (Exception e) {
						logger.error("No question");
						beta();
						return false;
					}

					i = 0;
					try {
						anwers = parser.getAnswersToSituation(situationid, questionid);
						for (Answer answer : anwers) {
							i++;
							System.out.println("\t" + i + answer.getAnswerlines());

						}
					} catch (Exception e) {
						logger.error("No answer");
						beta();
						return false;
					}
				}
			  }
			}
			return true;
	 }
	 /**
	  *The main method.
	  *
	  *@param args arguments object  
	  */
	public static void main(String[] args) {
		
		Main main = new Main();
		main.engine(args);

		logger.info("SuccessFull");
		
	   

	}
	/**
	 *Returns the game's result.
	 * 
	 *@param win indicates the games ending
	 *@param intelligence the character's current intelligence
	 *@return end game information 
	 */
	public  String finish(boolean win , int intelligence) {
		String str;
		
		if (win && intelligence>=100)
			str="Sikeresen teljesítetted a tárgyakat";
		else if(!win)
			str=("Sikertelenül teljesítetted a tárgyakat");
		else
			str=("Eljutottál vizsgáig de az intelligenciád:"+intelligence
					+" túl kicsi, minimum 100 kell, ezért vizsgakurzusra kerültél");
		System.out.println(str);
		logger.info("Game-end:"+str);
		
		return str;
	}
	/**
	 *Informs the player about the game's ending. 
	 */
	public  void beta() {
		logger.info("Game-end:"+"A játék beta verziója véget ért");
		System.out.println("A játék beta verziója véget ért");
		
	}

	
	

}
