import java.io.*;
import java.util.*;
// 두 수의 합
// int[] 배열 만든 후 Arrays.sort()
public class Bj3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        int x = Integer.parseInt(br.readLine());

        int str = 0;
        int end = N-1;

        while(str<end){
            if(arr[str]+arr[end] == x){
                cnt++;
                str++; end--;
            } else{
                if (arr[str] + arr[end] < x) {
                    str++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }
}
