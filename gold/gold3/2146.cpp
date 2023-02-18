#include <iostream>
#include <utility>
#include <queue>
#include <algorithm>
using namespace std;

int board[102][102];
int vis[102][102];
int dist[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, cnt = 0;
queue<pair<int, int>> que;

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> board[i][j];
        }
    }
    // 육지 번호 붙이기
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j] == 1 && vis[i][j] == 0)
            {
                ++cnt;
                que.push({i, j});
                vis[i][j] = 1;
                while (!que.empty())
                {
                    auto cur = que.front();
                    que.pop();
                    board[cur.first][cur.second] = cnt;
                    for (int dis = 0; dis < 4; dis++)
                    {
                        int nx = cur.first + dx[dis];
                        int ny = cur.second + dy[dis];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                            continue;
                        if (board[nx][ny] != 1 || vis[nx][ny] > 0)
                            continue;
                        que.push({nx, ny});
                        vis[nx][ny] = 1;
                        board[nx][ny] = cnt;
                    }
                }
            }
        }
    }
    // 거리 배열 초기화
    for (int i = 0; i < n; i++)
        fill(dist[i], dist[i] + n, -1);
    // 육지에서 다른육지까지 거리 BFS
    int ans = 10000000;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j] != 0)
            {
                que.push({i, j});
                dist[i][j] = 0;
                bool escape = false;
                while (!que.empty())
                {
                    auto cur = que.front();
                    que.pop();
                    for (int dis = 0; dis < 4; dis++)
                    {
                        int nx = cur.first + dx[dis];
                        int ny = cur.second + dy[dis];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                            continue;
                        if (dist[nx][ny] >= 0 || board[i][j] == board[nx][ny])
                            continue;
                        if (board[nx][ny] != 0 && board[i][j] != board[nx][ny])
                        {
                            ans = min(ans, dist[cur.first][cur.second]);
                            while (!que.empty())
                            {
                                que.pop();
                            }
                            escape = true;
                            break;
                        }
                        dist[nx][ny] = dist[cur.first][cur.second] + 1;
                        que.push({nx, ny});
                    }
                }
                for (int i = 0; i < n; i++)
                    fill(dist[i], dist[i] + n, -1);
            }
        }
    }
    cout << ans;
}
