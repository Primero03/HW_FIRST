package hwh;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        TaxSystem tx = new TaxSystem();
        taxes6 tax6 = new taxes6();
        taxes15 tax15 = new taxes15();
        Company cmp1 = new Company("Lukoil", tx);
        System.out.println("Выберите систему налогооблажения:");
        System.out.println("1.УСН доходы — налог 6% от доходов");
        System.out.println("2.УСН доходы минус расходы — налог 15% от разницы доходов и расходов");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                cmp1.setTaxSystem(tax6);
                break;
            case 2:
                cmp1.setTaxSystem(tax15);
                break;
        }

        while (true) {
            System.out.println("Для закрытия программы введите 'end'");
            System.out.print("Укажите изменения на счету:");
            String entry = sc.nextLine();
            System.out.println();

            if ("end".equals(entry)) {
                System.out.println("Программа завершена");
                break;
            }

            if (!entry.isEmpty()) {
                int transfer = Integer.parseInt(entry);
                cmp1.shiftMoney(transfer);
            }
        }
        cmp1.payTaxes();
    }
}
