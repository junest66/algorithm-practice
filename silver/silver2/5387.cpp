#include <iostream>
#include <list>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n;
    cin >> n;
    while(n--) {
        string str;
        list<char> li;
        auto iter = li.begin();
        cin >> str;
        for(auto c: str) {
            if(c=='<') {
                if(iter != li.begin()) iter--;
            }
            else if(c== '>') {
                if(iter != li.end()) iter++;
            }
            else if(c== '-') {
                if(iter!=li.begin()) {
                    iter--;
                    iter = li.erase(iter);                 
                }
            }
            else li.insert(iter,c);
        }
        for(auto c : li) cout<<c;
        cout << '\n';
    }
    return 0;
}