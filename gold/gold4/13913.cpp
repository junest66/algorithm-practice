#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;
int n,k;
int arr[100002];
queue<int> que;
vector<int> vec;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    memset(arr,-1,sizeof(arr));
    cin >> n >> k;
    que.push(n);
    arr[n] = n;
    while(!que.empty()) {
        int cur = que.front();
        que.pop();
        if(cur == k) {
            int temp = cur;
            while(temp != n) {
                vec.push_back(temp);
                temp = arr[temp];
            }
            vec.push_back(n);
            break;
        }
        int nx = cur + 1;
        int ny = cur - 1;
        int nz = cur * 2;
        if(nx >= 0 && nx <= 100000 && arr[nx] == -1) {
            que.push(nx);
            arr[nx] = cur;
        }
        if(ny >= 0 && ny <= 100000 && arr[ny] == -1) {
            que.push(ny);
            arr[ny] = cur;
        }
        if(nz >= 0 && nz <= 100000 && arr[nz] == -1) {
            que.push(nz);
            arr[nz] = cur;
        }
    }
    cout << vec.size()-1 << '\n';
    for(int i=vec.size()-1; i>=0; i--) {
        cout << vec[i] << " ";
    }
    

}