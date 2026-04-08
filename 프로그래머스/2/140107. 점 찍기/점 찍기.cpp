#include <cmath>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    long long limit = (long long)d * d;

    for (long long x = 0; x <= d; x += k) {

        long long maxY = floor(sqrt(limit - (x * x)));
        
        answer += (maxY / k) + 1;
    }

    return answer;
}