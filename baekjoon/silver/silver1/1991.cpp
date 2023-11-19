#include <iostream>
#include <map>
#include <utility>
using namespace std;

map<char, pair<char,char>> mp;

void preOrder(char node) {
    cout << node;
    if(mp[node].first != '.') preOrder(mp[node].first);
    if(mp[node].second != '.') preOrder(mp[node].second);
}

void inOrder(char node) {
    if(mp[node].first != '.') inOrder(mp[node].first);
    cout << node;
    if(mp[node].second != '.') inOrder(mp[node].second);
}

void postOrder(char node) {
    if(mp[node].first != '.') postOrder(mp[node].first);
    if(mp[node].second != '.') postOrder(mp[node].second);
    cout << node;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        char root, left, right;
        cin >> root >> left >> right;
        mp[root] = make_pair(left,right);
    }
    preOrder('A');
    cout << '\n';
    inOrder('A');
    cout << '\n';
    postOrder('A');

}