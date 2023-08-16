#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for(auto x: commands) {
        vector<int> vec;
        for(int i = x[0]-1; i<x[1]; i++) {
            vec.push_back(array[i]);
        }
        sort(vec.begin(),vec.end());
        answer.push_back(vec[x[2]-1]);
    }
    return answer;
}