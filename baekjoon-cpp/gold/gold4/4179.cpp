#include <iostream>
#include <string>
#include <queue>
#include <utility>
using namespace std;
string board[1002];
int jihun[1002][1002];
int fire[1002][1002];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n,m;
    cin >> n >> m;
    string str;
    queue<pair<int,int>> jih;
    queue<pair<int,int>> fir;
    for(int i=0; i<n; i++) {
        fill(fire[i], fire[i]+m, -1);
        fill(jihun[i], jihun[i]+m, -1);
    }
    for(int i=0; i<n; i++)
        cin >> board[i];
    for(int i=0; i<n; i++) { // 불, 지훈 시작점 큐에 넣기
        for(int j=0; j<m; j++) {
            if(board[i][j] == 'J') {
                jih.push({i,j});
                jihun[i][j] = 0;
            }
            if(board[i][j] == 'F') {
                fir.push({i,j});
                fire[i][j] = 0;
            }
        }
    }
    while(!fir.empty()) {  //먼저 불 BFS 
        auto cur = fir.front();
        fir.pop();
        for(int dir = 0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[nx][ny] ==  '#' || fire[nx][ny] >= 0) continue;
            fir.push({nx,ny});
            fire[nx][ny] = fire[cur.first][cur.second] + 1;
        }
    }
    while(!jih.empty()) {
        auto cur = jih.front();
        jih.pop();
        for(int dir = 0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) { //범위를 벗어나건 탈출 성공
                cout << jihun[cur.first][cur.second] + 1;
                return 0;
            }
            if(board[nx][ny] == '#' || jihun[nx][ny] >= 0) continue;
            if(jihun[cur.first][cur.second]+1 >= fire[nx][ny] && fire[nx][ny] != -1) continue;  // 지훈의 다음 갈곳의 시간이 그곳의 불시간보다 크면 못감 
            jih.push({nx,ny});
            jihun[nx][ny] = jihun[cur.first][cur.second] + 1;
        }
    }
    cout << "IMPOSSIBLE";

    return 0;
}