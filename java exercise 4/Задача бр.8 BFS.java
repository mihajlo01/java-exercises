package bfs.algoritmi;
import java.io.*; 
import java.util.*; 
public class BFS {


	    private int V;    
	    private LinkedList<Integer> adj[]; 
	  
	    // Конструктор 
	    BFS(int v) 
	    { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for (int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    // Функција за креирање на граф
	    void addEdge(int v,int w) 
	    { 
	        adj[v].add(w); 
	    } 
	  
	    // го печати BFS  
	    void BFS(int s) 
	    { 
	        // Ги бележи сите јазли како непосетени 
	        boolean visited[] = new boolean[V]; 
	  
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	  
	        // Го бележи моменталниот јазел како посетен
	        visited[s]=true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	            // Печати јазел 
	            s = queue.poll(); 
	            System.out.print(s+" "); 
	  
	            Iterator<Integer> i = adj[s].listIterator(); 
	            while (i.hasNext()) 
	            { 
	                int n = i.next(); 
	                if (!visited[n]) 
	                { 
	                    visited[n] = true; 
	                    queue.add(n); 
	                } 
	            } 
	        } 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        BFS g = new BFS(9); 
	  
	        g.addEdge(0, 8); 
	        g.addEdge(1, 0); //0=A; 1=B; 2=C; 3=D; 4=E; 5=F; 6=G; 7=H; 8=S
	        g.addEdge(2, 3); 
	        g.addEdge(2, 4);
	        g.addEdge(2, 5);
	        g.addEdge(6, 5);
	        g.addEdge(6, 7);
	        g.addEdge(7, 4);
	        g.addEdge(8, 2); 
	        g.addEdge(8, 6);
	  
	        System.out.println("Резултат:"); 
	  
	        g.BFS(1); 
	    } 
	} 

