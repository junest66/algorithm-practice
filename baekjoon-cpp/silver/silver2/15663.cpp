#include <iostream>
#include <algorithm>
using namespace std;

int n,m;
int num[10];
int arr[10];
bool isused[10];


void func(int k) {
    if(k==m) {
        for(int i=0; i<m; i++) {
            cout << arr[i] <<" ";
        }
        cout << '\n';
        return;
    }
    int temp = 0;
    for(int i=0; i<n; i++) {
        if(!isused[i] && temp != num[i]) {   // 이전의 넣었던 수와 이제 넣을 수가 같지 않을때
            isused[i]  = true;
            arr[k] = num[i];
            temp = arr[k];
            func(k+1);
            isused[i] = false;
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