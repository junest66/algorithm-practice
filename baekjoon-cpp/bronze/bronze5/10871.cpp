#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n, m, a, i;
    int count = 0;
    int arr[10000];
    cin >> n >> m;
   for(i=0; i<n; i++) {
        cin >> a;
        if(a < m) arr[count++] = a;
    }
    for(i=0; i<count;i++) {
        cout << arr[i] << " ";
    }
}