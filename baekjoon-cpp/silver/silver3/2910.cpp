//숫자가 10억이 넘어가므로 카운팅정렬 사용 X 

#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

bool cmp(const pair<int,int> &a, const pair<int, int> &b) {
    return a.second > b.second;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    vector<pair<int, int>> vec;
    for(int i=0; i<n; i++) {
        int a;
        cin >> a;
        bool search = false;
        if(!vec.empty()) {
            for(int j=0; j<vec.size(); j++) {
                if(a== vec[j].first) {
                    vec[j].second++;
                    search = true;
                    break;
                }
            }
            if(!search) vec.push_back({a,1});
        }
        else vec.push_back({a,1});
    }
    stable_sort(vec.begin(),vec.end(), cmp);
    for(int i=0; i<vec.size(); i++) {
        for(int j=0; j<vec[i].second; j++) {
            cout << vec[i].first << '\n';
        }
    }

}