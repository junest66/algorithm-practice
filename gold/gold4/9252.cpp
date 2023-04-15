#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

string a, b;
int C[1001][1001];
int trace[1001][1001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> a >> b;

    int n = a.length();
    int m = b.length();

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            if(a[i-1]== b[j-1]) {
                C[i][j] = C[i-1][j-1] + 1;
                trace[i][j] = 1;
            }
            else {
                if(C[i-1][j] > C[i][j-1]) {
                    C[i][j] = C[i-1][j];
                    trace[i][j] = 2;
                }
                else {
                    C[i][j] = C[i][j-1];
                    trace[i][j] = 3;
                }
            }
        }
    }
    cout << C[n][m] << '\n';
    string ans = "";
    while(n>0 && m>0) {
        if(trace[n][m] == 1) {
            ans += a[n-1];
            n--;
            m--;
        }
        else if(trace[n][m] == 2) {
            n--;
        }
        else if(trace[n][m] == 3) {
            m--;
        }
    }
    reverse(ans.begin(), ans.end());
    cout << ans;
    
}