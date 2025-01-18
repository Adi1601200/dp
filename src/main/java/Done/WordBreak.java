package Done;

import java.util.List;

public class WordBreak {

    // https://leetcode.com/problems/word-break/description/?envType=problem-list-v2&envId=dynamic-programming

    public boolean wordBreak(String s, List<String> wordDict) {
       return findDic(0,s,wordDict);
    }

    private boolean findDic(int index, String s, List<String> wordDict) {

        if(index == s.length()){
            return true;
        }

        if(index > s.length()){
            return false;
        }

        boolean answer = false;
        for(int i=0;i<wordDict.size();i++) {
            if(matchWord(index,s,wordDict.get(i))){
                answer = findDic(index + wordDict.get(i).length(),s,wordDict);
            }
        }

        return answer;

    }

    private boolean matchWord(int index, String s, String dict) {
        boolean match = true;
        for (int i = 0; i < dict.length(); i++) {
            if (dict.charAt(i) != s.charAt(index)) {
                match = false;
                break;
            }
            index = index+1;
        }
        return match;
    }

}
