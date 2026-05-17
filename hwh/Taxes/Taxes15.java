package hwh.Taxes;

public class Taxes15 extends TaxSystem {

    @Override
    public int ZZ() {
        System.out.println("A");
        int z =3;
        return z;
    }

    @Override
    public int calcTaxFor(int debit, int credit) {
        int result;
        result = (debit - credit) / 100 * 15;
        return result;
    }
}
