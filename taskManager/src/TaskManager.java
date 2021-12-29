import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TaskManager {
    HashMap<Integer, String> taskName = new HashMap<>();
     HashMap<Integer, String> taskDescription = new HashMap<>();
     HashMap<Integer, String> taskFlag = new HashMap<>();
     HashMap<Integer, Integer> taskRootId = new HashMap<>();
     HashMap<Integer, String> taskType = new HashMap<>();
     ArrayList<Integer> id = new ArrayList<>();

    private void addTask(String name, String description, String flag, Integer rootId, String type){
        int id = newId();
        taskName.put(id, name);
        taskDescription.put(id,description);
        taskFlag.put(id, flag);
        taskRootId.put(id, rootId);
        taskType.put(id,type);
        System.out.println("Чей-то созданно");
    }

    private int newId(){
        int newId;
        newId = id.size() + 1;
        id.add(1);
        return newId;
    }

    public void createNewEpic () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название");
        String name = scanner.next();
        System.out.println("Введите описание");
        String description = scanner.next();
        addTask(name, description,"NEW", 0,"Epic");
    }

    public void createNewSubtask () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название");
        String name = scanner.next();
        System.out.println("Введите описание");
        String description = scanner.next();
        System.out.println("Введите ID родителя");
        int rootID = scanner.nextInt();
        addTask(name, description, "NEW", rootID, "Subtask");
    }

    public void createNewTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название");
        String name = scanner.next();
        System.out.println("Введите описание");
        String description = scanner.next();
        addTask(name, description, "NEW", 0, "Task");

    }

    public void getTaskList() {
        for (Integer names : taskName.keySet()){
            if (taskType.get(names).equals("Task")){
                System.out.print("ID = " + names + " ");
                System.out.println(taskName.get(names));
                }
        }
    }
//Получение списка всех эпиков
    public void getEpicList (){
        for (int id : taskType.keySet()){
            if (taskType.get(id).equals("Epic")){
            System.out.println("ID = "+ id +" Название: " + taskName.get(id) + ". Статус: " + taskFlag.get(id)+".");
            }
        }
    }

    public void getTaskByEpicId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID эпика");
        int searchId = scanner.nextInt();
        for (Integer searh : taskRootId.keySet()) {
            if (taskRootId.get(searh) == searchId) {
            System.out.println(taskName.get(searh));
            }
        }
    }

    public void getTaskById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID задачи");
        int id = scanner.nextInt();
        System.out.println("ID = "+ id +" Название: " + taskName.get(id) + ". Статус: " + taskFlag.get(id)+".");
    }

    //обновляем флаг, отправляем на проверку / апдейт эпик
    public void changeFlagByID (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID задачи");
        int id = scanner.nextInt();
        System.out.println("Введите новый статус задачи");
        System.out.println("1 - In Progress");
        System.out.println("2 - Done");
        int command = scanner.nextInt();
        if (command == 1){
            taskFlag.replace(id,"IN_PROGRESS");
            epicFlagUpdate(id,"IN_PROGRESS");
        }else if (command == 2){
            taskFlag.replace(id,"DONE");
            epicFlagUpdate(id,"DONE");
            }
        else {
            System.out.println("Неверная комманда");
        }
    }

    private void epicFlagUpdate(int id, String status) {
        if (status.equals("IN_PROGRESS")){ //Ищем эпик и меняем его статус
            taskFlag.replace(taskRootId.get(id), status);
        }
        else if (status.equals("DONE")){
            int tmpFlag = 0;
            int tmpkey = taskRootId.get(id);//находим ID эпика
            for (int rootID : taskRootId.values()){//проходем по таблице находим ключи подзадач
                if (rootID == tmpkey){
                    //если есть незакрытые задачи меняем флаг на IN_PROGRESS
                    if ((taskFlag.get(tmpkey).equals("IN_PROGRESS"))&&(taskFlag.get(tmpkey).equals("NEW"))){
                        tmpFlag = 1;
                    }
                }
            }
            if (tmpFlag == 1){
                taskFlag.replace(tmpkey,"IN_PROGRESS");
                System.out.println("IN PROGRESS");
            }else{
                taskFlag.replace(tmpkey,"DONE");
                System.out.println("DONE");
            }
        }
    }


/*
Это пока оставлю, пригодится при доработке
    public void fill() {
            addTask("Построить домну","Огромную такую","NEW",0,"Epic");
            addTask("Построить туалет","Типа сартир","NEW",0,"Epic");
            addTask("Сделать фундамент","Мощный такой","NEW",1,"Subtask");
            addTask("Привезти кирпичей","Отстроить и поджечь","NEW",1,"Subtask");
            addTask("Выкопать яму","Огромную такую","NEW",2,"Subtask");
            addTask("Сколотить сартир","Не забыть дырку в полу","NEW",2,"Subtask");
            addTask("Накормить кота","кормом для котов","NEW",0,"Task");
            addTask("Кастрировать кота","Не самому, ножницы тупые","NEW", 0, "Task");
        }*/
    private void deleteAll(){
            taskDescription.clear();
            taskName.clear();
            taskFlag.clear();
            taskRootId.clear();
            taskType.clear();
            id.clear();
        }

    public void deleteAllTasks() {
        System.out.println("Вы уверены?");
        System.out.println("Напишите Да/Нет");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
            if (command.equals("Да")){
                deleteAll();
            }
            else {
                System.out.println("Ничего не удалено");
        }
    }

    public void deleteTaskByID() {
        System.out.println("Введите ID удаляемой Задачи");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if (taskDescription.get(id).equals("Task")){
            taskDescription.remove(id);
            taskName.remove(id);
            taskFlag.remove(id);
            taskRootId.remove(id);
            taskType.remove(id);
        }
        else {
            System.out.println("Это не task");
        }
    }
}

