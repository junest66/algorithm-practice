#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m;
int x, y, a, b;
int board[101][101];
bool vis[101][101];
vector<pair<int, int>> vec[102][102];
int ans;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

bool is_corn(pair<int,int> nxt) {
    for(int dir=0; dir<4; dir++) {
        int nx= nxt.first + dx[dir];
        int ny = nxt.second + dy[dir];
        if(nx< 1 || ny < 1 || nx > n || ny > n) continue;
        if(vis[nx][ny]) return 1;
    }
    return 0;
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        cin >> x >> y >> a >> b;
        vec[x][y].push_back({a, b});
    }
    queue<pair<int,int>> que;
    board[1][1] = 1;
    que.push({1, 1});
    vis[1][1] = 1;
    while(!que.empty()) {
        auto cur = que.front();
        que.pop();
        for(auto nxt : vec[cur.first][cur.second]) { 
            if(vis[nxt.first][nxt.second]) continue; // 불 켜야할곳을 이미 방문 한 경우 
            if(is_corn(nxt)) { //불켜야할곳의 상하좌우중 방문한 곳이 있으면
                vis[nxt.first][nxt.second] = 1;  //방문을 하고  큐 삽입
                que.push({nxt.first,nxt.second});
            }
        board[nxt.first][nxt.second] = 1;
        }
        for(int dir=0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx< 1 || ny < 1 || nx > n || ny > n) continue;
            if(vis[nx][ny] || board[nx][ny] == 0) continue;
            vis[nx][ny] = 1;
            que.push({nx,ny});

        }
    }
    int ans = 0;
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            ans += board[i][j];
        }
    }
    cout << ans;

}