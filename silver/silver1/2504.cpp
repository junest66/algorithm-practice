#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;
    int sum = 0;
    int temp = 1;
    stack<char> stack;
    bool error = true;
    for(int i=0; i<str.size(); i++) {
        if(str[i] == '(') {
            stack.push(str[i]);
            temp *= 2;
        }
        else if( str[i]== '[') {
            stack.push(str[i]);
            temp *= 3;
        }
        else if( str[i] == ')') {
            if(stack.empty() || stack.top() != '(') {
                error = false;
                break;
            }
            else {
                if(str[i-1] == '(') {
                    sum += temp;
                }
                stack.pop();
                temp /= 2;
            }
        }
        else if( str[i] == ']') {
            if(stack.empty() || stack.top() != '[') {
                error = false;
                break;
            }
            else {
                if(str[i-1] == '[') {
                    sum += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
    }
    if(error==true && stack.empty()) cout << sum;
    else cout << 0;
    return 0; 
}