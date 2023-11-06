#include <bits/stdc++.h>
using namespace std;

    vector<int> bellman_ford(int V, vector<vector<int>>& edges, int S) {
        vector<int> dist(V, 1e8);
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (auto it : edges) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (auto it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                return { -1 };
            }
        }
        return dist;
    }


int main() {
        cout<<"Enter the number of nodes"<<endl;

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
    vector<vector<int>>edges;
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            if(matrix[i][j]!=0){
                edges.push_back({i,j,matrix[i][j]});
            }
        }
    }
    vector<int> dist = bellman_ford(V, edges, 0);

    for(int i=0;i<V;i++){
        cout<<dist[i]<<endl;
    }

    return 0;
}
