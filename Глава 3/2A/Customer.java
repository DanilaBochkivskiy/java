import java.util.ArrayList;

class Customer {
    private int id;
    private String familiya;
    private String imya;
    private String otchestvo;
    private String address;
    private String cardNum;
    private String bankAcc;

    public Customer(int id, String familiya, String imya, String otchestvo, String address, String CardNum, String bankAcc) {
        this.id = id;
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.address = address;
        this.cardNum = CardNum;
        this.bankAcc = bankAcc;
    }

    public Customer() {
        this.id = 0;
        this.familiya = "0";
        this.imya = "0";
        this.otchestvo = "0";
        this.address = "0";
        this.cardNum = "0";
        this.bankAcc = "0";
    }

    public int getId() { return id; }
    public String getFamiliya() { return familiya; }
    public String getImya() { return imya; }
    public String getOtchestvo() { return otchestvo; }
    public String getAddress() { return address; }
    public String getCardNum() { return cardNum; }
    public String getBankAcc() { return bankAcc; }

    public void setId(int id) { this.id = id; }
    public void setFamiliya(String familiya) { this.familiya = familiya; }
    public void setImya(String imya) { this.imya = imya; }
    public void setOtchestvo(String otchestvo) { this.otchestvo = otchestvo; }
    public void setAddress(String address) { this.address = address; }
    public void setCardNum(String cardNum) { this.cardNum = cardNum; }
    public void setBankAcc(String bankAcc) { this.bankAcc = bankAcc; }

    public String getName() {
        return familiya + " " + imya + " " + otchestvo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", ФИО='" + getName() + '\'' +
                ", адрес='" + address + '\'' +
                ", карта='" + cardNum + '\'' +
                ", счет='" + bankAcc + '\'' +
                '}';
    }
}

class Customers {
    private ArrayList<Customer> customers;

    public Customers() {
        customers = new ArrayList<>();
    }

    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public void sortName() {
        ArrayList<Customer> temp = new ArrayList<>(customers);

        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = 0; j < temp.size() - i - 1; j++) {
                if (temp.get(j).getFamiliya().compareTo(temp.get(j + 1).getFamiliya()) > 0) {
                    Customer buf = temp.get(j);
                    temp.set(j, temp.get(j + 1));
                    temp.set(j + 1, buf);
                }
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }

    public void CardRange(String minCard, String maxCard) {
        for (int i = 0; i < customers.size(); i++) {
            String card = customers.get(i).getCardNum();
            if (card.compareTo(minCard) >= 0 && card.compareTo(maxCard) <= 0) {
                System.out.println(customers.get(i));
            }
        }
    }
}
