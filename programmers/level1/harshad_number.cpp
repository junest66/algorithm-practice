#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(int x) {
    bool answer = true;
    int sum = 0;
    int n = x;
    while(n>0) {
        sum += (n%10);
        n /= 10;
    }
    if(x % sum == 0) {
        answer = true;
    }
    else {
        answer = false;
    }
    return answer;
}