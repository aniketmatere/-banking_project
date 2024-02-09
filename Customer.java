public class Customer {
    private static int count;
    private int accountNumber;
    private String accountName;
    private String loginId;
    private String password;
    private String number;
    private String address;
    private double AccountBalance;

    public Customer(int accountNumber, String accountName, String loginId, String password, String number, String address) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.loginId = loginId;
        this.password = password;
        this.number = number;
        this.address = address;
        count++;
    }
    public Customer(String accountName, String number, String address,String loginId,String password){
        this.accountNumber = 1000+count;
        this.accountName = accountName;
        this.number = number;
        this.address = address;
        this.loginId = loginId;
        this.password = password;
        count++;
    }

    public Customer(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", AccountBalance=" + AccountBalance +
                '}';
    }

}
