import java.io.*;
import java.util.*;

public class Bj28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack s = new Stack();

        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command){
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    s.add(num);
                    break;
                case 2:
                    if(!s.isEmpty()) sb.append(s.pop()+"\n");
                    else sb.append("-1\n");
                    break;
                case 3:
                    sb.append(s.size()+"\n");
                    break;
                case 4:
                    if(s.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case 5:
                    if (!s.isEmpty()) sb.append(s.peek()+"\n");
                    else sb.append(-1+"\n");
                    break;
            }
        }

        System.out.println(sb);

    }
}
