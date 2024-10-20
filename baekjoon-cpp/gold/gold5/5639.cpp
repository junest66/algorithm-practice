#include <algorithm>
#include <iostream>
#include <map>
using namespace std;

map<int, pair<int, int>> mp;
int arr[10001];

void postorder(int node) {       // 후위순회
    if (mp[node].first != -1) {  // 왼쪽 자식이 있다면
        postorder(mp[node].first);
    }
    if (mp[node].second != -1) {  // 오른쪽 자식이 있다면
        postorder(mp[node].second);
    }
    cout << node << "\n";  // 현재 노드의 데이터 출력
}

void func(int start, int end) {
    if (start == end) {
        mp[arr[start]] = make_pair(-1, -1);
        return;
    }
    int left = 0;
    int right = 0;
    for (int i = start; i <= end; i++) {
        if (arr[start] > arr[i]) {
            left = i;
            break;
        }
    }
    for (int i = start; i <= end; i++) {
        if (arr[start] < arr[i]) {
            right = i;
            break;
        }
    }
    if (left != 0 && right != 0) {
        mp[arr[start]] = make_pair(arr[left], arr[right]);
        func(left, right - 1);
        func(right, end);
    } else if (left != 0 && right == 0) {
        mp[arr[start]] = make_pair(arr[left], -1);
        func(left, end);
    } else if (left == 0 && right != 0) {
        mp[arr[start]] = make_pair(-1, arr[right]);
        func(right, end);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int i = 0;
    int tmp;
    while (cin >> tmp) {
        arr[i++] = tmp;
    }
    func(0, i - 1);
    postorder(arr[0]);

    return 0;
}