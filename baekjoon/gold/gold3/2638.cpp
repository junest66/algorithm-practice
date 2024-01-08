#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

int arr[101][101];
int vec[101][101];
int visited[101][101];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int n, m;
int answer;
vector<pair<int, int>> cheese;
queue<pair<int, int>> que;
int eraseNum;


void initVisit() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            visited[i][j] = 0;
        }
    }
}

void bfs() {
    initVisit();
    que.push(make_pair(0, 0));
    visited[0][0] = 1;
    while (!que.empty()) {  // 공기업데이트
        auto cur = que.front();
        que.pop();
        vec[cur.first][cur.second] = -1;  // 공기라는 뜻~
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (arr[nx][ny] || visited[nx][ny]) continue;
            que.push(make_pair(nx, ny));
            visited[nx][ny] = 1;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) {
                cheese.push_back(make_pair(i, j));
            }
        }
    }
    int cheeseNum = cheese.size();

    while (cheeseNum != eraseNum) {
        answer++;
        bfs();
        for(int i = 0; i < cheese.size(); i++) {
        }
        for (int i = cheese.size() - 1; i >= 0; --i) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nx = cheese[i].first + dx[j];
                int ny = cheese[i].second + dy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (vec[nx][ny] == -1) {
                    count++;
                }
            }
            if (count >= 2) {
                arr[cheese[i].first][cheese[i].second] = 0;
                cheese.erase(cheese.begin() + i);
                eraseNum++;
            }
        }
    }

    cout << answer;
    return 0;
}