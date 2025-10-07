class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int a=0; a*k<=d; a++) {
            long maxB = (long) Math.sqrt((long)d*d - (long)(a*k)*(a*k)) / k ;
            answer = answer + (maxB +1);
        }
        
        return answer;
    }
}