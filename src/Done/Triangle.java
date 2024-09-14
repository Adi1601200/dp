package Done;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

    private Map<String,Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        int rowSize = triangle.size();
        return calcMinSum(0,0,triangle,rowSize);
    }

    private int calcMinSum(int row, int col, List<List<Integer>> triangle, int rowSize) {
        if(row>rowSize-1){
            return 0;
        }
        if(col>triangle.get(row).size()-1){
            return 0;
        }
        String key = row + "|" + col;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int sum  = triangle.get(row).get(col) + Math.min(calcMinSum(row+1,col,triangle, rowSize),calcMinSum(row+1,col+1,triangle, rowSize));
        map.put(key,sum);
        return map.get(key);
    }
}
