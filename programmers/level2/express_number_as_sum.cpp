#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool func(int start, int n) {
    int sum = 0;
    while (true) {
        sum += start;
        start++;
        if (sum == n) {
            return true;
        } else if (sum > n) {
            return false;
        }
    }
}

int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n / 2; i++) {
        if (func(i, n)) {
            answer++;
        }
    }
    return answer + 1;
}