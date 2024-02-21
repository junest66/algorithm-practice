#include <iostream>
#include<string>
#include <stack>
using namespace std;

stack<int> stk;

int solution(string s)
{
    int answer = 0;
    
    for(auto x: s) {
        if(!stk.empty() && stk.top() == x) {
            stk.pop();
        } else {
            stk.push(x);
        }
    }
    if(stk.empty()) {
        answer = 1;
    }

    return answer;
}