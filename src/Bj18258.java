import java.io.*;
import java.util.*;

public class Bj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N= Integer.parseInt(st.nextToken());
        Deque q = new ArrayDeque();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            switch (s){
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    q.add(n);
                    break;
                case "pop":
                    if(q.isEmpty()) sb.append(-1 + "\n");
                    else{
                        sb.append(q.poll()+"\n");
                    }
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front":
                    if(q.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(q.peekFirst()+"\n");
                    break;
                case "back":
                    if(q.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(q.peekLast()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
