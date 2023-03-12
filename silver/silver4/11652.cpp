#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

long long arr[100001];
long long ans;
int maxans = 1;
int cnt = 1;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for(int i=0; i<n; i++)
        cin >> arr[i];
    sort(arr, arr+n);
    ans = arr[0];
    for(int i = 1; i < n; i++){
        if(arr[i] == arr[i-1])
            cnt++;
        else cnt = 1;
        
        if(maxans < cnt){
            maxans = cnt;
            ans = arr[i];
        }
    }
    
    cout << ans << '\n';
}