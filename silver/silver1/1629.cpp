#include <iostream>
using namespace std;

long long func(int a, int b, int m) {
    if(b == 1) return a%m;
    long long val = func(a,b/2,m);
    val =val * val % m;
    if(b%2) return val * a % m;
    else return val;
}

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    long long a, b, m;
    cin >> a >> b >> m;
    cout << func(a,b,m);
    return 0;

}