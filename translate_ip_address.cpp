#include <iostream>
#include <sstream>
#include <bitset>
#include <string>
using namespace std;

uint32_t translate(string& ipAddress) {
    istringstream iss(ipAddress);
    string s;
    uint32_t ans = 0;
    for (int i = 0; i < 4; i++) {
        getline(iss, s, '.');
        uint32_t val = stoi(s);
        ans = (ans << 8) | val;
    }
    return ans;
}

int main() {
    string ipAddress;
    cout << "Enter a dotted decimal IP address (xxx.xxx.xxx.xxx format): ";
    cin >> ipAddress;
    uint32_t address = translate(ipAddress);
    cout << "32-bit address: " << bitset<32>(address) << endl;
    return 0;
}
