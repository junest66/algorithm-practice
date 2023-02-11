#include <iostream>
#include <utility>
#include <queue>
#include <algorithm>
using namespace std;

int board[51][51];
bool visited[51][51];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while(t--) {
        int m, n, num;
        int count = 0;
        queue<pair<int,int>> que;
        cin >> m >> n >> num;
        int a,b;
        for(int i=0; i<num; i++) {
            cin >> a >> b;
            board[b][a] = 1;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1 && !visited[i][j]) {  //배추가 있으면서 아직 방문하지 않는 곳
                    que.push({i,j});
                    visited[i][j]= true;
                    while(!que.empty()) {
                        auto cur = que.front();
                        que.pop();
                        for(int dis=0; dis<4; dis++) {
                            int nx = cur.first + dx[dis];
                            int ny = cur.second + dy[dis];
                            if(nx<0 || nx >= n || ny<0 || ny >=m) continue;
                            if(board[nx][ny] != 1 || visited[nx][ny]) continue;
                            que.push({nx,ny});
                            visited[nx][ny] = true;
                        }
                    }
                    count++;
                }
            }
        }
        cout << count <<'\n';
        for(int i = 0; i < n; i++) {  //배열 초기화 !!
        fill(board[i], board[i]+m, 0);
        fill(visited[i], visited[i]+m, false);
        }
    }
    return 0;
}