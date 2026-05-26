class MinStack {
    Stack<Integer> elements;
    Stack<Integer> minElements;

    public MinStack() {
        elements = new Stack<>();
        minElements = new Stack<>();
    }
    
    public void push(int val) {
        elements.push(val);
        int min = 0;
        if(minElements.isEmpty()) {
            min = val;
        } else{
            min = Math.min(val, minElements.peek());
        }
        minElements.push(min);
    }
    
    public void pop() {
        elements.pop();
        minElements.pop();
    }
    
    public int top() {
        return elements.peek();
    }
    
    public int getMin() {
        return minElements.peek();
    }
}
