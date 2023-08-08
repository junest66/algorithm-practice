#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    string answer = "";
    if(num % 2) { // 홀수
        answer = "Odd";
    }
    else { // 짝수
        answer = "Even";
    }
    return answer;
}