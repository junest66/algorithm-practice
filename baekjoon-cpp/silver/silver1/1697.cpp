#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;
int subin[100002];
int main() {
    queue<int> que;
    int n,m;
    cin >> n >> m;
    subin[n] = 1;
    que.push(n);
    while(!que.empty()) {
        int cur = que.front();
        que.pop();
        if(cur == m) {
            cout << subin[cur] - 1;
            return 0;
        }
        if(cur+1 <= 100000 && subin[cur+1] == 0) {
            que.push(cur+1);
            subin[cur+1] = subin[cur] + 1;
        }
        if(cur-1 >=0 && subin[cur-1] == 0) {
            que.push(cur-1);
            subin[cur-1] = subin[cur] + 1;
        }
        if(cur*2 <= 100000 && subin[cur*2] == 0) {
            que.push(cur*2);
            subin[cur*2] = subin[cur] + 1;
        }
    }

}