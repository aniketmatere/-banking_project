import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer account1 = new Customer(1000,"Rohit k Jadhav","Rohi9046","Rohit@123","9021739046",
                                            "A/p chimbali phata tal:khed,dist:pune");
       // Coustmer1 coustmer1 = new Coustmer1(account1);
        OnlineBanking onlineBanking = new OnlineBanking();
        onlineBanking.addTOList(account1);
        onlineBanking.displayDetailes();
        int choice;

        do {
            System.out.println("Enter 1 For Open New Account");
            System.out.println("Enter 2 For Login");

            choice = scanner.nextInt();

            switch (choice){
                case 1:
                {
                    scanner.nextLine();
                    System.out.println("Enter Your Name");
                    String name = scanner.nextLine();
                    System.out.println("Enter your mobile Number ");
                    String number = scanner.nextLine();
                    System.out.println("Enter your Address ");
                    String address = scanner.nextLine();
                    String loginId = onlineBanking.createLoginId(name,number);
                    String password = onlineBanking.setPassword(number);
                    Customer newAccount = new Customer(name,number,address,loginId,password);
                    onlineBanking.addTOList(newAccount);

                    System.out.println(newAccount);
                    break;

                }
                case 2:
                {
                    scanner.nextLine();
                    System.out.println("Enter your Login-Id");
                    String loginId = scanner.nextLine();
                    System.out.println("Enter your Password");
                    String password = scanner.nextLine();
                    Customer obj = new Customer(loginId, password);
                    if(onlineBanking.checkLoginDetails(obj)){
                        int option;
                        do {
                            System.out.println("Enter 1 For Withdraw Money");
                            System.out.println("Enter 2 For Deposit Money");
                            System.out.println("Enter 3 For Check Balance");
                           // System.out.println("Enter 5 For Close Account");
                            System.out.println("Enter 4 For Logout");
                            option = scanner.nextInt();
                            switch (option){
                                case 1:
                                {
                                    System.out.println("Enter Amount For Withdrawal");
                                    double amount = scanner.nextInt();
                                    onlineBanking.withdrawMoney(obj,amount);
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("Enter Amount For Depositions");
                                    double amount = scanner.nextInt();
                                    onlineBanking.depositMoney(obj,amount);
                                    break;
                                }
                                case 3:
                                {
                                    onlineBanking.getbalance(obj);
                                    break;
                                }
                                case 4:
                                {
                                    System.out.println("Logging Out....");
                                    break;
                                }
                                default: {
                                    System.out.println("Invalid Input");
                                    System.out.println("Successfully LogOut");
                                    break;
                                }
                            }

                        }while (option<=3);
                    }
                    break;
                }
                default:
                {
                    System.out.println("Invalid Input");
                    break;
                }

            }
        }while (choice<3);
        onlineBanking.displayDetailes();

    }
}
