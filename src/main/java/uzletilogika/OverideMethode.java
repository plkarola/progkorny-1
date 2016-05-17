package uzletilogika;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OverideMethode {

	public  String input() {
		 try {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

				String s = input.readLine();
				System.out.println("My chose: " + s);

				return s;
			} catch (Exception e) {
				;
			}
			return null;

	}
	
}
