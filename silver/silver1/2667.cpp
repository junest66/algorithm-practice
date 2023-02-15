#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
#include <string>
#include <vector>
using namespace std;
string board[27];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int vis[735][735];
queue<pair<int, int>> que;
vector<int> vec;

int main()
{
    int n;
    int count = 0;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> board[i];
        for (int j = 0; j < n; j++)
        {
            if (board[i][j] == '0')
                vis[i][j] = -1;
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (vis[i][j] == 0)
            {
                que.push({i, j});
                int ans = 1;
                vis[i][j] = ans;
                ++count;
                while (!que.empty())
                {
                    auto cur = que.front();
                    que.pop();
                    for (int dis = 0; dis < 4; dis++)
                    {
                        int nx = cur.first + dx[dis];
                        int ny = cur.second + dy[dis];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (vis[nx][ny] != 0) continue;
                        que.push({nx, ny});
                        vis[nx][ny] = ++ans;
                    }
                }
                vec.push_back(ans);
            }
        }
    }
    cout << count << '\n';
    sort(vec.begin(),vec.end());
    for(int e : vec) cout << e << '\n';
}