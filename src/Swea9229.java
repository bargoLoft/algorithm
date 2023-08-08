import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//9229. 한빈이와 Spot Mart D3
public class Swea9229 {
    static int N;
    static int M;
    static int max;
    static int[] snacks;

    static void whatSnackDoYouLike(int dep,int[] select, int start){

        if(dep == 2){
            // 종료
            int weight = snacks[select[0]]+snacks[select[1]];
            if(weight>max&&weight<=M)
                max = weight;
            return;
        }

        // 조합
        for(int i=start;i<N;i++){
                select[dep] = i;
                whatSnackDoYouLike(dep+1,select,i+1);
            }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            // max 초기화
            max = -1;

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            snacks = new int[N]; // 과자들 무게
            int[] select = new int[2]; // 선택한 과자
            st = new StringTokenizer(br.readLine());

            for(int i=0;i<N;i++){
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            whatSnackDoYouLike(0,select,0);
            System.out.printf("#%d %d\n",t,max);
        }
    }
}
