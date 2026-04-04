public interface MobileOperator {
    void createContract();
    void openAccount(String number);
    void updateAccount(String info);
    void getInfo();
    void checkBalance();
    void viewPayments();
    void changePlan(String plan);
    void refill(double amount);
    void closeAccount();
}