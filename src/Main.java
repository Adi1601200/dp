import Done.*;



public class Main {
    public static void main(String[] args) {
        FrogJump frog = new FrogJump();
        int[] stones = {0,1,2,3,4,8,9,11};
        boolean ans = frog.canCross(stones);
        System.out.println("Answer = " + ans);
    }
}