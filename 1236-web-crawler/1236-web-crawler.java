/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        result.add(startUrl);
        
        StringBuilder url = new StringBuilder();
        
        int count = 0;
        
        for(int i = 0; i < startUrl.length() && count < 3; i++){
            if(startUrl.charAt(i) == '/'){
                count++;
                if(count == 3) continue;
            }
            url.append(startUrl.charAt(i));
        }
        
        System.out.println(url.toString());
        
        dfs(visited, result, url.toString(), startUrl, htmlParser);
        
        return new ArrayList<>(result);
    }
    
    private void dfs(Set<String> visited, 
                     Set<String> result,
                     String startUrl,
                     String url, HtmlParser htmlParser){
        
        if(visited.contains(url)){
            return;
        }
        
        visited.add(url);
        
        List<String> urls = htmlParser.getUrls(url);
        
        for(String neighbor: urls){
            if(neighbor.startsWith(startUrl) || neighbor.startsWith(startUrl)){
                result.add(neighbor);
            }
            if(!startUrl.startsWith(neighbor) && !neighbor.startsWith(startUrl)){
                continue;
            }
            dfs(visited, result, startUrl, neighbor, htmlParser);
        }
    }
}