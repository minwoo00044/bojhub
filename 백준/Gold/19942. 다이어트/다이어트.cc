#include <iostream>
#include <vector>

using namespace std;

vector<int> req;
vector<int> cost;
vector<vector<int>> table;
vector<int> answer;
const int INF = 1e9;
int minCost = INF, n;

void dfs(int depth, int nutritions[], vector<int>& selected, int sum){
    if(sum > minCost) return;
    
    if(depth == n){
        for(int i=0;i<4;i++){
            if(nutritions[i] < req[i]) return;
        }
        // 2. 비용이 더 낮으면 무조건 갱신
        if (sum < minCost) {
            minCost = sum;
            answer = selected;
        } 
        // 3. 비용이 같다면 사전순으로 더 앞선 경우만 갱신
        else if (sum == minCost) {
            if (answer.empty() || selected < answer) {
                answer = selected;
            }
        }
        return;
    }
    for(int i=0;i<4;i++){
        nutritions[i] += table[depth][i];
    }
    selected.push_back(depth+1);
    dfs(depth+1, nutritions,selected ,sum+table[depth][4]);
    
    for(int i=0;i<4;i++){
        nutritions[i] -= table[depth][i];
    }
    selected.pop_back();
    
    dfs(depth+1, nutritions, selected, sum);

}

int main()
{
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    cin >> n;
    for(int i=0;i<4;i++){
        int inp;
        cin >> inp;
        req.push_back(inp);
    }
    table.assign(n,vector<int>(5,0));
    for(int i=0;i<n;i++){
        for(int j=0;j<5;j++){
            cin >> table[i][j];
        }
    }
    int arr[4] = {0,};
    vector<int> selected;
    dfs(0,arr, selected, 0);

    cout << ((minCost == INF) ? -1 : minCost) << "\n";
    for (int idx : answer) cout << idx << " ";

    return 0;
}