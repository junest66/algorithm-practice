#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> vec;
int vis[10];
int arr[10];
int n,m;

void func(int k, int pre) {
    if(k==m) {
        for(int i=0; i<m; i++) {
            cout << vec[arr[i]-1] << " ";
        }
        cout << '\n';
        return;
    }
    for(int i=1; i<=n; i++) {
        if(!vis[i] && pre < i) {
        arr[k] = i;
        vis[i] = true;
        func(k+1, arr[k]);
        vis[i] = false;
        }
    }

}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int a;
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> a;
        vec.push_back(a);   
    }
    sort(vec.begin(), vec.end());
    func(0,0);
}