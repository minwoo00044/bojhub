#include <bits/stdc++.h>

using namespace std;
int probs[16];
int n,l,r,x, answer;
vector<int> selected;
void dfs(int depth){
    if(depth == n){
        if(selected.size() <= 1) return;
        int sum = 0, min_ = 1e9, max_ = 0;
        for(int s : selected){
            sum += probs[s];
            min_ = min(min_, probs[s]);
            max_ = max(max_, probs[s]);
        }
        if(sum >= l && sum <= r && abs(max_-min_) >= x){
            answer++;
        }
        return;
    }
    selected.push_back(depth);
    dfs(depth+1);
    selected.pop_back();
    dfs(depth+1);
}

int main()
{
    cin >> n >> l >> r >> x;
    
    for(int i=0;i<n;i++){
        cin >> probs[i];
    }
    answer = 0;
    dfs(0);
    cout << answer;
    return 0;
}