package demo;

import java.util.HashMap;
import java.util.List;

//Employee info
class Employee {
 // It's the unique id of each node;
 // unique id of this employee
 public int id;
 // the importance value of this employee
 public int importance;
 // the id of direct subordinates
 public List<Integer> subordinates;
};

public class EmployeeIMportance {
	  public int getImportance(List<Employee> employees, int id) {
	        if(employees == null || employees.size() == 0) return 0;
	        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
	        for(Employee e : employees){
	            map.put(e.id,e);
	        }
	      return helper(map, id);
	    }
	    
	    private int helper(HashMap<Integer, Employee> map, int id){
	        Employee e = map.get(id);
	        int result = e.importance;
	        
	        for(int sub : e.subordinates){
	            result += helper(map, sub);
	        }
	        return result;
	    }
}