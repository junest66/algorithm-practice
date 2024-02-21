#include <string>
#include <vector>

using namespace std;

int binNumberOneCount(int n) {
    int count = 0;
    while(n != 0) {
        if(n % 2) {
            count++;
        }
        n /= 2;
    }
    return count;
}

int solution(int n) {
    int answer = 0;
    int a = binNumberOneCount(n);
    for(int i = n+1; ; i++) {
        if(binNumberOneCount(i) == a) {
            answer = i;
            break;
        }
    }
    return answer;
}