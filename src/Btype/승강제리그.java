package Btype;

import java.util.*;
import java.io.*;

// 각 리그의 최고, 중간, 최악의 선수를 골라내야한다.
// 최대 힙, 최소 힙 -> 최고, 최악만 뽑기 가능
// 상위권 최대, 최소 힙 / 하위권 최대, 최소 힙 -> 중간값 뽑기 가능!
// for문 순서대로 변경하면 이전 for문의 변경이 다음에 영향을 주므로 교환할 선수를 기억해두고 한 번에 교환.

class 승강제리그 {

    private static Scanner sc;
    private static UserSolution usersolution = new UserSolution();

    private final static int CMD_INIT = 100;
    private final static int CMD_MOVE = 200;
    private final static int CMD_TRADE = 300;

    private static boolean run() throws Exception {

        int query_num = sc.nextInt();
        int ans;
        boolean ok = false;

        for (int q = 0; q < query_num; q++) {
            int query = sc.nextInt();

            if (query == CMD_INIT) {
                int N = sc.nextInt();
                int L = sc.nextInt();
                int mAbility[] = new int[N];
                for (int i = 0; i < N; i++){
                    mAbility[i] = sc.nextInt();
                }
                usersolution.init(N, L, mAbility);
                ok = true;
            } else if (query == CMD_MOVE) {
                int ret = usersolution.move();
                ans = sc.nextInt();
                if (ans != ret) {
                    ok = false;
                }
            } else if (query == CMD_TRADE) {
                int ret = usersolution.trade();
                ans = sc.nextInt();
                if (ans != ret) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;

        System.setIn(new java.io.FileInputStream("/Users/bagchangjun/IdeaProjects/algorithm/src/Btype/sample_input.txt"));
        sc = new Scanner(System.in);
        T = sc.nextInt();
        MARK = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int score = run() ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }
        sc.close();
    }

    static class UserSolution {
        class Player implements Comparable<Player>{
            int id;
            int ability;

            public Player(int id, int ability){
                this.id = id;
                this.ability = ability;
            }

            @Override
            public int compareTo(Player player){
                if(this.ability == player.ability){
                    return -(this.id-player.id);
                }
                else return this.ability - player.ability;
            }
        }

        class League{
            PriorityQueue<Player> maxHeapUpper = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Player> minHeapUpper = new PriorityQueue<>();
            PriorityQueue<Player> maxHeapLower = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Player> minHeapLower = new PriorityQueue<>();

            public void addPlayer(Player player){
                if(minHeapUpper.isEmpty() || player.ability >= minHeapUpper.peek().ability){
                    maxHeapUpper.add(player);
                    minHeapUpper.add(player);
                } else {
                    maxHeapLower.add(player);
                    minHeapLower.add(player);
                }

                // 하위권이 더 많아지면 상위권으로 옮김
                while(maxHeapLower.size() > maxHeapUpper.size()){
                    Player toMove = maxHeapLower.poll();
                    minHeapLower.remove(toMove);
                    maxHeapUpper.add(toMove);
                    minHeapUpper.add(toMove);
                }

                // 상위권이 하위권과 2명 차이가 나면 하위권으로 옮김
                while(maxHeapUpper.size() > maxHeapLower.size()+1){
                    Player toMove = minHeapUpper.poll();
                    maxHeapUpper.remove(toMove);
                    maxHeapLower.add(toMove);
                    minHeapLower.add(toMove);
                }
            }

            public Player removeBestPlayer(){
                Player bestPlayer = maxHeapUpper.poll();
                minHeapUpper.remove(bestPlayer);
                return bestPlayer;
            }

            public Player removeWorstPlayer(){
                Player worstPlayer = minHeapLower.poll();
                maxHeapLower.remove(worstPlayer);
                return worstPlayer;
            }

            public Player removeMidPlayer(){
                Player midPlayer = minHeapUpper.poll();
                maxHeapUpper.remove(midPlayer);
                return midPlayer;
            }
        }

        League[] leagues;
        int leaguesLength;

        void init(int N, int L, int mAbility[]) {
            leagues = new League[L];
            leaguesLength = L;

            for(int i=0;i<L;i++){
                leagues[i] = new League();
            }

            for(int i=0; i<N;i++){
                int leagueIndex = i / (N / L);
                Player player = new Player(i, mAbility[i]);
                leagues[leagueIndex].addPlayer(player);
            }
        }

        int move() {
            ArrayList<Player> worstPlayers = new ArrayList<>();
            ArrayList<Player> bestPlayers = new ArrayList<>();
            int sumOfMovedPlayerIds = 0;

            // 먼저 교환할 선수들을 결정합니다.
            for (int i = 0; i < leaguesLength - 1; i++) {
                Player worstPlayerCurrent = leagues[i].removeWorstPlayer();
                Player bestPlayerNext = leagues[i + 1].removeBestPlayer();
                worstPlayers.add(worstPlayerCurrent);
                bestPlayers.add(bestPlayerNext);
            }

            // 결정된 선수들을 교환합니다.
            for (int i = 0; i < leaguesLength - 1; i++) {
                Player worstPlayerCurrent = worstPlayers.get(i);
                Player bestPlayerNext = bestPlayers.get(i);
                leagues[i].addPlayer(bestPlayerNext);
                leagues[i + 1].addPlayer(worstPlayerCurrent);
                sumOfMovedPlayerIds += bestPlayerNext.id;
                sumOfMovedPlayerIds += worstPlayerCurrent.id;
            }

            return sumOfMovedPlayerIds;
        }

        int trade() {
            ArrayList<Player> midPlayers = new ArrayList<>();
            ArrayList<Player> bestPlayers = new ArrayList<>();
            int sumOfMovedPlayerIds = 0;

            // 먼저 교환할 선수들을 결정합니다.
            for (int i = 0; i < leaguesLength - 1; i++) {
                Player midPlayerCurrent = leagues[i].removeMidPlayer();
                Player bestPlayerNext = leagues[i + 1].removeBestPlayer();
                midPlayers.add(midPlayerCurrent);
                bestPlayers.add(bestPlayerNext);
            }

            // 결정된 선수들을 교환합니다.
            for (int i = 0; i < leaguesLength - 1; i++) {
                Player midPlayerCurrent = midPlayers.get(i);
                Player bestPlayerNext = bestPlayers.get(i);
                leagues[i].addPlayer(bestPlayerNext);
                leagues[i + 1].addPlayer(midPlayerCurrent);
                sumOfMovedPlayerIds += bestPlayerNext.id;
                sumOfMovedPlayerIds += midPlayerCurrent.id;
            }

            return sumOfMovedPlayerIds;
        }
    }

}


