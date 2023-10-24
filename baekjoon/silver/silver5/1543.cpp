#include <iostream>
#include <string>
#include <vector>
using namespace std;

int split(string s, string d) {
    int num = 0;
    int pos = s.find(d);
    while(pos != -1) {
        num++;
        pos = s.find(d, pos + d.size());
    }

    return num;
}

int main() {
    string str,d;
    getline(cin, str);
    getline(cin, d);
    cout << split(str, d);
    return 0;
}