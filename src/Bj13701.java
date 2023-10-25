import java.io.*;
import java.util.*;
// 중복 제거

// 비트 마스킹. int를 쪼개서.
public class Bj13701 {
    static int MAX = 1048576;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[MAX];

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if((arr[n/32] & 1<<(n%32)) == 1<<(n%32)) continue;
            arr[n/32] |= 1<<(n%32);
            sb.append(n+" ");
        }

        System.out.println(sb);
    }
}
