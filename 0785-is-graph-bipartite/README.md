<h2><a href="https://leetcode.com/problems/is-graph-bipartite/">785. Is Graph Bipartite?</a></h2><h3>Medium</h3><hr><div speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">There is an <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">undirected</strong> graph with <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">n</code> nodes, where each node is numbered between <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">0</code> and <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">n - 1</code>. You are given a 2D array <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph</code>, where <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code> is an array of nodes that node <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code> is adjacent to. More formally, for each <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">v</code> in <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code>, there is an undirected edge between node <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code> and node <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">v</code>. The graph has the following properties:</p>

<ul speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">There are no self-edges (<code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code> does not contain <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code>).</li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">There are no parallel edges (<code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code> does not contain duplicate values).</li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">If <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">v</code> is in <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code>, then <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code> is in <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[v]</code> (the graph is undirected).</li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">The graph may not be connected, meaning there may be two nodes <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code> and <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">v</code> such that there is no path between them.</li>
</ul>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">A graph is <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">bipartite</strong> if the nodes can be partitioned into two independent sets <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">A</code> and <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">B</code> such that <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">every</strong> edge in the graph connects a node in set <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">A</code> and a node in set <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">B</code>.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Return <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">true</code><em speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"> if and only if it is <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">bipartite</strong></em>.</p>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi2.jpg" style="width: 222px; height: 222px;" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> false
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Explanation:</strong> There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.</pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong class="example" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi1.jpg" style="width: 222px; height: 222px;" speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
<pre speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px"><strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Input:</strong> graph = [[1,3],[0,2],[1,3],[0,2]]
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Output:</strong> true
<strong speechify-initial-font-family="SFMono-Regular, Consolas, &quot;Liberation Mono&quot;, Menlo, Courier, monospace" speechify-initial-font-size="13px">Explanation:</strong> We can partition the nodes into two sets: {0, 2} and {1, 3}.</pre>

<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">&nbsp;</p>
<p speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">Constraints:</strong></p>

<ul speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph.length == n</code></li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">1 &lt;= n &lt;= 100</code></li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">0 &lt;= graph[u].length &lt; n</code></li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">0 &lt;= graph[u][i] &lt;= n - 1</code></li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px"><code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code>&nbsp;does not contain&nbsp;<code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code>.</li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">All the values of <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code> are <strong speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">unique</strong>.</li>
	<li speechify-initial-font-family="-apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;" speechify-initial-font-size="14px">If <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[u]</code> contains <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">v</code>, then <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">graph[v]</code> contains <code speechify-initial-font-family="monospace" speechify-initial-font-size="13px">u</code>.</li>
</ul>
</div>