#include <iostream>
using namespace std;

int n,m;
int arr[10];
bool check[10];

void func(int k) {
    if(k==m) {
        for(int i=0; i< m; i++) {
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i=1; i<=n; i++) {
        if(!check[i]) {
            arr[k] = i;
            check[i] = true;
            func(k+1);
            check[i] = false;
        }
    }

}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    func(0);

}