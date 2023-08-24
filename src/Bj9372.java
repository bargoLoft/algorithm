import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 상근이의 여행.
// union, find 사용.
// root까지 가서 변경!
public class Bj9372 {
    static int[] parents;
    private static int find(int a){
        if(parents[a] == a){
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot){
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parents = new int[N+1];
            int fly = 0;

            for(int i=0;i<=N;i++){
                parents[i] = i;
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a) == find(b)){
                    continue;
                }
                union(a,b);
                fly++;
            }

            System.out.println(fly);
        }

    }
}
