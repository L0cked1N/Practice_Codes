#include <iostream>
#include <string>
using namespace std;

int main() {
    int t; // number of test cases
    cin >> t;

    while (t--) {
        int n, k; // length of the string and maximum number of swaps
        cin >> n >> k;
        
        string s;
        cin >> s;

        // First, let's check if the string is already universal
        bool isUniversal = true;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] >= s[n - i - 1]) {
                isUniversal = false;
                break;
            }
        }

        // If the string is already universal
        if (isUniversal) {
            cout << "YES" << endl;
        } else {
            // Count mismatches
            int mismatches = 0;
            for (int i = 0; i < n / 2; i++) {
                if (s[i] >= s[n - i - 1]) {
                    mismatches++;
                }
            }
            
            // If mismatches are less than or equal to k, output YES, otherwise NO
            if (mismatches <= k) {
                cout << "YES" << endl;
            } else {
                cout << "NO" << endl;
            }
        }
    }

    return 0;
}
