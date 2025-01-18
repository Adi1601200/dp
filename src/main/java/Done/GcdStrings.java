package Done;

public class GcdStrings {

    // https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75

    public String gcdOfStrings(String str1, String str2) {
        if(str1.isEmpty() && !str2.isEmpty()){
            return str2;
        }
        if(str2.isEmpty() && !str1.isEmpty()){
            return str1;
        }
        if(str1.length()<str2.length()){
            String sub = str2.substring(0,str1.length());
            if(sub.equals(str1)){
               return gcdOfStrings(str2.substring(str1.length()),str1);
            }else{
                return "";
            }
        }else{
            String sub = str1.substring(0,str2.length());
            if(sub.equals(str2)){
                return gcdOfStrings(str1.substring(str2.length()),str2);
            }else{
                return "";
            }
        }
    }
}
