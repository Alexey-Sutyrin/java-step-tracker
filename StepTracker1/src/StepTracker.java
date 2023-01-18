import java.util.Scanner;
class StepTracker {  // основная логика проекта - в данном модуле
    Scanner scanner; // новое поле класса Scanner
    MonthData[] monthToData; // новое поле типа "массив класса MonthData" класса StepTracker
    int goalByStepsPerDay = 10000; // новое поле класса int с присвоением значения
    Converter converter = new Converter(0.00075,0.05); // новое поле класса Converter с присвоением значения
    StepTracker (Scanner scan) { //создание массива по месяцам
        scanner = scan; // присвоение полю значения аргумента scan
        monthToData = new MonthData[12]; // присвоение полю значения массива из 12 элементов-индексов
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData(); // каждому индексу поля-массива присваивается пустое значение класса MonthData
        }
    }
    void addNewNumberStepsPerDay () { // метод - занесение кол-ва пройденных шагов в ячейку - Пункт 1 Меню
        int day = 1;
        int month = 1;
        int steps = 1;
        System.out.println("Введите номер месяца от 0 - январь до 11 - декабрь.");
        int monthNumber = scanner.nextInt();
        if (monthNumber > 11) {
            System.out.println("Номер месяца неверен - больше 11!");
            return;
        } else if (monthNumber < 0) {
            System.out.println("Номер месяца неверен - меньше 0!");
            return;
        } else {
            month = monthNumber;
        }
        System.out.println("Введите номер дня в месяце от 1 до 30 (включительно).");
        int dayNumber = scanner.nextInt();
        if (dayNumber > 30) {
            System.out.println("Номер дня неверен - больше 30!");
            return;
        } else if (dayNumber < 1) {
            System.out.println("Номер дня неверен - меньше 1!");
            return;
        } else {
            day = dayNumber;
        }
        System.out.println("Введите количество пройденных шагов за этот день.");
        int stepsCount = scanner.nextInt();
        if (stepsCount < 1) {
            System.out.println("Количество пройденных шагов некорректно.");
            return;
        } else {
            steps = stepsCount ;
        }
        MonthData monthData = monthToData[month];
        monthData.days[day-1] = steps;
        System.out.println ("Изменения внесены успешно!" + " Месяц " + month +  " День " + day + " = " + steps + " шагов");
    }
    void changeStepGoal() {          // метод - смена общей цели по пройденным шагам на каждый день - Пункт 3 Меню
        System.out.println("Cтарая цель = " + goalByStepsPerDay + " шагов в день");
        System.out.println("Введите новую цель по количеству шагов в день: ");
        int newGoal = scanner.nextInt();
        if (newGoal < 1) {
            System.out.println("Новое значение цели некорректно!");
        } else {
            goalByStepsPerDay = newGoal;
            System.out.println("Цель по количеству шагов в день успешно изменена!");
            System.out.println("Новая цель = " + goalByStepsPerDay + " шагов в день");
        }
    }
    void printStatistic() {     // вывод общей статистики - Пункт 2 Меню
        int monthUser = 1;
        System.out.println("Введите номер месяца от 0 - январь до 11 - декабрь."); // ввод и проверка номера месяца
        int monthNumber = scanner.nextInt();
        if (monthNumber > 11) {
            System.out.println("Номер месяца неверен - больше 11!");
            return;
        } else if (monthNumber < 0) {
            System.out.println("Номер месяца неверен - меньше 0!");
            return;
        } else {
            monthUser = monthNumber;
        }
        MonthData oldMonthData = new MonthData(); // получение соответствующего месяца
        oldMonthData = monthToData[monthUser];    // получение соответствующего месяца
        int summa = oldMonthData.sumStepsFromMonth();  // получение суммы шагов за месяц
        System.out.println("Вывод общей статистики : "); // вывод общей статистики
        oldMonthData.printDaysAndStepsFromMonth();      // вывод общей статистики
        System.out.println("Cумма шагов за месяц : " + oldMonthData.sumStepsFromMonth());// вывод суммы шагов за месяц
        System.out.println("Максимальное количество пройденных шагов за месяц : " + oldMonthData.maxStepsInMonth()); // вывод максимального пройденного количества шагов за месяц
        System.out.println("За месяц пройдена дистанция, Км : " + converter.convertToKm(summa) );// вывод суммарной пройденной дистанции в км за месяц
        System.out.println("За месяц сожжено энергии, ККал : " + converter.convertStepsToKilocalories(summa) );// вывод количества сожжённых килокалорий за месяц
        System.out.println("Длительность лучшей серии непрерывного совершенства выше нормы : " + oldMonthData.bestSeries(goalByStepsPerDay) + " д. подряд!" ); // вывод лучшей серии рекордов за месяц в днях подряд
        System.out.println("Напоминаем, норма шагов сейчас : " + goalByStepsPerDay + " шагов в день"); // итог
        System.out.println(); // дополнительный перенос строки
    }
}
