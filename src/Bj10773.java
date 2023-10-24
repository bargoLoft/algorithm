import java.io.*;
import java.util.*;

public class Bj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> s = new Stack();

        int sum=0;
        for(int i=0;i<K;i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0) sum-=s.pop();
            else{
                s.add(n);
                sum+=n;
            }
        }
        System.out.println(sum);
    }
}
