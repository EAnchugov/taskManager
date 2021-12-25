import java.util.Scanner;

public class Menu {
    public static void mainMenuPrint(){
        System.out.println("Ведите, номер команды:");
        System.out.println("1. Получение списка всех задач");
        System.out.println("2. Получение списка всех эпиков");
        System.out.println("3. Получение списка всех подзадач определённого эпика.");
        System.out.println("4. Получение задачи любого типа по идентификатору.");
        System.out.println("5. Добавление новой задачи, эпика и подзадачи. Сам объект должен передаваться в качестве параметра.");
        System.out.println("6. Обновление задачи любого типа по идентификатору. Новая версия объекта передаётся в виде параметра.");
        System.out.println("7. Удаление ранее добавленных задач — всех и по идентификатору.");

        mainMenu();
        }

        public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        if (command.equals("1")){

        }
        else if (command.equals("2")) {

        }
        else if (command.equals("3")){

        }
        else if (command.equals("4")){

        }
        else if (command.equals("5")){

        }
        else if (command.equals("6")){

        }
        else if (command.equals("7")){

        }
        else {
        System.out.println("Неверная команда.");
        mainMenu();
        }
            scanner.close();
    }


}
