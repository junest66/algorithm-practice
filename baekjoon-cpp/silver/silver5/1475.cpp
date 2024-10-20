#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int a;
    int max = 0;
    int arr[10] = {};
    cin >> a;
    while(a!=0) {
        int n = a % 10;
        arr[n]++;
        a/=10;
    }
    int n = (arr[6] + arr[9] + 1) / 2;
    arr[6] = n;
    arr[9] = n;
    for(int i=0; i<10; i++) {
        if(max<arr[i]) max = arr[i];
    }
    cout << max;
    return 0;
}

