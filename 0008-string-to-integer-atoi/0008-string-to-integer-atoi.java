class Solution {
    public int myAtoi(String s) {
        int r=0;
        while(r<s.length() && s.charAt(r)==' '){
            r++;
        }
        int sign=1;
        if(r<s.length() && (s.charAt(r)=='+'|| s.charAt(r)=='-')){
            if(s.charAt(r)=='-'){
                sign=-1;
            }
            r++;
        }
        if(r>=s.length() || !Character.isDigit(s.charAt(r))){
            return 0;
        }
        long result=0;
        while(r<s.length() && Character.isDigit(s.charAt(r))){
            result=result*10+(s.charAt(r)-'0');
            if(sign * result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            r++;
        }
        return (int)(sign*result);
    }
}