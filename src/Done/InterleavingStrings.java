package Done;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Long> map = new HashMap<>();
        long ans = interleave(s1,s2,s3,0,0,0,map);
        return ans != 0;
    }

    private long interleave(String s1, String s2, String s3, int currOne, int currTwo, int match, Map<String, Long> map) {

        if(match>s3.length()-1){
            if(currOne>s1.length()-1 && currTwo>s2.length()-1){
                map.put(currOne + "|" + currTwo + "|" + match, 1L);
                return 1;
            }else {
                return 0;
            }
        }
//        if(currOne>s1.length()-1 || currTwo>s2.length()-1){
//            return 0;
//        }
        if(map.containsKey(currOne + "|" + currTwo + "|" + match)){
            return map.get(currOne + "|" + currTwo + "|" + match);
        }
        if(!checkChar(s1,s3,currOne,match) && !checkChar(s2,s3,currTwo,match)){
            map.put(currOne + "|" + currTwo + "|" + match,0L);
            return 0;
        } else if (checkChar(s1,s3,currOne,match) && checkChar(s2,s3,currTwo,match)) {
            long ans = interleave(s1,s2,s3,currOne+1,currTwo,match+1, map)
                    + interleave(s1,s2,s3,currOne,currTwo+1,match+1, map);
            map.put(currOne + "|" + currTwo + "|" + match,ans);
            return ans;
        } else if (checkChar(s1,s3,currOne,match)) {
            long ans = interleave(s1,s2,s3,currOne+1,currTwo,match+1, map);
            map.put(currOne + "|" + currTwo + "|" + match,ans);
            return ans;
        } else if (checkChar(s2,s3,currTwo,match)) {
            long ans = interleave(s1,s2,s3,currOne,currTwo+1,match+1, map);
            map.put(currOne + "|" + currTwo + "|" + match,ans);
            return ans;
        }
        return 0;
    }

    private boolean checkChar(String t1,String t2,int one,int two){
        if(one>t1.length()-1){
            return false;
        }
        return t1.charAt(one) == t2.charAt(two);
    }
}
