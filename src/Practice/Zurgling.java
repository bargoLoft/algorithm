package Practice;

public class Zurgling {
    static class Zergling{
        int hp = 80;
        int mana = 200;

        void attack(){
            System.out.println("attack");
            hp++;
            mana-=10;
        };
        void move(){
            System.out.println("move");
            hp-=10;
            mana+=5;
        };
        void status(){
            System.out.println("hp = "+hp);
            System.out.println("mana = "+mana);
        }
    }
    public static void main(String[] args) {
        Zergling z = new Zergling();
        z.status();
        z.attack();
        z.status();
        z.move();
        z.status();
    }
}
