#include <iostream>
#include <stack>
#include <string>

using namespace std;

stack<char> stk;

bool solution(string s) {
    bool answer = true;

    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            stk.push(s[i]);
        } else {
            if (stk.empty()) {
                answer = false;
                break;
            } else {
                stk.pop();
            }
        }
    }
    if (!stk.empty()) {
        answer = false;
    }

    return answer;
}