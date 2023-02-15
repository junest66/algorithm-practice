#include <iostream>
#include <utility>
#include <queue>
using namespace std;
int height, now, goal, up, down;
int arr[1000002];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> height >> now >> goal >> up >> down;
    queue<int> que;
    bool suc = false;
    int ans = 1;
    que.push(now);
    arr[now] = ans;
    while (!que.empty())
    {
        int cur = que.front();
        que.pop();
        if (cur == goal)
        {
            suc = true;
            break;
        }
        int ubtn = cur + up;
        int dbtn = cur - down;
        if (ubtn <= height && arr[ubtn] == 0)
        {
            que.push(ubtn);
            arr[ubtn] = arr[cur] + 1;
        }
        if (dbtn >= 1 && arr[dbtn] == 0)
        {
           que.push(dbtn);
            arr[dbtn] = arr[cur] + 1;
        }
    }
    if (suc)
        cout << arr[goal] -1;
    else
        cout << "use the stairs";
}