#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int board[1002][1002];
int dis[1002][1002];
int n,m;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(0);
    queue<pair<int,int>> que;
    cin >> m >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> board[i][j];
            if(board[i][j] == 1) que.push({i,j});
            else if(board[i][j] == 0) dis[i][j] = -1;
        }
    }
    while(!que.empty()) {
        auto cur = que.front();
        que.pop();
        for(int dir = 0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dis[nx][ny] >= 0) continue;
            dis[nx][ny] = dis[cur.first][cur.second] + 1;
            que.push({nx,ny});
        }
    }
    int ans = 0;
    for(int i=0; i< n; i++) {
        for(int j=0; j<m; j++) {
            if(dis[i][j] == -1) { //큐를 다 돌았는데도 방문하지 않은 곳이 존재
                cout << -1;
                return 0;
            }
            ans = max(ans,dis[i][j]);
        }
    }
    cout << ans;
    return 0;
    

}