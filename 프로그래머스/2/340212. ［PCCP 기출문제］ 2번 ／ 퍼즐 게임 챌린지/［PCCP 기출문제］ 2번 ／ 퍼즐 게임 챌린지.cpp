#include <string>
#include <vector>

using namespace std;

long long calc(const vector<int>& diffs, const vector<int>& times, int level){
    long long ret = 0;
    int time_cur, time_prev = -1, diff;
    for(int i=0;i<diffs.size();i++){
        time_cur = times[i];
        diff = diffs[i];
        if(level >= diff){
            ret += time_cur;
        }
        else{
            if(i == 0){
                ret += (diff - level + 1)*time_cur;
            }
            else{
                ret += (diff - level)*(time_cur + time_prev) + time_cur;
            }
        }
        time_prev = time_cur;
    }
    
    return ret;
}

int solution(vector<int> diffs, vector<int> times, long long limit) {
    int left = 1;
    int right = 1;
    for(int diff : diffs){
        right = max(right,diff);
    }
    while(left <= right){
        int mid = (left + right) / 2;
        long long t = calc(diffs, times, mid);
        if(t <= limit){
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
    }
    
    return left;
}