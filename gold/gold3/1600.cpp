#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>

using namespace std;

int k;
int m,n;
int board[202][202];
int vis[202][202][32];
int bx[8] = {2, 1, -1, -2, -2, -1, 1, 2};
int by[8] = {1, 2, 2, 1, -1, -2, -2, -1};
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
queue<tuple<int,int,int>> que;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int ans = -1;
    cin >> k;
    cin >> m >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> board[i][j];
        }
    }
    fill_n(&vis[0][0][0], 202*202*32, -1);
    que.push({0,0,0});
    vis[0][0][0] = 0;
    while(!que.empty()) {
        auto cur = que.front();
        que.pop();
        int curX, curY, jump;
        tie(curX,curY,jump) = cur;
        if(curX == n-1 && curY == m-1) {
            ans = vis[curX][curY][jump];
            break;
        }
        for(int dis = 0; dis<4; dis++) {
            int nx = curX + dx[dis];
            int ny = curY + dy[dis];
            if(nx<0 || ny <0 || nx>=n || ny >=m) continue;
            if(vis[nx][ny][jump] >= 0 || board[nx][ny] == 1) continue;
            que.push({nx,ny,jump});
            vis[nx][ny][jump] = vis[curX][curY][jump] + 1;
        }
        if(jump < k) {
            for(int dis = 0; dis<8; dis++) {
            int nx = curX + bx[dis];
            int ny = curY + by[dis];
            if(nx<0 || ny <0 || nx>=n || ny >=m) continue;
            if(vis[nx][ny][jump+1] >= 0 || board[nx][ny] == 1) continue;
            que.push({nx,ny,jump+1});
            vis[nx][ny][jump+1] = vis[curX][curY][jump] + 1;
            }
        }
    }
    cout << ans;
    
}