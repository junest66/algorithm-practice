#include <iostream>
#include <string>
#include <utility>
#include <queue>
using namespace std;
string str[102];
int dist[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m;

int main() {
    cin >> n >> m;
    int count = 0;
    for(int i=0; i< n; i++)
        cin >> str[i];
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            dist[i][j] = -1;
        }
    }
    queue<pair<int,int>> queue;
    dist[0][0] = 1;
    queue.push({0,0});
    while(!queue.empty()) {
        pair<int,int> cur = queue.front();
        queue.pop();
        for(int dir = 0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx<0 || nx > n || ny < 0 || ny > m) continue;
            if(dist[nx][ny] >= 0 || str[nx][ny] != '1' ) continue; // dis[nx][ny] == -1 이어야 방문 X 
            queue.push({nx,ny});
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
        }
    }
    cout << dist[n-1][m-1];

}
