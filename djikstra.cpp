#include<bits/stdc++.h>
using namespace std;

vector<int>djikstra(int V,vector<vector<int>>adj[],int S){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>minHeap;
    vector<int>dist(V,INT_MAX);
    dist[S]=0;
    minHeap.push({0,S});
    while(minHeap.size()>0){
        int node=minHeap.top().second;
        int distance=minHeap.top().first;
        minHeap.pop();
        for(auto it:adj[node]){
            int v=it[0];
            int w=it[1];
            if(distance+w<dist[v]){
                dist[v]=distance+w;
                minHeap.push({distance+w,v});
            }
        }
    }
    return dist;
}

int main() {
    cout<<"Enter the total number of nodes"<<endl;
    int V;
    cin>>V;
     cout<<"Enter the graph in matrix form"<<endl;
     vector<vector<int>>matrix(V,vector<int>(V,0));
     for(int i=0;i<V;i++){
         for(int j=0;j<V;j++){
             int ele;
             cin>>ele;
             matrix[i][j]=ele;
         }
     }
//     int V = matrix.size();
     vector<vector<int>>adj[V];
     for(int i=0;i<V;i++){
         for(int j=0;j<V;j++){
             if(matrix[i][j]!=0){
                 adj[i].push_back({j,matrix[i][j]});
             }
         }
     }
     vector<int>ans(V,0);
     ans=djikstra(V,adj,0);
     for(int i=0;i<V;i++){
         cout<<i<<"           "<<ans[i]<<endl;
     }

    return 0;
}
