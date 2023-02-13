#include <iostream>
#include <queue>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

int gr[20002];
vector<int> adj[20002];
int k,v,e;

bool solve() {
    fill(gr, gr + v +1, -1);  
    for(int i=1; i<=v; i++) {
        if(gr[i] != -1) continue; //이미방문 한 곳
        queue<int> que;
        que.push(i);
        gr[i] = 0;
        while(!que.empty()) {
            int cur = que.front();
            que.pop();
            for(int nxt : adj[cur]) {
                if(gr[nxt] != -1) {
                    if(gr[cur] == gr[nxt]) return false; //같은 색깔
                    else continue;
                }
                gr[nxt] = (gr[cur] + 1) %2;
                que.push(nxt);
            }
        }
    }
    return true;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> k;
    while(k--) {
        cin >> v >> e;
        for(int i=1; i <=v; i++) {  //초기화
            adj[i].clear();
        }

        int i, j;
        while(e--) {
            cin >> i >> j;
            adj[i].push_back(j);
            adj[j].push_back(i);
        }
        if(solve()) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}