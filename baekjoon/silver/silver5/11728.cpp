#include <iostream>
using namespace std;
int arr1[1000001];
int arr2[1000001];
int arr3[2000002];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n,m;
    cin >> n >> m;
    for(int i=0; i<n; i++) cin >> arr1[i];
    for(int i=0; i<m; i++) cin >> arr2[i];

    int aidx = 0;
    int bidx = 0;

    for(int i=0; i<n+m; i++) { 
        if(aidx == n) arr3[i] = arr2[bidx++]; 
        else if(bidx == m) arr3[i] = arr1[aidx++];
        else if(arr1[aidx] <= arr2[bidx]) {
            arr3[i] = arr1[aidx++];
        }
        else arr3[i] = arr2[bidx++];
    }
    for(int i=0; i< n+m; i++) {
        cout << arr3[i] << " ";
    }

}