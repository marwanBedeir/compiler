/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author my lab
 */
public class OurStack {
    
    public static final  int maxSize = 400;
    private int top;
    private StackInput[] stackArray = new StackInput[maxSize];

    public OurStack() {
        
        this.top = -1;
    }
    
    public void push(StackInput x) {
      stackArray[++top] = x;
   }
    
   public StackInput pop() {
      return stackArray[top--];
   }
    
    public boolean isEmpty() {
      return (top == -1);
   }
   public boolean isFull() {
      return (top == maxSize - 1);
   }
   
   public StackInput peek() {
      return stackArray[top];
   }
    
}
