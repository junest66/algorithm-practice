#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int board[1002][1002];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m,p;
int s[11];
int area[11];
queue<tuple<int,int,int>> que[10];


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m >> p;
    for(int i=1; i<=p; i++) 
        cin >> s[i];
    char ch;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> ch;
            if(ch == '.') board[i][j] = 1;
            else if(ch == '#') board[i][j] = 0;
            else {
                board[i][j] = 0;
                que[ch-'0'].push({i,j,0});
                area[ch-'0'] += 1;
            }
        }
    }
    while(1) {
        bool isExtend = false;
        for(int i=1; i<=p; i++) {
            queue<tuple<int,int,int>> nextq;
            while(!que[i].empty()){
                int curX, curY, curstep;
                tie(curX,curY,curstep) = que[i].front();
                que[i].pop();
                if(curstep >= s[i]) {
                    nextq.push({curX,curY,0});
                    continue;
                }
                for(int dir = 0; dir<4; dir++) {
                    int nx = curX + dx[dir];
                    int ny = curY + dy[dir];
                    if(nx< 0 || ny < 0 || nx >=n || ny >= m) continue;
                    if(!board[nx][ny]) continue;
                    que[i].push({nx,ny,curstep+1});
                    board[nx][ny] = 0;
                    area[i]++;
                    isExtend = true;
                }
            }
            que[i] = nextq;
        }
        if(!isExtend) break;
    }
    for(int i=1; i<=p; i++)
        cout<< area[i] << " "; 
}