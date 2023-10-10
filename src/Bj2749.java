import java.io.*;
import java.util.*;

// 피보나치 수 3
// DP x
// 그냥 피사노 주기
// 10의 거듭제곱의 나머지는 15 * 10^(n-1) 의 주기를 갖는다.

public class Bj2749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        N = N%(15*1000000);

        long prev = 0;
        long cur = 1;
        for(int i=0;i<N-1;i++){
            long tmp = (prev + cur) % 1000000;
            prev = cur;
            cur = tmp;
        }

        System.out.println(cur);
    }
}
