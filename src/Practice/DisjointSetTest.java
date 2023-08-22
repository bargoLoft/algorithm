package Practice;

public class DisjointSetTest {

    static int N;
    static int parents[];
    private static void make(){
        parents = new int[N];
        for(int i=0;i<N;i++){
            parents[i] = i;
        }
    }

     private static int find(int a){
        if(a==parents[a]) return a;
        return find(parents[a]);
     }

     private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
     }


    public static void main(String[] args) {

    }
}
