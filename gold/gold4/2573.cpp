#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;
int board[303][303];
bool vis[303][303];
int bingsan[303][303];
int n,m;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
queue<pair<int,int>> que;
vector<pair<int,int>> vec;

int bfs() {
    int count =0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(board[i][j] != 0 && vis[i][j] == false) {
                ++count;
                que.push({i,j});
                vis[i][j] = true;
                while(!que.empty()) {
                    auto cur = que.front();
                    que.pop();
                    int cnt= 0;
                    for(int dis= 0; dis<4; dis++) {
                        int nx = cur.first + dx[dis];
                        int ny = cur.second + dy[dis];
                        if(nx<0 || nx >= n || ny<0 || ny >= m) continue;
                        if(board[nx][ny] != 0 && vis[nx][ny] == false) {
                            que.push({nx,ny});
                            vis[nx][ny] = true;
                        }
                        if(board[nx][ny]==0) {
                            ++cnt;
                        }
                    }
                    bingsan[cur.first][cur.second] = cnt;
                }
            }
        }
    }
    return count;
}
void solve() {
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(board[i][j]!= 0 && bingsan[i][j] !=0) {
               board[i][j] = max(0,board[i][j] - bingsan[i][j]);
            }
        }
    }
    
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
    int ans = 0;
    while(1) {
        int temp = bfs();
        for(int i=0; i<n; i++) fill(vis[i],vis[i]+m, 0);
        if(temp>=2){
            cout<< ans;
            return 0;
        } 
        else if (temp==0) {
            cout << 0;
            return 0;
        }
        else {
             ++ans;
             solve();
             for(int i=0; i<n; i++) fill(bingsan[i],bingsan[i]+m, 0);
        }
    }
    return 0;

}