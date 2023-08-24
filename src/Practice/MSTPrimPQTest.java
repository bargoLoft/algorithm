package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MSTPrimPQTest {
    static int V, adjMatrix[][];

    static class Vertex implements Comparable<Vertex>{
        int no,weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o){
            return Integer.compare(this.weight,o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(br.readLine());
        adjMatrix = new int[V][V];

        for(int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            for( int j=0; j<V; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방문 정점
        boolean[] visited = new boolean[V];
        int[] minEdge = new int[V]; // 자신과 트리의 정점들 간 최소 간선 비용.
        PriorityQueue<Vertex> pQueue = new PriorityQueue<>();

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        pQueue.offer(new Vertex(0, minEdge[0]));

        int result = 0;
        int min = 0, minVertex = 0, cnt =0;

        for(int c= 0;c<V;c++){
            // 1. 미방문 정점 중 최소 비용 간선 선택.
            Vertex cur = pQueue.poll();
            minVertex = cur.no;
            min = cur.weight;
            if(visited[minVertex]) continue;

            // 2. 방문체크
            visited[minVertex] = true;
            result+=min;
            if(++cnt==V) break;

            // 3. 새로 추가된 간선 포함 업데이트.
            for(int i=0; i<V;i++){
                if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]){
                    minEdge[i] = adjMatrix[minVertex][i];
                    pQueue.offer((new Vertex(i, minEdge[i])));
                }
            }
        }



        System.out.println(result);
    }
}