#include <iostream>
using namespace std;

int n,m;
int arr[10];
bool vis[10];

void func(int k, int pre) {
    if(k==m) {
        for(int i=0; i< m; i++) {
            cout << arr[i] << " ";
        }
        cout << '\n';
        return;
    }
    for(int i=1; i<= n; i++) {
        if(!vis[i] && pre < i) {
            arr[k] = i;
            vis[i] = true;
            func(k+1, arr[k]);5
            vis[i] = false;
        }
    }
    
    
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    func(0,0);
}