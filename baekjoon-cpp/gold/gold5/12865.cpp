#include <iostream>
#include <algorithm>
using namespace std;

int w[101];
int v[101];
int d[101][100001];
int n,k;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    for(int i=1; i<=n; i++) {
        cin >> w[i] >> v[i];
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=k; j++) {
            if(j>=w[i]) {//물건이 들어가는 경우 
                d[i][j] = max(d[i-1][j], d[i-1][j-w[i]]+ v[i]);  //물건을 넣는 경우와 넣지않은 경우중 큰걸 선택
            }
            else {
                d[i][j] = d[i-1][j];
            }
        }
    } 
    cout << d[n][k];
    
}