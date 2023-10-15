import java.io.*;
import java.util.*;

public class Bj1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        HashSet aSet = new HashSet();

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            int n = Integer.parseInt(st.nextToken());
            aSet.add(n);
        }

        int cnt = 0;
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            int n = Integer.parseInt(st.nextToken());
            if(aSet.contains(n)) cnt++;
        }

        System.out.println(A+B-cnt*2);
    }
}
