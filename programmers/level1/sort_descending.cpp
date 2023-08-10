#include <string>
#include <vector>
#include <queue>
#include <string>

using namespace std;

long long solution(long long n) {
    priority_queue <int> pq;
    while(n>0) {
        pq.push(n%10);
        n /= 10;
    }
    string s = "";
    while(!pq.empty()) {
        s.push_back(pq.top() + '0');
        pq.pop();
    }
    return stoll(s);
}