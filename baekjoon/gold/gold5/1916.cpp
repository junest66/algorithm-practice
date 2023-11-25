#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;
const int INF = 0x3f3f3f3f;
int n, m;
typedef pair<int,int> pii;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    vector<vector<pii>> adj(n+1);
    vector<int> d(n+1, -1);
    while(m--) {
        int st, en, w;
        cin >> st >> en >> w;
        adj[st].push_back({w,en});
    }
    int start, end;
    cin >> start >> end;
    priority_queue<pii, vector<pii>, greater<pii>> que;
    d[start] = 0;
    que.push({d[start], start});
    while(!que.empty()) {
        auto current = que.top();
        que.pop();
        int currentW = current.first;
        int currentPos = current.second;
        if(d[currentPos] != currentW) continue;
        for(auto x : adj[currentPos]) {
            int nxtW = x.first;
            int nxtP = x.second;
            if(d[nxtP] > d[currentPos] + nxtW) {
                d[nxtP] = d[currentPos] + nxtW;
                que.push({d[nxtP], nxtP});
            }
        }
    }
    cout << d[end];
}