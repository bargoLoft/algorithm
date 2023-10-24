import java.io.*;
import java.util.*;

public class Bj28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Deque dq = new ArrayDeque();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command){
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                case 3:
                    if(!dq.isEmpty()){
                        sb.append(dq.pollFirst()+"\n");
                    } else sb.append("-1\n");
                    break;
                case 4:
                    if(!dq.isEmpty()){
                        sb.append(dq.pollLast()+"\n");
                    } else sb.append("-1\n");
                    break;
                case 5:
                    sb.append(dq.size()+"\n");
                    break;
                case 6:
                    if(dq.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 7:
                    if(!dq.isEmpty()){
                        sb.append(dq.peekFirst()+"\n");
                    } else sb.append("-1\n");
                    break;
                case 8:
                    if(!dq.isEmpty()){
                        sb.append(dq.peekLast()+"\n");
                    } else sb.append("-1\n");
                    break;
            }

        }

        System.out.println(sb);
    }
}
