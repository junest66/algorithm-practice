#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

stack<int> stk;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    int vSize = board.size();
    
    for(auto x: moves) {
        int temp = 0;
        while(temp < vSize) {
            if(board[temp][x-1] == 0) {
                temp++;
                continue;
            }
            else {
                if(stk.empty()) {
                    stk.push(board[temp][x-1]);
                }
                else {
                    if(stk.top() == board[temp][x-1]) {
                        answer+=2;
                        stk.pop();
                    }
                    else {
                        stk.push(board[temp][x-1]);
                    }
                }
                board[temp][x-1] = 0;
                break;   
            }
        }
    }
    return answer;
}