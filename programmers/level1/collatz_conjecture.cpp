#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int num) {
    long long temp = num;
    long long cnt = 0;
    long long answer = 0;
    if(cnt == 0 && temp == 1) {
        answer = 0;
    }
    while(temp != 1) {
        if(cnt > 500) {
            return -1;
        }
        if(temp % 2) {
            cnt++;
            temp = temp*3+1;
        }
        else {
            cnt++;
            temp = temp / 2;
        }
    }
    return cnt;
}