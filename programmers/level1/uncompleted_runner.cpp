#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    map<string,int> mp;
    string answer = "";
    for(auto x: participant) {
        if(mp.find(x) != mp.end()) {
            mp[x]++;
        }
        else {
            mp.insert({x,1});
        }
    }
    for(auto x: completion) {
        mp[x]--;
    }
    for(auto x: mp) {
        if(x.second != 0) {
            answer = x.first;
            break;
        }
    }

    return answer;
}