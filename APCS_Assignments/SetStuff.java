import java.util.ArrayList;

public class SetStuff {
	ArrayList<Integer> feeld;
	
	public SetStuff() {
	}
	//returns an ArrayList<Integer> that only includes 17.
	public ArrayList<Integer> ret17() {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(17);
		return ret;
	}
	//Returns the 0th element of an ArrayList<Integer> 
	public int zerothElement(ArrayList<Integer> al){
		return al.get(0);
	}
	//checks to see if an inputted int[] contains a specified int
	public boolean contains(int a, int[] ar){
		boolean ret = false;
		for (int e : ar) {
			if (a == e) ret = true;
		}
		return ret;
	}
	//checks to see if int[] b contains any integers
	//in int[] a
	public boolean anyContains(int[] a, int[] b){
		boolean ret = false;
		for (int e : a) {
			for (int f : b) {
				if (e == f) ret = true;
			}
		}
		return ret;
	}
	//Performs the union function on two inputted 
	//int[]s, returning a single int[]
	public int[] union(int[] a, int[] b){
		int[] ret = new int[a.length+b.length];
		for (int i = 0; i < a.length; i++) {
			ret[i] = a[i];
		}
		for (int j = 0; j < b.length; j++) {
			ret[a.length+j] = b[j];
		}
		return ret;
	}
	//Performs the intersection function on two inputted 
	//int[]s, returning a single int[]
	public int[] intersect(int[] a, int[] b){
		int len = 0;
		for (int e : a) {
			for (int f : b) {
				if (e == f) len++;
			}
		}
		int[] ret = new int[len];
		int bk = 0;
		for (int i = 0; i < a.length; i++) {
			for (int e : b) {
				if (a[i] == e) {ret[bk] = a[i]; bk++;}
			}
		}
		return ret;
	}
	//Finds the nearestunvisitednode given a set of nodes visited,
	//a set of distances to those nodes, and a set of node names.
	public String nearesUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName){
		int num = 0;
		for (boolean b : visited) {
			if (!b) num++;
		}
		if (num == 0) {return "";}
	  
		int[] indices = new int[num];
		int bk = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {indices[bk] = i; bk++;}
		}
	  
		int min = distance[indices[0]];
		int ind = indices[0];
		for (int e : indices) {
			if (distance[e] < min) {min = distance[e]; ind = e;}
		}
	  
		return nodeName[ind];
	}
	//Returns an ArrayList<Object> containing all the inputted ints
	public ArrayList<Object> listify(int a, int b, int c){
		ArrayList<Object> ret = new ArrayList<Object>();
		ret.add(a); ret.add(b); ret.add(c);
		return ret;
	}
	//Adds an edge to a graph of ArrayList<ArrayList<Object>s
	public ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c){
		ArrayList<Object> ret1 = new ArrayList<Object>();
		ret1.add(a); ret1.add(b); ret1.add(c); 
		ArrayList<ArrayList<Object>> ret = graph;
		ret.add(ret1);
		return ret;
	}
	//collects the first two nodes of several ArrayList<Integer>s
	public ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist){
	 	ArrayList<Integer> ret = new ArrayList<Integer>();
	 	for (ArrayList<Integer> e : edgelist) {
	 		if (ret.contains(e.get(0)) == false) {ret.add(e.get(0));}
	 		if (ret.contains(e.get(1)) == false) {ret.add(e.get(1));}
	 	}
	 	return ret;
	}
	//Creates an ArrayList<Integer> of size n, and assigns all the elements
	//a value of infinity, except for the "start" value, which is assigned 0.
	public ArrayList<Integer> setInfinity(int n, int start){
		ArrayList<Integer> ret = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			ret.add(Integer.MAX_VALUE);
		}
		ret.set(start, 0);
		return ret;
	}
}
