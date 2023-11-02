#include <algorithm>
#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#include <cstring>
using namespace std;

queue<int> que;
stack<int> stk;
int n, m, v;
vector<int> vec[10001];
bool visited[10001];

void dfs() {
    while (!stk.empty()) {
        int current = stk.top();
        stk.pop();
        if(visited[current]) continue;
        cout << current << " ";
        visited[current] = 1;
        sort(vec[current].rbegin(), vec[current].rend());
        for(auto nxt : vec[current]) {
            if(visited[nxt]) continue;
            stk.push(nxt);
        }
    }
    cout << '\n';
} 

void bfs() {
    memset(visited, 0, sizeof(visited));
    while (!que.empty()) {
        int current = que.front();
        que.pop();
        if(visited[current]) continue;
        cout << current << " ";
        visited[current] = 1;
        sort(vec[current].begin(), vec[current].end());
        for(auto nxt : vec[current]) {
            if(visited[nxt]) continue;
            que.push(nxt);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m >> v;
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }
    que.push(v);
    stk.push(v);
    dfs();
    bfs();
}