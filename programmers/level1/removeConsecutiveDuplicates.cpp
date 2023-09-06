#include <vector>
#include <iostream>
#include <queue>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    queue<int> que;
    vector<int> answer;
    for(auto x : arr) {
        if(!que.empty() && que.back() != x) {
            que.push(x);
        }
        else if(que.empty()) {
            que.push(x);
        }
    }
    while(!que.empty()) {
        answer.push_back(que.front());
        que.pop();
    }

    return answer;
}