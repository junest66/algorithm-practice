#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int ans;
int n, m, g, r;
int brownSoilSize; // 배양액을 뿌릴 수 있는 땅의 수
int map[50][50];
int gtime[50][50];   // 초록색 배양액이 퍼진 시간을 저장
int rtime[50][50];   // 빨간색 배양액이 퍼진 시간을 저장
bool flower[50][50]; // 꽃이 피었는지 체크

int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

vector<pair<int, int>> brownSoil; // 배약액을 뿌릴 수 있는 땅의 좌표를 저장

vector<pair<int, int>> green; // 초록색 배양액을 뿌릴 좌표를 저장
vector<pair<int, int>> red;   // 빨간색 배양액을 뿌릴 좌표를 저장

void bfs()
{
    queue<pair<int, int>> gq;
    queue<pair<int, int>> rq;

    // 시간을 -1로 초기화
    memset(gtime, -1, sizeof(gtime));
    memset(rtime, -1, sizeof(rtime));

    memset(flower, false, sizeof(flower));

    // 초록색 배양액을 뿌린 땅과 빨간색 배양액을 뿌린 땅을 각각 큐에 넣어준다.
    for (pair<int, int> p : green)
    {
        gq.push(make_pair(p.first, p.second));
        gtime[p.first][p.second] = 0;
    }
    for (pair<int, int> p : red)
    {
        rq.push(make_pair(p.first, p.second));
        rtime[p.first][p.second] = 0;
    }

    int fcnt = 0;
    int gqsize;
    int rqsize;
    int x, y, nx, ny;
    while (!gq.empty() || !rq.empty())
    {
        gqsize = gq.size();
        rqsize = rq.size();

        // 초록색 배양액 먼저 bfs
        while (gqsize--)
        {
            x = gq.front().first;
            y = gq.front().second;
            gq.pop();

            // 이미 꽃이 피어난 땅은 배양액이 퍼뜨려지지 않는다
            if (flower[x][y])
                continue;

            for (int k = 0; k < 4; k++)
            {
                nx = x + dx[k];
                ny = y + dy[k];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                // 방문 체크
                if (gtime[nx][ny] != -1)
                    continue;
                // 호수인지 체크
                if (map[nx][ny] == 0)
                    continue;

                // 빨간색 배양액이 이미 있는 곳인지 체크
                if (rtime[nx][ny] != -1)
                    continue;

                // 위의 조건을 모두 통과했다면 배양액이 퍼진다
                gtime[nx][ny] = gtime[x][y] + 1;
                gq.push(make_pair(nx, ny));
            }
        }

        // 빨간색 배양액 bfs
        while (rqsize--)
        {
            x = rq.front().first;
            y = rq.front().second;
            rq.pop();

            for (int k = 0; k < 4; k++)
            {
                nx = x + dx[k];
                ny = y + dy[k];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                // 방문체크
                if (rtime[nx][ny] != -1)
                    continue;
                // 호수인지 체크
                if (map[nx][ny] == 0)
                    continue;

                if (gtime[nx][ny] == -1)
                {
                    // 초록색 배양액이 있는지 체크
                    rtime[nx][ny] = rtime[x][y] + 1;
                    rq.push(make_pair(nx, ny));
                }
                else if (gtime[nx][ny] == rtime[x][y] + 1)
                {
                    // 초록색 배양액이 있지만 동시에 도착한다면

                    // 꽃이 핀다.
                    flower[nx][ny] = true;
                    rtime[nx][ny] = rtime[x][y] + 1;

                    // 꽃의 개수 증가
                    fcnt++;
                }
            }
        }
    }

    // 피울 수 있는 꽃의 최대개수를 저장
    if (ans < fcnt)
        ans = fcnt;
}

void select(int index, int gcnt, int rcnt)
{
    // 남은 배양액의 수가 남아있는 배양액을 뿌릴 수 있는 땅보다 많으면 안된다(배양액을 남김없이 사용해야 하므로)
    if (gcnt + rcnt > (brownSoilSize - index))
        return;
    if (gcnt == 0 && rcnt == 0)
    {
        // 배양액을 모두 골랐다면 bfs로 배양액을 뿌려준다.
        bfs();
        return;
    }
    if (index == brownSoilSize)
        return;

    int x = brownSoil[index].first;
    int y = brownSoil[index].second;

    // index번째 땅에 배양액을 뿌리지 않는 경우
    select(index + 1, gcnt, rcnt);

    // index번째 땅에 초록색 배양액을 뿌리는 경우
    if (gcnt > 0)
    {
        green.push_back(make_pair(x, y));
        select(index + 1, gcnt - 1, rcnt);
        green.pop_back();
    }

    // index번째 땅에 빨간색 배양액을 뿌리는 경우
    if (rcnt > 0)
    {
        red.push_back(make_pair(x, y));
        select(index + 1, gcnt, rcnt - 1);
        red.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    ans = 0;
    cin >> n >> m >> g >> r;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> map[i][j];
            // 배양액을 뿌릴 수 있는 땅이면 벡터에 넣어놓는다.
            if (map[i][j] == 2)
                brownSoil.push_back(make_pair(i, j));
        }
    }

    brownSoilSize = brownSoil.size();
    select(0, g, r);

    cout << ans << '\n';

    return 0;
}
