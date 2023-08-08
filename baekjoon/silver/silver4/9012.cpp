#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    cin >> n;
    while(n--) {
        string str;
        stack<char> stack;
        cin >> str;
        bool invaild = true;
        for(auto c : str) {
            if(c == '(') stack.push(c);
            else if(c==')') {
                if(stack.empty() || stack.top() != '(') {
                    invaild = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.empty()) invaild = false;
        if(invaild) cout<< "YES\n";
        else cout << "NO\n";
    }
}