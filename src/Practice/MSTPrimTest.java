package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTPrimTest {
    static int V, adjMatrix[][];

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


        boolean[] visited = new boolean[V];
        int[] minEdge = new int[V]; // 자신과 트리의 정점들 간 최소 간선 비용.

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;

        int result = 0;
        int min = 0, minVertex = 0;

        for(int c= 0;c<V;c++){
            minVertex = -1;
            min = Integer.MAX_VALUE;
            // 1. 미방문 정점 중 최소 비용 간선 선택.
            for(int i=0;i<V;i++){
                if(!visited[i] && min>minEdge[i]){
                    minVertex = i;
                    min = minEdge[i];
                }
            }

            // 2. 방문체크
            visited[minVertex] = true;
            result+=min;

            // 3. 새로 추가된 간선 포함 업데이트.
            for(int i=0; i<V;i++){
                if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]){
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }



        System.out.println(result);
    }
}