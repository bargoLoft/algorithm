import java.util.LinkedList;
import java.util.Queue;

public class exercise {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        q.offer("2");
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        System.out.println(q.peek());
    }
}
