#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
using namespace std;

char board[1001][1001];
int vis[1001][1001][11][2];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m,k;
queue<tuple<int,int,int,int>> que;


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m >> k;
    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            cin >> board[i][j];
    que.push({0,0,0,1});
    vis[0][0][0][1] = 1;
    while(!que.empty()) {
        auto cur = que.front();
        que.pop();
        int curX,curY,curK,curT;
        tie(curX,curY,curK,curT) = cur;
        if(curX == n-1 && curY == m-1) {
            cout << vis[curX][curY][curK][curT];
            return 0;
        }
        int nt = (curT+1)%2;
        for(int dis=0; dis<4; dis++) {
            int nx = curX + dx[dis];
            int ny = curY + dy[dis];
            if(nx< 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(board[nx][ny] == '0') {
                if(vis[nx][ny][curK][nt]!=0) continue;
                que.push({nx,ny,curK,nt});
                vis[nx][ny][curK][nt] = vis[curX][curY][curK][curT] + 1;
            }
            else {
                if(curK == k) continue;
                if(curT == 1) {
                    if(vis[nx][ny][curK+1][nt]!=0) continue;
                    que.push({nx,ny,curK+1,nt});
                    vis[nx][ny][curK+1][nt] = vis[curX][curY][curK][curT] + 1;
                }
                else {
                    if(vis[curX][curY][curK][nt]!=0) continue;
                    que.push({curX,curY,curK,nt});
                    vis[curX][curY][curK][nt] = vis[curX][curY][curK][curT] + 1;
                }
            }
        }
    }
    cout << -1;

}