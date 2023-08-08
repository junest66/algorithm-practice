#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

vector<string> vec;

bool cmp(string a, string b) {
    if(a.size() == b.size()) return  a < b;
    return a.size() < b.size();
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
        string a;
        cin >> a;
        vec.push_back(a);
    }
    sort(vec.begin(),vec.end(),cmp);
    cout << vec[0] << '\n';
    for(int i=1; i<n; i++) {
        if(vec[i] != vec[i-1]) cout << vec[i] << '\n';
    }

}
