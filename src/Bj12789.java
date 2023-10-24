import java.io.*;
import java.util.*;

public class Bj12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> line = new ArrayDeque();
        Stack<Integer> waiting = new Stack();

        for(int i=0;i<N;i++){
            line.addLast(Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        while(!line.isEmpty()){
            int n = line.pop();

            if(n==idx){
                idx++;
                continue;
            }
            while(!waiting.isEmpty()&&waiting.peek()==idx){
                waiting.pop();
                idx++;
            }

            waiting.add(n);
        }

        while(!waiting.isEmpty() && waiting.peek()==idx){
            waiting.pop();
            idx++;
        }

        if(waiting.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
