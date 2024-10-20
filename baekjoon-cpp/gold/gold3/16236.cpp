#include <string.h>
#include <algorithm>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

struct fish {
    int time;
    int x;
    int y;
};

struct cmp {
    bool operator()(fish a, fish b) {
        if (a.time == b.time) {
            if (a.x == b.x) {
                return a.y > b.y;
            }
            return a.x > b.x;
        }
        return a.time > b.time;
    }
};

class Shark {
   public:
    int size;
    int eat_num;

    Shark() : size(2), eat_num(0) {}

    void eat();
};

void Shark::eat() {
    eat_num++;
    if (eat_num == size) {
        eat_num = 0;
        size++;
    }
}

int n;
int space[21][21];
int dx[4] = {-1, 0, 0, 1};
int dy[4] = {0, -1, 1, 0};
int visited[21][21];
int answer;
Shark shark;

void eat_fish_bfs(pair<int, int> start) {
    queue<fish> q;
    q.push({0, start.first, start.second});

    while (true) {
        priority_queue<fish, vector<fish>, cmp> pq;

        while (!q.empty()) {
            int curx = q.front().x;
            int cury = q.front().y;
            int curt = q.front().time;
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (space[nx][ny] > shark.size || visited[nx][ny]) continue;
                q.push({curt + 1, nx, ny});
                visited[nx][ny] = true;

                if (space[nx][ny] < shark.size && space[nx][ny] != 0) {
                    pq.push({curt + 1, nx, ny});
                }
            }
        }
        memset(visited, false, sizeof(visited));
        if (!pq.empty()) {  // 먹을 물고기 남아 있다면
            int fishX = pq.top().x;
            int fishY = pq.top().y;
            int fishT = pq.top().time;
            pq.pop();
            shark.eat();
            space[fishX][fishY] = 0;
            answer += fishT;
            q.push({0, fishX, fishY});
            visited[fishX][fishY] = true;
        } else {
            cout << answer << '\n';
            break;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    pair<int, int> start;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> space[i][j];
            if (space[i][j] == 9) {
                start = {i, j};
                space[i][j] = 0;
                visited[i][j] = true;
            }
        }
    }

    eat_fish_bfs(start);

    return 0;
}