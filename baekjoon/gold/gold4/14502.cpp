#include <cstring>
#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
int arr[9][9];
int copyArr[9][9];
int visited[9][9];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
vector<pair<int, int>> virus;
vector<pair<int, int>> emptyPlace;
int ans = 0;

void playVirus(int xp, int yp) {
    if (visited[xp][yp]) return;
    visited[xp][yp] = 1;
    for (int i = 0; i < 4; i++) {
        int nxp = xp + dx[i];
        int nyp = yp + dy[i];
        if (nxp < 0 || nyp < 0 || nxp >= n || nyp >= m) continue;
        if (copyArr[nxp][nyp] == 1) continue;
        if (visited[nxp][nyp]) continue;
        copyArr[nxp][nyp] = 2;
        playVirus(nxp, nyp);
    }
}

int getAnser() {
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (copyArr[i][j] == 0) count++;
        }
    }
    return count;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 2) {
                virus.push_back({i, j});
            } else if (arr[i][j] == 0) {
                emptyPlace.push_back({i, j});
            }
        }
    }
    vector<int> combination(emptyPlace.size(), 1);
    for (int i = 0; i < 3; i++) {
        combination[i] = 0;
    }
    do {
        memcpy(copyArr, arr, sizeof(copyArr));
        memset(visited, 0, sizeof(visited));
        for (int i = 0; i < emptyPlace.size(); i++) {
            if (combination[i] == 0) {
                copyArr[emptyPlace[i].first][emptyPlace[i].second] = 1;
            }
        }
        for (auto x : virus) {
            playVirus(x.first, x.second);
        }
        ans = max(ans, getAnser());
    } while (next_permutation(combination.begin(), combination.end()));

    cout << ans;

    return 0;
}