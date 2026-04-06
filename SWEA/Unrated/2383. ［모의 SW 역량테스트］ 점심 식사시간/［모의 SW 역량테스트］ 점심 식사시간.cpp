#include <bits/stdc++.h>

using namespace std;

struct Stair {
    int r, c, length;
};

vector<pair<int,int>> person;
vector<Stair> stairs;
int ans;
int INF = 1e9;


int completeTime(vector<int>& arrive, int k){
    if (arrive.empty()) return 0;
    
    vector<int> finish_times(arrive.size());
    
    for (int i = 0; i < arrive.size(); i++) {
        if (i < 3) {
            finish_times[i] = arrive[i] + 1 + k;
        } else {
            int enter_time = max(arrive[i] + 1, finish_times[i - 3]);
            finish_times[i] = enter_time + k;
        }
    }
    return finish_times.back();
}

int simulate(vector<int>& selected) {
    vector<int> arrive0, arrive1;
    
    for (int i = 0; i < person.size(); i++) {
        int stair_idx = selected[i];
        int dist = abs(person[i].first - stairs[stair_idx].r) + abs(person[i].second - stairs[stair_idx].c);
        
        if (stair_idx == 0) {
            arrive0.push_back(dist);
        } else {
            arrive1.push_back(dist);
        }
    }
    
    sort(arrive0.begin(), arrive0.end());
    sort(arrive1.begin(), arrive1.end());
    
    return max(completeTime(arrive0, stairs[0].length), completeTime(arrive1, stairs[1].length));
}

void dfs(int depth, vector<int>& selected) {
    // 종료 조건: 모든 사람의 계단 배정이 끝났을 때
    if (depth == person.size()) {
        ans = min(ans,simulate(selected));
        return;
    }

    selected[depth] = 0;
    dfs(depth + 1, selected);

    selected[depth] = 1;
    dfs(depth + 1, selected);
}

int main(int argc, char** argv) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int T;
    cin >> T;

    for(int test_case = 1; test_case <= T; ++test_case) {
        person.clear();
        stairs.clear();
        
        int n;
        cin >> n;
        ans = INF;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int inp;
                cin >> inp;
                
                if(inp == 1) {
                    person.push_back({i, j});
                }
                else if(inp >= 2) {
                    stairs.push_back({i, j, inp});
                }
            }
        }
        
        vector<int> selected(person.size(), 0); 
        
        dfs(0, selected);
        
        cout << "#" << test_case << " " << ans << "\n";
    }
    return 0;
}