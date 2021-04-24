package ts.algoritmi;
import java.io.*;  
import java.util.*;  

public class TopoloshkoSortiranje {
	    private int V;  
	   
	    private ArrayList<ArrayList<Integer>> adj;  
	    
	    //Конструктор
	    TopoloshkoSortiranje(int v)  
	    {  
	        V = v;  
	        adj = new ArrayList<ArrayList<Integer>>(v);  
	        for (int i=0; i<v; ++i)  
	            adj.add(new ArrayList<Integer>());  
	    }  
	    
	    // Функција за додавање на јазел од графот
	    void addEdge(int v,int w) { adj.get(v).add(w); }  
	    
	    // рекурзивна функција која ја користи TopoloshkoSortiranje
	    void topologicalSortUtil(int v, boolean visited[],  
	                             Stack<Integer> stack)  
	    {  
	        // Бележи го јазелот како посетен.  
	        visited[v] = true;  
	        Integer i;  
	    
	        // Рекурзија за сите јазли
	        Iterator<Integer> it = adj.get(v).iterator();  
	        while (it.hasNext())  
	        {  
	            i = it.next();  
	            if (!visited[i])  
	                topologicalSortUtil(i, visited, stack);  
	        }  
	    
	        // Push на моменталнот јазел во стекот кој го зачувува резултатот  
	        stack.push(new Integer(v));  
	    }  
	    
	    // Функцијата за тополошко сортирање. Ја користи topologicalSortUtil() функцијата 
	    void topologicalSort()  
	    {  
	        Stack<Integer> stack = new Stack<Integer>();  
	    
	        // Бележи ги ситте јазли како непосетени  
	        boolean visited[] = new boolean[V];  
	        for (int i = 0; i < V; i++)  
	            visited[i] = false;  
	    
	        for (int i = 0; i < V; i++)  
	            if (visited[i] == false)  
	                topologicalSortUtil(i, visited, stack);  
	    
	        // Печати го резултатот  
	        while (stack.empty()==false)  
	            System.out.print(stack.pop() + " ");  
	    }  
	    
	    public static void main(String args[])  
	    {  
	        // Го креираме графот
	        TopoloshkoSortiranje g = new TopoloshkoSortiranje(8);  
	        g.addEdge(0, 2);  
	        g.addEdge(1, 2);  
	        g.addEdge(1, 3);  
	        g.addEdge(2, 4);  
	        g.addEdge(3, 5);
	        g.addEdge(4, 5);  
	        g.addEdge(4, 7);
	        g.addEdge(5, 6);
	    
	        System.out.println("Резултат: ");  
	        g.topologicalSort();  
	    }    
	
}
