import java.io.*;
import java.util.*;
// 숫자 카드
// 맵 업데이트.
public class Bj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> hashMap = new HashMap();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(st.nextToken());
            int value = hashMap.getOrDefault(tmp,0);
            hashMap.put(tmp,value+1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int tmp = Integer.parseInt(st.nextToken());
            int value = hashMap.getOrDefault(tmp,0);
            sb.append(value+" ");
        }

        System.out.println(sb);
    }
}
