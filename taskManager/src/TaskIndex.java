import java.util.ArrayList;

public class TaskIndex {
    ArrayList<Integer> id = new ArrayList<>();
    public int newId(){
        int newId;
        newId = id.size() + 1;
        id.add(1);
        return newId;
    }
}
