package uzletilogika;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
* The OverideMethode contains the input method's abstraction.
*/
public abstract class OverrideMethod {
    /**
    *Returns with the key requested from the standard input.
    *
    *@return the string from the standard input
    */
	public  String input() {
		 try {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

				String s = input.readLine();
				System.out.println("My choose: " + s);

				return s;
			} catch (Exception e) {
				;
			}
			return null;

	}

}
