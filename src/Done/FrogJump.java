package Done;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    Map<String,Boolean> map = new HashMap<>();

    public boolean canCross(int[] stones) {
        return frogJump(1,0,1,stones);
    }

    private boolean frogJump(int index, int lastIndex,int lastJump, int[] stones) {
        if(index == stones.length-1){
            int currentJump = stones[index] - stones[lastIndex];
            return lastJump == currentJump;
        }
        if(map.containsKey(index + "|" + lastIndex + "|" + lastJump)){
            return map.get(index + "|" + lastIndex + "|" + lastJump);
        }
        if(lastJump<=0){
            map.put(index + "|" + lastIndex + "|" + lastJump , false);
            return false;
        }
        int currentJump = stones[index] - stones[lastIndex];
        if(lastJump<currentJump){
            map.put(index + "|" + lastIndex + "|" + lastJump , false);
            return false;
        } else if (lastJump>currentJump) {
            boolean answer = frogJump(index+1,lastIndex,lastJump,stones);
            map.put(index + "|" + lastIndex + "|" + lastJump , answer);
            return answer;
        }
        boolean answer = frogJump(index+1 ,index,currentJump-1,stones)
                || frogJump(index+1,index,currentJump,stones)
                || frogJump(index+1,index,currentJump+1,stones);
        map.put(index + "|" + lastIndex + "|" + lastJump , answer);
        return answer;
    }
}
