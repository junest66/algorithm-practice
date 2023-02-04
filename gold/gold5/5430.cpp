#include <iostream>
#include <deque>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(0);
    int n, a;
    string str;
    string arr;
    cin >> n;
    while(n--) {
        deque <string> deque;
        string plus="";
        int rcount = 0;
        bool error = false;
        cin >> str;
        cin >> a;
        cin >> arr;
        for(int i=1; i<arr.size(); i++) {
            if(arr[i] == ',' || arr[i] == ']') {
                if(!plus.empty()) {
                     deque.push_back(plus);
                     plus.clear();
                }
            }
            else plus+=arr[i];

        }
        for(int i=0; i<str.size(); i++) {
            if(str[i] == 'R') rcount++;
            else if(str[i] == 'D') {
                if(deque.empty()) {
                    error = true;
                    cout << "error" <<'\n';
                    break;
                }
                if(rcount % 2 ==0) deque.pop_front(); //rcount가 짝수면 앞에꺼 버리기 
                else deque.pop_back(); //rcount가 홀수면 뒤에꺼 버리기
            }
        }
        if(!error) {
            cout << "[";
            if(rcount%2 ==0) { //짝수면 앞에서 부터 그대로 출력
                for(int i=0; i<deque.size(); i++) {
                    cout << deque[i];
                    if(i!=deque.size()-1) cout << ",";
                }
                cout << "]" << '\n';
            }
            else {
                for(int i=deque.size()-1; i>=0; i--){
                    cout<< deque[i];
                    if(i) cout << ",";
                }
                cout << "]" << '\n';
            }
        }
    }
    return 0;
}