#include <iostream>
using namespace std;

int arr[100001];
int arr1[2000001];
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int count = 0;
    int n,x;
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    cin >> x;
    for(int i=0; i<n; i++) {
        if(x-arr[i] >0 && arr1[x-arr[i]] == 1) count++;
        arr1[arr[i]] = 1;
    }
    cout << count;
    return 0;
}