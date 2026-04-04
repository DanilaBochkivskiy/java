public class InternetClient extends BaseSub implements InternetSub {
    public InternetClient(String number) { super(number); }

    @Override
    public void boostSpeed() { System.out.println("Скорость увеличена."); }

    @Override
    public void setParentalControl(boolean state) {
        System.out.println("Родительский контроль: " + (state ? "ВКЛ" : "ВЫКЛ"));
    }
}