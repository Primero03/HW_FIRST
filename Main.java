package HashArra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Мапа: адрес -> цена доставки 1 кг
        Map<Address, Double> costPerAddress = new HashMap<>();

        // Заполняем мапу тестовыми адресами и ценами
        costPerAddress.put(new Address("Russia", "Saint-Petersburg"), 18.0);
        costPerAddress.put(new Address("United Kingdom", "London"), 112.4);
        costPerAddress.put(new Address("United Kingdom", "Manchester"), 108.6);
        costPerAddress.put(new Address("Spain", "Madrid"), 103.8);
        costPerAddress.put(new Address("USA", "New York"), 45.0);
        costPerAddress.put(new Address("Germany", "Berlin"), 30.0);
        costPerAddress.put(new Address("Germany", "Cologne"), 99.0);
        costPerAddress.put(new Address("Japan", "Tokyo"), 55.0);


        HashSet<String> supportedCountries = new HashSet<>();
        for (Address addr : costPerAddress.keySet()) {
            supportedCountries.add(addr.getCountry());
        }

        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;

        System.out.println("Сервис доставки. Вводите заказы по частям.");
        System.out.println("Для завершения введите 'end' вместо страны.");

        while (true) {
            System.out.print("\nВведите страну (или 'end' для завершения): ");
            String country = scanner.nextLine().trim();

            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine().trim();

            System.out.print("Введите вес груза (кг): ");
            String weightInput = scanner.nextLine().trim();

            double weight;
            try {
                weight = Double.parseDouble(weightInput);
                if (weight <= 0) {
                    System.out.println("Вес должен быть положительным числом. Пропускаем этот заказ.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный вес. Введите число. Пропускаем этот заказ.");
                continue;
            }

            Address orderAddress = new Address(country, city);


            if (!supportedCountries.contains(country)) {
                System.out.println("Такой страны нет в списке обслуживаемых направлений.");
                continue;
            }

            
            Double pricePerKg = costPerAddress.get(orderAddress);

            if (pricePerKg == null) {
                System.out.println("Адрес не обслуживается: " + orderAddress);
            } else {
                double cost = pricePerKg * weight;
                totalCost += cost;
                System.out.printf("Стоимость доставки для %s (%.2f кг): %.2f руб.%n",
                        orderAddress, weight, cost);
            }
        }

        System.out.printf("%nОбщая сумма всех доставок: %.2f руб.%n", totalCost);
        scanner.close();
    }
}


class Address {
    private final String country;
    private final String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return country.equals(address.country) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return country + ", " + city;
    }
}
