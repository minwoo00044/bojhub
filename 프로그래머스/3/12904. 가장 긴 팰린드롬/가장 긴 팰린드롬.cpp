#include <bits/stdc++.h>
using namespace std;

// 중심을 기준으로 양옆으로 확장하며 팰린드롬 길이를 찾는 함수
int expandAroundCenter(const string& s, int left, int right) {
    while (left >= 0 && right < s.length() && s[left] == s[right]) {
        left--;
        right++;
    }
    // 루프를 빠져나왔을 때는 이미 팰린드롬 조건이 깨진 상태이므로
    // 실제 팰린드롬 길이는 (right - 1) - (left + 1) + 1 = right - left - 1
    return right - left - 1;
}

int solution(string s) {
    int max_len = 0;
    
    for (int i = 0; i < s.length(); i++) {
        // 1. 홀수 길이 팰린드롬 탐색 (i가 중심)
        int len1 = expandAroundCenter(s, i, i);
        
        // 2. 짝수 길이 팰린드롬 탐색 (i와 i+1 사이가 중심)
        int len2 = expandAroundCenter(s, i, i + 1);
        
        // 둘 중 가장 긴 값을 갱신
        max_len = max({max_len, len1, len2});
    }
    
    return max_len;
}