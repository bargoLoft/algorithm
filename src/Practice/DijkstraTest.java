package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
    static class Node{
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Node[] adjList = new Node[V]; // 인접리스트
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        for(int i=0;i<E;++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to,weight,adjList[from]);
        }

        final int INF = Integer.MAX_VALUE;
        Arrays.fill(distance,INF);

        distance[start] = 0;
        int min =0, stopOver = 0;

        for(int i=0;i<V;i++){
            stopOver = -1;
            min = INF;
            for(int j=0;j<V;j++){
                if(!visited[j]&& min>distance[j]){
                    min = distance[j];
                    stopOver = j;
                }
            }
            if(stopOver == -1) break;

            visited[stopOver] = true;
            if(stopOver == end) break;

            for(Node temp = adjList[stopOver]; temp!=null;temp=temp.next){
                if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight){
                    distance[temp.vertex] = min + temp.weight;
                }
            }
        }

        System.out.println(distance[end] != INF ? distance[end] : -1);



    }
}
