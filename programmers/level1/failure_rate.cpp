#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int num[501];

bool compare(pair<double, int> &a, pair<double, int> &b) {
    if (a.first > b.first) {
        return true;
    } else if (a.first < b.first) {
        return false;
    } else {
        return a.second < b.second;
    }
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<double,int>> vec;
    int total = stages.size();
    for(auto x: stages) {
        num[x]++;
    }
    for(int i=1; i<=N; i++) {
        vec.push_back(make_pair((double)num[i]/total,i));
        total -= num[i];
    }
    sort(vec.begin(),vec.end(), compare);
    for(auto x : vec) {
        answer.push_back(x.second);
    }
    return answer;
}