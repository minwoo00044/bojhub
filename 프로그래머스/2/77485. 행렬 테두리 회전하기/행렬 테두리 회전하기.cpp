#include <bits/stdc++.h>

using namespace std;

int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};

int rotate(vector<vector<int>>& board, int x1, int y1, int x2, int y2) {
    int x = x1;
    int y = y1;
    
    // 시작점의 값을 쥐고 출발합니다.
    int prev_val = board[x][y];
    int min_val = prev_val;
    int dir = 0;
    
    while (dir < 4) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        // 다음 칸이 테두리 범위 안이라면 값을 교환하고 이동합니다.
        if (nx >= x1 && nx <= x2 && ny >= y1 && ny <= y2) {
            int temp = board[nx][ny];
            board[nx][ny] = prev_val;
            prev_val = temp;
            
            // 들고 있는 값 중 최솟값을 계속 갱신합니다.
            min_val = min(min_val, prev_val);
            
            x = nx;
            y = ny;
        } else {
            // 범위를 벗어나면 모서리에 도달한 것이므로 방향을 꺾습니다.
            dir++;
        }
    }
    
    return min_val + 1;
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    vector<vector<int>> board(rows,vector<int>(columns,0));
    for(int i=0;i<rows;i++){
        for(int j=0;j<columns; j++){
            board[i][j] = i*columns + j;
        }
    }
    for(int i=0;i<queries.size();i++){
        int x1 = queries[i][0]-1;
        int y1 = queries[i][1]-1;
        int x2 = queries[i][2]-1;
        int y2 = queries[i][3]-1;
        
        answer.push_back(rotate(board,x1,y1,x2,y2));
        
    }
    return answer;
}