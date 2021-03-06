# 期末总结

## 个人的感性想法

1. * 对于工程师而言，算法本身不是枯燥无味的，相反去学习一大堆应用的reference doc， 
我觉得更无聊；虽然后者对于应用派为主的中国而言可能更有用；因为你不可能学习完所有的应用；
而基础的算法知识是连接所有上层应用知识的桥梁，达到学习后者事半功倍的效果；
   * go deeper， 每种应用是算法加数据结构组成，说的更宽泛些，
业务代码同样也是，如果有较好的算法素养，对于你个人的代码性能提升有较大的帮助，而不是花大代价做所谓牛逼的jvm调优；
  2. 并非学习算法的目的在于在工程中秀高深，晦涩的代码，而是更好的理解自己代码的性能瓶颈和其他人的代码；

## 数据结构

1. 良好的数据结构设计是非常重要的，在正确的场合使用正确的结构，事半功倍；
   * 总体来说可以分为：数组，链表; 
   * 根据两者的单独延伸和组合又可以产生多种多样的数据结构，队列，堆栈，树，hash表，trie；
2. 掌握一种数据结构，同样需要刻意练习;

## 算法
* 总览：   

    1. 程序： if else + loop + recursive;  
    2. 掌握基本的时间复杂度分析方法；
    3. 刻意练习算法题目，不能只做一遍；
    4. 发现重复子问题
    5. 五毒神掌或者更多遍
    
    
* 具体分析举例：   
    * 几乎所有题目都是重复子问题， 但是每种题目思考的方式有不同：    
        * 接雨水问题： 需要辅助栈；   
        * 斐波那契： 可以memo递归， 可以dp；    
        * 树： 递归解决， 某些题目不用回溯，所以可以考虑直接递归；    
        * 岛屿问题和8皇后问题： DFS 或者BFS，过遍数    
        * 排序问题： quicksort 和 mergesort 一个可以不需要辅助数组，一个需要，但是都是递归和归并的思路；     
        * 硬币问题和爬楼梯问题： dp思路，和注意硬币问题偶尔可以贪心。    
    * 字符串的动态递归：
        * 大部分难度大的题目都需要2级维度，如何思考子问题需要经验积累；
        
        
## 师傅领进门，修行在个人