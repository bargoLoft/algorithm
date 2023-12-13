package Practice;

public class OOP {

    public class Robot{
        public int hp;

        public void move(){
            System.out.println("move!");
        };
        public void stop(){
            System.out.println("stop!!!!");
        };
    }


    public static class SpeedRobot {
        private int modelID;

        public void run(){
            System.out.println("run!");

        };
        public void work(){
            System.out.println("work!");
        };

    }
    public class PowerRobot{
        private int mana;

        public void attack(){

        };
        public void jump(){

        };

    }

    public static void main(String[] args) {
        SpeedRobot sr = new SpeedRobot();
    }
}
