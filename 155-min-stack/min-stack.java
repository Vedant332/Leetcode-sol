class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        long value = val;

        if (st.isEmpty()) {
            st.push(value);
            min = value;
        } else {
            if (value < min) {
                long newVal = 2L * value - min;
                st.push(newVal);
                min = value;
            } else {
                st.push(value);
            }
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            if (st.peek() < min) {
                min = 2L * min - st.peek();
            }

            st.pop();
        }
    }
    
    public int top() {
        if (st.peek() < min) {
            return (int) min;
        }

        return st.peek().intValue();
    }
    
    public int getMin() {
        return (int) min;
    }
}