package hwh.Taxes;

public class Taxes6 extends TaxSystem {


    public int ZZG() {
        System.out.println("A");
        int z =2;
        return z;
    }

    @Override
    public int calcTaxFor(int debit, int credit) {
        int result;
        result = debit / 100 * 6;
        return result;
    }
}
