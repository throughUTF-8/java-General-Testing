import java.util.Scanner;

public class urTesting1 {
	public static boolean singleCharacter( String s ) {
		if(s.length() != 1) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean containsSingle( String s, String t ) {
		if(!singleCharacter(s)) {
			return false;
		}
		if((s.toLowerCase()).compareTo(t.toLowerCase()) != 0) {
			return false;
		}
		else {
			return  true;
		}
	}
	public static String xoSelect( int a ) {
		if(a%2 == 0) {
			return "O";
		}
		else {
			return "X";
		}
	}
	public static int checkNumber( String s ) {
		if (!singleCharacter(s)) {
			return -1;
		}
		else if (!(s.compareTo( "1" ) >= 0 && s.compareTo( "9" ) <= 0)) {
			return -1;
		}
		else{
			return Integer.parseInt(s);
		}
	}
	public static boolean winCon( String[] a ){
		if( a[1].equals(a[2]) && a[1].equals(a[3]) ) {
			return true;
		}
		else if( a[4].equals(a[5]) && a[4].equals(a[6]) ) {
			return true;
		}
		else if( a[7].equals(a[8]) && a[7].equals(a[9]) ) {
			return true;
		}
		else if( a[1].equals(a[4]) && a[1].equals(a[7]) ) {
			return true;
		}
		else if( a[2].equals(a[5]) && a[2].equals(a[8]) ) {
			return true;
		}
		else if( a[3].equals(a[6]) && a[3].equals(a[9]) ) {
			return true;
		}
		else if( a[1].equals(a[5]) && a[1].equals(a[9]) ) {
			return true;
		}
		else if( a[3].equals(a[5]) && a[3].equals(a[7]) ) {
			return true;
		}
		else{
			return false;
		}
	}
	public static void main( String[] args )
    {
		
		int xO = 0;
		String[] slot = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String  row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ",
				row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ",
				row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
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
        	 else {
        		 System.out.println("Please respond with the single character 'X' or 'O'!");
        		 command = in.nextLine();
        	 }
        }
        System.out.println("Where would " + xoSelect(xO) + "'s like to play first?");
        System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
		turnNumber = 1;
        command = in.nextLine();
        //TURN ONE
        while(turnNumber == 1) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO);
            			turnNumber = 2;
        			}
        		}
        		if(turnNumber != 2) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("First move successful! Now it's " + xoSelect(xO + 1) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN TWO
        while(turnNumber == 2) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO + 1);
            			turnNumber = 3;
        			}
        		}
        		if(turnNumber != 3) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Second move successful! Now it's " + xoSelect(xO) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN THREE
        while(turnNumber == 3) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO);
            			turnNumber = 4;
        			}
        		}
        		if(turnNumber != 4) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Third move successful! Now it's " + xoSelect(xO + 1) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN FOUR
        while(turnNumber == 4) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO + 1);
            			turnNumber = 5;
        			}
        		}
        		if(turnNumber != 5) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Fourth move successful! Now it's " + xoSelect(xO) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN FIVE
        while(turnNumber == 5) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO);
            			turnNumber = 6;
        			}
        		}
        		if(turnNumber != 6) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        if(winCon( slot )) {
        	System.out.println(xoSelect(xO) + " has won the game!");
        	row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
    		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
    		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
    		System.out.println(row1);
            System.out.println("-----------");
            System.out.println(row2);
            System.out.println("-----------");
            System.out.println(row3);
            in.close();
            return;
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Fifth move successful! Now it's " + xoSelect(xO + 1) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN SIX
        while(turnNumber == 6) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i < 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO + 1);
            			turnNumber = 7;
        			}
        		}
        		if(turnNumber != 7) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        if(winCon( slot )) {
        	System.out.println(xoSelect(xO + 1) + " has won the game!");
        	row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
    		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
    		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
    		System.out.println(row1);
            System.out.println("-----------");
            System.out.println(row2);
            System.out.println("-----------");
            System.out.println(row3);
            in.close();
            return;
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Sixth move successful! Now it's " + xoSelect(xO) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN SEVEN
        while(turnNumber == 7) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO);
            			turnNumber = 8;
        			}
        		}
        		if(turnNumber != 8) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        if(winCon( slot )) {
        	System.out.println(xoSelect(xO) + " has won the game!");
        	row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
    		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
    		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
    		System.out.println(row1);
            System.out.println("-----------");
            System.out.println(row2);
            System.out.println("-----------");
            System.out.println(row3);
            in.close();
            return;
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Seventh move successful! Now it's " + xoSelect(xO + 1) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
        //TURN EIGHT
        while(turnNumber == 8) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i < 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO + 1);
            			turnNumber = 9;
        			}
        		}
        		if(turnNumber != 9) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        if(winCon( slot )) {
        	System.out.println(xoSelect(xO + 1) + " has won the game!");
        	row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
    		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
    		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
    		System.out.println(row1);
            System.out.println("-----------");
            System.out.println(row2);
            System.out.println("-----------");
            System.out.println(row3);
            in.close();
            return;
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("Eighth move successful! Now it's " + xoSelect(xO) + "'s turn!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        command = in.nextLine();
      //TURN NINE
        while(turnNumber == 9) {
        	if(checkNumber(command) != -1) {
        		int i;
        		for( i = 1; i <= 9; i++ ) {
        			if((checkNumber(command) == i) && (checkNumber(slot[i]) == i)) {
            			slot[i] = xoSelect(xO);
            			turnNumber = 10;
        			}
        		}
        		if(turnNumber != 10) {
        				System.out.println("Please respond with the single number 1 - 9 corresponding to an appropriate, available slot.");
        				System.out.println(row1);
        				System.out.println("-----------");
    		        	System.out.println(row2);
    		        	System.out.println("-----------");
    		        	System.out.println(row3);
    		        	command = in.nextLine();
        		}
        	}
        	else if(checkNumber(command) == -1) {
        		System.out.println("Please respond with the single number 1 - 9");
        		command = in.nextLine();
        	}
        }
        if(winCon( slot )) {
        	System.out.println(xoSelect(xO) + " has won the game!");
        	row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
    		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
    		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
    		System.out.println(row1);
            System.out.println("-----------");
            System.out.println(row2);
            System.out.println("-----------");
            System.out.println(row3);
            in.close();
            return;
        }
        row1 = " " + slot[1] + " | " + slot[2] + " | " + slot[3] + " ";
		row2 = " " + slot[4] + " | " + slot[5] + " | " + slot[6] + " ";
		row3 = " " + slot[7] + " | " + slot[8] + " | " + slot[9] + " ";
        System.out.println("It's a Cat's game!");
		System.out.println(row1);
        System.out.println("-----------");
        System.out.println(row2);
        System.out.println("-----------");
        System.out.println(row3);
        in.close();
        return;
}}
