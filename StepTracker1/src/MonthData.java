class MonthData { // сбор статистики и подсчёт данных по месяцам
    int[] days = new int[30]; // поле типа целочисленный массив - класса Month Data
    void printDaysAndStepsFromMonth() {     // сбор статистики за конкретный месяц и вывод 30 строк за месяц
        for (int i = 0; i < 30; i++) {
            System.out.println( (i+1) + " день: " + days[i]);
        }
    }
    int sumStepsFromMonth() {               // суммирование количества пройденных шагов за конкретный месяц и возврат значения
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }
    int maxStepsInMonth() {                // нахождение максимального значения количества шагов за день в конкретном месяце и возврат значения
        int maxSteps = 0;
        int temp;
        for (int i = 0; i < 30; i++) {
            temp = days[i];
            if (temp > maxSteps) {
                maxSteps = temp;
            }
        }
        return maxSteps;
    }
    int averageStepsInMonth() {            // ДОБАВЛЕНО 19.01.23 - нахождение среднего дневного значения пройденных шагов за месяц
        int averageSteps = 0;
        int temp = 0;
        for (int i = 0; i < 30; i++) {
            temp = temp + days[i];
        }
        averageSteps = (temp / 30);
        return averageSteps;
    }
    int bestSeries(int goalByStepsPerDay) {  // нахождение лучшей серии из нескольких дней подряд по превышению норматива и возврат значения
        int bestSession = 0;
        int countBest = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > goalByStepsPerDay) {
                bestSession = bestSession + 1;
                if (countBest < bestSession) {
                    countBest = bestSession;
                }
            } else {
                bestSession = 0;
            }
        }
        return countBest;
    }
}