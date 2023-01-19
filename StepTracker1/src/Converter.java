public class Converter { // класс, отвечающий за конвертации шагов в Км и ККал
    double stepLength = 0.00075;  // ДОБАВЛЕНО 19.01.23 - заданная длина 1 шага в км
    double stepEnergy = 0.05;  // ДОБАВЛЕНО 19.01.23 - заданная затрата энергии на 1 шаг в килокалориях, магические числа убрал
    double convertToKm (double steps) {// перевод количества шагов в километры, согласно указанной длине шага
        double resultKm = 0; // ДОБАВЛЕНО 19.01.23 - занёс в метод, в else cтало на 1 строку меньше
        if (steps > 0) {
            resultKm = steps * stepLength ;
        } else {
            System.out.println("Пройденной дистанции нет. Больше двигайтесь! " );
        }
        return resultKm ;
    }
    double convertStepsToKilocalories (double steps) { // перевод количества шагов в затраченные ККал, согласно заданной затрате на 1 шаг
        double resultKcal = 0; // ДОБАВЛЕНО 19.01.23 - занёс в метод, в else cтало на 1 строку меньше
        if (steps > 0) {
            resultKcal = steps * stepEnergy ;
        } else {
            System.out.println("Затрат энергии нет. Больше двигайтесь! ");
        }
        return resultKcal;
    }
}
