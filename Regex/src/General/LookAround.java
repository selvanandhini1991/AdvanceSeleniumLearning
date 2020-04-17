package General;

public class LookAround {

	public static void main(String[] args) {
		
		//Refer :http://www.regular-expressions.info/lookaround.html
		//Referring the delimeter with lookahead and lookbehind is called lookaround.
		
		//general split with whitespace
		
//		String a = "The sun rises in the east";
//		System.out.println(a.split(" ")); //returns object
//		//String[] A=a.split(" ");
//		String[] A = a.split("\\s+");
//		for(String t:A) {
//			System.out.println(t);
//		}
		
		/*Lookahead
		 * Negative lookahead provides the solution: q(?!u) 
		 * Positive lookahead works just the same. q(?=u)
		 * */
		String a1 = "Iraq"; //q followed by nothing
		String a2 = "quit"; //q followed by u 
		
		/*Lookbehind
		 * Positive lookbehind : q(?<=a)
		 * Negative lookbehind : q(?<!a)
		 * */
		
		String word = "quit is qdefined as quit in Iraq";
		//String[] array = word.split("q(?!u)");
		/*quit is 
		  defined as quit in Ira*/
		String[] array = word.split("q(?=u)");
		/*uit is qdefined as 
		  uit in Iraq*/
//		for(String t:array) {
//			System.out.println(t);
//		}
//		
		String str = " 1 sun rises CP-2345 and 19 roses and 5 oranges";
//		q=\\d+\\b , u =(\\d{3,5}+)
		String[] sarr = str.split("\\d+\\s(?!\\d{3,5})");
		
		for(String s:sarr) {
			System.out.println(s);
		}

	}

}
