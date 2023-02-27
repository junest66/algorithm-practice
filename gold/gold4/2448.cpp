#include <iostream>
using namespace std;

char map[3072][6144];

void func(int x, int y, int n) {
    if(n==3) {
        map[x][y] = '*';
        map[x+1][y-1] = '*';
        map[x+1][y+1] = '*';
        for(int i=0; i<5; i++) {
            map[x+2][y-2+i] = '*';
        }
        return;
    }
    else {
        func(x,y,n/2);
        func(x+n/2,y-n/2,n/2);
        func(x+n/2,y+n/2,n/2);
    }
}

int main() {
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<2*n-1; j++) {
            map[i][j] = ' ';
        }
    }
    func(0,n-1,n);
    for(int i=0; i<n; i++) {
        for(int j=0; j<2*n-1; j++) {
            cout << map[i][j];
        }
        cout << '\n';
    }
}