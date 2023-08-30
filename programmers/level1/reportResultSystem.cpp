#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int arr[1001][1001];
int singo[1001];
map<string,int> mp;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    
    for(int i=0; i<id_list.size(); i++) { //이름과 인덱스 저장
        mp.insert({id_list[i],i});
    }
    for(auto x: report) {
        auto pos = x.find(' ');
        string str1 = x.substr(0,pos);
        string str2 = x.substr(pos+1);
        if(arr[mp[str1]][mp[str2]] == 0) {
            arr[mp[str1]][mp[str2]]++;
            singo[mp[str2]]++;
        }
        else {
            continue;
        }
    }
    for(int i=0; i<id_list.size(); i++) {
        int count = 0;
        for(int j=0; j<id_list.size(); j++) {
            if(arr[i][j] > 0 && singo[j] >=k) {
                count++;
            }
        }
        answer.push_back(count);
    }
    
    
    return answer;
}