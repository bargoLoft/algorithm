import java.io.*;
import java.util.*;
// 9를 6과 합쳐서 + 1 / 2
public class Bj1475    {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[10];

        while(N>0){
            num[N%10]++;
            N/=10;
        }

        num[6] =  (num[6] + num[9] + 1) / 2;

        int max = 0;
        for(int i=0;i<9;i++){
            max = Math.max(num[i],max);
        }

        System.out.println(max);
    }
}
