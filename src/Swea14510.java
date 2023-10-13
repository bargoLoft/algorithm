import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea14510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] tree = new int[N];
            int max = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                tree[i] = Integer.parseInt(st.nextToken());
                if(tree[i]>max) max = tree[i];
            }
            int day = 0;

            for(int i=0;i<N;i++){
                tree[i] = max - tree[i];
                while(tree[i] >= 3){
                    tree[i] -= 3;
                    day+=2;
                }
            }

            int one = 0;
            int two = 0;

            for(int i=0;i<N;i++){
                if(tree[i]==1) one++;
                else if(tree[i]==2) two++;
            }

            while(one>0 && two > 0){
                one--;
                two--;
                day+=2;
            }

            if(one > 0){
                day+= one * 2 - 1;
            } else if(two > 0){
                while(two >= 3){
                    two -=3;
                    day +=4;
                }
                if(two==1) day+=2;
                else if(two==2) day+=3;
            }

            System.out.printf("#%d %d\n",t,day);
        }
    }
}
