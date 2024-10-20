#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;

int n;
int home[17][17];
int dx[3] = {1, 0, 1};
int dy[3] = {0, 1, 1};
int answer = 0;

void dfs(int curX, int curY, int curDir) {
    if (curX == n && curY == n) {
        answer++;
        return;
    }
    for (int i = 0; i < 3; i++) {
        int nextX = curX + dx[i];
        int nextY = curY + dy[i];
        if (nextX < 0 || nextY < 0 || nextX > n || nextY > n || home[nextX][nextY]) continue;
        if (curDir == 0 && i == 1 || curDir == 1 && i == 0) continue;
        if (i == 2 && (home[nextX - 1][nextY] || home[nextX][nextY - 1])) continue;
        dfs(nextX, nextY, i);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> home[i][j];
        }
    }
    dfs(1, 2, 1);
    cout << answer;

    return 0;
}

// bfs 방법

// int main() {
//     ios::sync_with_stdio(0);
//     cin.tie(0);

//     cin >> n;
//     for (int i = 1; i <= n; i++) {
//         for (int j = 1; j <= n; j++) {
//             cin >> home[i][j];
//         }
//     }
//     queue<pair<pair<int, int>, int>> que;
//     que.push({{1, 2}, 1});
//     while (!que.empty()) {
//         auto cur = que.front();
//         que.pop();
//         int curX = cur.first.first;
//         int curY = cur.first.second;
//         if(curX == n && curY == n) {
//             answer++;
//             continue;
//         }
//         int curNumber = cur.second;
//         for (int i = 0; i < 3; i++) {
//             int nextX = curX + dx[i];
//             int nextY = curY + dy[i];
//             if (nextX < 0 || nextY < 0 || nextX > n || nextY > n) continue;
//             if (home[nextX][nextY]) continue;
//             if (curNumber == 0 && i == 1) continue;
//             if (curNumber == 1 && i == 0) continue;
//             if (i == 2 && (home[nextX][nextY] || home[nextX - 1][nextY] || home[nextX][nextY - 1])) continue;
//             que.push({{nextX, nextY}, i});
//         }
//     }

//     cout << answer;
//     return 0;
// }