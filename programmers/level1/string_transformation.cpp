#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int index = 0;
    for(int i=0; i<s.length(); i++) {
        if(s[i] == ' ') {
            index = 0;
            answer.push_back(' ');
            continue;
        }
        if(index % 2) {
            if(s[i]>='a' && s[i] <= 'z') { //이미 소문자면
                answer.push_back(s[i]);
            }
            else { // 대문자 -> 소문자
                answer.push_back((s[i] + 32));
            }
            index++;
            
        }
        else { //짝수면 대문자로
            if(s[i]>='A' && s[i] <= 'Z') { //이미 대문자면
                answer.push_back(s[i]);
            }
            else { // 소문자 -> 대문자
                answer.push_back((s[i] - 32));
            }
            index++;
        }
    }
    return answer;
}