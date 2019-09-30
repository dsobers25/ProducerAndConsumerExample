# Producer and Consumer Example


## The producer and consumer problem is when you have 2 threads that need to communicate with each other in order to access a shared resource.

## the producer writes to the resource and the consumer reads from the resource.

In this example I use a Queue as a my shared resource. In order to 
and enable communication between these two threads I synchronize the my resource
and use the wait() and notify() methods from the Thread API in order control which thread has the lock on it.





