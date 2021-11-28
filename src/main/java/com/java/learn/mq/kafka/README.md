####Kafka
#####总述
分区：副本冗余、伸缩、局部有序、提高吞吐量

完成首领选举时间长、占用内存多


根据保存时间和保存的数据量来进行数据的保存
超过数据量会关闭日志片段，关闭后超过预定的时间会删除掉



Kafka的Broker数量：取决于数据量，以及副本数

内存交换是啥意思



使用Key进行分区时，最好提前规划好分区，不能新增新的分区
消费者的数量不能超过分区数量否则会导致消费者闲置

再均衡：分区所有权从一个消费者转移到另外一个消费者
新增分区、消费者数量发生变化
再均衡后，每个消费者需要重新从Kafka获取Offset信息来作为Offset提交的起始

再均衡期间消费组是无法消费消息的


心跳和消息轮询
消费者是通过定期轮询来从Kafka中获取消息的

一个消费组群会有指定一个Broker作为组群协调器，用来检测消费者的心跳
第一加入消费者的消费者会成为“群主”，从协调器那里获取活跃消费者的名单，并将分区分配给各个消费者。
这个过程再进行再均衡时会打破。






###消费者
__consumer_offset主题用来记录客户段提交的偏移量
再均衡会导致分区最后一次提交的偏移量与客户段之前处理的偏移量发生不一致就会导致
消息的丢失或者重复消费


自动提交会设置一个提交的频率，如果在上一次提交之后，下一次提交之前发生再均衡，那么客户端
会重新消费已经执行但尚未提交的消息
自动提交会造成消息重复消费


手动提交分为同步提交和异步提交
同步提交（重试机制，保证消息不丢失），比较安全，可重试不会丢失数据但是会影响吞吐
异步提交，吞吐高，但不能重试，因为客户端Offset可能因为落后于服务端而导致重新消费，可以用CAS来
解决，先比较再更新   

提交失败不重试一般不会影响，因为后续总有成功提交的，但需要注意的是，在再均衡之前必须保证成功提交
否则会导致消息重复消费


每个分区会在其中一个Broker上指定一个Leader



Zookeeper
管理Broker集群、记录客户端提交的Offset信息，现在已经保存在了Kafka上
第一个加入集群的Broker会成为控制器，负责分区leader的选举，并在Zookeeper上创建一个临时节点，其它broker在创建时会发现已经存在，创建
失败，会在Zookeeper上创建一个watch对象，一旦broker发生了变化，就会通知到其它的broker。

控制器负责分区选举的broker，一旦控制器失去联系或者退出集群，其它broker会去zookeeper上创建临时节点

分区Leaders负责分区所有权的分配，分区Leader所在的broker失联或退出集群，控制器会进行分区leader的选举

kafka主要通过zookeeper来进行控制器选举，并通过watch机制来通知其它broker，通过epoch来防止脑裂


首领副本用于处理客户端的请求，跟随者副本仅同步首领副本的数据，作为冗余数据

kafka的零拷贝技术，文件从Linux操作系统文件资源直接复制到网卡中，而不经由应用，减少内核态和用户态
之间的上下文切换提高了效率



Kafka吞吐高的原因
多分区、多消费者
消息顺序追加
零拷贝技术
页缓存技术
mmap文件映射：开辟非堆内存与操作系统内核内存映射，相当于内核内存，内核可以直接访问、落盘


非同步副本：如果一个副本在同步和非同步状态来回切换，很有可能是垃圾回收的配置问题

不完全首领选举:剩余副本没有同步副本，均为非同步副本

最少同步副本数：超过最小同步副本数，才算写入成功


###消息丢失
1、生产端
    ack的设置在0或者1的情况下会导致数据不一致，即可能会导致
    重复提交来保证消息发送成功
3、消费端
    auto.offset.reset  无偏移量可提交或提交的偏移量在broker上不存在，earliest 从分区开始读取 lastest从
    分区最后获取

1、发送者发送失败：通过重试
2、ACK设置为1，可能会导致消息丢失，跟随着副本尚未同步首领副本，且时间足够短，仍标记为
eg1:
 broker 配置了 3个副本，井且禁用了不完全首领选举，这样应该可以保证万无 一失。
我们把生产者发送消息的 acks 设为1 （只要首领接收到消息就可以认为消息 写入成功）。
生产者发送 个消息给首领，首领成功 入，但跟随者副本还没有接收到这个消息。
领向生产者发送了 个响应，告诉它“消息写入成功”，然后它崩横了，而此时悄息还
没有被其他副本复制过去 另外两个副本此时仍然被认为是同步的（毕竟判定 个副
不同步需要 小段时间），而且其中的 1个副本成了新的首领 因为悄息还没有被写入
这个副本，所以就丢失了，但发送消息的客户端却认为消息已成功 因为消费者
不到丢失的消息，所以此时的系统仍然是 致的（因为副本没有收到这个消息，所以
息不算已提交），但从生产者角度来看，它丢失了1 个消息

eg2:
 broker 配置了3个副本，并且禁用了不完全首领选举。我们接受了之前的教训
生产者的 acks 设为 all 。假设现在往 Kafka 发送消息，分区的首领刚好崩愤，新的首领
正在选举当中， Kafka 会向生产者返回“首领不可用”的响应 在这个时候，如
者没能正确处理这个错误，也没有重试发送消息直到发送成功，那么消息也有可能丢失。
这算不上是 broker 的可靠性问题，因为 broker 并没有收到这个消息。这也不是 致性
问题，因为消费者井没有读到这个消息。问题在于如果生产者没能正确处理这些错误，
丢消息的是它们自己。
那么，我们该如何避免这些悲剧性的后果呢？从上面两个例子可以看出，每个使用 Kafk
的开发人员都要注意两件事情

根据可靠性需求配置恰当的 acks 值。
在参数配置和代码里正确处理错误。

acks=0 意味着如果生产者能够通过网络把消息发送出去，那么就认为消息已成功
Kafka 。在这种情况下还是有可能发生错误，比如发送的对象无能被序列化或者网卡发
生故障，但如果是分区离线或整个集群长时间不可用，那就不 收到任何错误 即使
在发生完全首领选举的情况下，这种模式仍然会丢失消息，因为在新首领选举过程中
并不知道首领已经不可用了。在 acks=0 模式下的运行速度是非常快的（这就是为什
很多基准测试都是基于这个模式），你可以得到惊人的吞吐 和带宽利用 ，不过如
选择了这种模式， 一定会丢失 一些消息。
 ack s=1 意味若首领在收到消息并把它写入到分区数据文件（不 定同步到磁盘上）时
会返回确认或错误响应。在这个模式下，如果发生正常的首领选举，生产者会在选
收到 Leade NotAvai.lableExcepti.on 异常，如果生产者能恰当地处理这个错误（
6.4.2 节），它会重试发送消息，最终消息会安全到达新的首领那里。不过在这个模式
下仍然有可能丢失数据，比如消息已经成功写入首领，但在消息被复制到跟随者副本之
前首领发生崩溃。

ack s=all 意味着首领在返回确认或错误响应之前，会等待所有同步副本都收到悄息。如
果和 l'li. 1. i.nsync. epli.cas 参数结合起来，就可以决定在返回确认前至少有多少个副本
能够收到悄息 这是最保险的做也一一生产者会 直重试直到消息被成功提交。不过这
也是最慢的做毡，生产者在继续发送其他消息之前需要等待所有副本都收到当前的消息。