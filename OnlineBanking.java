import java.text.SimpleDateFormat;
import java.util.*;

public class OnlineBanking {
    private Customer customer;
    private List<Customer> accountList ;// = new ArrayList<>();

    public OnlineBanking() {
        accountList=new ArrayList<>();
    }
    public void addTOList(Customer account){
        accountList.add(account);
    }

    public String createLoginId(String name, String number){
         name= name.substring(0,4);
         number= number.substring(6);
         return (name+number);
    }
    public String setPassword(String number){
        Scanner scanner = new Scanner(System.in);
        System.out.println("OTP Send On "+number.substring(0,2)+"******"+number.substring(8));
        Random random = new Random();
        int genderedOtp = random.nextInt(1000,9999);
        System.out.println("OPT :"+genderedOtp);
        System.out.println("Please Enter 4-Digit  OTP");
        int opt = scanner.nextInt();
        if(genderedOtp == opt){
            scanner.nextLine();
            System.out.println("Enter new password  password May AlphaNumeric and Contain AtLeast one Special character ");
            return (scanner.nextLine());
        }
        else {
            System.out.println("Invalid Otp");

        }
        return null;
    }


    public void withdrawMoney(Customer obj , double amount){
        for (Customer temp:accountList) {
            if(obj.getLoginId().equals(temp.getLoginId())){
                double accBalance = temp.getAccountBalance();
                if(accBalance<amount){
                    System.out.println("Invalid Balance");
                    transactionReceipt(temp);
                }
                else {
                    accBalance=accBalance-amount;
                    System.out.println("Money Withdraw Successfully");
                    temp.setAccountBalance(accBalance);
                    transactionReceipt(temp);
                }
            }
        }

    }
    public boolean checkLoginDetails (Customer obj) {
        for (var temp : accountList) {
            if (obj.getLoginId().equals(temp.getLoginId())) {
                String loginPassword = (accountList.get(accountList.indexOf(temp))).getPassword();
                return (loginPassword.equals(obj.getPassword()));
            }
        }
        System.out.println("Invalid LOGIN details!!!");
        System.out.println("Please try Again...");
        return false;
    }
    public void depositMoney(Customer obj,double amount) {
        for (Customer temp:accountList) {
            if(obj.getLoginId().equals(temp.getLoginId())){
                double accbal = temp.getAccountBalance() + amount;
                temp.setAccountBalance(accbal);
                System.out.println("Money Deposit Successfully");
                transactionReceipt(temp);
            }
        }

    }
    public  void getbalance(Customer obj){
        for (Customer temp:accountList) {
            if(obj.getLoginId().equals(temp.getLoginId())){
                System.out.println("Account Balance is "+temp.getAccountBalance());
               // transactionReceipt(temp);
            }
        }

    }
    public void transactionReceipt(Customer obj){
        Date date = new Date();
//        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss a");
        String sfd = dateFormat.format(date);
        System.out.println("********TRANSACTION RECEIPT********");
        System.out.println();
        System.out.println("Receipt No :");
        System.out.println("Transaction Date : "+sfd);
        System.out.println("Account No : *****"+obj.getAccountNumber());
        System.out.println("Account Holder Name : "+obj.getAccountName());
        System.out.println("Account Balance : "+obj.getAccountBalance());
        System.out.println("*************************************************************************");
        System.out.println();

    }
    public void displayDetailes(){
        System.out.println(accountList);
    }
   // public

}
