import java.util.ArrayDeque;
import java.util.Queue;

public class GraphSearch {

    static class Node{
        int vertext;
        Node next;

        public Node(int vertext,Node next){
            super();
            this.vertext = vertext;
            this.next = next;
        }
        @Override
        public String toString(){
            return String.valueOf('?');
        }
    }

    private static void bfs(Node adjList[]){
        int size = adjList.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[size];

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println((char)(current+65));

            for(Node temp = adjList[current]; temp!=null;temp = temp.next){
                if(!visited[temp.vertext]){
                    queue.offer(temp.vertext);
                    visited[temp.vertext] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
