import java.util.HashMap;

public class EpicManager {

    HashMap<Integer, String> epicName = new HashMap<>();
    HashMap<Integer, String> epicDescription = new HashMap<>();
    HashMap<Integer, String> epicFlag = new HashMap<>();

    public void newEpic(String name, String description, String flag){
        TaskIndex taskIndex = new TaskIndex();
        int id = taskIndex.newId();
        epicName.put(id, name);
        epicDescription.put(id,description);
        epicFlag.put(id, flag);
        System.out.println("Эпик '" + name + "' создан" );
    }


}
