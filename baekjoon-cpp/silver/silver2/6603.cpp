#include <iostream>
using namespace std;

int n;
int num[50];
bool isused[50];
int arr[6];

void func(int m, int k, int pos) {
    if(k==6) {
        for(int i=0; i<6; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for(int i=0; i<m; i++) {
        if(!isused[i] && pos < num[i]) {
            isused[i] = true;
            arr[k] = num[i];
            func(m,k+1, arr[k]);
            isused[i] = false;
        }
    }

}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    while(1) {
        cin >> n;
        if(n==0) {
            return 0;
        }
        fill(num,num+50,0);
        fill(arr,arr+6,0);
        fill(isused,isused+50,false);
        for(int i=0; i<n; i++)
            cin >> num[i];
        func(n,0,0);
        cout << '\n';
    }

}