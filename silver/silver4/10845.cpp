#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    queue<int> que;
    cin >> n;
    while(n--) {
        string str;
        cin >> str;
        if(str == "push") {
            int a;
            cin >> a;
            que.push(a);
        }
        else if(str == "front") {
            if(que.empty()) cout << -1 << '\n';
            else cout << que.front() << '\n';
        }
        else if(str == "pop") {
            if(que.empty()) cout << -1 << '\n';
            else {
              cout << que.front() << '\n';  
              que.pop();
            } 
        }
        else if(str == "size") cout << que.size() << '\n';
        else if(str == "empty") {
            if(que.empty()) cout << 1 << '\n';
            else cout << 0 << '\n';
        }
        else if(str == "back") {
            if(que.empty()) cout << -1 << '\n';
            else cout << que.back() << '\n';
        }

    }
    return 0;

}