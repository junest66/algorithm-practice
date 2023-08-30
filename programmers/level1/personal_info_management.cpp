#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

map<string,int> mp;

int dayToInt(string today) {
    today.erase(std::remove(today.begin(), today.end(), '.'), today.end());
    return stoi(today);
}
int func(string str, int dal) {
    int a = stoi(str.substr(0,4));
    int b = stoi(str.substr(5,7));
    int c = stoi(str.substr(8,10));
    
    b += dal;
    if(b>12) {
        if(!(b%12)) {
            a+=(b/12-1);
            b=12;
        }
        else {
            a += b/12;
            b = b%12;
        }
        
    }
    c -= 1;
    if(c == 0) {
        b-=1;
        c= 28;
    }
    if(b==0) {
        b=12;
        a-=1;
    }
    string q = to_string(a);
    string w = to_string(b);
    string e = to_string(c);
    if(stoi(w) < 10) {
        w.insert(0,"0");
    }
    if(stoi(e) < 10) {
        e.insert(0,"0");
    }
    string result = q+w+e;
    cout << dayToInt(result) << " "; 
    return dayToInt(result);
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    int current = dayToInt(today);
    
    for(auto x: terms) {
        string str1 = x.substr(0,x.find(' '));
        string str2 = x.substr(x.find(' '),x.length());
        mp.insert(make_pair(str1,stoi(str2)));
    }
    for(int i=0; i<privacies.size(); i++) {
        string str1 = privacies[i].substr(0,privacies[i].find(' '));
        string str2 = privacies[i].substr(privacies[i].find(' ')+1,privacies[i].length());
        int temp = mp[str2];
        if(current > func(str1,temp)) {
            answer.push_back(i+1);
        }        
    }
    return answer;
}