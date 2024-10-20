#include <iostream>
#include <queue>
#include <utility>
using namespace std;

long long a, b;
int ans;
queue<pair<int, long long>> que;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> a >> b;
    que.push({1, a});
    while(!que.empty()) {
        auto current = que.front();
        que.pop();
        int currentCount = current.first;
        long long currentNum = current.second;
        if(currentNum == b) {
            ans = currentCount;
        }
        if(currentNum * 2 <= b) {
            que.push({currentCount+1 , currentNum * 2});
        }
        if(currentNum * 10 + 1 <= b) {
            que.push({currentCount+1 , currentNum * 10 +1});
        }
    }
    if(ans == 0) cout << -1 << "\n";
    else cout << ans << '\n';

}