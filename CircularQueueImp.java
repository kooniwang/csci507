public class CircularQueueImp {
    int capacity;
    Object[] queue;
    int front = 0;
    int rear = -1;
    int size = 0;
    public CircularQueueImp(int capacity){
        this.capacity = capacity;
        queue = new Object[capacity];
    }

    public void enqueue(Object oj){
        if(this.isFull()) throw new IllegalStateException("The size if full, no element can be enqueued now!");
        else{
            rear = (rear + 1) % capacity;
            queue[rear] = oj;
            size++;
        }
    }

    public void dequeue(){
        if(this.isEmpty()) throw new IllegalStateException("The queue is already empty, no element can be dequeued now!");
        else{
            queue[front] = null;
            front = (front + 1) % capacity;
            size--;
        }
    }

    public Object peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == capacity;
    }


    @Override
    public String toString() {
        String str = "";
        if(rear < front){
            for(int i = front; i < capacity; i++){
                str = str.concat(this.queue[i].toString());
            }

            for(int j = 0; j <= rear; j++){
                str = str.concat(this.queue[j].toString());
            }
        }else{
            for(int m = front; m <= rear; m++){
                str = str.concat(this.queue[m].toString());
            }
        }
        return str;
    }

    public static void main(String[] args){
        CircularQueueImp queueImp = new CircularQueueImp(7);
        queueImp.enqueue(1);
        queueImp.enqueue(2);
        queueImp.enqueue(3);
        queueImp.enqueue(4);
        queueImp.enqueue(5);
        queueImp.enqueue(6);
        queueImp.enqueue(7);
        System.out.println(queueImp);

        queueImp.dequeue();
        queueImp.dequeue();
        queueImp.dequeue();
        System.out.println(queueImp);

        queueImp.enqueue(5);
        queueImp.enqueue(6);
        queueImp.enqueue(7);
        System.out.println(queueImp);


        queueImp.dequeue();
        queueImp.dequeue();
        queueImp.dequeue();
        queueImp.dequeue();
        queueImp.dequeue();
        System.out.println(queueImp);
    }

}
