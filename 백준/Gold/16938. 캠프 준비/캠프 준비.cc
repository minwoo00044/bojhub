#include <bits/stdc++.h>
using namespace std;

int n, l, r, x, answer;
int probs[16];

// cnt: 선택한 문제 수, sum: 난이도 합, mn: 최소 난이도, mx: 최대 난이도
void dfs(int depth, int cnt, int sum, int mn, int mx) {
    if (depth == n) {
        if (cnt >= 2 && sum >= l && sum <= r && (mx - mn) >= x) {
            answer++;
        }
        return;
    }

    // 1. 현재 문제를 선택하는 경우
    dfs(depth + 1, cnt + 1, sum + probs[depth], min(mn, probs[depth]), max(mx, probs[depth]));
    
    // 2. 현재 문제를 선택하지 않는 경우
    dfs(depth + 1, cnt, sum, mn, mx);
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); // 입출력 속도 향상
    
    cin >> n >> l >> r >> x;
    for (int i = 0; i < n; i++) cin >> probs[i];

    answer = 0;
    // 초기값: mn은 아주 크게, mx는 아주 작게 설정
    dfs(0, 0, 0, 1e9, 0);
    
    cout << answer;
    return 0;
}