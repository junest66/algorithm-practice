#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    while(n--) {
        int a, b;
        int x, y;
        vector<int> va;
        vector<int> vb;
        int count =0;
        cin >> a >> b;
        for(int i=0; i<a; i++) {
            cin >> x;
            va.push_back(x);
        }
        for(int j=0; j<b; j++) {
            cin >> y;
            vb.push_back(y);
        }
        sort(va.begin(),va.end());
        sort(vb.begin(),vb.end());
        for(int i=0; i < a; i++) {
            for(int j=0; j < b; j++) {
                if(va[i] > vb[j]) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        cout << count << '\n';
    }



}