import java.util.*;

class Solution {
    
    static char[][] graph;
    
    public Integer[] solution(String[] maps) {
        
        List<Integer> answer = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        graph = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            graph[i] = maps[i].toCharArray();
        }
        
        // maps 2차원배열로 변환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 'X') {
                    int sum = bfs(i, j);
                    answer.add(sum);
                }
            }
        }
        
        if (answer.isEmpty()) {
            return new Integer[]{-1};
        }

        Collections.sort(answer);
        return answer.toArray(new Integer[0]);
    }
    
    static int bfs(int row, int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        int sum = 0;
        
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            
            if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length) continue;
            if (graph[x][y] == 'X') continue;
            
            sum += graph[x][y] - '0';
            graph[x][y] = 'X';
            
            for (int i = 0; i < 4; i++) {
                q.offer(new int[]{x + dx[i], y + dy[i]});
            }
        }
        return sum;
    }
}