#include <iostream>
#include <cmath>
using namespace std;

int func(int n, int r, int c) {
    if(n==0) return 0;
    int half = pow(2,n-1);
    if(r<half && c < half) return func(n-1,r,c);
    else if(r < half && c >= half) return half*half + func(n-1, r, c-half);
    else if(r >= half && c < half) return half*half *2 +func(n-1,r-half,c);
    return half*half * 3 +func(n-1, r-half, c-half);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, r, c;
    cin >> n >> r >> c;
    cout << func(n,r,c);
}