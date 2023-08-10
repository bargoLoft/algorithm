import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Swea4012 {
    static int N;
    static int[][] food;
    static int[] foodBasket;
    static int[] isSelected;
    static int min;

    // 시너지 합 구해주는 함수
    static int permSum(int[] arr){
        int size = arr.length;
        int sum = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j)
                    continue;
                sum+=food[arr[i]][arr[j]];
            }
        }
        return sum;
    }

    static void permutation(int dep){
        if(dep == N / 2 ){
            // 차 집합으로 B를 구하기 위해 ArrayList 생성
            ArrayList<Integer> foodBasketA = new ArrayList();
            ArrayList<Integer> foodBasketB = new ArrayList();
            for(int n:foodBasket){
                foodBasketA.add(n);
            }

            for(int i=0;i<N;i++){
                foodBasketB.add(i);
            }

            // 차 집 합
            foodBasketB.removeAll(foodBasketA);

            // 다시 배열로 돌리기.
            int[] tmp = new int[foodBasketB.size()];
            for (int i = 0 ; i < foodBasketB.size() ; i++)
                tmp[i] = foodBasketB.get(i).intValue();

            // A,B 시너지 합 계산
            int foodA = permSum(foodBasket);
            int foodB = permSum(tmp);

            // 차이가 최소일 시 최소에 저장.
            int dif = Math.abs(foodA-foodB);
            if(dif<min)
                min = dif;

            return;
        }

        for(int i=0;i<N;i++){
            // 순열 조건
            if(dep!=0 && i<=foodBasket[dep-1])
                continue;
            // 1이 들어갈때 와 들어가지 않을 때로 나눴을 때 반만 구해주면 된다.
            if(foodBasket[0] == 1)
                break;

            isSelected[i] = 1;
            foodBasket[dep] = i;
            permutation(dep+1);
            isSelected[i] = 0;

        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            food = new int[N][N];
            foodBasket = new int[N/2];
            isSelected = new int[N];
            min = Integer.MAX_VALUE;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            permutation(0);

            System.out.printf("#%d %d\n",t,min);
        }
    }
}
