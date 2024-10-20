#include <iostream>
#include <list>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    string str;
    int n;
    cin >> str;
    list<char> li;
    auto iter = li.end();
    for(auto c: str) li.push_back(c);
    cin >> n;
    while(n--) {
        char op;
        cin >> op;
        if(op == 'P') {
            char a;
            cin >> a;
            li.insert(iter,a);
        }
        else if(op == 'L') {
            if(iter!=li.begin()) iter--;
        }
        else if(op == 'D') {
            if(iter!=li.end()) iter++;;
        }
        else if(op == 'B') {
            if(iter!=li.begin()) {
                iter--;
                iter = li.erase(iter);
            }
        }
    }
    for(auto c : li) cout<<c;
    return 0;
}