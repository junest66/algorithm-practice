#include <iostream>
#include <queue>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n, m;
    queue<int> que;
    cin >> n >> m;
    for(int i=1; i<=n; i++)
        que.push(i);
    cout << '<';
    while(!que.empty()) {
        for(int i=1; i<m; i++) {
            que.push(que.front());
            que.pop();
        }
        cout << que.front();
        que.pop();
        if(que.size()) cout<< ", ";
    }
    cout << '>';
     return 0;
}