#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int deleteZero = 0;
int transferCount = 0;

string secondMethod(int count) {
    string a = "";
    while(count != 0) {
        a.push_back((count % 2 + '0'));
        count /= 2;
    }
    reverse(a.begin(), a.end());
    return a;
}

string transfer(string s) {
    int count = 0;
    for(auto x: s) {
        if(x == '1') {
            count++;
        } else {
            deleteZero++;
        }
    }
    transferCount++;
    return secondMethod(count);
}

vector<int> solution(string s) {
    vector<int> answer;
    while(s != "1") {
        s = transfer(s);
    }
    answer.push_back(transferCount);
    answer.push_back(deleteZero);
    return answer;
}