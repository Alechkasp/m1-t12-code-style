import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, int depositPeriod) {
        double value = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
        return round(value);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        double value = amount + amount * 0.06 * depositPeriod;
        return round(value);
    }

    double round(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void calculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double profit = 0;
            if (action == 1) {
                profit = calculateSimplePercent(amount, depositPeriod);
            } else if (action == 2) {
                profit = calculateComplexPercent(amount, depositPeriod);
            }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + profit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }
}