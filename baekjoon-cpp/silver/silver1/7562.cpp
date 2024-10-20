#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;
int board[305][305];
int dx[8]= {1,2,-1,-2,2,1,-2,-1};
int dy[8] = {2,1,2,1,-1,-2,-1,-2};
int n;
int width;
int nowx, nowy;
int finx, finy;
queue<pair<int,int>> que;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    while(n--) {
        cin >> width;
        for (int i = 0; i < width; i++)
            fill(board[i], board[i] + width, -1);  
        cin >> nowx >> nowy;
        cin >> finx >> finy;
        que.push({nowx,nowy});
        board[nowx][nowy] = 0;
        while(!que.empty()) {
            auto cur = que.front();
            que.pop();
            for(int dis=0; dis<8; dis++) {
                int nx = cur.first + dx[dis];
                int ny = cur.second + dy[dis];
                if(nx < 0 || nx >= width || ny <0 || ny >= width) continue;
                if(board[nx][ny]>=0) continue;
                que.push({nx,ny});
                board[nx][ny] = board[cur.first][cur.second] +1;
            }
        }
        cout << board[finx][finy] <<'\n';
  }
        
}