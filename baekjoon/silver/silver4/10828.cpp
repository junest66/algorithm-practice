#include <iostream>
#include <stack>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    stack<int> stack;
    cin >> n;
    while(n--) {
        string n;
        cin >> n;
        if(n=="push") {
            int a;
            cin >> a;
            stack.push(a);
        } 
        else if(n == "pop") {
            if(stack.empty()) cout << -1 << '\n';
            else {
                cout<< stack.top() << '\n';
                stack.pop();
            } 
        }
        else if(n == "size") cout<< stack.size() << '\n';
        else if(n == "empty") {
            if(stack.empty()) cout << 1 << '\n';
            else cout << 0 << '\n';
        }
        else if(n == "top") {
            if(stack.empty()) cout << -1 << '\n';
            else cout<< stack.top() << '\n';
        }
    }
    return 0;
}