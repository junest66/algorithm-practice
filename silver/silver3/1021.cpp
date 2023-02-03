#include <iostream>
#include <deque>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n, m;
    int count = 0;
    deque<int> deque;
    cin >> n >> m;
    for(int i=1; i<=n; i++) deque.push_back(i);
    while(m--) {
        int index;
        int a;
        cin >> a;
        for(int i=0; i<deque.size(); i++) {
            if(a==deque[i]) {
                index = i;
                break;
            }
        }
        if(index <= deque.size() - index) { // 원소가 앞에 있는경우 
            while(deque.front() != a) {
                deque.push_back(deque.front());
                deque.pop_front();
                count++;
            }
            deque.pop_front();
        } 
        else {
            while(deque.front() != a) { // 원소가 뒤에 있는경우
                deque.push_front(deque.back());
                deque.pop_back();
                count++;
            }
            deque.pop_front();
        } 
    }
    cout << count;


    return 0;
}