#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

    string str;
    vector<string> vec;
    cin >> str;
    int strsize = str.size();
    for(int i=0; i<strsize; i++) {
        vec.push_back(str.substr(i));
    }
    sort(vec.begin(),vec.end());
    for(auto e : vec) cout << e << "\n";
}