#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> vec;
    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        int a;
        cin >> a;
        vec.push_back(a);
    }
    sort(vec.begin(),vec.end(), greater<>());
    for(auto e : vec) cout<< e << '\n';

}