#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;

bool compare(pair<int,int> a, pair<int,int> b) {
    
    if(a.first < b.first) return true;
    else if(a.first == b.first) {
        return a.second < b.second;
    }
    return false;
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    pair<int,int> pr;
    vector<pair<int,int>> vec;

    int n;
    cin >> n;
    for(int i=0; i<n; i++) {
       cin >> pr.first >> pr.second;
       vec.push_back(pr);
    }

    sort(vec.begin(),vec.end(), compare);
    for(int i=0; i<n; i++) {
       cout << vec[i].first << " " << vec[i].second << '\n';
    }
}