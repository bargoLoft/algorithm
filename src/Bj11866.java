import java.io.*;
import java.util.*;
// 요시푸스 순열

// 큐
public class Bj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue q = new ArrayDeque();

        for(int i=1;i<=N;i++){
            q.add(i);
        }

        sb.append("<");

        for(int i=1;i<N;i++){
            for(int j=0;j<K-1;j++){
                q.add(q.poll());
            }
            sb.append(q.poll()+", ");
        }

        sb.append(q.poll()+">");

        System.out.println(sb);
    }
}
