#include <iostream>
#include <queue>
#include <utility>
#include <vector>
using namespace std;
int n;
vector<pair<int, int>> vec;
int ans = 0;
queue<int> que;

void dfs(int k) {
    if(k == n) {
        int crashint = 0;
        for(int i=0; i<n; i++) {
            if(vec[i].first <=0) crashint++;
        }
        ans = max(ans,crashint);
        return;
    }
    if(vec[k].first <= 0) dfs(k+1);
    else {
        bool crashflag = false;
        for(int i=0; i<n; i++) {
            if(i==k || vec[i].first <= 0) continue; //i가 집어든 계란이거나 이미 깨져있는 계란 일경우 넘어감
            vec[i].first -= vec[k].second;
            vec[k].first -= vec[i].second;  //i 계란과 집어든 계란과 서로 때림
            crashflag = true;
            dfs(k+1);
            vec[i].first += vec[k].second;
            vec[k].first += vec[i].second;
        }
        if(!crashflag) dfs(n);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++)
    { 
        int a, b;
        cin >> a >> b;
        vec.push_back({a,b});
    }
    dfs(0);
    cout << ans;
}
