#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

vector<int> p(10005,-1);
vector<int> r(10005);

int find(int x) {
    if(p[x] == x) return x;
    return p[x] = find(p[x]);
}

bool is_diff_group(int u, int v) {
    u = find(u);
    v = find(v);
    if(u == v) return 0;
    if(r[u] > r[v]) //트리의 높이가 u가 더 큰 경우 v의 부모를 u로
        p[v] = u;
    else {  // 트리의 높이가 v가 더크거나 같은 경우
        p[u] = v;  //일단 u의 부모를 v로 하고
        if(r[u]== r[v])
            r[v]++; //같은경우 합칠때 트리의 높이가 1늘어남
    }
    return 1;
}

int v,e;
tuple<int,int,int> edge[100005];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> v >> e;
    for (int i = 1; i <= v; i++) {
		p[i] = i;
    }
    for(int i=0; i<e; i++) {
        int a, b, cost;
        cin >> a >> b>> cost;
        edge[i] = {cost, a, b};
    }
    sort(edge, edge + e);
    int cnt = 0;
    int ans = 0;

    for(int i=0; i<e; i++) {
        int a, b, cost;
        tie(cost,a,b) = edge[i];
        if(!is_diff_group(a,b)) continue;
        ans += cost;
        cnt++;
        if(cnt == v-1) break;
    }
    cout << ans;
}