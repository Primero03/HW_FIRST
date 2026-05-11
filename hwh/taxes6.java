package hwh;

public class taxes6 extends TaxSystem {



    @Override
    public int calcTaxFor(int debit, int credit) {
        int result;
        result = debit / 100 * 6;
        return result;
    }
}
