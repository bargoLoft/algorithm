import java.io.*;
import java.util.*;

// 숫자
// Long.parseLong 도 고쳐야..
// StringBuilder, BufferedReader, StringTokenizer
public class Bj10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong((st.nextToken()));

        if (A>B){
            long tmp = A;
            A = B;
            B = tmp;
        }

        System.out.println(Math.max(B-A-1,0));
        for(long i=A+1;i<B;i++){
            sb.append(i+" ");
        }
        System.out.print(sb);
    }
}
