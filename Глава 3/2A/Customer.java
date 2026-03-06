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
    private Customer[] customers;
    private int count = 0;

    public Customers() {
        customers = new Customer[3];
    }
    public void addCustomers(Customer customer){
        customers[count++] = customer;
    }
    public void sortName() {
        Customer[] temp = new Customer[count];
        for (int i = 0; i < count; i++) {
            temp[i] = customers[i];
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (temp[j].getFamiliya().compareTo(temp[j + 1].getFamiliya()) > 0) {
                    Customer buf = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = buf;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println(temp[i]);
        }
    }

    public void CardRange(String minCard, String maxCard) {
        for (int i = 0; i < count; i++) {
            String card = customers[i].getCardNum();
            if (card.compareTo(minCard) >= 0 && card.compareTo(maxCard) <= 0) {
                System.out.println(customers[i]);
            }
        }
    }
}