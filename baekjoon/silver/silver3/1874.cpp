#include <iostream>
#include <stack>
#include <string>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int m=1;
    int n;
    stack<int> stack;
    string str;
    cin >> n;
    while(n--) {
        int k;
        cin >> k;
        while(m<=k) {
            stack.push(m++);
            str+="+\n";
        }
        if(stack.top() != k) {
            cout << "NO\n";
            return 0;
        }
        stack.pop();
        str+="-\n";
    }
    cout << str;
    return 0;
}