import java.util.Scanner;
class Main { // основной модуль, меню ввода - вывода
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // запуск метода сканирования
        StepTracker stepTracker = new StepTracker(scanner); // запуск модуля StepTracker
        while (true) {            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            int userInput = scanner.nextInt(); // повторное считывание данных от пользователя
            if (userInput == 1) {          // Меню > Пункт 1 > Ввести количество шагов за день
                stepTracker.addNewNumberStepsPerDay();
                System.out.println(); // строка - отступ
            } else if (userInput == 2) {   // Меню > Пункт 2 > Напечатать статистику за месяц
                stepTracker.printStatistic();
                System.out.println();
            } else if (userInput == 3) {   // Меню > Пункт 3 > Изменить цель по количеству шагов в день
                stepTracker.changeStepGoal();
                System.out.println();
            } else if (userInput == 4) {   // Меню > Пункт 4 > Выход
                System.out.println("Пока! The End.");
                scanner.close();
                return;
            } else {   // логика для команд, которых нет в Меню
                System.out.println("Такой команды нет. Введите корректный номер пункта Меню.");
                System.out.println();
            }
        }
    }
    static void printMenu () { // печать вступительного меню
        System.out.println("Что вы хотите сделать? Наберите номер команды и нажмите Enter.");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выход");
    }
}