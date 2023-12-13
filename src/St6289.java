import java.io.*;
import java.util.*;
// 우물 안 개구리

// 유니온 파인드. 아님
// 인맥 풀 고려 X 걍 지만 아는 사람만 중에
public class St6289 {
    static int[] king;
    static int[] weight;
//    static int find(int x){
//        if(king[x] == x ) return x;
//        else return king[x] = find(king[x]);
//    }
//
//    static void union(int x,int y){
//        x = find(x);
//        y = find(y);
//
//        if(weight[x]<weight[y]) king[x] = y;
//        else king[y] = x;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        weight = new int[N+1];
        king = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            weight[i] = Integer.parseInt(st.nextToken());
            king[i] = 1; // 내가 짱이다.
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(weight[a] > weight[b]){
                king[b] = 0;
            } else if(weight[a] < weight[b]){
                king[a] = 0;
            }
            else{
                king[a] = 0;
                king[b] = 0;
            }
        }

        int cnt =0;

        for(int i=1;i<=N;i++){
            cnt+=king[i];
        }

        System.out.println(cnt);
    }
}
