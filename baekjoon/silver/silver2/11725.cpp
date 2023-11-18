#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int p[100001];
bool visited[100001];
queue<int> que;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    vector<vector<int>> vec(n+1);
    for(int i = 1; i < n; i++) {
        int u, v;
        cin >> u >> v;
        vec[u].push_back(v);
        vec[v].push_back(u);
    }
    que.push(1);
    while(!que.empty()) {
        int current = que.front();
        que.pop();
        for(auto x: vec[current]) {
            if(!visited[x]) {
                p[x] = current;
                que.push(x);
            }
        }
        visited[current] = 1;
    }
    
    for(int i = 2; i <= n; i++) {
        cout << p[i] << '\n';
    }

    return 0;
}