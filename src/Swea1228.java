import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 1228. [S/W 문제해결 기본] 8일차 - 암호문1
public class Swea1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Deque<Integer> d = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                d.addLast(Integer.valueOf(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<command;i++){
                Deque<Integer> tmp = new ArrayDeque<>();
                st.nextToken(); // I 빼주기
                int start = Integer.parseInt(st.nextToken());
                int numCount = Integer.parseInt(st.nextToken());

                for(int j=0;j<start;j++){
                    tmp.addLast(d.pollFirst());
                }
                for(int j=0;j<numCount;j++){
                    tmp.addLast(Integer.parseInt(st.nextToken()));
                }
                while (!d.isEmpty()){
                    tmp.addLast(d.pollFirst());
                }
                d = tmp;
            }

            System.out.printf("#%d ",t);
            for(int i=0;i<10;i++){
                System.out.printf("%d ",d.pollFirst());
            }
            System.out.println();





        }

    }
}
