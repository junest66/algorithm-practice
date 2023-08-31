#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

string solution(string new_id) {
    string answer = "";
    string temp2 = "";
    string temp3 = "";
    
    transform(new_id.begin(), new_id.end(), new_id.begin(), ::tolower);
    for(auto x : new_id) {
        if((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9') || x == '-' || x== '_' || x== '.') {                            temp2.push_back(x);
        }
    }
    int count = 0;
    for(int i=0; i<temp2.size(); i++) {
        if(temp2[i] == '.') {
            count++;
        }
        else {
            if(count >= 1) {
                temp3.push_back('.');
                count = 0;
            }
            temp3.push_back(temp2[i]);
        }
    }
    if(temp3.front() == '.') {
        temp3.erase(temp3.begin());
    }
    if(temp3.back() == '.') {
        temp3.erase(temp3.end()-1);
    }
    if(temp3.empty()){
        temp3.push_back('a');
    }
    if(temp3.length() >= 16) {
        temp3.erase(temp3.begin()+15,temp3.end());
    }
    if(temp3.back() == '.') {
        temp3.erase(temp3.end()-1);
    }
    if(temp3.length() <= 2) {
        while(temp3.length() != 3) {
            temp3.push_back(temp3.back());
        }
    }
    
    answer = temp3;
    
    return answer;
}