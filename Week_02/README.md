# 学习笔记
## HashMap

  * 函数变量：
    ```
        transient Node<K,V>[] table; // 整个哈希表就是这么个数组
        static class Node<K,V> implements Map.Entry<K,V> {
                final int hash; // key hash值
                final K key;// 具体key
                V value; // 具体value
                Node<K,V> next; 键相同hashcode在表中最开始表现为链表实现
        } //每个node 的具体情况      
    ``` 
  * releaseNotes-注释:
    *  选定的参数是 resizing threshold:0.75, bin中的元素可以达到一个参数为0.5 的泊松分布,
    一个链条中超过8(TREEIFY_THRESHOLD)个的几率为0.00000006,
     所以真正会变成红黑树（treeify）几率也不高 
    *  如果真正变成红黑树，会引入树排序的问题,一般依靠hashcode， 
    如果元素本身实现Comparable，则依赖此方法；当然如果comparable 相等，有实现其他函数打破此情景,元素不会丢失；
  
  * Put
    * put操作，其实实现就是         
        ```
        return putVal(hash(key), key, value, false, true); 
        ```
        后面两个参数可以暂时不管。总的来说就是计算key的hashcode，然后找寻相对应的地方插入value；
        ```$xslt
        if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
        else 则根据是否大于8，选择treefiy，或者链表化这个tab[i];
        ```
  * Get
    * get操作，几乎理论一致，先寻找tab[i]， 找到根据node为树，还是一般的node，选择进一步寻找的方式；

### 总结

* 本周数据结构：
    * 第 5 课 | 哈希表、映射、集合 - 基础数据结构，日常工作都会用到
    * 第 6 课 | 树、二叉树、二叉搜索树 - 其实是链表的升维，多递归题目；
    * 第 6 课 | 堆和二叉堆、图 - 堆的题目多余图；

* 树：
   * 基本结构：左右或者多叉，以二叉为多数，牢记遍历方式， 中序和前序需要熟练写出迭代遍历方式；时间复杂度O(N);
   * 特殊结构： 二叉搜索树， 在树的基础上维护了类似于堆的顺序，但是左右子树都符合这个规则，可以利用中序遍历获得升序序列；搜索一个值的时间复杂度O(logN);
* 堆：
   * 1.父亲节点大于其子节点的值，但是遍历结果并不一定有序；但是可以利用堆为大顶堆或者小顶堆的性质，快速获得最值；
   * 2.在大量数据中找部分最值很有用，毕竟不用存储所有数据;
* 图：
   * 主要包括拓扑排序，但是前提不能有环；
         
   
      
    