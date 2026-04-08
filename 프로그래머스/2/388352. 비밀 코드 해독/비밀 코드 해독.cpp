#include <string>
#include <vector>

using namespace std;
int N,M;
vector<int> req;
vector<int> resp;
int answer;
bool checkAll(int mask){
    for(int i=0;i<req.size();i++){
        int n = mask & req[i];
        int count = 0;
        while (n > 0) {
            n &= (n - 1); // 가장 오른쪽에 있는 1을 제거하는 마법의 식
            count++;
        }
        if(count != resp[i]) return false;
    }
    return true;
}

void backtrack(int idx, int count, int current_mask) {
    if (count == M) {
        // 모든 질문 조건(q, ans)에 부합하는지 최종 확인
        if (checkAll(current_mask)) answer++;
        return;
    }
    if (idx > N) return;

    // 1. 현재 숫자 idx를 포함하는 경우
    backtrack(idx + 1, count + 1, current_mask | (1 << idx));

    // 2. 현재 숫자 idx를 포함하지 않는 경우
    backtrack(idx + 1, count, current_mask);
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    answer = 0;
    N = n;
    M = q[0].size();
    for(auto query : q){
        int mask = 0;
        for(auto i : query){
            mask |= (1 << i);
        }
        req.push_back(mask);
    }
    resp = ans;
    backtrack(1,0,0);
    return answer;
}