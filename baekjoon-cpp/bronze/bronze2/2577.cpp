#include <iostream>
#include <string>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int arr[10] = {0};
    int a,b,c;
    string str;
    cin >> a >> b >> c;
    str = to_string(a*b*c);
    for(int i=0; i<str.size(); i++) {  
       arr[str[i]-48]++;
    }
    for(int i=0; i<10; i++) {
        cout << arr[i] << '\n';
    }
}