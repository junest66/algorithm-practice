#include <iostream>
#include <algorithm>
using namespace std;

int n,m;
char alpha[16];
char arr[16];
bool isused[26];

void func(int k, char pos) {
    if(k==n) {
        int vow = 0; //모음
        int cons = 0; //자음
        for(int i=0; i<n; i++) {
            if(arr[i]== 'a' || arr[i] == 'i' || arr[i] == 'e' || arr[i] == 'o' || arr[i] == 'u') ++vow;
            else ++cons;
        }
        if(vow> 0 && cons > 1) {
            for(int i=0; i<n; i++) {
                cout << arr[i];
            }
            cout << '\n';
            return;
        }
        return;
    }
    for(int i=0; i<m; i++) {
        if(!isused[i] && pos < alpha[i]) {
            isused[i] = true;
            arr[k] = alpha[i];
            func(k+1, arr[k]);
            isused[i] = false;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int i=0; i<m; i++)
        cin >> alpha[i];
    sort(alpha,alpha+m);
    func(0, '0');

}