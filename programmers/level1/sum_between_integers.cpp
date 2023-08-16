#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    if(a==b) {
        return a;
    }
    int minNumber = 0;
    int maxNumber = 0;
    if(a>b) {
        maxNumber = a;
        minNumber = b;
    }
    else {
        maxNumber = b;
        minNumber = a;
    }
    for(int i=minNumber; i<=maxNumber; i++) {
        answer += i;
    }
    
    return answer;
}