#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;
int vis[2][500002];
int board[500002];
int n, m;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int  bro, sis, ans = 0;
    queue<pair<int,int>> que;
    cin >> sis >> bro;
    que.push({sis, 0});
    for(int i=0; i<2; i++)
        fill(vis[i], vis[i]+ 500002, -1);
    vis[0][sis] = 0;
    while(!que.empty()) {
        int v, vt, nvt;
        tie(v,vt) = que.front();
        nvt = vt + 1;
        que.pop();
        for(int nv: {2 * v, v+1, v-1}) {
            if(nv < 0 || 500002 < nv) continue;
            if(vis[nvt%2][nv] != -1) continue;
            vis[nvt % 2][nv] = nvt;
            que.push({nv,nvt});
        }
    }
    bool found = false;
    while(bro <= 500000) {
        if(vis[ans % 2][bro] <= ans) {
            found = true;
            break;
        }
        bro += ++ans;
    }
    if(found) cout << ans;
    else cout<< -1;
}
