class Solution {
    
    public String simplifyPath(String path) {
        
        String [] pathSplit = path.split("/");
        
        Stack<String> paths = new Stack<>();
        Stack<String> reversePaths = new Stack<>();
        
        for(int i = 0; i < pathSplit.length; i++){
            
            pathSplit[i] = pathSplit[i].trim();
            
            if(!pathSplit[i].equals("")){  
                
                if(pathSplit[i].equals(".")){
                    continue;
                }
                
                if(pathSplit[i].equals("..")){
                   if(!paths.isEmpty()){
                       paths.pop();
                   }
                   continue;
                }
                
                paths.add(pathSplit[i]);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!paths.isEmpty()){
            reversePaths.push(paths.pop());
        }
        
        if(reversePaths.isEmpty()){
            result.append("/");
        }
        
        while(!reversePaths.isEmpty()){
            result.append("/");
            result.append(reversePaths.pop());
        }
        
        return result.toString();
    }
}