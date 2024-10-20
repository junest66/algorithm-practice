#include <algorithm>
#include <iostream>
using namespace std;

int n, m;
int d[101][101];
const int INF = 0x3f3f3f3f;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for(int i=1; i<=n; i++)
        fill(d[i], d[i]+1+n, INF);
    while (m--) {
        int st, en, w;
        cin >> st >> en >> w;
        d[st][en] = min(d[st][en], w);
    }
    for(int i = 1; i <= n; i++) {
        d[i][i] = 0;
    }
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (d[i][j] != INF) cout << d[i][j] << " ";
            else cout << 0 << " ";
        }
        cout << '\n';
    }
}

// #include <iostream>
// #include <algorithm>
// using namespace std;

// const int INF = 0x3f3f3f3f;
// int d[105][105];
// int n,m;
// int main() {
//     ios::sync_with_stdio(0);
//     cin.tie(0);

//     cin >> n >> m;
//     for(int i=1; i<=n; i++)
//         fill(d[i], d[i]+1+n, INF);
//     while(m--) { //간선 입력 받기
//         int a,b,c;
//         cin >> a >> b >> c;
//         d[a][b] = min(d[a][b], c);
//     }
//     for(int i=1; i<=n; i++) d[i][i] = 0; //자기 자신으로 가는 비용 0으로
//     for(int k=1; k<=n; k++) { // 거쳐갈 정점
//         for(int i=1; i<=n; i++) {
//             for(int j=1; j<=n; j++) {
//                  if(d[i][k] + d[k][j] < d[i][j]) d[i][j] = d[i][k] + d[k][j];
//             }
//         }
//     }
//     for(int i=1; i<=n; i++) {
//         for(int j=1; j<=n; j++) {
//             if(d[i][j] == INF) cout << "0 ";
//             else cout << d[i][j] << " ";
//         }
//         cout << '\n';
//     }

// }