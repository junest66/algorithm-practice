#include <iostream>
#include <utility>
#include <deque>
using namespace std;
int arr[200002];
int n,m;
deque<pair<int,int>> deck;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    arr[n] = 1;
    deck.push_back({n,0});
    while(!deck.empty()) {
        auto cur = deck.front();
        deck.pop_front();
        if(cur.first == m) {
            cout << cur.second;
            return 0;
        }
        int nx = cur.first + 1;
        int ny = cur.first - 1;
        int nz = cur.first * 2;
        if(arr[nz] == 0 && 0 <= nz && nz <=100000) {
            arr[nz] = 1;
            deck.push_front({nz,cur.second});
        }
        if(arr[nx] == 0 && 0 <= nx && nx <=100000) {
            arr[nx] = 1;
            deck.push_back({nx,cur.second+1});
        }
        if(arr[ny] == 0 && 0 <= ny && ny <=100000) {
            arr[ny] = 1;
            deck.push_back({ny,cur.second+1});
        }

    }


}