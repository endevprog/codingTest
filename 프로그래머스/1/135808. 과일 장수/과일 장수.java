import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();        
        for (int element : score) {
            list.add(element);    
        }
        
        list.sort(Comparator.reverseOrder());
        
        for(int i=0; i<list.size(); i=i+m) {
            if(i+m > list.size()) {
                break;
            }
            List<Integer> subList = list.subList(i,i+m);
            
            int sum = subList.get(m-1) * m;
            answer = answer + sum;
        }
        
        return answer;
    }
}