// Baekjoon - 10090번 Counting Inversions
#include <iostream>
using namespace std;

long long ans;
//merge sort
void merge(int *arr, int left, int middle, int right) {
    int i = left;
    int j = middle+1;
    int t= 1;
    int temp[right-left+1];

    while(i <= middle && j <= right) {
        if(arr[i] <= arr[j]) {
            temp[t++] = arr[i++];
        }

        else {
            ans+= middle-i+1;
            temp[t++] = arr[j++];  
        } 
    }

    while( i <= middle) {
        temp[t++] = arr[i++];
    }
    while(j <= right) {
        temp[t++] = arr[j++];
    }
    i = left;
    t= 1;
    while( i<= right) {
        arr[i++] = temp[t++];
    }

}

void merge_sort(int *arr, int left, int right) {
    if(left < right) {
        int middle = (left + right) / 2;
        merge_sort(arr, left, middle);
        merge_sort(arr, middle+1, right);
        merge(arr, left, middle, right);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    int arr[1000001]={0,};
    cin >> n;
    for(int i=0; i<n; i++)
        cin >> arr[i];
    merge_sort(arr,0,n-1);
    cout << ans;

    return 0;
}