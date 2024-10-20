#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
using namespace std;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int board[102][102];
int ans[10000];
queue<pair<int,int>> que;

int main() {
    int n,m,k; //n이 행 m이 열 
    int count = 0;
    int cnt = 0;
    cin >> n >> m >> k;
    while(k--) {
        int a,b,c,d;
        cin >> a >> b;
        cin >> c >> d;
        for(int i=b; i<d; i++) {
            for(int j=a; j<c; j++) {
                board[i][j] = -1;
            }
        }
    }
    for(int i=0; i< n; i++) {
        for(int j=0; j<m; j++) {
            if(board[i][j] == 0) {
                que.push({i,j});
                board[i][j] = ++cnt;
                count++;
                while(!que.empty()) {
                    auto cur = que.front();
                    que.pop();
                    for(int dis = 0; dis<4; dis++) {
                        int nx = cur.first + dx[dis];
                        int ny = cur.second + dy[dis];
                        if(nx<0 || nx >=n || ny < 0 || ny >= m) continue;
                        if(board[nx][ny] != 0) continue;
                        que.push({nx,ny});
                        board[nx][ny] = ++cnt;
                    }
                }
                ans[count-1] = cnt;
                cnt = 0;
            }
        }
    }
    cout << count << '\n';
    sort(ans,ans+count);
    for(int i = 0; i<count; i++)
        cout << ans[i] << " ";
}