#include <iostream>
#include <stack>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    int sum = 0;
    stack<int> stack;
    cin >> n;
    while(n--) {
        int a;
        cin >> a;
        if(a==0) {
            sum -= stack.top();
            stack.pop();
        }
        else  {
            sum += a;
            stack.push(a);
        }
    }
    cout << sum;
    return 0;
}