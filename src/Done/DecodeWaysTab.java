package Done;

public class DecodeWaysTab {
    public int numDecodings(String s) {
        int len = s.length();
        int[] a = new int[len];
        if(s.charAt(len-1) == '0'){
            a[len-1] = 0;
        }else{
            a[len-1] = 1;
        }

        for(int i = len-2;i>=0;i--){
            a[i] = a[i+1] + calValidString(s.charAt(i),s.charAt(i+1));
        }

        return a[0];

    }

    private int calValidString(char c, char c1) {
        if(c == '0'){
            return 0;
        }else if(((c - '0')*10) + (c1 - '0') >26){
            return 0;
        }
        return 1;
    }
}
