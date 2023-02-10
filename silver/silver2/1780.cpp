#include <iostream>
using namespace std;

int arr[2200][2200];
int ans[3];  //-1, 0 , 1 갯수 
bool check(int x, int y, int n) { //다 같은 숫자로 된 종이 인지 확인 하는 함수
    for(int i=x; i<x+n; i++) {
        for(int j=y; j<y+n; j++) {
            if(arr[x][y] != arr[i][j]) return false;
        }
    }
    return true;
}

void func(int x, int y, int n) {
    if(check(x,y,n)) {
        ans[arr[x][y] + 1]++;
        return;
    }
    int z = n / 3;
    for(int i=0; i< 3; i++)
        for(int j=0; j<3; j++)
            func(x+i*z,y+j*z, z);
}

int main() {
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> arr[i][j];
        }
    }
    func(0,0,n);
    for(int i=0; i<3; i++) {
        cout << ans[i]<< '\n';
    }

}