#include <iostream>
#include <queue>
#include <string>
#include <utility>
#include <algorithm>
using namespace std;
int n;
string str;
char board[102][102];
char redg[102][102];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,-1,0,1};
int dist[102][102];
int dist1[102][102];

int bfs(char arr[][102], int vis[][102]) {
    int count = 0;
    queue<pair<int,int>> que;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(vis[i][j]==0) {
                que.push({i,j});
                vis[i][j]=++count;
                while(!que.empty()) {
                    auto cur = que.front();
                    que.pop();
                    for(int dir = 0; dir<4; dir++) {
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        if(nx<0 || nx >=n || ny < 0 || ny >=n) continue;
                        if(vis[nx][ny]!= 0 || arr[cur.first][cur.second] != arr[nx][ny]) continue;
                        que.push({nx,ny});
                        vis[nx][ny] = vis[cur.first][cur.second];
                    }
                }
            }
        }
    }
    return count;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> str;
        for(int j=0; j< n; j++) {
            board[i][j] = str[j];
            redg[i][j] = str[j];
            if(str[j] == 'G') redg[i][j] = 'R';
        }
    }
    cout << bfs(board,dist) << " " << bfs(redg,dist1);

}