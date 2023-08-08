#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    vector<long long> vec;
    for(int i=0; i<n; i++) {
        string a;
        cin >> a;
        reverse(a.begin(),a.end());
        vec.push_back(stoll(a));
    }
    sort(vec.begin(),vec.end());
    for(auto e: vec) cout<< e << '\n';

}