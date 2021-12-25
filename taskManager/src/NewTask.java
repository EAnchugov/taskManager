import javax.swing.*;
import java.util.Scanner;

public class NewTask {
    EpicManager epicManager = new EpicManager();

    public static void printMenu(){
        System.out.println("Что вы хотите создать?");
        System.out.println("1. Эпик");
        System.out.println("2. Задачу");
        System.out.println("3. Подзадачу");
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        if (command.equals("1")){
        System.out.println("Название Эпика");
        String name = scanner.next();
        System.out.println("Введите описание метода");
        String description = scanner.next();
        epicManager.newEpic(name, description, "NEW");
        }
        else if (command.equals("2")){

        }
        else if (command.equals("3")){

        }
        else{
            System.out.println("Неверная комманда");
        }
        scanner.close();
    }
}
