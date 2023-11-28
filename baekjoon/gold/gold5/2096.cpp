#include <algorithm>
#include <iostream>
using namespace std;

int n;
int max1, max2, max3;
int min1, min2, min3;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int cur1, cur2, cur3;
        cin >> cur1 >> cur2 >> cur3;
        int max1Temp = max(max1, max2);
        int max2Temp = max(max(max1, max2), max3);
        int max3Temp = max(max2, max3);
        int min1Temp = min(min1, min2);
        int min2Temp = min(min(min1, min2), min3);
        int min3Temp = min(min2, min3);
        max1 = max1Temp + cur1;
        min1 = min1Temp + cur1;
        max2 = max2Temp + cur2;
        min2 = min2Temp + cur2;
        max3 = max3Temp + cur3;
        min3 = min3Temp + cur3;
    }
    cout << max(max(max1, max2), max3) << " ";
    cout << min(min(min1, min2), min3) << "";
    return 0;
}