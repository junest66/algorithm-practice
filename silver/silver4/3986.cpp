#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    int ans = 0;
    cin >> n;
    while(n--) {
        string str;
        stack<char> stack;
        cin >> str;
        for(auto c : str) {
            if(!stack.empty() && stack.top() == c) stack.pop();
            else stack.push(c);
        }
        if(stack.empty()) ans++;
    }
    cout << ans;

}