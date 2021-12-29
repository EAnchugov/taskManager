import java.util.Scanner;

public class Menu {

    static TaskManager taskManager = new TaskManager();
    static Scanner scanner = new Scanner(System.in);


    public static void mainMenuPrint(){
        System.out.println("Ведите, номер команды:");
        System.out.println("1. Получение списка всех задач");
        System.out.println("2. Получение списка всех эпиков");
        System.out.println("3. Получение списка всех подзадач определённого эпика.");
        System.out.println("4. Получение задачи любого типа по идентификатору.");
        System.out.println("5. Добавление новой задачи, эпика и подзадачи. Сам объект должен передаваться в качестве параметра.");
        System.out.println("6. Обновление задачи любого типа по идентификатору. Новая версия объекта передаётся в виде параметра.");
        System.out.println("7. Удаление ранее добавленных задач — всех и по идентификатору.");
        System.out.println("8. Заполнить базу");
        System.out.println("0. Выход");
        }

    public static void deleteTaskMenu(){
        System.out.println("1. Удалить задачу по идентефикатору");
        System.out.println("2. Удалить все задачи");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
            if (command == 1){
                taskManager.deleteTaskByID();
            }else if (command == 2){
                taskManager.deleteAllTasks();
            }else {
                System.out.println("Неверная комманда");
        }
    }

    public static void newTaskMenu(){
        System.out.println("Что вы хотите создать?");
        System.out.println("1. Эпик");
        System.out.println("2. Задачу");
        System.out.println("3. Подзадачу");
        String command = scanner.next();

        if (command.equals("1")){
            taskManager.createNewEpic();
        }
        else if (command.equals("3")){
            taskManager.createNewSubtask();
        } else if(command.equals("2"))
            taskManager.createNewTask();
    }


    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mainMenuPrint();
            String command = scanner.next();
            if (command.equals("1")) {
                taskManager.getTaskList();
            } else if (command.equals("2")) {
                taskManager.getEpicList();
            } else if (command.equals("3")) {
                taskManager.getTaskByEpicId();
            } else if (command.equals("4")) {
                taskManager.getTaskById();
            } else if (command.equals("5")) {
            newTaskMenu();
                taskManager.createNewTask();
            } else if (command.equals("6")) {
                taskManager.changeFlagByID();
            } else if (command.equals("7")) {
                deleteTaskMenu();
// Пока оставлю
//            } else if (command.equals("8")) {
//                taskManager.fill();
            }else if (command.equals("0")) {
                System.out.println("Выход...");
                break;
            } else {
                System.out.println("Неверная команда.");
             }
        }
    }

}
