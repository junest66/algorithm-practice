#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool compare(int &a, int &b) {
    string str1 = to_string(a);
    string str2 = to_string(b);
    
    if (str1 + str2 > str2 + str1) {
        return true; 
    } else {
        return false;
    }
}


string solution(vector<int> numbers) {
    string answer = "";
    sort(numbers.begin(), numbers.end(), compare);
    if(numbers[0] == 0) {
        answer.push_back('0');
        return answer;
    }
    for(int i=0; i<numbers.size(); i++) {
        answer += to_string(numbers[i]);
    }
    return answer;
}