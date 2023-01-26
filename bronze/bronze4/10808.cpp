#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    string a;
    int alp[26] = {0};
    cin >> a;
    for(int i=0; i<a.size(); i++) alp[a[i] - 97]++;
    for(int i=0; i<26; i++) cout << alp[i] << " ";
    return 0;
}