#include <iostream>
#include <string>
using namespace std;
int board[64][64];

bool check(int n, int y, int x) {
    int temp = board[y][x];
    for(int i=y; i<y+n; i++) {
        for(int j=x; j<x+n; j++) {
            if(temp!=board[i][j]) return false;
        }
    }
    cout << temp;
    return true;
}

void func(int n, int y, int x) {
   if(n==1) {
      cout<< board[y][x];
      return;
   }
   if(check(n,y,x)) return;
   else {
        int half = n /2 ;
        cout << "(";
        func(half,y,x);
        func(half,y, x+half);
        func(half,y+half,x);
        func(half,y+half, x+half);
        cout << ")";
   }

}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        string str;
        cin >> str;
        for(int j =0; j<n; j++) {
            board[i][j] = str[j] - '0';
        }
    }
    func(n, 0, 0);
}