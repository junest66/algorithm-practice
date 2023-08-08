#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
#include <string>
using namespace std;
int k;
int n, m;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
const int MX = 120;
char board[MX][MX];
int vis[MX][MX];
string firstkey;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> k;
    while (k--)
    {
        cin >> n >> m;
        queue<pair<int, int>> que;
        queue<pair<int, int>> closed[26];
        int key[26] = {};
        int ans = 0;
        for (int i = 0; i <= n+1; i++)
        {
            fill(board[i], board[i] + m + 2, 0);
            fill(vis[i], vis[i] + m + 2, 0);
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                cin >> board[i][j];
            }
        }
        cin >> firstkey;
        for(auto c: firstkey) key[c-'a']= 1;
        que.push({0,0});
        vis[0][0] = 1;
        while (!que.empty())
        {
            auto cur = que.front();
            que.pop();
            for (int dir = 0; dir < 4; dir++)
            {
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || ny < 0 || nx > n+1 || ny > m+1) continue;
                if (vis[nx][ny] || board[nx][ny] == '*') continue;
                vis[nx][ny] = 1;
                //열쇠
                if (board[nx][ny] >= 'a' && board[nx][ny] <= 'z')
                {
                    int k = board[nx][ny] - 'a';
                    key[k] = 1;
                    while(!closed[k].empty()) {
                        auto ndoor = closed[k].front();
                        closed[k].pop();
                        que.push({ndoor.first,ndoor.second});
                    }
                }
                else if(board[nx][ny] >= 'A' && board[nx][ny] <= 'Z') {
                    int k = board[nx][ny] + 32 - 'a';
                    if(!key[k]) {
                        closed[k].push({nx,ny});
                        continue;
                    }
                }
                else if(board[nx][ny] == '$') ans++;
                que.push({nx,ny});
            }
        }
        cout << ans << '\n';
    }
}