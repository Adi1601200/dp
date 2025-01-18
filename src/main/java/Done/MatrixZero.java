package Done;

import java.util.ArrayList;
import java.util.List;

public class MatrixZero {
    // https://leetcode.com/problems/set-matrix-zeroes/description/



    public void setZeroes(int[][] matrix) {

        List<String> map = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == 0){
                    map.add("R" + i);
                    map.add("C" + j);
                }
            }
        }

        map.forEach(f -> {
            if(f.charAt(0) == 'R'){
                setRow(matrix, (int) f.charAt(1),0);
            }
        });

    }

    public static void setRow(int[][] matrix, int rowIndex, int value) {
        if (rowIndex >= 0 && rowIndex < matrix.length) {
            for (int col = 0; col < matrix[rowIndex].length; col++) {
                matrix[rowIndex][col] = value;
            }
        }
    }
}
