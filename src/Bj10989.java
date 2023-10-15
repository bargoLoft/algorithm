import java.io.*;
import java.util.*;
// 수 정렬하기 3

// 카운팅 정렬.(수의 범위가 작으면 매우 효과적)
public class Bj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] arr_sort = new int[N+1];

        int[] count = new int[10001];


        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            count[tmp]++;
        }

        for(int i=1;i<=10000;i++){
            count[i] = count[i] + count[i-1];
        }

        for(int i=0;i<N;i++){
            arr_sort[count[arr[i]]--] = arr[i];
        }

        for(int i=1;i<=N;i++){
            sb.append(arr_sort[i]+"\n");
        }

        System.out.println(sb);
    }
}
