package Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class LeetCode1431 {


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answers = new ArrayList<>();
        int maxNumber = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxNumber) {
                answers.add(Boolean.TRUE);
            } else {
                answers.add(Boolean.FALSE);
            }
        }
        return answers;
    }
}
