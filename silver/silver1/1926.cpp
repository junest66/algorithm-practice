#include <iostream>
#include <queue>
#include <utility>
using namespace std;
#define X first
#define Y second
int board[502][502];
bool vis[502][502];
int n,m;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    cin >> n >> m;
    int count = 0; //그림의 갯수
    int mx = 0; //최대 넓이 
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> board[i][j];
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(board[i][j] == 0 || vis[i][j]== 1) continue;
            count++;
            queue<pair<int,int>> que;
            que.push({i,j});
            vis[i][j] = true;
            int area = 0; //그림의 넓이
            while(!que.empty()) {
                area++;
                pair<int,int> cur = que.front();
                que.pop();
                for(int dir=0; dir<4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx > n || ny < 0 || ny > m) continue; //범위 밖
                    if(vis[nx][ny] || board[nx][ny] != 1) continue; // 방문한 곳 과 0인 부분 제외
                    que.push({nx,ny});
                    vis[nx][ny] = true;
                }
            }
            mx = max(mx,area);
        }
    }
    cout << count << '\n' << mx;

}