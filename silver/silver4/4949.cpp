#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    while(1) {
        stack<char>stk;
        string str;
        getline(cin,str);
        bool isvaild = true;
        if(str.length()==1 && str[0] == '.') break;
        for(auto c : str) {
            if(c== '(' || c == '[') stk.push(c);
            else if(c==')') {
                if(stk.empty() || stk.top() !='(') {
                    isvaild = false;
                    break;
                }
                stk.pop();
            }
            else if(c==']') {
                if(stk.empty() || stk.top() !='[') {
                    isvaild = false;
                    break;
                }
                stk.pop();
            }
        }
        if(!stk.empty()) {
            isvaild = false;
        }
        if(isvaild) cout << "yes\n";
        else cout << "no\n";
    }
    
}