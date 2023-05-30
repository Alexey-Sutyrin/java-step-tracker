import java.util.Scanner;
class StepTracker {  // основная логика проекта - в данном модуле
    Scanner scanner; // новое поле класса Scanner
    MonthData[] monthToData; // новое поле типа "массив класса MonthData" класса StepTracker
    int goalByStepsPerDay = 10000; // новое поле класса int с присвоением значения
    Converter converter = new Converter(); // новое поле класса Converter, ДОБАВЛЕНО 19.01.23 - магические числа из присвоения убрал
    StepTracker (Scanner scan) { //создание массива по месяцам
        scanner = scan; // присвоение полю значения аргумента scan
        monthToData = new MonthData[12]; // присвоение полю значения массива из 12 элементов-индексов
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData(); // каждому индексу поля-массива присваивается пустое значение класса MonthData
        }
    }
    void addNewNumberStepsPerDay () { // метод - занесение кол-ва пройденных шагов в ячейку - Пункт 1 Меню
        System.out.println("Введите номер месяца от 1 - январь до 12 - декабрь."); // 30.05.23 - диапазон 0-11 заменен на 1-12
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) { // ДОБАВЛЕНО 19.01.23 - сложные условия формата AND,OR у нас во 2 спринте, но в замечаниях разрешили - с удовольствием добавлю
            System.out.println("Номер месяца неверен - он должен быть в пределах от 1 до 12!"); // 30.05.23 - диапазон 0-11 заменен на 1-12
            return;
        }
        System.out.println("Введите номер дня в месяце от 1 до 30 (включительно).");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {   // ДОБАВЛЕНО 19.01.23, лишние else все убрал
            System.out.println("Номер дня неверен - он должен быть в пределах от 1 до 30!");
            return;
        }
        System.out.println("Введите количество пройденных шагов за этот день.");
        int stepsCount = scanner.nextInt();
        if (stepsCount < 1) {
            System.out.println("Количество пройденных шагов некорректно - оно должно быть больше 0!");
            return;
        }
        MonthData monthData = monthToData[monthNumber-1];
        monthData.days[dayNumber-1] = stepsCount;
        System.out.println ("Изменения внесены успешно!" + " Месяц " + monthNumber +  " День " + dayNumber + " = " + stepsCount + " шагов");
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
                                // ДОБАВЛЕНО 30.05.23 - диапазон вводимых месяцев 0-11 изменён на 1-12
        System.out.println("Введите номер месяца от 1 - январь до 12 - декабрь."); // ввод и проверка номера месяца
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) { // ДОБАВЛЕНО 19.01.23 - аналогично addNewNumberStepsPerDay
            System.out.println("Номер месяца неверен - он должен быть в пределах от 1 до 12!");
            return;
        }
        MonthData oldMonthData = new MonthData(); // получение соответствующего месяца
        oldMonthData = monthToData[monthNumber-1];    // получение соответствующего месяца, 30.05.23 - коррекция на 1
        int summa = oldMonthData.sumStepsFromMonth();  // получение суммы шагов за месяц
        System.out.println("Вывод общей статистики : "); // вывод общей статистики
        oldMonthData.printDaysAndStepsFromMonth();      // вывод общей статистики
        System.out.println("Cумма шагов за месяц : " + oldMonthData.sumStepsFromMonth());// вывод суммы шагов за месяц
        System.out.println("Максимальное количество пройденных шагов за месяц : " + oldMonthData.maxStepsInMonth()); // вывод максимального пройденного количества шагов за месяц
        // ДОБАВЛЕНО 19.01.23 - вывод среднего количества шагов за день в данном месяце
        System.out.println("Среднее количество пройденных шагов за день в этом месяце : " + oldMonthData.averageStepsInMonth());
        System.out.println("За месяц пройдена дистанция, Км : " + converter.convertToKm(summa) );// вывод суммарной пройденной дистанции в км за месяц
        System.out.println("За месяц сожжено энергии, ККал : " + converter.convertStepsToKilocalories(summa) );// вывод количества сожжённых килокалорий за месяц
        System.out.println("Длительность лучшей серии непрерывного совершенства выше нормы : " + oldMonthData.bestSeries(goalByStepsPerDay) + " д. подряд!" ); // вывод лучшей серии рекордов за месяц в днях подряд
        System.out.println("Напоминаем, норма шагов сейчас : " + goalByStepsPerDay + " шагов в день"); // итог
        System.out.println(); // дополнительный перенос строки
    }
}
