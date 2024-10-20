#include <iostream>
#include <queue>
#include <utility>
#include <set>
#include <cstring>
using namespace std;

int n,k;
int arr[100001];
int dx[3] = {1, -1 , 2};
set<int> st;
queue<pair<int,int>> que;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> k;
    memset(arr, -1 , sizeof(arr));
    que.push({0, n});
    while(!que.empty()) {
        auto current = que.front();
        que.pop();
        int currentTime = current.first;
        int currentPos = current.second;
        if(arr[currentPos] != -1 && currentTime >= arr[currentPos]) continue;
        if(currentPos == k) {
            st.insert(currentTime);
        }
        arr[currentPos] = currentTime;
        for(int i = 0; i < 3; i++) {
            int nextPos;
            if(i == 2) {
                nextPos = currentPos * dx[i];
                if(nextPos < 0 || nextPos > 100000) continue;
                que.push({currentTime, nextPos});
            } else {
                nextPos = currentPos + dx[i];
                if(nextPos < 0 || nextPos > 100000) continue;
                que.push({currentTime+1, nextPos});
            }
        }
    }
    cout << *(st.begin());
    return 0;
}