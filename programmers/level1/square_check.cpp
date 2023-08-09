#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    // long long answer = 0;
    // double s = sqrt(n);
    // int a = (int)s;
    // if(s/a == 1) {
    //     return (s+1) * (s+1);
    // }
    // else {
    //     return -1;
    // }
    for(long long i = 1; i*i<=n; i++) {
        if(i * i == n) {
            return (i+1)*(i+1);
        }
    }
    return -1;
    
}