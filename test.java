import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        
    HashMap<Integer, String> passportsAndNames = new HashMap<>();

    passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
    passportsAndNames.put(162348, "Иван Михайлович Серебряков");
    passportsAndNames.put(8082771, "Дональд Джон Трамп");

    String lidiaName = passportsAndNames.get(212133);
    System.out.println(lidiaName);
    System.out.println(Arrays.asList(passportsAndNames));
    }
}
