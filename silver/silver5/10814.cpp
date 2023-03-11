#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;

bool compare(pair<int,string> a, pair<int,string> b) {
    return a.first < b.first;
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    pair<int,string> pr;
    vector<pair<int,string>> vec;

    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
       cin >> pr.first >> pr.second;
       vec.push_back(pr);
    }

    stable_sort(vec.begin(),vec.end(), compare);
    for(int i=0; i<n; i++) {
       cout << vec[i].first << " " << vec[i].second << '\n';
    }
}