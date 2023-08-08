#include <iostream>
#include <stack>
#include <string>
using namespace  std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    string str;
    stack<char> stack;
    cin >> str;
    int count = 0;
    for(int i=0; i<str.size(); i++) {
        if(str[i] == '(') stack.push(str[i]);
        else if(str[i]==')' && str[i-1] == '(') { //레이저
            stack.pop();
            count += stack.size();
        }
        else {
            count++;
            stack.pop();
        }
    }
    cout << count;
}