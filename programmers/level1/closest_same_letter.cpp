#include <string>
#include <vector>

using namespace std;


vector<int> solution(string s) {
    int arr[26];
    for(int i=0; i<26; i++) {
        arr[i] = -1;
    }
    vector<int> answer;
    for(int i=0; i<s.size(); i++) {
        if(arr[s[i]-'a'] == -1) {
            answer.push_back(-1);
            arr[s[i]-'a'] = i;
        }
        else {
            answer.push_back((i-arr[s[i]-'a']));
            arr[s[i]-'a'] = i;
        }
    }
    return answer;
}