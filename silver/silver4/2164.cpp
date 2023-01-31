#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    queue<int> que;
    cin >> n;
    for(int i=1; i<=n; i++) que.push(i);
    while(que.size()!=1) {
        que.pop();
        que.push(que.front());
        que.pop();
    }
    cout << que.front();
}