package code;

public class MyStackA_String_65011466 {
    int MAX_SIZE=100;
    String stack[] = new String[MAX_SIZE];
    int top = 0;
   
    public void push(String d){
        stack[top++] = d;
    }
    public String pop(){
        return stack[--top];
    }
    public String peek(){
        return stack[top-1];
    }
    public boolean isFull(){
        return top==MAX_SIZE;
    }
    public boolean isEmpty(){
        return top==0;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("top->");
        for(int i=top-1; i>=0; i--) {
            sb.append("[");
            sb.append(stack[i]);
            sb.append("]->");
        }
        sb.append("bottom");
        return new String(sb);
    }
}
