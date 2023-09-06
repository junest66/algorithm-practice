#include <string>
#include <vector>
#include <queue>
#include <utility>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> vec;
    vector<int> answer;
    for(int i=0; i<progresses.size(); i++) {
        if((100-progresses[i]) % speeds[i] == 0) {
            vec.push_back((100-progresses[i]) / speeds[i]);
        }
        else {
           vec.push_back((100-progresses[i]) / speeds[i]+1);
        }
    }
    int count = 1;
    int temp = -1;
    for(int i=0; i<vec.size(); i++) {
        if(temp == -1) {
            temp = vec[i];
            continue;
        }
        if(temp >= vec[i]) {
            count ++;
        }
        else {
            answer.push_back(count);
            count = 1;
            temp = vec[i];
        }
    }
    answer.push_back(count);   

    
    return answer;
}