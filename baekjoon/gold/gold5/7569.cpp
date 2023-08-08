#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int m,n,h;
int tmt[103][103][103];
int vis[103][103][103];
int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,1,0,-1,0,0};
int dz[6] = {0,0,0,0,1,-1};
queue<tuple<int,int,int>> que;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n >> h;
    for(int i=0; i<h; i++) {
        for(int j=0; j<n; j++) {
            for(int k = 0; k<m; k++) {
                cin >> tmt[j][k][i];
                if(tmt[j][k][i] == 1) que.push({j,k,i});
                else if(tmt[j][k][i] ==0) vis[j][k][i] = -1;
            }
        } 
    }
    while(!que.empty()) {
        auto cur = que.front();
        que.pop();
        for(int dis= 0; dis< 6; dis++) {
            int nx = get<0>(cur) + dx[dis];
            int ny = get<1>(cur) + dy[dis];
            int nz = get<2>(cur) + dz[dis];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
            if(vis[nx][ny][nz] >= 0) continue;
            que.push({nx,ny,nz});
            vis[nx][ny][nz] = vis[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
        }
    }
    int count = 0;
    for(int i=0; i<h; i++) {
        for(int j=0; j<n; j++) {
            for(int k = 0; k<m; k++) {
                if(vis[j][k][i]== -1) {
                    cout << -1;
                    return 0;
                }
                count = max(count,vis[j][k][i]);
            }
        } 
    }
    cout << count;
}