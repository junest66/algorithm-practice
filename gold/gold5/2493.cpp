#include <iostream>
#include <stack>
#include <utility>
using namespace std;

stack<pair<int,int>> stk;
int n;

int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(0);
    cin >> n;
    stk.push({100000001,0});
    for(int i=1; i<=n; i++) {
        int height;
        cin >> height;
        while(stk.top().first < height) 
            stk.pop();
        cout << stk.top().second << " ";
        stk.push({height,i});
    }
    return 0;
}