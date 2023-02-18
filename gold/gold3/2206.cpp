#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;
int vis[1002][1002][2];
char board[1002][1002];
int n,m;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int bfs() {
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++){
           vis[i][j][0] = -1;
           vis[i][j][1] = -1;
        }
    }
    vis[0][0][0] = 1;
    vis[0][0][1] = 1;
    queue<tuple<int,int,int>> que;
    que.push({0,0,0});
    while(!que.empty()) {
        int x,y,broken;
        tie(x,y,broken) = que.front();
        if(x==n-1 && y==m-1) return vis[x][y][broken];
        que.pop();
        int next = vis[x][y][broken] + 1;
        for(int dis = 0; dis<4; dis++) {
            int nx = x + dx[dis];
            int ny = y + dy[dis];
            if(nx<0 || ny <0 || nx >= n || ny >=m) continue;
            if(board[nx][ny] == '0' && vis[nx][ny][broken] == -1) { //0이고 아직 방문 안한 곳
                vis[nx][ny][broken] = next;
                que.push({nx,ny,broken});
            }
            if(board[nx][ny] == '1' && vis[nx][ny][1] == -1 && !broken )  { //다음이 벽이고  방문 안햇고, 아직 부시기 1회를 안씀
                vis[nx][ny][1] = next;
                que.push({nx,ny,1});
            }
        }
        
    }
    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> board[i][j];
        }
    }
    cout<< bfs();
    return 0;
}