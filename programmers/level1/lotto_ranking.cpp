#include <string>
#include <vector>

using namespace std;

int arr[7];

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    arr[6]= 1;
    arr[5]= 2;
    arr[4]= 3;
    arr[3]= 4;
    arr[2]= 5;
    arr[1]= 6;
    arr[0]= 6;
    
    int count = 0;
    int success = 0;
    for(auto x : lottos) {
        if(x == 0) {
            count ++;
        }
        for(auto y : win_nums) {
            if(x == y) {
                success++;
            }
        }
    }
    if(success == 6) {
        answer.push_back(arr[6]);
        answer.push_back(arr[6]);
    }
    else {
        if(success+count > 6) {
            answer.push_back(arr[6]);
        }
        else {
            answer.push_back(arr[success+count]);
        }
        answer.push_back(arr[success]);
    }
    
    return answer;
}