#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
#include <set>
using namespace std;

int n, k;
int visited[100001];
int dx[3] = {1, -1, 2};
queue<pair<int, int>> que;
multiset<int> ans;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> k;
    que.push({0, n});
    while(!que.empty()) {
        auto current = que.front();
        int currentTime = current.first;
        int currentPos = current.second;
        que.pop();
        if(visited[currentPos] && visited[currentPos] < currentTime) {
            continue;
        }
        for(int i = 0 ; i < 3; i++) {
            int next;
            if(i == 2) {
                next = currentPos * dx[i];
            } else {
                next = currentPos + dx[i];
            }
            if(next < 0 || next > 100000) continue;
            que.push({currentTime+1, next});
            visited[currentPos] = currentTime;
        }
        if(currentPos == k) {
            ans.insert(currentTime);
        }
    }
    int firstValue = *(ans.begin());
    cout << firstValue << "\n";
    cout << ans.count(firstValue);
    return 0;
}