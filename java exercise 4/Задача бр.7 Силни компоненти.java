package sk.algoritmi;
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 

public class SilniKomponenti {


	    private int V;    
	    private LinkedList<Integer> adj[]; 
	  
	    //Конструктор 
	    SilniKomponenti(int v) 
	    { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for (int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    //Функција за создавање на графот 
	    void addEdge(int v, int w)  { adj[v].add(w); } 
	  
	    // Рекурзивна функција за печатење на DFS почнувајќи од v 
	    void DFSUtil(int v,boolean visited[]) 
	    { 
	        // Бележи го јазелот кој се користи и печати го 
	        visited[v] = true; 
	        System.out.print(v + " "); 
	  
	        int n; 
	  
	        Iterator<Integer> i =adj[v].iterator(); 
	        while (i.hasNext()) 
	        { 
	            n = i.next(); 
	            if (!visited[n]) 
	                DFSUtil(n,visited); 
	        } 
	    } 
	  
	    // Функција која го печати Транзитивниот граф на почетниот 
	    SilniKomponenti getTranspose() 
	    { 
	    	SilniKomponenti g = new SilniKomponenti(V); 
	        for (int v = 0; v < V; v++) 
	        { 
	            // Recur for all the vertices adjacent to this vertex 
	            Iterator<Integer> i =adj[v].listIterator(); 
	            while(i.hasNext()) 
	                g.adj[i.next()].add(v); 
	        } 
	        return g; 
	    } 
	  
	    void fillOrder(int v, boolean visited[], Stack stack) 
	    { 
	        // Бележи го моменталниот јазел како посетен и печати го
	        visited[v] = true; 
	  
	        Iterator<Integer> i = adj[v].iterator(); 
	        while (i.hasNext()) 
	        { 
	            int n = i.next(); 
	            if(!visited[n]) 
	                fillOrder(n, visited, stack); 
	        } 
	  
	        // push v во Stack 
	        stack.push(new Integer(v)); 
	    } 
	  
	    // Главната функција која ги наоѓа силните компоненти и ги печати
	    void printSCCs() 
	    { 
	        Stack stack = new Stack(); 
	  
	        // Бележи ги сите јазли како непосетени 
	        boolean visited[] = new boolean[V]; 
	        for(int i = 0; i < V; i++) 
	            visited[i] = false; 
	  
	        for (int i = 0; i < V; i++) 
	            if (visited[i] == false) 
	                fillOrder(i, visited, stack); 
	  
	        // Креирање на транзитивен граф
	        SilniKomponenti gr = getTranspose(); 
	  
	        // Бележи ги сите јазли како посетени 
	        for (int i = 0; i < V; i++) 
	            visited[i] = false; 
	  
	        while (stack.empty() == false) 
	        { 
	            // Pop на јазел од стек
	            int v = (int)stack.pop(); 
	  
	            // Печатење на резутат
	            if (visited[v] == false) 
	            { 
	                gr.DFSUtil(v, visited); 
	                System.out.println(); 
	            } 
	        } 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	    	SilniKomponenti g = new SilniKomponenti(9); 
	        g.addEdge(0, 1); 
	        g.addEdge(1, 2); 
	        g.addEdge(2, 3); 
	        g.addEdge(2, 4);
	        g.addEdge(3, 0); 
	        g.addEdge(4, 5);  
	        g.addEdge(5, 6);
	        g.addEdge(6, 4);
	        g.addEdge(6, 7);
	        g.addEdge(7, 8);
	  
	        System.out.println("Резултат:"); 
	        g.printSCCs(); 
	    
	} 
}
