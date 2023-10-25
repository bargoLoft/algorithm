import java.io.*;
import java.util.*;

public class Bj2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            for(int j=0;j<N-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
