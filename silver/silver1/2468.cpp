#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int board[102][102];
int vis[102][102];
int n;
int maxlimit;
int final;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

void bfs(int i, int j ,int limit) {
    queue<pair<int,int>> que;
    que.push({i,j});
    vis[i][j] = 1;
    while(!que.empty()) {
        auto cur = que.front();
        que.pop();
        for(int dis = 0; dis<4; dis++) {
            int nx = cur.first + dx[dis];
            int ny = cur.second + dy[dis];
            if(nx<0 || nx >=n || ny <0 || ny >= n) continue;
            if(vis[nx][ny]!=0 || board[nx][ny] <= limit) continue;
            que.push({nx,ny});
            vis[nx][ny] = 1;
        }
    }

}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin>> board[i][j];
            maxlimit = max(board[i][j],maxlimit);
        }
    }
    for(int limit = 0; limit<=maxlimit; limit++) {
        for(int i=0; i<n; i++)
            fill(vis[i],vis[i]+n, 0);
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(vis[i][j]== 0 && limit < board[i][j]) {
                    bfs(i,j,limit);
                    ans++;
                }
            }
        }
        final = max(ans,final);
    }
    cout << final;

    

}