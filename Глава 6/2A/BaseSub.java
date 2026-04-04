public class BaseSub implements MobileOperator {
    protected String number;
    protected double balance;
    protected String currentPlan;

    public BaseSub(String number) {
        this.number = number;
        this.balance = 0.0;
        this.currentPlan = "Стандартный";
    }

    @Override public void createContract() { System.out.println("Договор оформлен."); }
    @Override public void openAccount(String number) { this.number = number; }
    @Override public void updateAccount(String info) { System.out.println("Данные обновлены."); }
    @Override public void getInfo() { System.out.println("Номер: " + number + ", Тариф: " + currentPlan); }
    @Override public void checkBalance() { System.out.println("Баланс: " + balance + " руб."); }
    @Override public void viewPayments() { System.out.println("Выписка сформирована."); }
    @Override public void changePlan(String plan) { this.currentPlan = plan; }
    @Override public void refill(double amount) { this.balance += amount; }
    @Override public void closeAccount() { System.out.println("Счет " + number + " закрыт."); }
}
