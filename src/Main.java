import Done.ClimbingStairs;
import Done.DecodeWaysTab;
import Done.InterleavingStrings;
import Done.UniqueBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        InterleavingStrings intl = new InterleavingStrings();
        System.out.println(intl.isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
                "abababababababababababababababababababababababababababababababababababababababababababababababababab",
                "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"));

        System.out.println(intl.isInterleave(
                "aab",
                "axy",
                "aaxaby"
        ));
    }
}