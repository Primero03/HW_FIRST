package hwh;

public class Company {
    String title;
    int debit = 0;
    int credit = 0;
    TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }


    public int shiftMoney(int amount) {
        if (amount > 0) {
            debit = debit + amount;
        }
        if (amount < 0) {
            credit = credit + Math.abs(amount);
        }
        if (amount == 0) {
            System.out.println("Данные не были введены");
        }
        return amount;
    }

    public void payTaxes() {
        int result = taxSystem.calcTaxFor(debit,credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + result + " руб.");
        debit = 0;
        credit = 0;
    }
}
