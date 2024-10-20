#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> vec;
int vis[10];
int arr[10];
int n,m;

void func(int k) {
    if(k==m) {
        for(int i=0; i<m; i++) {
            cout << arr[i] << " ";
        }
        cout << '\n';
        return;
    }
    for(int i=0; i<n; i++) {
        if(!vis[i]) {
        arr[k] = vec[i];
        vis[i] = true;
        func(k+1);
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
    func(0);
}