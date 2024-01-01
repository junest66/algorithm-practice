#include <iostream>
#include <vector>
#include <utility>
using namespace std;

int n, m, t;
int arr[51][51];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
vector<pair<int,int>> purity;


void diffusion() {
    vector<vector<int>> vec(n+1, vector<int> (m+1, 0));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (arr[i][j] == -1) continue;
            int amount = arr[i][j] / 5;
            int count = 0;
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                if (arr[nx][ny] == -1) continue;
                vec[nx][ny] += amount;
                count++;
            }
            vec[i][j] = vec[i][j] - amount * count;
        }
    }
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            arr[i][j] += vec[i][j];
        }
    }
}

void clean() {
    pair<int,int> firstPos = purity[0];
    pair<int,int> secondPos = purity[1];
    int firstY = firstPos.first;
    int secondY = secondPos.first;
    for(int i = firstY -1; i >= 1; i--) { // 1행 1열
        if(arr[i + 1][1] == -1) {
            continue;
        }
        arr[i+1][1] = arr[i][1];
    }

    for(int i = 2; i <= m; i++) {
        arr[1][i-1] = arr[1][i];
    }

    for(int i = 2; i <= firstY; i++) {
        arr[i-1][m] = arr[i][m];
    }

    for(int i = m - 1; i >= 1; i--) {
        if(i == 1) {
            arr[firstY][2] = 0;
            continue;
        }
        arr[firstY][i + 1] = arr[firstY][i];
    }

    //second
    for(int i = secondY + 1; i <= n; i++) {
        if(arr[i-1][1] == -1) {
            continue;
        }
        arr[i-1][1] = arr[i][1];
    }

    for(int i = 2; i <= m; i++) {
        arr[n][i-1] = arr[n][i];
    }

    for(int i = n-1; i >= secondY; i--) {
        arr[i+1][m] = arr[i][m];
    }

    for(int i = m - 1; i >= 1; i--) {
        if(i == 1) {
            arr[secondY][2] = 0;
            continue;
        }
        arr[secondY][i + 1] = arr[secondY][i];
    }


}

int printResult() {
    int answer = 0;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if(arr[i][j] != -1) answer += arr[i][j];
        }
    } 
    return answer;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m >> t;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> arr[i][j];
            if(arr[i][j] == -1) {
                purity.push_back(make_pair(i,j));
            }
        }
    }

    for (int i = 0; i < t; i++) {
        diffusion();
        clean();
    }

    cout << printResult();

    return 0;
}