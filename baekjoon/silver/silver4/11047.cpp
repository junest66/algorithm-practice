#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int arr[10] = {};
    int n,k;
    int count =0;
    cin >> n >> k;
    for(int i=0; i<n; i++)
        cin >> arr[i];
    for(int i=n; i>0; i--) {
        count += k / arr[i-1];
        k = k % arr[i-1];
    }
    cout << count;
    return 0;
}