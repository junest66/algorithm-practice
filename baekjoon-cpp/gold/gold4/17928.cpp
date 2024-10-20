#include <iostream>
#include <stack>
using namespace std;
stack<int> s;
int n;
int arr[1000001];
int ans[1000001];
int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++) cin >> arr[i];
    for(int i=n-1; i>=0; i--) {
       while(!s.empty() && arr[i] >= s.top()) s.pop();
       if(s.empty()) ans[i] = -1;
       else ans[i] = s.top();
       s.push(arr[i]);
    }
    for(int i=0; i<n; i++) cout << ans[i]<< " ";
    return 0;
}