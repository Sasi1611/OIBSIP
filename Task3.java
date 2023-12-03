import java.util.*;
import java.sql.Timestamp;


class Account{

	String accNo = "123456789";
	int pin = 1234;
	float accBal = 100000.0f;
	int transactions = 0;
	String transactionHistory = "";
	String red="\u001B[31m";
	String green="\u001B[32m";
	String white="\u001B[37m";
	Scanner input = new Scanner(System.in);
	
	public boolean login() {
		boolean isLogin = false;
		System.out.println("Enter Account Number");
		String userAccNo = input.nextLine();
		
		if(accNo.equals(userAccNo)) {
			System.out.println("Enter PIN");
			int userPin = input.nextInt();
			if(pin == userPin) {
				isLogin = true;
			}
			else {
			    System.out.println(red+"Incorrect PIN" +white);
			    isLogin = false;
	    		}
		}
		else {
			System.out.println(red + "Incorrect Account Number..." + white);
			isLogin = false;
		}
		return isLogin;
	}
	
	public void transactionHistory(){
		if(transactions == 0) {
			System.out.println("No transactions.\n");
		}
		else {
			System.out.println(transactionHistory);
		}
		
	}
	
	public void withdraw() {
		System.out.println("Enter amount to withdraw:");
		float amount = input.nextFloat();
		
		if(accBal>= amount) {
			if(amount <= 10000) {
				accBal -= amount;
				transactions++;
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String str = " Withdrawn Rs." + amount +" "+ timestamp +"\n";
				transactionHistory = transactionHistory.concat(str);	
				System.out.println(green+"Withdraw Successful.\n"+white);
			}
			else {
				System.out.println(red + "Limit is 10000.00.\n" + white);
			}
		}
		else {
			System.out.println(red + "Insufficient Balance.\n" + white);
		}	
	}
	
	public void deposit() {
		System.out.println("Enter amount to deposit:");
		float amount = input.nextFloat();
		
		if(amount <= 10000f) {
			accBal += amount;
			transactions++;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        		System.out.println(timestamp);
			String str = "Rs."+amount + " Deposited. "+ timestamp+"\n";
			transactionHistory = transactionHistory.concat(str);
			System.out.println(green + "Successfully Deposited.\n" + white);
		}
		else {
			System.out.println(red + "Limit is 10000.00.\n" + white);
		}
	}
	
	public void transfer() {
		System.out.println("Enter Account Number of Receipent:");
		String accNum = input.next();
		
		System.out.println("Enter amount:");
		input.nextLine();
		float amount = input.nextFloat();
		
		if(accBal >= amount) {
			if(amount <= 15000f) {
				System.out.println("\nAmount transfered Successfully.\n");
				accBal -= amount;
				transactions++;
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       				System.out.println(timestamp);
				String str = amount + " Rs. transfered to " + accNum + " " + timestamp + "\n";
				transactionHistory = transactionHistory.concat(str);		
		    }
			else {
				System.out.println(red + "Limit is 15000.00.\n" + white);
			}
		}
		else {
			System.out.println(red + "Insufficient Balance.\n" + white);
		}
	}

	public void checkBalance() {
		System.out.println("Rs." + accBal + "\n");
	}

}

class Atm{
	public static void main(String[] args) {

		String red="\u001B[31m";
		String green="\u001B[32m";
		String white="\u001B[37m";
		Scanner input = new Scanner(System.in);
		Account a = new Account();
		System.out.println("------------- WELCOME to ATM -------------");
		System.out.println("\nPlease Enter your card\n");
		
		boolean isValid = a.login();

		if(isValid) {
			boolean flag = false;
		    while(!flag) {
		    		System.out.println("Enter your choice : \n");
				System.out.println("1.Transactions History");
				System.out.println("2.Withdraw");
				System.out.println("3.Deposit");
				System.out.println("4.Transfer");
				System.out.println("5.Check Balance");
				System.out.println("6.Exit");
				int choice = input.nextInt();
				
				switch(choice){
					case 1:
						a.transactionHistory();
						break;
					case 2:
						a.withdraw();
						break;
					case 3:
						a.deposit();
						break;
					case 4:
						a.transfer();
						break;
					case 5:
						a.checkBalance();
						break;
					case 6:
						flag = true;
						System.out.println("\nThank you for visiting!");
						break;
					default:
						System.out.println(red + "Please enter correct choice \n" + white);				
				}
			}
		}
		
	}
}