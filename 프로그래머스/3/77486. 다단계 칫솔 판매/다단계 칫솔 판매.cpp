#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<string,string> parent;
unordered_map<string,int> idx;

vector<int> answer;

void dfs(string s, int profit){
    int payment = profit/10;
    answer[idx[s]] += profit - payment;
    if(parent.find(s) != parent.end() && payment > 0){
        dfs(parent[s],payment);
    }
}
vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    int n = enroll.size();
    answer.resize(n,0);
    for(int i=0;i<n;i++){
        idx[enroll[i]] = i;
        if(referral[i] == "-") continue;
        parent[enroll[i]] = referral[i];
    }
    int m = seller.size();
    for(int i=0;i<m;i++){
        string s = seller[i];
        dfs(s,amount[i]*100);
    }
    return answer;
}