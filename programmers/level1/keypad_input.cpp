#include <string>
#include <vector>
#include <map>
#include <utility>
#include <iostream>
#include <cstdlib>

using namespace std;

map<int,pair<int,int>> mp;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    for(int i=0; i<=8; i++) {
        mp.insert({i+1,make_pair(i%3, i/3)});
    }
    mp.insert({10,{0,3}});
    mp.insert({11,{2,3}});
    mp.insert({0,{1,3}});
    
    int startLeft = 10;
    int startRight = 11;
    for(auto x: numbers) {
        if(x!=0 && x%3 == 1) {
            answer.push_back('L');
            startLeft = x;
        }
        else if(x!=0 && x%3 == 0) {
            answer.push_back('R');
            startRight = x;
        }
        else {
            int dLeft = abs(mp[x].first - mp[startLeft].first) + abs(mp[x].second - mp[startLeft].second);
            int dRight = abs(mp[x].first - mp[startRight].first) + abs(mp[x].second - mp[startRight].second);
            if(dLeft < dRight) {
                answer.push_back('L');
                startLeft = x;
            }
            else if(dLeft > dRight) {
                answer.push_back('R');
                startRight = x;
            }
            else {
                if(hand == "right") {
                    answer.push_back('R');
                    startRight = x;
                }
                else {
                    answer.push_back('L');
                    startLeft = x;
                }
            }
        }
    }
    
    return answer;
}