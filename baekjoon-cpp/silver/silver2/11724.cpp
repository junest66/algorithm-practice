#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

int n, m, answer;
vector<vector<int>> vec(1001);
bool visited[1001];
queue<int> que;

void bfs(int i) {
    answer++;
    // cout << "i : " << i << '\n';
    visited[i] = true;
    while (!que.empty()) {
        auto current = que.front();
        que.pop();
        for (auto nxt : vec[current]) {
            if (visited[nxt]) {
                continue;
            }
            visited[nxt] = true;
            que.push(nxt);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        vec[u].push_back(v);
        vec[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            que.push(i);
            bfs(i);
        }
    }
    cout << answer;
}