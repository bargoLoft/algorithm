import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Bj2644 {

    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 사람 수 N
        list = new ArrayList[N+1];
        int[] chonsu = new int[N+1]; // 촌수 저장 배열.
        Arrays.fill(chonsu,-1); // -1로 초기화.

        // 객체기에 하나마다 일일이 초기화 해주어야.
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        // 촌수 계산해야 하는 둘.
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 촌수 관계 입력.
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list[parent].add(child);
            list[child].add(parent);
        }

        Queue<Integer> q = new LinkedList<Integer>();

         chonsu[a] = 0; // 자기자신은 0촌
         q.add(a);

         int ans = -1;

         // BFS
         while(!q.isEmpty()){
             int current = q.poll();
             if(current == b){ // a -> 0 일때부터 b까지 닿았다면.
                 ans = chonsu[current]; // current가 아닌 chonsu[current]
                 break;
             }

             for(int i=0;i<list[current].size();i++){
                 int tmp = list[current].get(i);
                 if(chonsu[tmp] != -1) continue; // 이미 친척이면 패스
                 chonsu[tmp] = chonsu[current] + 1; // 촌수 업데이트
                 q.add(tmp);
             }
         }

        System.out.println(ans);

    }
}
