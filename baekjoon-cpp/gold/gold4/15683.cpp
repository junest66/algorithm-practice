#include <iostream>
#include <utility>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
int board[8][8];
int camernum;
int res = 100;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
vector<pair<int,int>> vcctv;

void check(int x, int y, int dir) {
    dir %=4;
    while(true) {
        int nx = x + dx[dir];
        int ny = y+ dy[dir];
        x = nx;
        y = ny;
        if (nx < 0 || ny < 0 || nx >= n || ny >= m)return;
        if (board[nx][ny] == 6) return;
        if (board[nx][ny] != 0) continue;
        board[nx][ny] = 7;
    }
}

void solve(int index)
{
    if (index == vcctv.size())
    {
        int temp_res = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == 0)
                    temp_res++;
            }
        }
        res = min(res, temp_res);
        return;
    }
    int x = vcctv[index].first;
    int y = vcctv[index].second;
    int backup[8][8];
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            backup[i][j] = board[i][j];
        }
    }
    for (int dir = 0; dir < 4; dir++)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backup[i][j] = board[i][j];
            }
        }
        if(board[x][y] == 1) {
            check(x,y,dir);
        }
        else if(board[x][y] == 2) {
            check(x,y,dir);
            check(x,y,dir+2);
        }
        else if(board[x][y] == 3) {
            check(x,y,dir);
            check(x,y,dir+1);
        }
        else if(board[x][y] == 4) {
            check(x,y,dir);
            check(x,y,dir+1);
            check(x,y,dir+2);
        }
        else if(board[x][y] == 5) {
            check(x,y,dir);
            check(x,y,dir+1);
            check(x,y,dir+2);
            check(x,y,dir+3);
        }
        solve(index+1);
        for (int i = 0; i < n; i++) { //되돌려놓기
            for (int j = 0; j < m; j++) {
                board[i][j] = backup[i][j];
            }
        }
    }

    return;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    int ccount = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> board[i][j];
            if (board[i][j] > 0 && board[i][j] < 6)
            {
                vcctv.push_back({i, j});
            }
        }
    }
    solve(0);
    cout << res;
}