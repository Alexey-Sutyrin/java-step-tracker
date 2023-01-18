public class Converter { // класс, отвечающий за конвертации шагов в Км и ККал
    double stepLength;
    double stepEnergy;
    double resultKm;
    double resultKcal;
    Converter (double Length, double Energy) {
        stepLength = Length; // заданная длина 1 шага в км
        stepEnergy = Energy; // заданная затрата энергии на 1 шаг в килокалориях
    }
    double convertToKm (double steps) {      // перевод количества шагов в километры, согласно указанной длине шага
        if (steps > 0) {
            resultKm = steps * stepLength ;
        } else {
            resultKm = 0;
            System.out.println("Пройденной дистанции нет. Больше двигайтесь! " );
        }
        return resultKm ;
    }
    double convertStepsToKilocalories (double steps) { // перевод количества шагов в затраченные ККал, согласно заданной затрате на 1 шаг
        if (steps > 0) {
            resultKcal = steps * stepEnergy ;
        } else {
            resultKcal = 0;
            System.out.println("Затрат энергии нет. Больше двигайтесь! ");
        }
        return resultKcal;
    }
}
