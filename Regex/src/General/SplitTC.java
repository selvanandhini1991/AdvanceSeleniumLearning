package General;

public class SplitTC {

	public static void main(String[] args) {
		/* trial 1 -> Split with numbers [1-countofSteps] followed by whitespace and
		ignore remaining cases - just replace the u limit with countofStep variable*/ 
		
		/*Trial-2 -> Split with Numeric[2 digits] surrounded by whitespace by ignoring Numeric with 4 digits*/
		
		String TC = " 1 Login using any user user is logged in\r\n" + 
				"29 Click on Operation tab, from CP-4563 the drop down menu,\r\n"  +
				"3 Add profile updated by story-103038 to check unvalidated user" ;
		
		/*Handling the regex using Negative Lookahead method "q(?!u)"*/
		
		String q = "\\s\\d{1,2}\\s"; //check for one digit/2 digit Numeric surrounded by space
		String u = "\\d{4}"; // 4 digit Numeric
		
		String[] arr = TC.split(""+q+"(?!"+u+")");
		
		for(int i=1;i<arr.length;i++) {
			System.out.println("Test Step "+i+":"+ arr[i]);
		}
	}

}
