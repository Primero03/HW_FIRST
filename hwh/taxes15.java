package hwh;

public class taxes15 extends TaxSystem {


    @Override
    public int calcTaxFor(int debit, int credit) {
        int result;
        result = (debit - credit) / 100 * 15;
        return result;
    }
}
