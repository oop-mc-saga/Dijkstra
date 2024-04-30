# Dijkstra algorithm
## Description
The Dijsktra algorithm is a graph search algorithm that calculates the shortest path from a source node to all other nodes in a graph. 
The target graph is a weighted directed graph, where the weights are non-negative.

## Algorithm
- Let the source node be $n_0$.
- For initialization, the distance of the source node is set to 0 and all other nodes are set to $\infty$.
- Let $U$ be the binary heap that stores the nodes in the graph with the distance from the source as the key.  A node in $U$ is a node whose distance from the source has been calculated but not finalized.  
- Let $W$ be the set of nodes in the graph.  A node in $W$ is a node whose distance from the source has been finalized.
- The initial value of  $W=\emptyset$ and $n_0$ is added to $U$.


The algorithm proceeds as follows:
1. Extract the node $n$ with the smallest distance from the source from the binary heap $U$.
2. Find the neighbors $N$ of $n$.
    - Calculate the distance $d_\textrm{tmp}$ to $w\in N$ as the distance to $n$ plus the weight of the edge from $n$ to $w$.
    - If $d_\textrm{tmp}$ is less than the current distance of $w$, update the distance of $w$ to $d_\textrm{tmp}$.
    - If $w$ is in $U$, update the position of $w$ in the binary heap $U$. If $w$ is not in $U$, add $w$ to $U$.
3. Move $n$ to $W$. 
4. Repeat steps 1-3 until $U$ is empty.

