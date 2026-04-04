public class CorporateClient extends BaseSub implements CorporateSub {
    public CorporateClient(String number) { super(number); }

    @Override
    public void manageGroupLines() { System.out.println("Управление списком сотрудников."); }

    @Override
    public void getTaxReports() { System.out.println("Отчет для налоговой готов."); }
}
