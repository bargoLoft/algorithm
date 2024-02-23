import java.io.*;
import java.util.*;

public class Bj2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N*2-1;i++){
            for(int j=0;j<N-1-Math.abs(i-N+1);j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*Math.abs(i-N+1)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
