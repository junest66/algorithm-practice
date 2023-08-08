#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
#include <string>
using namespace std;

int m,n,h;
int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,1,0,-1,0,0};
int dh[6] = {0,0,0,0,1,-1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    while(1) {
        cin >> h >> m >> n;
        if(h==0 && m==0 && n==0) break;
        queue<tuple<int,int,int>> que;
        char board[32][32][32];
        int vis[32][32][32];
        bool isEscape = false;
        for(int i=0; i<h; i++) {
            for(int j=0; j<m; j++) {
                fill(vis[i][j], vis[i][j]+n,0);
            }
        }
        for(int i=0; i<h; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<n; k++) {
                   cin >> board[i][j][k];
                   if(board[i][j][k] == 'S') {
                      que.push({i,j,k});
                      vis[i][j][k] = 0;
                   }
                   else if(board[i][j][k]== '.') vis[i][j][k] = -1;

                }
            }
        }
        while(!que.empty()) {
            auto cur = que.front();
            que.pop();
            int curh,curx,cury;
            tie(curh,curx,cury) = cur;
            for(int dis=0; dis<6; dis++) {
                int nh = curh + dh[dis];
                int nx = curx + dx[dis];
                int ny = cury + dy[dis];
                if(nx<0 || ny<0 || nh<0 || nx >= m || ny>=n || nh>=h) continue;
                if(board[nh][nx][ny] == '#' || vis[nh][nx][ny] > 0) continue;
                vis[nh][nx][ny] = vis[curh][curx][cury] + 1;
                if(board[nh][nx][ny] == 'E') {
                    cout << "Escaped in " << vis[nh][nx][ny] << " minute(s)." << "\n";
                    isEscape = true;
                    break;
                }
                que.push({nh,nx,ny});
            }
        }
        while(!que.empty()) que.pop();
        if(!isEscape) cout << "Trapped!" << "\n";
    }
}