import java.util.Scanner;
import java.util.Arrays;

/**
 * Driver Class
 * 
 * @author Rutul Mehta
 */
public class driver {
	public static void main(String[] args) {
		int status;
		String input = "";

		account objaccount = new account();
		Scanner objScanner = new Scanner(System.in);
		
		do {
			System.out.println("Operation for DRIVER class\n" + "\n" + " 0. open\n" + " 1. deposit\n" + " 2. withdraw\n"
					+ " 3. balance\n" + " 4. lock\n" + " 5. unlock\n" + " 6. login\n" + " 7. pin\n" + " 8. logout\n"
					+ "\n" + " Testing-related methods\n" + " a. show state\n" + " b. show balance\n"
					+ " c. show lock status\n" + " d. show Total number of attempt\n" + "\n"
					+ " q. Quit Account Driver\n");
			System.out.println("Enter Operation Code :- ");
			input = objScanner.next();
			switch (input) {
				case "0": {
					MakeString("Open Method");
	
					System.out.println("\nEnter Account Number :- ");
					int accountNumber = objScanner.nextInt();
					System.out.println("\nEnter PIN :- ");
					int pin = objScanner.nextInt();
					System.out.println("\nEnter Initial Balance :- ");
					int balance = objScanner.nextInt();
	
					status = objaccount.open(accountNumber, pin, balance);
					System.out.println("\nStatus of the Open method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "1": {
					MakeString("Deposit Method");
	
					System.out.println("\nEnter Deposit amount:- ");
					int deposit = objScanner.nextInt();
	
					status = objaccount.deposit(deposit);
					System.out.println("\nStatus of the Deposit method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "2": {
					MakeString("Withdraw Method");
	
					System.out.println("\nEnter withdraw amount :-");
					int withdraw = objScanner.nextInt();
	
					status = objaccount.withdraw(withdraw);
					System.out.println("\nStatus of the withdraw method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "3": {
					MakeString("Balance Method");
	
					int balance = objaccount.balance();
					if (balance == -1) {
						status = objaccount.balance();
						System.out.println("\nStatus of the Balance method :- " + objaccount.show_status(status) + "\n");
					} else {
						System.out.println("\nAccount Balance :- " + balance);
					}
					break;
				}
				case "4": {
					MakeString("Lock Method");
	
					System.out.println("\nEnter Lock number :-");
					int locknumber = objScanner.nextInt();
	
					status = objaccount.lock(locknumber);
					System.out.println("\nStatus of the Lock method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "5": {
					MakeString("Unlock Method");
	
					System.out.println("\nEnter Lock number :- ");
					int locknumber = objScanner.nextInt();
	
					status = objaccount.unlock(locknumber);
					System.out.println("\nStatus of the Unlock method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "6": {
					MakeString("Login Method");
	
					System.out.println("\nEnter Account number :- ");
					int AccountNumber = objScanner.nextInt();
	
					status = objaccount.login(AccountNumber);
					System.out.println("\nStatus of the login method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "7": {
					MakeString("Pin Method");
	
					System.out.println("\nEnter PIN number:- ");
					int PINNumber = objScanner.nextInt();
	
					status = objaccount.pin(PINNumber);
					System.out.println("\nStatus of the PIN method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "8": {
					MakeString("Logout Method");
	
					status = objaccount.logout();
					System.out.println("\nStatus of the Logout method :- " + objaccount.show_status(status) + "\n");
					break;
				}
				case "a": {
					MakeString("Show Current State Method");
	
					String state = objaccount.show_state();
					System.out.println("\nCurrent state :- " + state + "\n");
					break;
				}
				case "b": {
					MakeString("Show Current Account Balance");
	
					int balance = objaccount.show_balance();
					System.out.println("\nCurrent balance :- " + balance + "\n");
					break;
				}
				case "c": {
					MakeString("Show Lock Status");
	
					String lockStatus = objaccount.show_lock_status();
					System.out.println(
							"\nCurrent Status of the Account, Either Account is locked or not :- " + lockStatus + "\n");
					break;
				}
				case "d": {
					MakeString("Show Total Number of Attempt");
	
					int attempts = objaccount.show_total_attempts();
					System.out.println("\nShow Total Number Attempts performed :- " + attempts + "\n");
					break;
				}
				case "q": {
					break;
				}
				default: {
					MakeString("Invalid operation code");
					break;
				}
			}
		} while (!input.equals("q"));
	}

	public static String createString(int stringLength) {

		// create char array of specified length
		char[] charArray = new char[stringLength];

		// fill all elements with the specified char
		Arrays.fill(charArray, '*');

		// create string from char array and return
		return new String(charArray);
	}

	public static void MakeString(String namestring) {

		System.out.println(createString((70 - namestring.length()) / 2) + " " + namestring + " "
				+ createString((70 - namestring.length()) / 2));
	}
}
