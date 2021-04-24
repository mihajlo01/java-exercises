package dfs.algoritmi;
import java.io.*; 
import java.util.*; 

public class DFS {
	   
	    private int V;   
	    
	    private LinkedList<Integer> adj[]; 
	  
	    DFS(int v) 
	    { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for (int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    void addEdge(int v, int w) 
	    { 
	        adj[v].add(w);  
	    } 
	   
	    void DFSUtil(int v,boolean visited[]) 
	    { 
	        visited[v] = true; 
	        System.out.print(v+" "); 
	  
	        Iterator<Integer> i = adj[v].listIterator(); 
	        while (i.hasNext()) 
	        { 
	            int n = i.next(); 
	            if (!visited[n]) 
	                DFSUtil(n, visited); 
	        } 
	    } 
	  
	    void DFS(int v) 
	    { 
	        boolean visited[] = new boolean[V]; 
	  
	        DFSUtil(v, visited); 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        DFS g = new DFS(7); 
	  
	        g.addEdge(0, 1); // A=0; B=1; C=2; D=3; E=4; F=5; G=6
	        g.addEdge(1, 2); 
	        g.addEdge(1, 3); 
	        g.addEdge(2, 0); 
	        g.addEdge(3, 0); 
	        g.addEdge(3, 2);
	        g.addEdge(4, 5);
	        g.addEdge(4, 6);
	        g.addEdge(5, 1);
	        g.addEdge(6, 5);
	        g.addEdge(6, 3);
	  
	        System.out.println("Почнувајќи од теме A!"); 
	  
	        g.DFS(4); 
	    } 
}
