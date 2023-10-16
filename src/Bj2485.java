import java.io.*;
import java.util.*;

public class Bj2485 {
    static int GCD(int A, int B){
        if(B==0) return A;
        return GCD(B,A%B);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(br.readLine());
        }

        int gcd = tree[1] - tree[0];
        for(int i=2;i<N;i++){
            gcd = GCD(gcd,tree[i] - tree[i-1]);
            if(gcd == 1) break;
        }

        int cnt = 0;
        for(int i=1;i<N;i++){
            cnt+= (tree[i] - tree[i-1]) / gcd - 1;
         }

        System.out.println(cnt);

    }
}
