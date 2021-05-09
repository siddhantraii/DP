import java.util.Scanner;
public class StringTask {
public static void main(String args[]) {
	Scanner scn = new Scanner(System.in);
	StringBuilder ss = new StringBuilder();
	String s = scn.nextLine();

	for(int i = 0; i<s.length(); i++){
		char ch = s.charAt(i);
		if(ch == 'A' || ch == 'a'|| ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u'){
			continue;
		}
		if(ch != 'A' || ch != 'a'|| ch != 'E' || ch != 'e' || ch != 'I' || ch != 'i' || ch != 'O' || ch != 'o' || ch != 'U' || ch != 'u'){
			if(ch >= 'a'  && ch <= 'z'){
			ss.append(".");
			ss.append(ch);
		}
		else ss.append(s.toLowerCase());
		}
		
	}
	System.out.print(ss);

	}
}