#include <algorithm>
#include <iostream>
using namespace std;

char board[21][21];
int arr[26];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int r, c;
int ans;

void func(int x, int y, int count) {
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
        if(!arr[board[nx][ny] - 'A']) {
            arr[board[nx][ny] - 'A'] = 1;
            func(nx,ny,count+1);
            arr[board[nx][ny] - 'A'] = 0;
        }
    }
    ans = max(count, ans);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> r >> c;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> board[i][j];
        }
    }
    arr[board[0][0] - 'A'] = 1;
    func(0, 0, 1);
    cout << ans;
}