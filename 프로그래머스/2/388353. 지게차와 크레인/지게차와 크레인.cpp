#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<vector<char>> board;
int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
int n,m;
int bfs(char target){
    queue<pair<int,int>> q;
    q.push({0,0});
    vector<vector<bool>> visited(n + 2, vector<bool>(m + 2, false));
    visited[0][0] = true;
    vector<pair<int,int>> marked;
    while(!q.empty()){
        pair<int,int> cur = q.front();
        q.pop();
        for(int d=0;d<4;d++){
            int nx = cur.first + dx[d];
            int ny = cur.second + dy[d];
            if(nx <0 || nx >n+1 || ny < 0 || ny >m+1 || visited[nx][ny]) continue;
            if(board[nx][ny] == 0){
                q.push({nx,ny});
                visited[nx][ny] = true;
            }
            else if(board[nx][ny] == target && !visited[nx][ny]){
                visited[nx][ny] = true;
                marked.push_back({nx,ny});
            }
        }
    }
    for(auto i : marked){
        board[i.first][i.second] = 0;
    }
    return marked.size();
}

int deleteAll(char target){
    int cnt = 0;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(board[i][j] == target){
                cnt++;
                board[i][j] = 0;
            }
        }
    }
    return cnt;
}
int solution(vector<string> storage, vector<string> requests) {
    n = storage.size();
    m = storage[0].size(); 
    int answer = n*m;
    board.assign(n+2,vector<char>(m+2,0));
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            board[i][j] = storage[i-1][j-1];
        }
    }
    for(string req : requests){
        if(req.length() == 1){
            answer -= (bfs(req[0]));
        } 
        else{
            answer -= deleteAll(req[0]);
        }
    }
    return answer;
}