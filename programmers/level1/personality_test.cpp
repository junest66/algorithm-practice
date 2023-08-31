#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

map<char,int> mp;

char func(char a, char b) {
    cout << mp[a] << " " << mp[b] << " ";
    if(mp[a] > mp[b]) {
        return a;
    }
    else if(mp[a] < mp[b]) {
        return b;
    }
    else {
        return a < b ? a : b;
    }
}

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    string str = "RTFCMJAN";
    for(auto x: str) {
        mp.insert({x,0});
    }
    for(int i=0; i<survey.size(); i++) {
        int temp = choices[i] - 4;
        if(temp < 0) {
            mp[survey[i][0]] =mp[survey[i][0]] + (temp*-1);
        }
        else if(temp > 0) {
            mp[survey[i][1]] += temp;
        }
    }
    vector<char> vec;
    vec.push_back(func('R','T'));
    vec.push_back(func('C','F'));
    vec.push_back(func('J','M'));
    vec.push_back(func('A','N'));
    for(auto x: vec) {
        answer.push_back(x);
    }
    return answer;
}