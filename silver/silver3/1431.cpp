#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

vector<string> vec;

bool cmp(string &a, string &b) {
    if(a.size() < b.size()) return true;
    else if (a.size() == b.size()) {
        int anum = 0;
        int bnum = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a[i] >= '1' && a[i] <= '9')
                anum =  anum + a[i] - '0';
        } 
        for (int i = 0; i < b.size(); i++) {
            if (b[i] >= '1' && b[i] <= '9')
                bnum = bnum + b[i] - '0';
        }
        if(anum != bnum) return anum < bnum;
        else  return a < b;
    }
    return false;
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string a;
        cin >> a;
        vec.push_back(a);
    }
    sort(vec.begin(), vec.end(), cmp);
    for (int i = 0; i < n; i++)
        cout << vec[i] << '\n';
}