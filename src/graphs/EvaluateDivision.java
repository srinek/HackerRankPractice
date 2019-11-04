package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	
/* public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Graph g = new Graph();
        int i = 0;
        for(List<String> equation : equations){
           Vertex v1 = g.addVertex(equation.get(0));
           Vertex v2 = g.addVertex(equation.get(1));
           // v1.addEdge(v2, values[i++]);
           g.union(v1, v2);
        }
        
        double[] result = new double[queries.size()];
        
        int k=0;
        
        for(List<String> queryList : queries){
            Vertex v1 = g.findParent(queryList.get(0));
            Vertex v2 = g.findParent(queryList.get(1));
            if(v1 != v2){
                result[k++] = -1d;
            }
            else{
                double val = g.computEquation(queryList.get(0), queryList.get(1));
                result[k++] = val;
            }
        }
        
        return result;
    }*/
    
    private static class Vertex{
        
        public String val;
        public List<Vertex> adjList = new ArrayList<>();
        public List<Double> weights = new ArrayList<>();
        public Map<String, Double> dist = new HashMap<>();
        public int rank = 0;
        public Vertex parent = null;
    
        
        public Vertex(String str){
            this.val = str;
            this.parent = this;
        }
        
        public void addEdge(Vertex v2, int weight){
            //v1.adjList.add(v2);
            //v1.weights.add(weight);
        }
        
        public boolean equals(Object obj){
            
            Vertex v = (Vertex) obj;
            return v.val.equals(this.val);
        }
    }
    
    
    public static class Graph{
        
        List<Vertex> vertices = new ArrayList<>();
        Map<String, Vertex> vertexMap = new HashMap<>();
        
        public Graph(){
            
            
        }
        
        public Vertex addVertex(String a){
            Vertex v = null;
            if(vertexMap.get(a) == null){
                v = new Vertex(a);
                vertices.add(v); 
                vertexMap.put(a, v);
            }
            else{
                v = vertexMap.get(a);
            }
            return v;
        }
        
        public Vertex getVertex(String a){
            return vertexMap.get(a);
        }
        
        public void union(Vertex node1, Vertex node2, double weight){
            
            Vertex v1p = findParent(node1);
            Vertex v2p = findParent(node2);
            
            if(v1p == v2p){
                return;
            }
            
            Vertex p = null;
            if(v1p.rank >= v2p.rank){
                v2p.parent = v1p;
                v1p.rank = v1p.rank + 1;
                p = v1p;
               
            }
            else{
                v1p.parent = v2p;
                v2p.rank = v2p.rank + 1;
                p = v2p;
            }
            p.dist.put(p.val+node2.val, p.dist.getOrDefault(p.val+node1.val, 1.0) * weight);
        }
        
        public Vertex findParent(Vertex node){
            
            Vertex parent = node.parent;
            
            if(parent != node){
                parent = findParent(node);
            }
            //node.parent = parent;
            return parent;
        }
        
        public double computEquation(String a, String b){
            Vertex v1 = findParent(vertexMap.get(a));
            Vertex v2 = getVertex(b);
            
            return 0.0d;
        }
        
    }
}
