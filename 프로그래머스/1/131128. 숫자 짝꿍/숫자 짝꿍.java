class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0']++;
        }
        
        for (int j = 0; j < Y.length(); j++) {
            yCount[Y.charAt(j) - '0']++;
        }
        
        int sum = 0;
        int sumExZero = 0;
        int xSum = 0;
        int ySum = 0;
        for(int k=0; k<10; k++) {
            sum = sum + Math.abs(xCount[k]-yCount[k]);
            xSum = xSum + xCount[k];
            ySum = ySum + yCount[k];
            if(k!=0){
                sumExZero = sumExZero + Math.abs(xCount[k]-yCount[k]); 
            }
        }
        
        if(sum == xSum+ySum) {
            return "-1";
        }
        if(sumExZero == xSum-xCount[0]+ySum-yCount[0] && xCount[0] > 0 && yCount[0] > 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int m=9; m>=0; m--) {
            int min = Math.min(yCount[m],xCount[m]);
            
            if(min>0) {
                sb.append(String.valueOf(m).repeat(min));
            }
        }
        return sb.toString();
    }
}