import java.io.*;
import java.util.*;

public class Bj1781 {
    static class Problem implements Comparable<Problem>{
        int deadline;
        int cup;

        Problem(int deadline, int cup){
            this.deadline =deadline;
            this.cup = cup;
        }

        @Override
        public int compareTo(Problem problem){
            if(this.cup > problem.cup) return -1; // 컵라면이 많은 순서
            else if(this.cup < problem.cup) return 1; // 컵라면이 적은 순서
            else {
                if(this.deadline < problem.deadline) return -1; // 남은 시간이 적은 순서
                else if(this.deadline > problem.deadline) return 1; // 남은 시간이 많은 순서
                else return 0; // 컵라면 수와 남은 시간이 모두 같을 경우
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Problem> p = new PriorityQueue();

        //입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            p.offer(new Problem(deadline, cup));
        }

        int time = 1;
        int totalCup = 0;
        while(!p.isEmpty()){
            Problem cp = p.poll();
            // 시간 넘었으면 새로 뽑기
            if(cp.deadline < time) continue;
            //System.out.println(cp.deadline + " "+cp.cup);
            time++;
            totalCup+=cp.cup;
        }

        System.out.println(totalCup);



    }
}
