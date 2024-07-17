package global.trend;
/////////////////// Question 10 ////////////////////
public class isPalindromeString {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        int n=sb.length();
        //if(n==1) return false;
        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i)!=sb.charAt(n-i-1)) return false;
        }
        System.out.println(sb.toString());
        return true;
    }

}
