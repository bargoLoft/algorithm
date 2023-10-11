import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 창용 마을 무리의 개수
public class Swea7465 {
    static int[] arr;

    static void union(int a, int b){
        if(find(a) == find(b)) return; // 조상이 같으면 리턴
        arr[find(b)] = a; // b의 대빵의 부모를 a로 변경
    }

    static int find(int a){
        if(arr[a] == a) return a; // 자기를 가리키면 자신 리턴
        return arr[a] = find(arr[a]); // 아니면 조상 찾아서 입력 후 리턴
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N+1];

            // 자기 자신 찍기
            for(int i=1;i<=N;i++){
                arr[i] = i;
            }

            // 무리 짓기
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
            }

            // 무리 개수 세기
            Set s = new HashSet();
            for(int i=1;i<=N;i++){
                //System.out.print(find(arr[i])+" ");
                s.add(find(arr[i]));
            }
            //System.out.println();

            System.out.printf("#%d %d\n",t,s.size());
        }
    }
}
