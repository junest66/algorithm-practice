#include <string>
#include <vector>
#include <iostream>

using namespace std;

int arr[2001][2001];

int combination(int n, int r)
{
    if(arr[n][r] == 0) {
        if(n == r || r == 0) {
            arr[n][r] = 1;
        }
        else {
            arr[n][r] = combination(n - 1, r - 1)%1234567 + combination(n - 1, r)%1234567;
        }
    }
    
    return arr[n][r];
}

long long solution(int n) {
    long long answer = 0;
    int twoNum = 0;
    while(1) {
        if(twoNum*2 <= n) {
            answer = (answer + combination(n-twoNum,twoNum))%1234567;
            twoNum++;
        }
        else {
            break;
        }
    }
    return answer;
}