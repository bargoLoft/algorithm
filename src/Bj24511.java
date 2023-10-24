import java.io.*;
import java.util.*;
// 큐스택

// 큐 따로 스택 따로
public class Bj24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        Deque q = new ArrayDeque();
        Stack s = new Stack();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int b = Integer.parseInt(st.nextToken());
            if(A[i]==0) q.add(b);
            else s.add(b);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int c = Integer.parseInt(st.nextToken());
            if(q.isEmpty()) sb.append(c+" ");
            else{
                q.addFirst(c);
                sb.append(q.pollLast()+" ");
            }
        }

        System.out.println(sb);
    }
}
