#include <iostream>
using namespace std;
int n;

void func(int n, int a, int b) {
    if(n==1) {
        cout << "*";
    }
    else if (a / (n / 3) % 3 == 1 && b / (n / 3) % 3 == 1) {
        cout << " ";
    }
    else func(n/3,a,b);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            func(n,i,j);
        }
        cout << "\n";
    }
    
}