#include <iostream>
#include <algorithm>
using namespace std;

int n,m;
int k;
int num[8];
int arr[8];
bool isused[10];

void func(int k) {
    if(k == m) {
        for(int i=0; i<m; i++) {
            cout << arr[i] << " ";
        }
        cout << '\n';
        return;
    }
    int temp = 0;
    for(int i=0; i<n; i++) {
        if(!isused[i] && temp != num[i]) {
            arr[k] = num[i];
            temp = arr[k];
            func(k+1);
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> num[i];
    }
    sort(num,num+n);
    func(0);

}