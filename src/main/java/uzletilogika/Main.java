package uzletilogika;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.List;

import javafx.beans.DefaultProperty;



public class Main  extends OverideMethode{

	OverideMethode ov;
	
	 public Main(){
		 ov=new OverideMethode() {
			 @Override
			 public String input() {
				 try {
						BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

						String s = input.readLine();
						System.out.println("My chose: " + s);

						return s;
					} catch (Exception e) {
						;
					}
					return null;
			 };
		 }
		;};
	
	 public Main(OverideMethode ov){
		this.ov=ov;
		
	}
	
	 public boolean engine(String[] args){
		 int situationid = 1;
			int questionid = 1;
			XMLParserImp parser = new XMLParserImp();
			Caracter caracter;
			if (args.length > 0)
				caracter = new Caracter(args[0]);
			else
				caracter = new Caracter("default");
			parser.basedir();
			for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
				System.out.println("\t\t"+parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
			situationid++;
			for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
				System.out.println(parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
			int i = 0;
			List<Ansver> ansvers = parser.getAnsversToSituation(situationid, questionid);
			for (Ansver ansver : ansvers) {
				i++;
				System.out.println("\t" + i + ansver.getAnsverlines());
			}

			while (true) {
				System.out.println("Caracter infromation 0  or chose ansver number");
				int hope;
				try{
				hope = Integer.parseInt(ov.input()) - 1;
				if(hope>i) continue;
				}
				catch(Exception e){System.out.println("Error number"); continue;}
				while (hope == -1) {
					i = 0;
					System.out.println(caracter);
					for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
						System.out.println(parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
					for (Ansver ansver : ansvers) {
						i++;
						System.out.println("\n\t\t" + i + ansver.getAnsverlines());
					}
					try{
						hope = Integer.parseInt(ov.input()) - 1;
						}
						catch(Exception e){System.out.println("Error number"); continue;}
					if(hope>i) continue;
						}
				caracter.setEnergy(ansvers.get(hope).getEnergy());
				caracter.setFuel(ansvers.get(hope).getFuel());
				caracter.setInteligent(ansvers.get(hope).getInteligenc());
				String nexthope = ansvers.get(hope).getCategory();

				if (nexthope.equals("true"))
					{finis(true ,caracter.getInteligent());
					break;
					}
				else if (nexthope.equals("false"))
					{finis(false ,caracter.getInteligent());
					break;}
				else {
					String[] splitednexthope = nexthope.split(" ");
					situationid = Integer.parseInt(splitednexthope[0]);
					questionid = Integer.parseInt(splitednexthope[1]);
					try {
						for (int ii = 0; ii < parser.getQuestion(questionid, situationid).getQuestinoline().size(); ii++)
							System.out.println(parser.getQuestion(questionid, situationid).getQuestinoline().get(ii));
					} catch (Exception e) {
						beta();
						return false;
					}

					i = 0;
					try {
						ansvers = parser.getAnsversToSituation(situationid, questionid);
						for (Ansver ansver : ansvers) {
							i++;
							System.out.println("\t" + i + ansver.getAnsverlines());

						}
					} catch (Exception e) {
						beta();
						return false;
					}
				}
			}
			return true;
	 }
	 
	public static void main(String[] args) {
		
		Main main = new Main();
		main.engine(args);
		
		
	   

	}

	public  String finis(boolean win , int inteligent) {
		String str;
		
		if (win && inteligent>=100)
			str="Sikeresen teljesiteted a tárgyakat";
		else if(!win)
			str=("Sikertelenül teljesitetted a tárgyakat");
		else
			str=("Eljutottál vizsgáig de az inteligenciád:"+inteligent
					+" tul kicsi minimum 100 kell ezért vizsgakurzusra kerültél");
		System.out.println(str);
		
		
		return str;
	}

	public  void beta() {
		System.out.println("A játék beta verziólya végetért");
		
	}

	
	

}
