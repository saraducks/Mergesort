/**
 * File Name: SlistMergeSort.java 
 * Sort int slist using Merge Sort
 * 
 * @author sara
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistMergeSort.java
 */

class SlistMergeSort extends SlistSort{
 
 @Override
  protected void sort(boolean ascend) {
    
	//WRITE CODE HERE
	a.first = merge_sort(a.first);
    
  }
  
  public node merge_sort(node n){
	  
	   node result = n;
	   
	  if(n == null){ return null; }

	  if(n != null && n.next != null){ 
    
	   node middle_element = getMiddle(n);
	   
	   node left = merge_sort(n);
	   
	   node right = merge_sort(middle_element);
	   
	   result = merge(left,right);
	   
	   numRecursion++;
	    
	  }
	   return result;
  }
  
  public node merge(node first_half, node second_half){
	  
	 node first_node = null;
	 node list_node = null;
	 
	 while(first_half != null && second_half != null){
		 
		 node first_half_node = first_half.next;
		 node second_half_node = second_half.next; 
		 
		 //count number of comparisons made for merge sort
		 numCompare++;
		 numSwap++;
		 
		 if(first_half.d <= second_half.d){
			 
			 if(first_node == null){
				 
				 first_node = first_half;
				 
			 }
			 
			 else{
				 
				 list_node.next = first_half;
			 
			 }
			 
			 list_node = first_half;
			 first_half.next = null;
			 first_half = first_half_node;
			 
		 }
		 else{
			 
			 if(first_node == null){
				 
				 first_node = second_half;
				 
			 }
			 
			 else{
				 
				 list_node.next = second_half;
				 
			 }
			 
			 list_node = second_half;
			 second_half.next = null;
			 second_half = second_half_node;
			 
		 }
	
	 }
	 
	 list_node.next = (first_half != null)?first_half:second_half;
	 
	 return first_node; 
	 
  }
  
  public node getMiddle(node n){
	  
	  u.myassert(n!=null);
	  u.myassert(n.next != null);
	  node pointer1, pointer2;
	  pointer1 = n;
	  pointer2 = n.next;
	  
	  while(pointer2 != null){
		 
		  pointer2 = pointer2.next;
		  if(pointer2!=null){
			  
			  pointer2 = pointer2.next;
			  pointer1 = pointer1.next;
			  
		  }
	  }
        
	  node middle = pointer1.next;
	  pointer1.next = null;
	  return middle;
  }
  
  public static void main(String[] args) {
    System.out.println("SlistMergeSort.java");
    SlistMergeSort u = new SlistMergeSort() ;
    u.testBench();
  }
}