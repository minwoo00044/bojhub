#include <bits/stdc++.h>

using namespace std;


long long get_gcd(long long a, long long b) {
    while (b != 0) {
        a %= b;
        swap(a, b);
    }
    return a;
}

long long solution(int w, int h) {
    long long W = w;
    long long H = h;
    
    return (W * H) - (W + H - get_gcd(W, H));
}