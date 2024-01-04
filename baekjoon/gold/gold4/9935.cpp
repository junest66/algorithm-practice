#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<char> stk;
string str, bomb;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> str >> bomb;
    for (char x : str) {
        stk.push(x);
        if (bomb.back() == x) {  // 폭발 문자열의 끝과 일치하다면
            string temp = "";
            for (int i = 0; i < bomb.size(); i++) {
                if (stk.empty()) {
                    break;
                } else {
                    char a = stk.top();
                    stk.pop();
                    temp.push_back(a);
                }
            }
            reverse(temp.begin(), temp.end());
            if (temp != bomb) {
                for (int i = 0; i < temp.size(); i++) {
                    stk.push(temp[i]);
                }
            }
        }
    }
    string answer = "";
    while (!stk.empty()) {
        answer.push_back(stk.top());
        stk.pop();
    }
    if (answer == "") {
        cout << "FRULA";
    } else {
        reverse(answer.begin(), answer.end());
        cout << answer;
    }
    return 0;
}