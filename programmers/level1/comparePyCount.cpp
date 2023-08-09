#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    int pnum = 0;
    int ynum = 0;
    for(auto i : s) {
        if(i == 'p' || i == 'P') pnum++;
        if(i == 'y' || i == 'Y') ynum++;
    }
    if(pnum == ynum) answer = true;
    else answer = false;

    return answer;
}