import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 4008. [모의 SW 역량테스트] 숫자 만들기
public class Swea4008 {

    static int max = -100_000_000;
    static int min = -100_000_000;

    static void cal(int dep, int N, int[] num, int[] arr,int[] operator, int[] usedOperator){
        if(dep == N-1){
            //종료.
            int cal = num[0];
            for(int i=0;i<N-1;i++){
                switch (arr[i]){
                    case 0:
                        cal+=num[i+1];
                        break;
                    case 1:
                        cal-=num[i+1];
                        break;
                    case 2:
                        cal*=num[i+1];
                        break;
                    case 3:
                        cal/=num[i+1];
                        break;
                }
            }
            for(int i: arr){
                System.out.print(i+" ");
            }
            System.out.println();
            if(cal>max) max = cal;
            if(cal<min) min = cal;

            return;
        }

        for(int i=0;i<4;i++){
            if(usedOperator[i]<operator[i]){
                usedOperator[i]++;
                arr[dep] = i;
                cal(dep+1,N,num,arr,operator,usedOperator);
                usedOperator[i]--;
            }
        }
    }
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            max = -100_000_000;
            min = 100_000_000;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] num = new int[N];
            int[] arr = new int[N-1];
            int[] operator = new int[4];
            int[] usedOperator = new int[4];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            cal(0,N,num,arr,operator,usedOperator);
            System.out.printf("#%d %d\n",t,max-min);
        }
    }
}
