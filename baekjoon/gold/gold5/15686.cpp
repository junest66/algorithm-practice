#include <iostream>
#include <vector>
#include <utility>
#include <cstdlib>
#include <limits.h>
#include <numeric>
using namespace std;

int n,m;
vector<int> visited(14, 0);
vector<pair<int,int>> home;
vector<pair<int,int>> chicken;
vector<vector<int>> dist(14);
int ans = INT_MAX;

void func(int start, int k) {
    if(k == m) {
        vector<int> minValue(home.size() + 1, INT_MAX);
        for(int i = 0; i < visited.size(); i++) {
            if(visited[i] == 1) {
                for(int j = 0; j < minValue.size(); j++) {
                    minValue[j] = min(minValue[j],dist[i][j]);
                }
            }
        }
        ans = min(ans, accumulate(minValue.begin(), minValue.end(), 0));
        return;
    }
    for(int i = start; i < chicken.size(); i++) {
        if(!visited[i]) {
            visited[i] = 1;
            func(i+1, k+1);
            visited[i] = 0;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            int a;
            cin >> a;
            if(a == 1) {
                home.push_back({i,j});
            }
            else if(a == 2) {
                chicken.push_back({i,j});
            }
        }
    }
    for(int i = 0; i < chicken.size(); i++) { //dist[i][j]  i:치킨집번호, j: 집 번호 
        for(auto y : home) {
            int xabs = abs(chicken[i].first - y.first);
            int yabs = abs(chicken[i].second - y.second);
            dist[i].push_back(xabs + yabs);
        }
    }
    func(0,0);
    cout << ans;
    return 0;
}

// #include <cstdlib>
// #include <iostream>
// #include <utility>
// #include <vector>
// #include <limits.h>
// #include <numeric>
// #include <algorithm>
// using namespace std;

// vector<pair<int, int>> chicken;
// vector<pair<int, int>> home;
// int dist[14][101];
// int n, m;
// int ans = INT_MAX;

// int main() {
//     ios::sync_with_stdio(0);
//     cin.tie(0);
//     cin >> n >> m;
//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < n; j++) {
//             int a;
//             cin >> a;
//             if (a == 1) {
//                 home.push_back({i, j});
//             } else if (a == 2) {
//                 chicken.push_back({i, j});
//             }
//         }
//     }
//     for (int i = 0; i < chicken.size(); i++) {
//         for (int j = 0; j < home.size(); j++) {
//             dist[i][j] = abs(chicken[i].first - home[j].first) + abs(chicken[i].second - home[j].second);
//         }
//     }
//     vector<int> vec(chicken.size());
//     for(int i = 0; i < vec.size(); i++) {
//         vec[i] = i;
//     }
//     vector<int> combination(chicken.size(), 1);
//     for (int i = 0; i < m; i++) {
//         combination[i] = 0;
//     }

//     do {
//         vector<int> minValue(home.size(), INT_MAX);
//         for(int i = 0; i < vec.size(); i++) {
//             if(combination[i] == 0) {
//                 for(int j = 0; j < home.size(); j++) {
//                     minValue[j] = min(minValue[j], dist[vec[i]][j]);
//                 }
//             }
//         }
//         ans = min(accumulate(minValue.begin(), minValue.end(), 0), ans);
//     } while(next_permutation(combination.begin(), combination.end()));
//     cout << ans;
//     return 0;
// }