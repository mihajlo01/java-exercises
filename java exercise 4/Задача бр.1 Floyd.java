package floyd.algoritmi;
import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class Floyd {   
    final static int INF = 99999, V = 4; 
  
    void floyd(int graph[][]) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
        /* Иницијализација на почетната матрица */
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
 
        
        for (k = 0; k < V; k++) 
        { 
            // Избери теме по теме како истото да биде почетно
            for (i = 0; i < V; i++) 
            { 
                // Избери теме така што тоа ќе биде дестинација за погоре избраното теме
                for (j = 0; j < V; j++) 
                { 
                    // Ако темето k се наоѓа на најктаткиот пат, тогаш измени dist[i][j] 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 
  
        // Печати ја матрицата која ги содржи најкратките патишта 
        printSolution(dist); 
    } 
  
    void printSolution(int dist[][]) 
    { 
        System.out.println("Оваа матрица ги прикажува најкратките патишта помеѓу темињата "); 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (dist[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 
   
    public static void main (String[] args) 
    { 
        /* Ќе го користиме следниот граф
              2 
        (A)<---(B) 
        | ^    ^    
      3 |  \  /       
        | 6 \/ 1
        |   /\   
        |  /  \      
       \|//    \     
       (C)----->(D) 
              1           */
        int graph[][] = { {0,   INF,  3, INF}, 
                          {2, 0,   INF, INF}, 
                          {INF, 1, 0,   1}, 
                          {6, INF, INF, 0} 
                        }; 
        Floyd a = new Floyd(); 
  
        // Печатење на решението
        a.floyd(graph); 
    } 
}
/* Користена литература --> GeeksForGeeks */