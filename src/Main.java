import Done.*;

public class Main {
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        int ans = ed.minDistance("teacher","teacherly");
        System.out.println("Answer = " + ans);
    }
}