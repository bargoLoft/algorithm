import java.io.*;
import java.util.*;

public class Bj13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 트럭의 수
        int W = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
        int[] trucks = new int[N];
        int[] bridge = new int[W];

        // 트럭 무게 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        while


    }
}
