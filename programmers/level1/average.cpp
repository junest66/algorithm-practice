#include <string>
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double answer = 0;
    for(auto it : arr) {
        answer += it;
    }
    return answer/= arr.size();
}