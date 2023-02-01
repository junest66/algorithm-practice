#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    int a;
    deque<int> deque;
    cin >> n;
    while(n--) {
        string str;
        cin >> str;
        if(str == "push_front") {
            cin >> a;
            deque.push_front(a);
        } 
        else if(str== "push_back") {
            cin >> a;
            deque.push_back(a);
        }
        else if(str== "pop_front") {
            if(deque.empty()) cout << -1 << "\n";
            else {
                cout << deque.front() << '\n';
                deque.pop_front();
            } 
        }
        else if(str== "pop_back") {
            if(deque.empty()) cout << -1 << "\n";
            else {
                cout << deque.back() << '\n';
                deque.pop_back();
            } 
        }
        else if(str == "size") cout << deque.size() << '\n';
        else if(str == "empty") {
            if(deque.empty()) cout << 1 << '\n';
            else cout << 0 << '\n';
        }
        else if(str == "front") {
            if(deque.empty()) cout << -1 << "\n";
            else {
                cout << deque.front() << '\n';
            }
        }
        else if(str== "back") {
            if(deque.empty()) cout << -1 << "\n";
            else {
                cout << deque.back() << '\n';
            } 
        }

    }
    return 0;
}