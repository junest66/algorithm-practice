#include <iostream>
using namespace std;

int main() {
    ios:: sync_with_stdio(0);
    cin.tie(0);
    int n, a;
    int min = 1000001;
    int max = -1000001;
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> a;
        if(a < min) min = a;
        if( a > max) max = a;
    }
    cout << min << " " << max;
}