#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct score
{
    string name;
    int korean;
    int english;
    int math;
};

bool cmp(score a, score b) {
    if(a.korean > b.korean) return true;
    else if( a.korean == b.korean) {
        if(a.english < b.english) return true;
        else if(a.english == b.english) {
            if( a.math > b.math) return true;
            else if(a.math == b.math) {
                return a.name < b.name;
            }
        }
    }
    return false;

}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<score> vec;
    int n;
    cin >> n;
    score a;
    for(int i=0; i<n; i++) {
        cin >> a.name >> a.korean >> a.english >> a.math;
        vec.push_back(a);
    }
    sort(vec.begin(),vec.end(), cmp);
    for(auto e : vec) cout << e.name << '\n';
    

}