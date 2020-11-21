学习笔记
####1. Java Queue
队列（Queue）是一个先入先出（FIFO）的数据结构。继承了Collection接口和Iterable接口。
除了基本的Collection的操作之外，还额外提供了插入、提取和检查操作。这些方法分为两种形式，形式一，若操作失败抛出异常，形式二，返回一个特殊值。

#####方法：
- boolean add(E e) 将指定的元素插入到此队列中，如果可以立即执行此操作，而不会违反容量限制， true在成功后返回 IllegalStateException如果当前没有可用空间，则抛出IllegalStateException。
- E element() 检索，但不删除，这个队列的头。
- boolean offer(E e) 如果在不违反容量限制的情况下立即执行，则将指定的元素插入到此队列中。
- E peek() 检索但不删除此队列的头，如果此队列为空，则返回 null。
- E poll() 检索并删除此队列的头，如果此队列为空，则返回 null。
- E remove() 检索并删除此队列的头。

####2. Java Priority Queue
基于优先级堆的无限优先级queue。优先级队列的元素根据它们的有序natural ordering，或由一个Comparator在队列构造的时候提供，
这取决于所使用的构造方法。 优先队列不允许null元素。 依靠自然排序的优先级队列也不允许插入不可比较的对象（这样做可能导致ClassCastException）。
队列的头部是相对于指定顺序的最小元素。 如果多个元素被绑定到最小值，那么头就是这些元素之一。如果任何线程修改队列，
多线程不应同时访问PriorityQueue实例。 而是使用线程安全的PriorityBlockingQueue类。
offer ， poll ， remove()和add的时间复杂度为O(log(n))。

#####方法：
- boolean add(E e) 将指定的元素插入到此优先级队列中。
- void clear() 从此优先级队列中删除所有元素。
- boolean contains(Object o) 如果此队列包含指定的元素，则返回true。
- Iterator<E> iterator() 返回此队列中的元素的迭代器。
- boolean 	offer(E e) 将指定的元素插入到此优先级队列中。
- E peek() 检索但不删除此队列的头，如果此队列为空，则返回 null。
- E poll() 检索并删除此队列的头，如果此队列为空，则返回 null。
- boolean remove(Object o) 从该队列中删除指定元素的单个实例（如果存在）。
- int size() 返回此集合中的元素数。



