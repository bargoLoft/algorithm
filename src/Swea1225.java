import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//암호생성기
public class Swea1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int t=1;t<=10;t++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> d = new ArrayDeque<>();
            for(int i=0;i<8;i++){
                d.addLast(Integer.parseInt(st.nextToken()));
            }

            loop : while(true){
                for(int i=1;i<=5;i++){
                    int n = d.peekFirst();
                    if(n-i<1){
                        d.pop();
                        d.addLast(0);
                        break loop;
                    } else{
                        d.addLast(d.pollFirst()-i);
                    }
                }
            }

            System.out.printf("#%d ",t);
            for(int i : d){
                System.out.printf("%d ",i);
            }
            System.out.println();

        }

    }
}
