#include <iostream>
using namespace std;

int arr[1025][1025];
int sum[1025][1025];
int n,m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); 
    cin >> n >> m;

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            cin >> arr[i][j];
            sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
        }
    }
    int x1,y1,x2,y2;
    for(int i=1; i<=m; i++) {
        cin >> x1 >> y1  >> x2 >> y2;
        int ans = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
        cout<< ans<< '\n';
    }

    return 0;
}