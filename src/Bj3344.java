import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj3344 {
    static int N;
    static int cnt;
    static int[] isUsed;
    static int[] plus;
    static int[] minus;
    static int[] queen;
    static StringBuilder sb = new StringBuilder();
    static boolean np(int[] p){
        int N = p.length;
        int i = N-1;
        // 맨 뒤부터 꼭대기 찾기
        while(i>0 && p[i-1]>=p[i]) --i;

        if(i==0) return false; // 다음 순열이 없음. 가장 큰 순열

        //꼭대기 직전 위치에서 교환할 한 단계 큰 수 뒤쪽에서 부터 찾기
        int j = N-1;
        while(p[i-1]>= p[j]) --j;

        // 꼭대기 직전 수와 한 단계 큰 수 교환
        swap(p,i-1,j);

        // 꼭대기 부터 맨 뒤까지 교환.
        int k = N-1;
        while(i<k){
            swap(p,i++,k--);
        }
        return true;
    }

    static void swap(int[] p,int a,int b){
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cnt = 0;
        queen = new int[N];
        isUsed = new int[N];
        plus = new int[2*N-1];
        minus = new int[2*N-1];

        int[] place = new int [N];
        for(int i=0;i<N;i++){
            if(i<N/2)
                place[i]=i*2;

            else{
                place[i]=(i-N/2)*2+1;
            }
        }

        while(np(place)){
            int isAvailable = 1;
            int[] plus = new int[2*N-1];
            int[] minus = new int[2*N-1];

            for(int i=0;i<N;i++){
                if(plus[i+place[i]]==1 || minus[i-place[i]+(N-1)]==1){
                    isAvailable = 0;
                    break;
                }
                plus[i+place[i]] = 1;
                minus[i-place[i]+(N-1)] = 1;
            }
            if(isAvailable == 1){
                break;
            }

        }
        for(int n:place){
            System.out.println(n);
        }

//        nQueen(0);

//        System.out.println(sb);
    }

}
