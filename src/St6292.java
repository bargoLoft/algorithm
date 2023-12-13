import java.io.*;
import java.util.*;
// 수퍼바이러스.
// 입력 받을때 Integer.parseInt(...)
// Long.parseLong(...) 인지..........
public class St6292 {
    static long DIVIDE = 1000000007;
    static long recursion( long P, long N){
        if(N==1) return P;
        if(N==0) return 1;

        long cur = recursion(P,N/2);
        long result = (cur*cur)%DIVIDE;
        if(N%2==0) return result;
        else return (result * P) % DIVIDE;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());


        long ans  = (recursion(P,N*10) * K) % DIVIDE;

        System.out.println(ans);
    }
}
