#include <bits/stdc++.h>

using namespace std;

struct node{
    int x,y,cost,d;
    
    bool operator<(const node& other) const {
        return cost > other.cost;
    }
};
int dx[] ={0,1,0,-1}, dy[] = {1,0,-1,0};

int solution(vector<vector<int>> board) {
    priority_queue<node> pq;
    int n = board.size();
    pq.push({0,0,0,-1});
    vector<vector<vector<int>>> dist(n, vector<vector<int>>(n, vector<int>(4, 1e9)));
    
    for(int i = 0; i < 4; i++) dist[0][0][i] = 0;
    
    
    while(!pq.empty()){
        node cur = pq.top();
        pq.pop();
        if(cur.x == n-1 && cur.y == n-1){
            return cur.cost;
        }
        
        if(dist[cur.x][cur.y][cur.d] < cur.cost) continue;
        
        for(int d = 0;d<4;d++){
            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];
            int ncost;
            if(cur.d == -1 || cur.d == d){
                ncost = cur.cost + 100;
            }
            else{
                ncost = cur.cost + 600;
            }
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || dist[nx][ny][d] <= ncost || board[nx][ny] == 1) continue;
            dist[nx][ny][d] = ncost;
            pq.push({nx,ny,ncost,d});
        }
    }
    return -1;
}