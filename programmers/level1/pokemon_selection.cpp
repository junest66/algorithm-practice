#include <vector>
#include <set>
using namespace std;

int solution(vector<int> nums)
{
    set<int> st;
    int answer = 0;
    for(auto x: nums) {
        st.insert(x);
    }
    int numsSize = nums.size() /2;
    int stSize = st.size();
    if(numsSize < stSize) {
        answer = numsSize;
    }
    else {
        answer = stSize;
    }
    return answer;
}