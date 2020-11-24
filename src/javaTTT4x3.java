import java.util.Scanner;
public class javaTTT4x3 {
	public static boolean singleCharacter( String s ) {
		if(s.length() != 1) {
			return false;
		}
		return true;
	}
	public static boolean containsSingle( String s, String t ) {
		if(!singleCharacter(s) || (s.toLowerCase()).compareTo(t.toLowerCase()) != 0) {
			return false;
		}
		return  true;
	}
	public static String xoSelect( int a ) {
		if(a%2 == 0) {
			return "O";
		}
		return "X";
	}
	public static String checkNumber( String s ) {
		if (!singleCharacter(s) || (!(s.compareTo( "A" ) >= 0 && s.compareTo( "L" ) <= 0))) {
			return "Z";
		}
		return s;
	}
	public static boolean winCon( String[] a ){
		if( (a[1].equals(a[2]) && a[1].equals(a[3])) || (a[2].equals(a[3]) && a[2].equals(a[4])) || 
			(a[5].equals(a[6]) && a[5].equals(a[7])) || (a[6].equals(a[7]) && a[6].equals(a[8])) ||
			(a[9].equals(a[10]) && a[9].equals(a[11])) || (a[10].equals(a[11]) && a[10].equals(a[12])) ||
			(a[1].equals(a[5]) && a[1].equals(a[9])) || (a[2].equals(a[6]) && a[2].equals(a[10])) ||
			(a[3].equals(a[7]) && a[3].equals(a[11])) || (a[4].equals(a[8]) && a[4].equals(a[12])) || 
			(a[1].equals(a[6]) && a[1].equals(a[11])) || (a[2].equals(a[7]) && a[2].equals(a[12])) ||
			(a[4].equals(a[7]) && a[4].equals(a[10])) || (a[3].equals(a[6]) && a[3].equals(a[9]))) {
			return true;
		}
		return false;
	}
	public static void main( String[] args )
    {	
		int xO = 0;
		String[] slot = {"0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
		String  row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " | " + slot[4],
				row2 = " " + slot[5] + " | " + slot[6] + " | " + slot[7] + " | " + slot[8],
				row3 = " " + slot[9] + " | " + slot[10] + " | " + slot[11] + " | " + slot[12];
		int turnNumber = 0;
		System.out.println( "Welcome to the game of Tic Tac Toe!" );
        System.out.println( "Please select if X's or O's would like to go first:" );
        Scanner in = new Scanner( System.in );
        String command = in.nextLine();
        while (xO == 0) {
        	 if( containsSingle( command, "X")) {
        		 xO = 1;
        	 }
        	 else if( containsSingle( command, "O")) {
        		 xO = 2;
        	 }
        	 else{
        		 System.out.println("Please respond with the single character 'X' or 'O'!");
        		 command = in.nextLine();
        	 }
        }
        System.out.println("Where would " + xoSelect(xO) + "'s like to play first?\n" +
        					row1 + "\n---------------\n" + row2 + "\n---------------\n" + row3);
		turnNumber = 1;
        command = in.nextLine();
        for(int i = 1; i <= 13; i++) {
	        if( i == 13) {
	        	row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " | " + slot[4];
	    		row2 = " " + slot[5] + " | " + slot[6] + " | " + slot[7] + " | " + slot[8];
	    		row3 = " " + slot[9] + " | " + slot[10] + " | " + slot[11] + " | " + slot[12];
	            System.out.println("It's a Cat's game!\n" +
	            					row1 + "\n---------------\n" + row2 + "\n---------------\n" + row3);
	            in.close();
	            return;
	        }
        	while(turnNumber == i) {
	        	if(!checkNumber(command).equals("Z")) {
	        		for( int j = 1; j <= 12; j++ ) {
	        			if((checkNumber(command)).equals(slot[j])) {
	            			slot[j] = xoSelect(xO + i + 1);
	            			turnNumber = i + 1;
	        			}
	        		}
	        		if(turnNumber != i + 1) {
	        				System.out.println("Please respond with the single, upper-case letter A - L corresponding to an appropriate, available slot.\n" +
	        									row1 + "\n---------------\n" + row2 + "\n---------------\n" + row3);
	    		        	command = in.nextLine();
	        		}
	        	}
	        	else if((checkNumber(command)).equals("Z")) {
	        		System.out.println("Please respond with the single, upper-case letter A - L");
	        		command = in.nextLine();
	        	}
	        	if(winCon( slot )) {
	        		row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " | " + slot[4];
		    		row2 = " " + slot[5] + " | " + slot[6] + " | " + slot[7] + " | " + slot[8];
		    		row3 = " " + slot[9] + " | " + slot[10] + " | " + slot[11] + " | " + slot[12];
	        		System.out.println(xoSelect(xO) + " has won the game!\n" + 
	        						   row1 + "\n---------------\n" + row2 + "\n---------------\n" + row3);
	                in.close();
	                return;
	        	}
	        }
        	if( i != 13 ) {
        		row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " | " + slot[4];
	    		row2 = " " + slot[5] + " | " + slot[6] + " | " + slot[7] + " | " + slot[8];
	    		row3 = " " + slot[9] + " | " + slot[10] + " | " + slot[11] + " | " + slot[12];
		        System.out.println("Move successful! Now it's " + xoSelect(xO + i) + "'s turn!\n" + 
		        					row1 + "\n---------------\n" + row2 + "\n---------------\n" + row3);
		        command = in.nextLine();
        	}
        }
        in.close();
}}
