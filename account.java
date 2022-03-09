//***********************************************
//************* CLASS ACCOUNT *******************
//***********************************************

/**
 * Account Class
 * @author Rutul Mehta
 */
public class account {
	private int x0; // Maximum Login Attempt
	private int x1; // Account Balance
	private int x2; // Lock Status :- 0 - Unlocked and 1 - Locked
	private int x3; // Pin Number
	private int x4; // State :- -1 - Initial, 0 - Idle, 1 - Check Pin, 2 - Ready/overdrawn/locked(based on other parameter)
	private int x5; // Account Number
	private int x6; // Transaction fees
	private int x7; // Minimum balance
	private int x8; // Lock Number
	private int x9; // Number of attempt

	public final String show_state() {
		String state = "";
		if (x4 == -1) {
	        state = "INITIAL";
	    }
	    if (x4 == 0) {
	        state = "IDLE";
	    }
	    else if (x4 == 1) {
	        state = "CHECK PIN";
	    }
	    else if (x4 == 2) {
	    	if (x2 == 1) {
	    		state = "LOCKED";
			}
			if (x1 < x7) {
	    		state = "OVERDRAWN";
			}
			else {
	    		state = "READY";
			}
		}
	    return state;
	}
	
	public final int show_balance() {
		return x1;
	}
	
	public final String show_lock_status() {
		if(x2 == 1) {
			return "LOCKED";
		}
		else {
			return "UNLOCKED";
		}
	}
	
	public final int show_total_attempts() {
		return x9;
	}

	public final String show_status(int status) {
		if (status == -1) {
			return "Fail";
		} else {
			return "Successful";
		}
	}

	public account() {
		x2 = 0;
		x4 = -1;
		x6 = 20;
		x7 = 200;
		x9 = 0;
		x0 = 3;
	}

	/**
	 * This method perform account open operation.
	 * 
	 * @param z : Account Number
	 * @param y : Pin Number
	 * @param x : Balance
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int open(int z, int y, int x) {
		if ((x > 0) && (x4 == -1) && (y > 0) && (z > 0)) {
			x1 = x;
			x3 = y;
			x5 = z;
			x4 = 0;
			return 0;
		}
		;
		return -1;
	}

	/**
	 * This method perform PIN operation (Provide PIN before any Transaction)
	 * 
	 * @param x : Pin number
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int pin(int x) {
		if (x4 != 1) {
			return -1;
		}
		if (x == x3) {
			x4 = 2;
			return 0;
		} else {
			x9++;
		}
		if (x9 >= x0) {
			x4 = 0;
		}
		return -1;
	}

	/**
	 * This method perform Logout operation (Logout from the account)
	 * 
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int logout() {
		if ((x4 == 0) || (x2 == 1)) {
			return -1;
		}
		x4 = 0;
		return 0;
	}

	/**
	 * This method perform Login operation (Login to the account)
	 * 
	 * @param x : Account Number
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int login(int x) {
		if (x4 != 0) {
			return -1;
		}
		if (x5 == x) {
			x4 = 1;
			x9 = 0;
			return 0;
		}
		return -1;
	}

	/**
	 * This method check balance of the account.
	 * 
	 * @return : Balance of the account
	 */
	public final int balance() {
		if (x4 != 2) {
			return -1;
		}
		return x1;
	}

	/**
	 * This method perform Lock operation (Account can be locked)
	 * 
	 * @param x : Lock number
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int lock(int x) {
		if (x4 != 2) {
			return -1;
		}
		if (x == x3) {
			return -1;
		}
		if (x2 == 0) {
			x2 = 1;
			x8 = x;
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * This method perform unlock operation (Account unlock with correct Lock
	 * number)
	 * 
	 * @param x : Lock Number
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int unlock(int x) {
		if (x4 != 2) {
			return -1;
		}
		if ((x2 == 1) && (x == x8)) {
			x2 = 0;
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * This method perform Deposit operation (Deposit d amount to the account)
	 * 
	 * @param d : Deposit amount
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int deposit(int d) {
		if (x4 != 2) {
			return -1;
		}
		if (x2 == 1) {
			return -1;
		}
		;
		if ((x1 + d < x7) && (d > 0)) {
			x1 = x1 + d - x6;
			return 0;
		} else {
			if (d > 0) {
				x1 = x1 + d;
				return 0;
			}
		}
		return -1;
	}

	/**
	 * This method perform withdraw opration (withdraw amount from the account)
	 * 
	 * @param w : withdraw amount
	 * @return : 0 --> Success, -1 --> Failure
	 */
	public final int withdraw(int w) {
		if (x4 != 2) {
			return -1;
		}
		if (x2 == 1) {
			return -1;
		}
		;
		if ((x1 > w) && (w > 0)) {
			if (x1 < x7) {
				return -1;
			} else {
				x1 = x1 - w;
			}
			if (x1 < x7) {
				x1 = x1 - x6;
			}
			return 0;
		}
		return -1;
	}
}