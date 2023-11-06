#include<bits/stdc++.h>
using namespace std;

int main(){

     cout<<"Enter the IP address in the given format xxx.xxx.xxx.xxx"<<endl;
     string s;
     cin>>s;
     string start = s.substr(0,3);
     int n=stoi(start);
     cout<<n<<endl;
     if(n>=0 && n<=127){
         cout<<"Class A"<<endl;
     }
     else if(n>=128 &&  n<=191){
         cout<<"Class B"<<endl;
     }
     else if(n>=192 && n<=223){
         cout<<"Class C"<<endl;
     }
     else if(n>=224 && n<=239){
         cout<<"Class D"<<endl;
     }
     else if(n>=240 && n<=254){
         cout<<"Class E"<<endl;
     }

    return 0;
}
