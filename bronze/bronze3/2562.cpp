#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);

    int max=0;
    int input;
    int n;
    for(int i=1; i<=9; i++) {
        cin >> input;
        if(max<input) {
            max = input;
            n = i;
        } 
    }
    cout << max << '\n' << n;
}